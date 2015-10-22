package services;

import dao.GuitarBrandDao;
import dto.GuitarBrandDto;
import entity.Entity;
import forJaxb.GuitarBrands;
import mysql.MySqlGuitarBrandDao;
import xmlbuilder.XmlBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetGuitarBrands implements GetCatalog<GuitarBrandDto> {

    @Override
    public List<GuitarBrandDto> getCatalog() throws PropertyVetoException, IOException, SQLException {
        GuitarBrandDao guitarBrandDao = new MySqlGuitarBrandDao();
        List<GuitarBrandDto> guitarBrandDtos = new ArrayList<GuitarBrandDto>();
        for (Entity elem : guitarBrandDao.getAll()) guitarBrandDtos.add((GuitarBrandDto) elem.createDto());
        return guitarBrandDtos;
    }

    @Override
    public void getCatalogForServlet(HttpServletResponse response) throws IOException, PropertyVetoException, SQLException, JAXBException {
        PrintWriter writer = response.getWriter();
        XmlBuilder xmlBuilder = new XmlBuilder();
        GuitarBrands guitarBrands = new GuitarBrands();
        guitarBrands.setGuitarBrandDtos(getCatalog());
        String parameterTypeXmlString = xmlBuilder.buildXmlWithJaxb(guitarBrands);
        writer.print(parameterTypeXmlString);
    }
}
