package xmlbuilder;

import dao.ParameterTypeDao;
import dto.ParameterTypeDto;
import entity.Entity;
import mysql.MySqlParameterTypeDao;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class XmlBuilderTest {

    private ParameterTypeDao parameterTypeDao;
    private XmlBuilder xmlBuilder;

    @Before
    public void setUp() throws PropertyVetoException, IOException, SQLException {
        parameterTypeDao = new MySqlParameterTypeDao();
        xmlBuilder = new XmlBuilder();
    }

    @Test
    @Ignore
    public void buildXmlWithJaxbForDtos() throws PropertyVetoException, IOException, SQLException {
        for (Entity elem : parameterTypeDao.getAll()) xmlBuilder.buildXmlWithJaxb(elem.createDto(), System.out);
    }

    @Test
    @Ignore
    public void buildXmlWithJaxbForSingleDto() throws PropertyVetoException, IOException, SQLException {
        xmlBuilder.buildXmlWithJaxb(parameterTypeDao.searchById(5).createDto(), System.out);
    }
}