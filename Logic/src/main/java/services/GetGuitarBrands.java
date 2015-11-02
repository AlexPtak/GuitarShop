package services;

import dao.GuitarBrandDao;
import dto.GuitarBrandDto;
import forJaxb.GuitarBrands;
import myUtils.GuitarShopException;
import mysql.MySqlGuitarBrandDao;
import parser.JaxbParser;

import javax.xml.bind.JAXBException;
import java.util.List;

public class GetGuitarBrands implements GetCatalog<GuitarBrandDto> {

    @Override
    public List<GuitarBrandDto> getCatalog() throws GuitarShopException {
        GuitarBrandDao guitarBrandDao = new MySqlGuitarBrandDao();
        return guitarBrandDao.getAll();
    }

    @Override
    public String getCatalogInXml() throws GuitarShopException, JAXBException {
        JaxbParser jaxbParser = new JaxbParser();
        GuitarBrands guitarBrands = new GuitarBrands();
        guitarBrands.setGuitarBrandDtos(getCatalog());
        String parameterTypeXmlString = jaxbParser.buildXmlWithJaxb(guitarBrands);
        return parameterTypeXmlString.toString();
    }
}
