package services;

import dto.FullGuitarDto;
import forJaxb.FullGuitars;
import myUtils.GuitarShopException;
import mysql.MySqlGuitarDao;
import parser.JaxbParser;

import javax.xml.bind.JAXBException;

public class GetFullGuitar implements GetCatalog {

    @Override
    public String getCatalogInXml() throws GuitarShopException, JAXBException {
        JaxbParser jaxbParser = new JaxbParser();
        FullGuitars fullGuitars = new FullGuitars();
        fullGuitars.setFullGuitarDtos(new MySqlGuitarDao().getAllFullGuitar());
        return jaxbParser.buildXmlWithJaxb(fullGuitars);
    }

    @Override
    public String getSingleInstanseFromCatalogById(int id) throws GuitarShopException, JAXBException {
        JaxbParser jaxbParser = new JaxbParser();
        FullGuitarDto fullGuitarDto = new MySqlGuitarDao().getFullGuitarById(id);
        return jaxbParser.buildXmlWithJaxb(fullGuitarDto);
    }
}
