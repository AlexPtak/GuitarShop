package parser;

import dto.FullGuitarDto;
import forJaxb.FullGuitars;
import mysql.MySqlGuitarDao;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JaxbParserTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testBuildXmlWithJaxb() throws Exception {
        FullGuitars fullGuitars = new FullGuitars();
        List<FullGuitarDto> fullGuitarDtos = new MySqlGuitarDao().getAllFullGuitar();
        fullGuitars.setFullGuitarDtos(fullGuitarDtos);
        JaxbParser.buildXmlWithJaxb(fullGuitars);
    }

    @Test
    public void testBuildObjectWithJaxb() throws Exception {

    }
}