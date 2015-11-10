package services;

import dto.ParameterTypeDto;
import forJaxb.ParameterTypes;
import myUtils.GuitarShopException;
import mysql.MySqlParameterTypeDao;

import javax.xml.bind.JAXBException;

public class GetParameterTypes implements GetCatalog<ParameterTypeDto> {

    @Override
    public ParameterTypes getCatalogInXml() throws GuitarShopException, JAXBException {
        ParameterTypes parameterTypes = new ParameterTypes();
        parameterTypes.setParameterTypeDtos(new MySqlParameterTypeDao().getAll());
        return parameterTypes;
    }

    @Override
    public ParameterTypeDto getSingleInstanceFromCatalogById(int id) throws GuitarShopException, JAXBException {
        return new MySqlParameterTypeDao().searchById(id);
    }
}