package services;

import dao.ParameterTypeDao;
import dto.ParameterTypeDto;
import entity.Entity;
import mysql.MySqlParameterTypeDao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetParameterTypes {

    public ParameterTypeDto getParameterType(int id) throws PropertyVetoException, IOException, SQLException {
        ParameterTypeDao parameterTypeDao = new MySqlParameterTypeDao();
        return (ParameterTypeDto) parameterTypeDao.searchById(id).createDto();
    }

    public List<ParameterTypeDto> getParameterTypes() throws PropertyVetoException, IOException, SQLException {
        ParameterTypeDao parameterTypeDao = new MySqlParameterTypeDao();
        List<ParameterTypeDto> parameterTypeDtos = new ArrayList<ParameterTypeDto>();
        for (Entity elem : parameterTypeDao.getAll()) parameterTypeDtos.add((ParameterTypeDto) elem.createDto());
        return parameterTypeDtos;
    }
}
