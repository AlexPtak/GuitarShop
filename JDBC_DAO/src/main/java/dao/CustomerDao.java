package dao;

import entity.Entity;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {

    public Entity searchById(int id) throws SQLException, IOException, PropertyVetoException;
    public List<Entity> searchByBrandAnType(String lastName, String mail) throws SQLException, IOException, PropertyVetoException;
}
