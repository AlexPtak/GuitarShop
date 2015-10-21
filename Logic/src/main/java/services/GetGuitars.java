package services;

import dao.GuitarDao;
import dto.GuitarDto;
import entity.Entity;
import mysql.MySqlGuitarDao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetGuitars {

    public List<GuitarDto> getGuitars() throws PropertyVetoException, IOException, SQLException {
        GuitarDao guitarDao = new MySqlGuitarDao();
        List<GuitarDto> guitarDtos = new ArrayList<GuitarDto>();
        for (Entity elem : guitarDao.getAll()) guitarDtos.add((GuitarDto) elem.createDto());
        return guitarDtos;
    }
}