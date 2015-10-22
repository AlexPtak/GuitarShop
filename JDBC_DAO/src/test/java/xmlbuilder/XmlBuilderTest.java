package xmlbuilder;

import dao.ParameterTypeDao;
import dto.ParameterTypeDto;
import entity.Entity;
import forJaxb.ParameterTypes;
import mysql.MySqlParameterTypeDao;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.xml.bind.JAXBException;
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
    //@Ignore
    public void buildXmlWithJaxbForDtos() throws PropertyVetoException, IOException, SQLException, JAXBException {
        List<ParameterTypeDto> parameterTypeDtos = new ArrayList<ParameterTypeDto>();
        for (Entity elem : parameterTypeDao.getAll()) parameterTypeDtos.add((ParameterTypeDto) elem.createDto());
        ParameterTypes parameterTypes = new ParameterTypes();
        parameterTypes.setParameterTypeDtos(parameterTypeDtos);
        xmlBuilder.buildXmlWithJaxb(parameterTypes);
    }

    @Test
    @Ignore
    public void buildXmlWithJaxbForSingleDto() throws PropertyVetoException, IOException, SQLException {
        //xmlBuilder.buildXmlWithJaxb(parameterTypeDao.searchById(5).createDto(), System.out);
    }
}