package services;

import myUtils.GuitarShopException;

import javax.xml.bind.JAXBException;

public interface GetCatalog {

    public String getCatalogInXml() throws GuitarShopException, JAXBException;
    public String getSingleInstanseFromCatalogById(int id) throws GuitarShopException, JAXBException;
}
