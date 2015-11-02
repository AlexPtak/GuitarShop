package services;

import dao.ParameterTypeDao;
import dto.ParameterTypeDto;
import forJaxb.ParameterTypes;
import myUtils.GuitarShopException;
import mysql.MySqlParameterTypeDao;
import parser.JaxbParser;

import javax.xml.bind.JAXBException;
import java.util.List;

public class GetParameterTypes implements GetCatalog<ParameterTypeDto> {

    @Override
    public List<ParameterTypeDto> getCatalog() throws GuitarShopException {
        ParameterTypeDao parameterTypeDao = new MySqlParameterTypeDao();
        return parameterTypeDao.getAll();
    }

    @Override
    public String getCatalogInXml() throws GuitarShopException, JAXBException {
        JaxbParser jaxbParser = new JaxbParser();
        ParameterTypes parameterTypes = new ParameterTypes();
        parameterTypes.setParameterTypeDtos(getCatalog());
        String parameterTypeXmlString = jaxbParser.buildXmlWithJaxb(parameterTypes);
        return parameterTypeXmlString.toString();
    }
}
