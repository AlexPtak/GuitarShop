package services;

import dto.FullGuitarDto;
import forJaxb.FullGuitars;
import myUtils.GuitarShopException;
import mysql.MySqlGuitarDao;

import javax.xml.bind.JAXBException;

public class GetFullGuitar implements GetCatalog<FullGuitarDto> {

    @Override
    public FullGuitars getCatalogInXml() throws GuitarShopException, JAXBException {
        FullGuitars fullGuitars = new FullGuitars();
        fullGuitars.setFullGuitarDtos(new MySqlGuitarDao().getAllFullGuitar());
        return fullGuitars;
    }

    @Override
    public FullGuitarDto getSingleInstanceFromCatalogById(int id) throws GuitarShopException, JAXBException {
        return new MySqlGuitarDao().getFullGuitarById(id);
    }
}
