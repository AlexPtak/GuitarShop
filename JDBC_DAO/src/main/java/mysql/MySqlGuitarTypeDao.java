package mysql;

import dao.GuitarTypeDao;
import entity.Entity;
import entity.GuitarType;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MySqlGuitarTypeDao implements GuitarTypeDao {

    private GuitarShopManager guitarShopManager;

    public MySqlGuitarTypeDao() throws PropertyVetoException, SQLException, IOException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Override
    public Entity searchById(int id) throws PropertyVetoException, SQLException, IOException {
        GuitarType guitarType = new GuitarType();
        guitarType.setId(id);
        return guitarShopManager.singleSelect(guitarType, null);
    }

    @Override
    public List<Entity> getAll() throws PropertyVetoException, SQLException, IOException {
        GuitarType guitarType = new GuitarType();
        return guitarShopManager.selectAll(guitarType);
    }
}
