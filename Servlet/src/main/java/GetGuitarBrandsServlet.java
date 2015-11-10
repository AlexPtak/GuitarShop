import forJaxb.GuitarBrands;
import myUtils.GuitarShopException;
import parser.JaxbParser;
import services.GetGuitarBrands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.PrintWriter;

public class GetGuitarBrandsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        GetGuitarBrands getGuitarBrands = new GetGuitarBrands();
        try {
            GuitarBrands guitarBrandsDto = getGuitarBrands.getCatalogInXml();
            String xml = JaxbParser.buildXmlWithJaxb(guitarBrandsDto);
            writer.print(xml);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (GuitarShopException e) {
            writer.print(e.getXmlMassage());
        } catch (Throwable e) {
            GuitarShopException exception = new GuitarShopException(e);
            writer.print(exception.getXmlMassage());
        }
    }
}
