package services;

import myUtils.GuitarShopException;
import org.junit.Test;

public class LoginTest {

    @Test
    public void testLoginForServlet() {
        Login login = new Login();
        try {
            System.out.println(login.loginForServlet("Login", "sd"));
        } catch (GuitarShopException e) {
            System.out.println(e.getMessage());
        }
    }
}