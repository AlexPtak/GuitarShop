package mysql;

import dao.CustomerDao;
import dao.Entity;
import entities.Customer;
import entities.Guitar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlCustomerDao implements CustomerDao {

    public Entity searchById(int id) throws SQLException {
        TransactionManager transactionManager = new TransactionManager();
        Customer customer = new Customer();
        customer.setId(id);
        return transactionManager.singleSelect(customer, null);
    }

    public List<Entity> searchByBrandAnType(String lastName, String mail) throws SQLException {
        TransactionManager transactionManager = new TransactionManager();
        Customer customer = new Customer();
        customer.setLastName(lastName);
        customer.setEmail(mail);
        return transactionManager.select(customer, null);
    }
}
