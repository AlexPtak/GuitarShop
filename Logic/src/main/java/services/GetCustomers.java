package services;

import dao.CustomerDao;
import dto.CustomerDto;
import entity.Entity;
import forJaxb.Customers;
import mysql.MySqlCustomerDao;
import parser.JaxbParser;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetCustomers implements GetCatalog<CustomerDto> {

    @Override
    public List<CustomerDto> getCatalog() throws PropertyVetoException, IOException, SQLException {
        CustomerDao customerDao = new MySqlCustomerDao();
        List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();
        for (Entity elem : customerDao.getAll()) customerDtos.add((CustomerDto) elem.createDto());
        return customerDtos;
    }

    @Override
    public void getCatalogForServlet(HttpServletResponse response) throws IOException, PropertyVetoException, SQLException, JAXBException {
        PrintWriter writer = response.getWriter();
        JaxbParser jaxbParser = new JaxbParser();
        Customers customers = new Customers();
        customers.setCustomerDtos(getCatalog());
        String parameterTypeXmlString = jaxbParser.buildXmlWithJaxb(customers);
        writer.print(parameterTypeXmlString);
    }
}
