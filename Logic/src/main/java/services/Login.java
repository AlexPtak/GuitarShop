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
            if (mySqlCustomerDao.searchByPassword(password) != null) {
                builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
                builder.append("<exception>you're in!</exception>");
                return builder.toString();
            }
            else throw new GuitarShopException("wrong password!");
        } else throw new GuitarShopException("wrong login!");
    }
}
