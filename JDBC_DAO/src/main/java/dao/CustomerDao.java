package dao;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {

    public Entity searchById(int id) throws SQLException;
    public List<Entity> searchByBrandAnType(String lastName, String mail) throws SQLException;
}
