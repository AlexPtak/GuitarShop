package parser;

import dao.GuitarDao;
import dto.FullGuitarDto;
import mysql.MySqlGuitarDao;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JaxbParserTest {

    private GuitarDao guitarDao;

    @Before
    public void setUp() throws Exception {
        guitarDao = new MySqlGuitarDao();
    }

    @Test
    public void testBuildXmlWithJaxb() throws Exception {
//        FullGuitars fullGuitars = new FullGuitars();
//        List<FullGuitarDto> fullGuitarDtos = new MySqlGuitarDao().getAllFullGuitar();
//        fullGuitars.setFullGuitarDtos(fullGuitarDtos);
//        JaxbParser.buildXmlWithJaxb(fullGuitars);
        List<FullGuitarDto> fullGuitarDto = guitarDao.searchByDtoFilter(guitarDao.searchById(1));
        System.out.println(JaxbParser.buildXmlWithJaxb(fullGuitarDto.get(0)));
    }

    @Test
    public void testBuildObjectWithJaxb() throws Exception {
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "      <FULL_GUITAR>\n" +
                "        <guitar>\n" +
                "          <color>black</color>\n" +
                "        </guitar>\n" +
                "      </FULL_GUITAR>";
        FullGuitarDto fullGuitarDto = (FullGuitarDto) JaxbParser.buildObjectWithJaxb(new FullGuitarDto(), s);
        System.out.println(fullGuitarDto.getGuitarDto().getColor());
    }
}