package services;

import dao.CustomerDao;
import dto.CustomerDto;
import myUtils.GuitarShopException;
import mysql.MySqlCustomerDao;

public class CreateUser {

    public String createUserForServlet(CustomerDto customerDto) throws GuitarShopException {
        CustomerDao mySqlCustomerDao = new MySqlCustomerDao();
        StringBuilder builder = new StringBuilder();
        if (mySqlCustomerDao.searchByLogin(customerDto.getLogin()) == null) {
            mySqlCustomerDao.insertCustomer(customerDto);
            builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
            builder.append("<massage>you're in!</massage>");
            return builder.toString();
        } else throw new GuitarShopException("please change your login beach!");
    }
}
