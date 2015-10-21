package mysql;

import dao.PurchaseDao;
import entity.Entity;
import entity.Purchase;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MqSqlPurchaseDao implements PurchaseDao {

    private GuitarShopManager guitarShopManager;

    public MqSqlPurchaseDao() throws PropertyVetoException, SQLException, IOException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Override
    public Entity searchById(int id) throws PropertyVetoException, SQLException, IOException {
        Purchase purchase = new Purchase();
        purchase.setId(id);
        return guitarShopManager.singleSelect(purchase, null);
    }

    @Override
    public List<Entity> getAll() throws PropertyVetoException, SQLException, IOException {
        Purchase purchase = new Purchase();
        return guitarShopManager.selectAll(purchase);
    }
}
