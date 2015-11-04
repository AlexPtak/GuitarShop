package services;

import dto.ParameterTypeDto;
import forJaxb.ParameterTypes;
import myUtils.GuitarShopException;
import mysql.MySqlParameterTypeDao;
import parser.JaxbParser;

import javax.xml.bind.JAXBException;

public class GetParameterTypes implements GetCatalog {

    @Override
    public String getCatalogInXml() throws GuitarShopException, JAXBException {
        JaxbParser jaxbParser = new JaxbParser();
        ParameterTypes parameterTypes = new ParameterTypes();
        parameterTypes.setParameterTypeDtos(new MySqlParameterTypeDao().getAll());
        return jaxbParser.buildXmlWithJaxb(parameterTypes);
    }

    @Override
    public String getSingleInstanseFromCatalogById(int id) throws GuitarShopException, JAXBException {
        JaxbParser jaxbParser = new JaxbParser();
        ParameterTypeDto parameterTypeDto = new MySqlParameterTypeDao().searchById(id);
        return jaxbParser.buildXmlWithJaxb(parameterTypeDto);
    }
}
