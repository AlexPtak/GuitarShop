package services;

import dto.ParameterValueDto;
import forJaxb.ParameterValues;
import myUtils.GuitarShopException;
import mysql.MySqlParameterValueDao;

import javax.xml.bind.JAXBException;

public class GetParameterValues implements GetCatalog<ParameterValueDto> {

    @Override
    public ParameterValues getCatalogInXml() throws GuitarShopException, JAXBException {
        ParameterValues parameterValues = new ParameterValues();
        parameterValues.setParameterValueDtos(new MySqlParameterValueDao().getAll());
        return parameterValues;
    }

    @Override
    public ParameterValueDto getSingleInstanceFromCatalogById(int id) throws GuitarShopException, JAXBException {
        return new MySqlParameterValueDao().searchById(id);
    }
}