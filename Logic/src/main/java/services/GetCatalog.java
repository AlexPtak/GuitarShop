package services;

import myUtils.GuitarShopException;

import javax.xml.bind.JAXBException;
import java.util.List;

public interface GetCatalog<T> {

    public List<T> getCatalog() throws GuitarShopException;
    public String getCatalogInXml() throws GuitarShopException, JAXBException;
}
