package dao;

import entity.Entity;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {

    public Entity searchById(int id) throws SQLException, IOException, PropertyVetoException;
    public Entity searchByLogin(String login) throws SQLException;
    public Entity searchByPassword(String pass) throws SQLException;
    public List<Entity> getAll() throws PropertyVetoException, SQLException, IOException;
    public void insertCustomer(String firstName, String lastName, String email, String phone, String login, String pass, int status) throws PropertyVetoException, SQLException, IOException;
}
