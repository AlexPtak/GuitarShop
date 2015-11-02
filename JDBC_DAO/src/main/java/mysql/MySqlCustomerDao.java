package mysql;

import dao.CustomerDao;
import dto.CustomerDto;
import entity.Customer;
import entity.Entity;
import myUtils.GuitarShopException;

import java.util.ArrayList;
import java.util.List;

public class MySqlCustomerDao implements CustomerDao {

    private GuitarShopManager guitarShopManager;

    public MySqlCustomerDao() throws GuitarShopException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    public CustomerDto searchById(int id) throws GuitarShopException {
        Customer customer = new Customer();
        customer.setId(id);
        return (CustomerDto) guitarShopManager.singleSelect(customer).createDto();
    }

    @Override
    public CustomerDto searchByLogin(String login) throws GuitarShopException {
        Customer customer = new Customer();
        customer.setLogin(login);
        Entity selectedEntity = guitarShopManager.singleSelect(customer);
        if (selectedEntity != null) return (CustomerDto) selectedEntity.createDto();
        return null;
    }

    @Override
    public CustomerDto searchByPassword(String pass) throws GuitarShopException {
        Customer customer = new Customer();
        customer.setPass(pass);
        Entity selectedEntity = guitarShopManager.singleSelect(customer);
        if (selectedEntity != null) return (CustomerDto) selectedEntity.createDto();
        return null;
    }

    @Override
    public List<CustomerDto> getAll() throws GuitarShopException {
        Customer customer = new Customer();
        List<Entity> entities = guitarShopManager.selectAll(customer);
        List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();
        for (Entity elem : entities) customerDtos.add((CustomerDto) elem.createDto());
        return customerDtos;
    }

    @Override
    public void insertCustomer(CustomerDto customerDto) throws GuitarShopException {
        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        customer.setLogin(customerDto.getLogin());
        customer.setPass(customerDto.getPass());
        customer.setStatusId(1);
        guitarShopManager.insert(customer);
    }
}
