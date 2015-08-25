package mysql;

import entities.Guitar;
import entities.Parameter;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException {
        MySqlCustomerDao mySqlCustomerDao = new MySqlCustomerDao();
        mySqlCustomerDao.searchById(3);
        TransactionManager transactionManager = new TransactionManager();
        transactionManager.insert(new Guitar());
        transactionManager.update(new Guitar(), new Guitar());
        Parameter parameter = new Parameter();
        System.out.println(parameter.toString());
    }
}
