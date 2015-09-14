package mysql;

import entity.Entity;
import entity.Customer;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public class GuitarShopManagerTest {

    private GuitarShopManager guitarShopManager;

    @Before
    public void setUp() throws PropertyVetoException, SQLException, IOException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Test
    @Ignore
    public void testSingleSelect() throws Exception {
        MySqlCustomerDao mySqlCustomerDao = new MySqlCustomerDao();
        Entity entity = mySqlCustomerDao.searchById(3);
        System.out.println(entity.toString());
    }

    @Test
    @Ignore
    public void testSelect() throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("George");
        customer.setPass("12546");
        for (Entity elem : GuitarShopManager.getInstance().select(customer, null)) System.out.println(elem.toString());
    }

    @Test
    @Ignore
    public void testInsert() throws Exception {
        Customer customer = new Customer();
        customer.setEmail("georgeKollias@gmail.com");
        customer.setLastName("Kollias");
        customer.setStatusId(1);
        customer.setPhone("555-483-466");
        customer.setPass("george.kollias");
        customer.setFirstName("George");
        customer.setLogin("GeorgeKollias");
        guitarShopManager.insert(customer);
    }

    @Test
    @Ignore
    public void testUpdate() throws Exception {
        int primeryKey = 6;
        Entity oldEntity = new MySqlCustomerDao().searchById(primeryKey);
        Customer editedEntity = new Customer();
        editedEntity.setId(primeryKey);
        editedEntity.setEmail("new Email");
        editedEntity.setPhone("new Phone");
        editedEntity.setPass("new Pass");
        editedEntity.setLogin("new Loggin");
        guitarShopManager.update(oldEntity, editedEntity);
    }
}