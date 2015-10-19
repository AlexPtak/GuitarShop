package dao;

import entity.Entity;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ParameterTypeDao {

    public Entity searchById(int id) throws PropertyVetoException, SQLException, IOException;
    public List<Entity> getAll() throws PropertyVetoException, SQLException, IOException;
}
