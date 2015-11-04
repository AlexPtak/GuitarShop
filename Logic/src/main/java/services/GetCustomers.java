package services;

import dto.CustomerDto;
import forJaxb.Customers;
import myUtils.GuitarShopException;
import mysql.MySqlCustomerDao;
import parser.JaxbParser;

import javax.xml.bind.JAXBException;

public class GetCustomers implements GetCatalog {

    @Override
    public String getCatalogInXml() throws GuitarShopException, JAXBException {
        JaxbParser jaxbParser = new JaxbParser();
        Customers customers = new Customers();
        customers.setCustomerDtos(new MySqlCustomerDao().getAll());
        return jaxbParser.buildXmlWithJaxb(customers);
    }

    @Override
    public String getSingleInstanseFromCatalogById(int id) throws GuitarShopException, JAXBException {
        JaxbParser jaxbParser = new JaxbParser();
        CustomerDto customerDto = new MySqlCustomerDao().searchById(id);
        return jaxbParser.buildXmlWithJaxb(customerDto);
    }
}
