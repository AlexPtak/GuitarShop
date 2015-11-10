package services;

import dto.GuitarTypeDto;
import forJaxb.GuitarTypes;
import myUtils.GuitarShopException;
import mysql.MySqlGuitarTypeDao;

import javax.xml.bind.JAXBException;

public class GetGuitarType implements GetCatalog<GuitarTypeDto> {

    @Override
    public GuitarTypes getCatalogInXml() throws GuitarShopException, JAXBException {
        GuitarTypes guitarTypes = new GuitarTypes();
        guitarTypes.setGuitarTypeDtos(new MySqlGuitarTypeDao().getAll());
        return guitarTypes;
    }

    @Override
    public GuitarTypeDto getSingleInstanceFromCatalogById(int id) throws GuitarShopException, JAXBException {
        return new MySqlGuitarTypeDao().searchById(id);
    }
}
