package services;

import dto.GuitarBrandDto;
import forJaxb.GuitarBrands;
import myUtils.GuitarShopException;
import mysql.MySqlGuitarBrandDao;
import parser.JaxbParser;

import javax.xml.bind.JAXBException;

public class GetGuitarBrands implements GetCatalog {

    @Override
    public String getCatalogInXml() throws GuitarShopException, JAXBException {
        JaxbParser jaxbParser = new JaxbParser();
        GuitarBrands guitarBrands = new GuitarBrands();
        guitarBrands.setGuitarBrandDtos(new MySqlGuitarBrandDao().getAll());
        return jaxbParser.buildXmlWithJaxb(guitarBrands);
    }

    @Override
    public String getSingleInstanseFromCatalogById(int id) throws GuitarShopException, JAXBException {
        JaxbParser jaxbParser = new JaxbParser();
        GuitarBrandDto guitarBrandDto = new MySqlGuitarBrandDao().selectById(id);
        return jaxbParser.buildXmlWithJaxb(guitarBrandDto);
    }
}
