package mysql;

import dao.Entity;
import dao.GuitarBrandDao;
import entities.GuitarBrand;

import java.sql.SQLException;
import java.util.List;

public class MySqlGuitarBrand implements GuitarBrandDao {

    @Override
    public Entity selectById(int id) throws SQLException {
        TransactionManager transactionManager = new TransactionManager();
        GuitarBrand guitarBrand = new GuitarBrand();
        guitarBrand.setId(id);
        return transactionManager.singleSelect(guitarBrand, null);
    }

    @Override
    public List<Entity> selectByBrand(String brand) throws SQLException {
        TransactionManager transactionManager = new TransactionManager();
        GuitarBrand guitarBrand = new GuitarBrand();
        guitarBrand.setBrand(brand);
        return transactionManager.select(guitarBrand, null);
    }
}
