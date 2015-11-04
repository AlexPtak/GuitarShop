package services;

import dto.ParameterValueDto;
import forJaxb.ParameterValues;
import myUtils.GuitarShopException;
import mysql.MqSqlParameterValueDao;
import parser.JaxbParser;

import javax.xml.bind.JAXBException;

public class GetParameterValues implements GetCatalog {

    @Override
    public String getCatalogInXml() throws GuitarShopException, JAXBException {
        JaxbParser jaxbParser = new JaxbParser();
        ParameterValues parameterValues = new ParameterValues();
        parameterValues.setParameterValueDtos(new MqSqlParameterValueDao().getAll());
        return jaxbParser.buildXmlWithJaxb(parameterValues);
    }

    @Override
    public String getSingleInstanseFromCatalogById(int id) throws GuitarShopException, JAXBException {
        JaxbParser jaxbParser = new JaxbParser();
        ParameterValueDto parameterValueDto = new MqSqlParameterValueDao().searchById(id);
        return jaxbParser.buildXmlWithJaxb(parameterValueDto);
    }
}