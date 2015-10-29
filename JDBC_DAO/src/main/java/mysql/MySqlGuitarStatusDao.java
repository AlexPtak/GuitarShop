package mysql;

import dao.GuitarStatusDao;
import entity.Entity;
import entity.GuitarStatus;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MySqlGuitarStatusDao implements GuitarStatusDao {

    private GuitarShopManager guitarShopManager;

    public MySqlGuitarStatusDao() throws PropertyVetoException, SQLException, IOException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Override
    public Entity searchById(int id) throws PropertyVetoException, SQLException, IOException {
        GuitarStatus guitarStatus = new GuitarStatus();
        guitarStatus.setId(id);
        return guitarShopManager.singleSelect(guitarStatus, null);
    }

    @Override
    public String getStatusById(int id) throws SQLException {
        GuitarStatus guitarStatus = new GuitarStatus();
        guitarStatus.setId(id);
        GuitarStatus selectedGuitarStatus = (GuitarStatus) guitarShopManager.singleSelect(guitarStatus, null);
        return selectedGuitarStatus.getStatus();
    }

    @Override
    public List<Entity> getAll() throws PropertyVetoException, SQLException, IOException {
        GuitarStatus guitarStatus = new GuitarStatus();
        return guitarShopManager.selectAll(guitarStatus);
    }
}
