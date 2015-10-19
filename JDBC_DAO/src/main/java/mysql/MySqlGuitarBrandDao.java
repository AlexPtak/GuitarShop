package mysql;

import dao.GuitarBrandDao;
import entity.Entity;
import entity.GuitarBrand;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MySqlGuitarBrandDao implements GuitarBrandDao {

    private GuitarShopManager guitarShopManager;

    public MySqlGuitarBrandDao() throws PropertyVetoException, SQLException, IOException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Override
    public Entity selectById(int id) throws SQLException, IOException, PropertyVetoException {
        GuitarBrand guitarBrand = new GuitarBrand();
        guitarBrand.setId(id);
        return guitarShopManager.singleSelect(guitarBrand, null);
    }

    @Override
    public List<Entity> selectByBrand(String brand) throws SQLException, IOException, PropertyVetoException {
        GuitarBrand guitarBrand = new GuitarBrand();
        guitarBrand.setBrand(brand);
        return guitarShopManager.select(guitarBrand, null);
    }

    @Override
    public List<Entity> getAll() throws PropertyVetoException, SQLException, IOException {
        GuitarBrand guitarBrand = new GuitarBrand();
        return guitarShopManager.selectAll(guitarBrand);
    }
}
