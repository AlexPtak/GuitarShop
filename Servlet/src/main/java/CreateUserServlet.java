import dto.CustomerDto;
import myUtils.GuitarShopException;
import services.CreateUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        CreateUser createUser = new CreateUser();
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName(request.getParameter("firstName"));
        customerDto.setLastName(request.getParameter("lastName"));
        customerDto.setEmail(request.getParameter("email"));
        customerDto.setPhone(request.getParameter("phone"));
        customerDto.setLogin(request.getParameter("login"));
        customerDto.setPass(request.getParameter("password"));
        try {
            writer.print(createUser.createUserForServlet(customerDto));
        } catch (GuitarShopException e) {
            writer.print(e.getXmlMassage());
        } catch (Throwable e) {
            GuitarShopException exception = new GuitarShopException(e);
            writer.print(exception.getXmlMassage());
        }
    }
}