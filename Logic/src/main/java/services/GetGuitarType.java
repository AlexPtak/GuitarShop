package services;

import dto.GuitarTypeDto;
import forJaxb.GuitarTypes;
import myUtils.GuitarShopException;
import mysql.MySqlGuitarTypeDao;
import parser.JaxbParser;

import javax.xml.bind.JAXBException;

public class GetGuitarType implements GetCatalog {

    @Override
    public String getCatalogInXml() throws GuitarShopException, JAXBException {
        JaxbParser jaxbParser = new JaxbParser();
        GuitarTypes guitarTypes = new GuitarTypes();
        guitarTypes.setGuitarTypeDtos(new MySqlGuitarTypeDao().getAll());
        return jaxbParser.buildXmlWithJaxb(guitarTypes);
    }

    @Override
    public String getSingleInstanseFromCatalogById(int id) throws GuitarShopException, JAXBException {
        JaxbParser jaxbParser = new JaxbParser();
        GuitarTypeDto guitarTypeDto = new MySqlGuitarTypeDao().searchById(id);
        return jaxbParser.buildXmlWithJaxb(guitarTypeDto);
    }
}
