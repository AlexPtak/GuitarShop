import forJaxb.GuitarTypes;
import myUtils.GuitarShopException;
import parser.JaxbParser;
import services.GetGuitarType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.PrintWriter;

public class GetGuitarTypesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        GetGuitarType getGuitarType = new GetGuitarType();
        try {
            GuitarTypes guitarTypesDto = getGuitarType.getCatalogInXml();
            String xml = JaxbParser.buildXmlWithJaxb(guitarTypesDto);
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
