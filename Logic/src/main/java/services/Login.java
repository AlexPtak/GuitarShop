package services;

import dao.CustomerDao;
import entity.Entity;
import myUtils.MyException;
import mysql.MySqlCustomerDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Login {

    public void loginForServlet(HttpServletRequest request, HttpServletResponse response) throws IOException, PropertyVetoException, SQLException, MyException {
        PrintWriter writer = response.getWriter();
        CustomerDao mySqlCustomerDao = new MySqlCustomerDao();
        Entity customer = mySqlCustomerDao.searchByLogin(request.getParameter("login"));
        if (customer != null) {
            if (mySqlCustomerDao.searchByPassword(request.getParameter("password")) != null) writer.print("you're in!");
            else throw new MyException("wrong password!");
        } else throw new MyException("wrong login!");
    }
}
