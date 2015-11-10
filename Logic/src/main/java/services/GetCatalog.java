package services;

import myUtils.GuitarShopException;

import javax.xml.bind.JAXBException;

public interface GetCatalog<T> {

    public Object getCatalogInXml() throws GuitarShopException, JAXBException;
    public T getSingleInstanceFromCatalogById(int id) throws GuitarShopException, JAXBException;
}