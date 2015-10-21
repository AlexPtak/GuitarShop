package mysql;

import dao.CustomerStatusDao;
import entity.CustomerStatus;
import entity.Entity;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MySqlCustomerStatusDao implements CustomerStatusDao {

    private GuitarShopManager guitarShopManager;

    public MySqlCustomerStatusDao() throws PropertyVetoException, SQLException, IOException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Override
    public Entity searchById(int id) throws PropertyVetoException, SQLException, IOException {
        CustomerStatus customerStatus = new CustomerStatus();
        customerStatus.setId(id);
        return guitarShopManager.singleSelect(customerStatus, null);
    }

    @Override
    public List<Entity> getAll() throws PropertyVetoException, SQLException, IOException {
        CustomerStatus customerStatus = new CustomerStatus();
        return guitarShopManager.selectAll(customerStatus);
    }
}
