package services;

import myUtils.MyException;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface GetCatalog<T> {

    public List<T> getCatalog() throws PropertyVetoException, IOException, SQLException;
    public void getCatalogForServlet(HttpServletResponse response) throws IOException, PropertyVetoException, SQLException, JAXBException, MyException;
}
