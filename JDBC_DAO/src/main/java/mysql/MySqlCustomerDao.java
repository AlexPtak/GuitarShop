package mysql;

import dao.CustomerDao;
import entity.Entity;
import entity.Customer;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MySqlCustomerDao implements CustomerDao {

    public Entity searchById(int id) throws SQLException, IOException, PropertyVetoException {
        GuitarShopManager transactionManager = new GuitarShopManager();
        Customer customer = new Customer();
        customer.setId(id);
        return transactionManager.singleSelect(customer, null);
    }

    public List<Entity> searchByBrandAnType(String lastName, String mail) throws SQLException, IOException, PropertyVetoException {
        GuitarShopManager transactionManager = new GuitarShopManager();
        Customer customer = new Customer();
        customer.setLastName(lastName);
        customer.setEmail(mail);
        return transactionManager.select(customer, null);
    }
}
