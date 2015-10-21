package mysql;

import dao.ParameterDao;
import entity.Entity;
import entity.Parameter;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MySqlParameterDao implements ParameterDao {

    private GuitarShopManager guitarShopManager;

    public MySqlParameterDao() throws PropertyVetoException, SQLException, IOException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Override
    public Entity searchById(int id) throws PropertyVetoException, SQLException, IOException {
        Parameter parameter = new Parameter();
        parameter.setId(id);
        return guitarShopManager.singleSelect(parameter, null);
    }

    @Override
    public List<Entity> getAll() throws PropertyVetoException, SQLException, IOException {
        Parameter parameter = new Parameter();
        return guitarShopManager.selectAll(parameter);
    }
}
