import dao.CustomerDao;
import mysql.MySqlCustomerDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class CreateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            CustomerDao mySqlCustomerDao = new MySqlCustomerDao();
            //req.getInputStream();
            if (mySqlCustomerDao.searchByLogin(req.getParameter("login")) == null) {
                CustomerDao customer = new MySqlCustomerDao();
                customer.insertCustomer(
                        req.getParameter("firstName"),
                        req.getParameter("lastName"),
                        req.getParameter("email"),
                        req.getParameter("phone"),
                        req.getParameter("login"),
                        req.getParameter("password"),
                        1);
                writer.print("you're in!");
            } else writer.print("please change your login beach!");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
