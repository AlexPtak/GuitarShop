package dao;

import entity.Entity;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface GuitarTypeDao {

    public Entity searchById(int id) throws PropertyVetoException, SQLException, IOException;
    public String getTypeNameById(int id) throws SQLException;
    public List<Entity> getAll() throws PropertyVetoException, SQLException, IOException;
}
