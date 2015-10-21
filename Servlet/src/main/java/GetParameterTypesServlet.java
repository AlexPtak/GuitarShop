import dto.ParameterTypeDto;
import entity.Entity;
import services.GetParameterTypes;
import xmlbuilder.XmlBuilder;

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
        GetParameterTypes getParameterTypes = new GetParameterTypes();
        XmlBuilder xmlBuilder = new XmlBuilder();
        try {
            for (ParameterTypeDto elem : getParameterTypes.getParameterTypes()) xmlBuilder.buildXmlWithJaxb(elem, System.out);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
