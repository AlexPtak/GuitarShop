package mysql;

import dao.CustomerStatusDao;
import dto.CustomerStatusDto;
import entity.CustomerStatus;
import entity.Entity;
import myUtils.GuitarShopException;

import java.util.ArrayList;
import java.util.List;

public class MySqlCustomerStatusDao implements CustomerStatusDao {

    private GuitarShopManager guitarShopManager;

    public MySqlCustomerStatusDao() throws GuitarShopException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Override
    public CustomerStatusDto searchById(int id) throws GuitarShopException {
        CustomerStatus customerStatus = new CustomerStatus();
        customerStatus.setId(id);
        return (CustomerStatusDto) guitarShopManager.singleSelect(customerStatus).createDto();
    }

    @Override
    public List<CustomerStatusDto> getAll() throws GuitarShopException {
        CustomerStatus customerStatus = new CustomerStatus();
        List<Entity> entities = guitarShopManager.selectAll(customerStatus);
        List<CustomerStatusDto> statusDtos = new ArrayList<CustomerStatusDto>();
        for (Entity elem : entities) statusDtos.add((CustomerStatusDto) elem.createDto());
        return statusDtos;
    }
}
