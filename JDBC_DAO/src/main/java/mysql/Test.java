package mysql;

import dao.Entity;
import entities.Customer;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException {
        /*
        MySqlCustomerDao mySqlCustomerDao = new MySqlCustomerDao();
        Entity entity = mySqlCustomerDao.searchById(2);
        System.out.println(entity.toString());
        */
        TransactionManager transactionManager = new TransactionManager();
        Customer customer = new Customer();
        customer.setFirstName("George");
        customer.setPass("12546");
        for (Entity elem : transactionManager.select(customer, null)) System.out.println(elem.toString());
    }
}
