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
import java.io.PrintWriter;

public class CreateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        StringBuilder builder = new StringBuilder();
//
//        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
//        builder.append("<CUSTOMER customer_id=\"3\">");
//        builder.append("<email>" + request.getParameter("email") + "</email>");
//        builder.append("<first_name>" + request.getParameter("firstName") + "</first_name>");
//        builder.append("<last_name>" + request.getParameter("lastName") + "</last_name>");
//        builder.append("<login>" + request.getParameter("login") + "</login>");
//        builder.append("<pass>" + request.getParameter("password") + "</pass>");
//        builder.append("<phone>" + request.getParameter("phone") + "</phone>");
//        builder.append("<status_id>1</status_id>");
//        builder.append("</CUSTOMER>");
//
//        String xmlFromBrowser = builder.toString();

        JaxbParser jaxbParser = new JaxbParser();
        CreateUser createUser = new CreateUser();
        PrintWriter writer = response.getWriter();

        String xmlFromBrowser = request.getParameter("textArea");

        try {
            CustomerDto customerDto = (CustomerDto) jaxbParser.buildObjectWithJaxb(new CustomerDto(), xmlFromBrowser);
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