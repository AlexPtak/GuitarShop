package services;

import dao.ParameterTypeDao;
import dto.ParameterTypeDto;
import entity.Entity;
import forJaxb.ParameterTypes;
import mysql.MySqlParameterTypeDao;
import parser.JaxbParser;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetParameterTypes implements GetCatalog<ParameterTypeDto> {

    @Override
    public List<ParameterTypeDto> getCatalog() throws PropertyVetoException, IOException, SQLException {
        ParameterTypeDao parameterTypeDao = new MySqlParameterTypeDao();
        List<ParameterTypeDto> parameterTypeDtos = new ArrayList<ParameterTypeDto>();
        for (Entity elem : parameterTypeDao.getAll()) parameterTypeDtos.add((ParameterTypeDto) elem.createDto());
        return parameterTypeDtos;
    }

    @Override
    public void getCatalogForServlet(HttpServletResponse response) throws IOException, PropertyVetoException, SQLException, JAXBException {
        PrintWriter writer = response.getWriter();
        JaxbParser jaxbParser = new JaxbParser();
        ParameterTypes parameterTypes = new ParameterTypes();
        parameterTypes.setParameterTypeDtos(getCatalog());
        String parameterTypeXmlString = jaxbParser.buildXmlWithJaxb(parameterTypes);
        writer.print(parameterTypeXmlString);
    }
}
