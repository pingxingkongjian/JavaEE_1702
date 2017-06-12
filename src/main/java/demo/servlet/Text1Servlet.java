package demo.servlet;

import demo.util.Db;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ${刘晋勇}
 * on 2017/6/10.
 */
@WebServlet(urlPatterns = "/text1")
public class Text1Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ip = req.getParameter("IP");

        Connection connection = Db.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT * FROM db_1702.ip WHERE inet_aton(?) BETWEEN inet_aton(min) AND inet_aton(max)";
            if (connection != null) {
                statement = connection.prepareStatement(sql);
            } else {
                return;
            }
            statement.setString(1,ip);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                req.getSession().setAttribute("message", resultSet.getString("geo"));
                req.getRequestDispatcher("text1.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "此IP地址不存在");
                req.getRequestDispatcher("text1.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Db.close(resultSet, statement, connection);
        }
    }
}