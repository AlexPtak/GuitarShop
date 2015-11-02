package mysql;

import dao.CustomerStatusDao;
import dto.GuitarStatusDto;
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
    public GuitarStatusDto searchById(int id) throws GuitarShopException {
        CustomerStatus customerStatus = new CustomerStatus();
        customerStatus.setId(id);
        return (GuitarStatusDto) guitarShopManager.singleSelect(customerStatus).createDto();
    }

    @Override
    public List<GuitarStatusDto> getAll() throws GuitarShopException {
        CustomerStatus customerStatus = new CustomerStatus();
        List<Entity> entities = guitarShopManager.selectAll(customerStatus);
        List<GuitarStatusDto> guitarStatusDtos = new ArrayList<GuitarStatusDto>();
        for (Entity elem : entities) guitarStatusDtos.add((GuitarStatusDto) elem.createDto());
        return guitarStatusDtos;
    }
}
