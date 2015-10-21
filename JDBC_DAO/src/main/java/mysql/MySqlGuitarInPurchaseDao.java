package mysql;

import dao.GuitarInPurchaseDao;
import entity.Entity;
import entity.GuitarInPurchase;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MySqlGuitarInPurchaseDao implements GuitarInPurchaseDao {

    private GuitarShopManager guitarShopManager;

    public MySqlGuitarInPurchaseDao() throws PropertyVetoException, SQLException, IOException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Override
    public Entity searchById(int id) throws PropertyVetoException, SQLException, IOException {
        GuitarInPurchase guitarInPurchase = new GuitarInPurchase();
        guitarInPurchase.setPurchaseId(id);
        return guitarShopManager.singleSelect(guitarInPurchase, null);
    }

    @Override
    public List<Entity> getAll() throws PropertyVetoException, SQLException, IOException {
        GuitarInPurchase guitarInPurchase = new GuitarInPurchase();
        return guitarShopManager.selectAll(guitarInPurchase);
    }
}
