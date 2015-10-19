package mysql;

import dao.GuitarDao;
import entity.Entity;
import entity.Guitar;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MySqlGuitarDao implements GuitarDao {

    private GuitarShopManager guitarShopManager;

    public MySqlGuitarDao() throws PropertyVetoException, SQLException, IOException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Override
    public Entity searchById(int id) throws PropertyVetoException, SQLException, IOException {
        Guitar guitar = new Guitar();
        guitar.setId(id);
        return guitarShopManager.singleSelect(guitar, null);
    }

    @Override
    public List<Entity> getAll() throws PropertyVetoException, SQLException, IOException {
        Guitar guitar = new Guitar();
        return guitarShopManager.selectAll(guitar);
    }
}
