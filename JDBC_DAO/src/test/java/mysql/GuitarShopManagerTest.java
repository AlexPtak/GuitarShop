package mysql;

import dao.CustomerDao;
import dto.CustomerDto;
import entity.Customer;
import entity.Entity;
import entity.ParameterType;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GuitarShopManagerTest {

    private GuitarShopManager guitarShopManager;

    @Before
    public void setUp() throws PropertyVetoException, SQLException, IOException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Test
    //@Ignore
    public void testSingleSelect() throws PropertyVetoException, SQLException, IOException {
        MySqlCustomerDao mySqlCustomerDao = new MySqlCustomerDao();
        Entity entity = mySqlCustomerDao.searchById(2);
        System.out.println(entity.toString());
    }

    @Test
    @Ignore
    public void testCreateCustomerDto() throws PropertyVetoException, IOException, SQLException {
        CustomerDao customerDao = new MySqlCustomerDao();
        List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();
        for (Entity elem : customerDao.getAll()) customerDtos.add((CustomerDto) elem.createDto());
        System.out.println(customerDtos.get(0).getLastName());
    }

    @Test
    @Ignore
    public void testSelect() throws PropertyVetoException, SQLException, IOException {
        Customer customer = new Customer();
        customer.setFirstName("George");
        customer.setPass("12546");
        for (Entity elem : GuitarShopManager.getInstance().select(customer, null)) System.out.println(elem.toString());
    }

    @Test
    @Ignore
    public void testSelectAll() throws PropertyVetoException, SQLException, IOException {
        ParameterType parameterType = new ParameterType();
        for (Entity elem : GuitarShopManager.getInstance().selectAll(parameterType)) System.out.println(elem.toString());
    }

    @Test
    @Ignore
    public void testInsert() throws SQLException {
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
    public void testUpdate() throws PropertyVetoException, SQLException, IOException {
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