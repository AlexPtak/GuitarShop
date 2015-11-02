package services;

import dao.CustomerDao;
import dto.CustomerDto;
import myUtils.GuitarShopException;
import mysql.MySqlCustomerDao;

public class Login {

    public String loginForServlet(String login, String password) throws GuitarShopException {
        StringBuilder builder = new StringBuilder();
        CustomerDao mySqlCustomerDao = new MySqlCustomerDao();
        CustomerDto customerDto = mySqlCustomerDao.searchByLogin(login);
        if (customerDto != null) {
            if (mySqlCustomerDao.searchByPassword(password) != null) return builder.append("you're in!").toString();
            else throw new GuitarShopException("wrong password!");
        } else throw new GuitarShopException("wrong login!");
    }
}
