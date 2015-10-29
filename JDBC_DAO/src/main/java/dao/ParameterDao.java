package dao;

import entity.Entity;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ParameterDao {

    public List<Entity> searchById(int guitarId) throws SQLException;
    public List<Entity> getAll() throws PropertyVetoException, SQLException, IOException;
}
