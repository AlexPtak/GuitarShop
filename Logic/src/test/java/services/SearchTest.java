package services;

import dto.FullGuitarDto;
import forJaxb.FullGuitars;
import org.junit.Before;
import org.junit.Test;
import parser.JaxbParser;

import java.util.List;

public class SearchTest {

    private Search search;

    @Before
    public void setUp() throws Exception {
        search = new Search();
    }

    @Test
    public void testSearchGuitars() throws Exception {

        StringBuilder builder = new StringBuilder();

        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<FULL_GUITAR>\n" +
                "    <parameter_Type-Value>\n" +
                "        <entry>\n" +
                "                <key parameter_type_id=\"9\">\n" +
                "                    <type>Накладка</type>\n" +
                "                </key>\n" +
                "                <value parameter_value_id=\"69\">\n" +
                "                    <parameter_type_id>9</parameter_type_id>\n" +
                "                    <value>Палисандр</value>\n" +
                "                </value>\n" +
                "            </entry>\n" +
                "    </parameter_Type-Value>\n" +
                "</FULL_GUITAR>");

        String xml = builder.toString();

        FullGuitarDto fullGuitarDto = (FullGuitarDto) JaxbParser.buildObjectWithJaxb(new FullGuitarDto(), xml);
        List<FullGuitarDto> fullGuitarDtos = search.searchGuitars(fullGuitarDto);

        FullGuitars fullGuitars = new FullGuitars();
        fullGuitars.setFullGuitarDtos(fullGuitarDtos);
        JaxbParser.buildXmlWithJaxb(fullGuitars);
    }
}