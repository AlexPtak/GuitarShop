import dto.FullGuitarDto;
import forJaxb.FullGuitars;
import myUtils.GuitarShopException;
import parser.JaxbParser;
import services.Search;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        Search search = new Search();

        String testXml = request.getParameter("textAreaForSearch");
        System.out.println(testXml);
        InputStream xmlFromBrowser = request.getInputStream();

        try {
            Object o = JaxbParser.buildObjectWithJaxb(new FullGuitarDto(), testXml);
            List<FullGuitarDto> fullGuitarDtos = search.searchGuitars((FullGuitarDto) o);
            FullGuitars fullGuitars = new FullGuitars();
            fullGuitars.setFullGuitarDtos(fullGuitarDtos);
            writer.print(JaxbParser.buildXmlWithJaxb(fullGuitars));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            GuitarShopException exception = new GuitarShopException(e);
            writer.print(exception.getXmlMassage());
        }
    }
}
