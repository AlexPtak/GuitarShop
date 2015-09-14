package dao;

import entity.Entity;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface GuitarBrandDao {

    public Entity selectById(int id) throws SQLException, IOException, PropertyVetoException;
    public List<Entity> selectByBrand(String brand) throws SQLException, IOException, PropertyVetoException;
}
