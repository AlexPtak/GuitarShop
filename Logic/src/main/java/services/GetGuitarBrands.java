package services;

import dto.GuitarBrandDto;
import forJaxb.GuitarBrands;
import myUtils.GuitarShopException;
import mysql.MySqlGuitarBrandDao;

import javax.xml.bind.JAXBException;

public class GetGuitarBrands implements GetCatalog<GuitarBrandDto> {

    @Override
    public GuitarBrands getCatalogInXml() throws GuitarShopException, JAXBException {
        GuitarBrands guitarBrands = new GuitarBrands();
        guitarBrands.setGuitarBrandDtos(new MySqlGuitarBrandDao().getAll());
        return guitarBrands;
    }

    @Override
    public GuitarBrandDto getSingleInstanceFromCatalogById(int id) throws GuitarShopException, JAXBException {
        return new MySqlGuitarBrandDao().selectById(id);
    }
}
