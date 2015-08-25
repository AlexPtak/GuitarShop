package dao;

import java.sql.SQLException;
import java.util.List;

public interface GuitarBrandDao {

    public Entity selectById(int id) throws SQLException;
    public List<Entity> selectByBrand(String brand) throws SQLException;
}
