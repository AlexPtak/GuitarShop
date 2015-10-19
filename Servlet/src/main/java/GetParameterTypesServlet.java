import dao.ParameterTypeDao;
import entity.Entity;
import mysql.MySqlParameterTypeDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class GetParameterTypesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            ParameterTypeDao mySqlParameterTypeDao = new MySqlParameterTypeDao();
            for (Entity elem : mySqlParameterTypeDao.getAll()) writer.println(elem.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
