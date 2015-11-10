package services;

import dto.CustomerDto;
import forJaxb.Customers;
import myUtils.GuitarShopException;
import mysql.MySqlCustomerDao;

import javax.xml.bind.JAXBException;

public class GetCustomers implements GetCatalog<CustomerDto> {

    @Override
    public Customers getCatalogInXml() throws GuitarShopException, JAXBException {
        Customers customers = new Customers();
        customers.setCustomerDtos(new MySqlCustomerDao().getAll());
        return customers;
    }

    @Override
    public CustomerDto getSingleInstanceFromCatalogById(int id) throws GuitarShopException, JAXBException {
        return new MySqlCustomerDao().searchById(id);
    }
}
