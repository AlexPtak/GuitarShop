import myUtils.GuitarShopException;
import services.Login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        Login login = new Login();
        try {
            writer.print(login.loginForServlet(request.getParameter("login"), request.getParameter("password")));
        } catch (GuitarShopException e) {
            writer.print(e.getXmlMassage());
        }
    }
}