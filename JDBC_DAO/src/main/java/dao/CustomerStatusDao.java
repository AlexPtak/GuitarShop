package dao;

import dto.CustomerStatusDto;
import myUtils.GuitarShopException;

import java.util.List;

public interface CustomerStatusDao {

    public CustomerStatusDto searchById(int id) throws GuitarShopException;
    public List<CustomerStatusDto> getAll() throws GuitarShopException;
}
