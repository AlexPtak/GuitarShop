import dao.GuitarDao;
import entity.Entity;
import mysql.MySqlGuitarDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class GetGuitarsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            GuitarDao guitarDao = new MySqlGuitarDao();
            for (Entity elem : guitarDao.getAll()) writer.print(elem.toString());
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
