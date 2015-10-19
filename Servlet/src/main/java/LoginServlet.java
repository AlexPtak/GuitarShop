import dao.CustomerDao;
import entity.Entity;
import mysql.MySqlCustomerDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            CustomerDao mySqlCustomerDao = new MySqlCustomerDao();
            Entity customer = mySqlCustomerDao.searchByLogin(req.getParameter("login"));
            if (customer != null) {
                if (mySqlCustomerDao.searchByPassword(req.getParameter("password")) != null) writer.print("you're in!");
                else writer.print("wrong password!");
            } else writer.print("wrong login!");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
