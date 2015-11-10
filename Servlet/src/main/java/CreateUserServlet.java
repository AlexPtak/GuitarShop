import dto.CustomerDto;
import myUtils.GuitarShopException;
import parser.JaxbParser;
import services.CreateUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class CreateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CreateUser createUser = new CreateUser();
        PrintWriter writer = response.getWriter();

        //String xmlFromBrowser = request.getParameter("textArea");
        InputStream xmlFromBrowser = request.getInputStream();

        try {
            CustomerDto customerDto = (CustomerDto) JaxbParser.buildObjectWithJaxb(new CustomerDto(), xmlFromBrowser);
            String xmlResponseFromService = createUser.createUserForServlet(customerDto);
            writer.print(xmlResponseFromService);
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