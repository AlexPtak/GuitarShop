package mysql;

import dao.CustomerDao;
import entity.Customer;
import entity.Entity;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MySqlCustomerDao implements CustomerDao {

    private GuitarShopManager guitarShopManager;

    public MySqlCustomerDao() throws PropertyVetoException, SQLException, IOException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    public Entity searchById(int id) throws PropertyVetoException, SQLException, IOException {
        Customer customer = new Customer();
        customer.setId(id);
        return guitarShopManager.singleSelect(customer, null);
    }

    @Override
    public Entity searchByLogin(String login) throws SQLException {
        Customer customer = new Customer();
        customer.setLogin(login);
        return guitarShopManager.singleSelect(customer, null);
    }

    @Override
    public Entity searchByPassword(String pass) throws SQLException {
        Customer customer = new Customer();
        customer.setPass(pass);
        return guitarShopManager.singleSelect(customer, null);
    }

    @Override
    public List<Entity> getAll() throws PropertyVetoException, SQLException, IOException {
        Customer customer = new Customer();
        return guitarShopManager.selectAll(customer);
    }

    @Override
    public void insertCustomer(String firstName, String lastName, String email, String phone, String login, String pass, int status) throws PropertyVetoException, SQLException, IOException {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setLogin(login);
        customer.setPass(pass);
        customer.setStatusId(status);
        guitarShopManager.insert(customer);
    }
}
