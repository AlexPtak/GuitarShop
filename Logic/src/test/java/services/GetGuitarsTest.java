package services;

import dto.GuitarDto;
import org.junit.Ignore;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class GetGuitarsTest {

    @Test
    @Ignore
    public void testGetGuitars() throws PropertyVetoException, IOException, SQLException {
        GetGuitars getGuitars = new GetGuitars();
        for (GuitarDto elem : getGuitars.getGuitars()) System.out.println(elem.toString());
    }
}