package services;

import dao.CustomerDao;
import myUtils.MyException;
import mysql.MySqlCustomerDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class CreateUser {

    public void createUserForServlet(HttpServletResponse response, HttpServletRequest request) throws MyException, PropertyVetoException, IOException, SQLException {
        PrintWriter writer = response.getWriter();
        CustomerDao mySqlCustomerDao = new MySqlCustomerDao();
        //request.getInputStream();
        if (mySqlCustomerDao.searchByLogin(request.getParameter("login")) == null) {
            CustomerDao customer = new MySqlCustomerDao();
            customer.insertCustomer(
                    request.getParameter("firstName"),
                    request.getParameter("lastName"),
                    request.getParameter("email"),
                    request.getParameter("phone"),
                    request.getParameter("login"),
                    request.getParameter("password"),
                    1);
            writer.print("you're in!");
        } else throw new MyException("please change your login beach!");
    }
}
