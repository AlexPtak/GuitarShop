package xmlbuilder;

import entity.Entity;
import mysql.MySqlParameterTypeDao;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class XmlBuilderTest {

    private XmlBuilder builder;

    @Before
    public void setUp() throws Exception {
        builder = new XmlBuilder();
    }

    @Test
    @Ignore
    public void testMarshall() throws PropertyVetoException, IOException, SQLException {
        Entity entity = new MySqlParameterTypeDao().searchById(5);
        builder.buildXmlWithJaxb(entity);
    }

    @Test
    public void testBuildXmlWithDom() throws PropertyVetoException, IOException, SQLException, ParserConfigurationException, TransformerException {
        List<Entity> entities = new MySqlParameterTypeDao().getAll();
        builder.buildXmlWithDom(entities);
    }
}