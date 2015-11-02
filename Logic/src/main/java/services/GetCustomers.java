package services;

import dao.CustomerDao;
import dto.CustomerDto;
import forJaxb.Customers;
import myUtils.GuitarShopException;
import mysql.MySqlCustomerDao;
import parser.JaxbParser;

import javax.xml.bind.JAXBException;
import java.util.List;

public class GetCustomers implements GetCatalog<CustomerDto> {

    @Override
    public List<CustomerDto> getCatalog() throws GuitarShopException {
        CustomerDao customerDao = new MySqlCustomerDao();
        return customerDao.getAll();
    }

    @Override
    public String getCatalogInXml() throws GuitarShopException, JAXBException {
        JaxbParser jaxbParser = new JaxbParser();
        Customers customers = new Customers();
        customers.setCustomerDtos(getCatalog());
        String parameterTypeXmlString = jaxbParser.buildXmlWithJaxb(customers);
        return parameterTypeXmlString.toString();
    }
}
