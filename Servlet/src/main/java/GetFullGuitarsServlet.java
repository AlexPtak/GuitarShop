import forJaxb.FullGuitars;
import myUtils.GuitarShopException;
import parser.JaxbParser;
import services.GetFullGuitar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.PrintWriter;

public class GetFullGuitarsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        GetFullGuitar getFullGuitar = new GetFullGuitar();
        try {
            FullGuitars fullGuitarsDto = getFullGuitar.getCatalogInXml();
            String xml = JaxbParser.buildXmlWithJaxb(fullGuitarsDto);
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
