package parser;

import dto.CustomerDto;
import mysql.MySqlCustomerDao;
import mysql.MySqlGuitarDao;
import org.junit.Before;
import org.junit.Test;

public class JaxbParserTest {

    private JaxbParser jaxbParser;

    @Before
    public void setUp() throws Exception {
        jaxbParser = new JaxbParser();
    }

    @Test
    public void testBuildXmlWithJaxb() throws Exception {
        //jaxbParser.buildXmlWithJaxb(new MySqlCustomerDao().searchById(1));
        jaxbParser.buildXmlWithJaxb(new MySqlGuitarDao().getFullGuitarById(1));
    }

    @Test
    public void testBuildObjectWithJaxb() throws Exception {
        CustomerDto customerDto = (CustomerDto) jaxbParser.buildObjectWithJaxb(new CustomerDto(), jaxbParser.buildXmlWithJaxb(new MySqlCustomerDao().searchById(1)));
        System.out.println(customerDto.getFirstName());
        System.out.println(customerDto.getLastName());
    }
}