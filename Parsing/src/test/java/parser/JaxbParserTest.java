package parser;

import dao.CustomerDao;
import dto.CustomerDto;
import mysql.MySqlCustomerDao;
import org.junit.Before;
import org.junit.Test;

public class JaxbParserTest {

    private JaxbParser jaxbParser;
    private CustomerDao customerDao;

    @Before
    public void setUp() throws Exception {
        jaxbParser = new JaxbParser();
        customerDao = new MySqlCustomerDao();
    }

    @Test
    public void testBuildXmlWithJaxb() throws Exception {
        jaxbParser.buildXmlWithJaxb(customerDao.searchById(1).createDto());
    }

    @Test
    public void testBuildObjectWithJaxb() throws Exception {
        String xml = jaxbParser.buildXmlWithJaxb(customerDao.searchById(1).createDto());
        CustomerDto customerDto = (CustomerDto) jaxbParser.buildObjectWithJaxb(new CustomerDto(), xml);
        System.out.println(customerDto.getFirstName());
        System.out.println(customerDto.getLastName());
    }
}