package services;

import dao.GuitarDao;
import mysql.MySqlGuitarDao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public class GetGuitars {

    GuitarDao guitarDao;

    public GetGuitars() throws PropertyVetoException, IOException, SQLException {
        guitarDao = new MySqlGuitarDao();
    }
}