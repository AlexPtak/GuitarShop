package dao;

import dto.CustomerDto;
import myUtils.GuitarShopException;

import java.util.List;

public interface CustomerDao {

    public CustomerDto searchById(int id) throws GuitarShopException;
    public CustomerDto searchByLogin(String login) throws GuitarShopException;
    public CustomerDto searchByPassword(String pass) throws GuitarShopException;
    public List<CustomerDto> getAll() throws GuitarShopException;
    public void insertCustomer(CustomerDto customerDto) throws GuitarShopException;
}
