package mysql;

import dao.ParameterTypeDao;
import entity.Entity;
import entity.ParameterType;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MySqlParameterTypeDao implements ParameterTypeDao {

    private GuitarShopManager guitarShopManager;

    public MySqlParameterTypeDao() throws PropertyVetoException, SQLException, IOException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Override
    public Entity searchById(int id) throws PropertyVetoException, SQLException, IOException {
        ParameterType parameterType = new ParameterType();
        parameterType.setId(id);
        return guitarShopManager.singleSelect(parameterType, null);
    }

    @Override
    public String getTypeById(int id) throws SQLException {
        ParameterType parameterType = new ParameterType();
        parameterType.setId(id);
        ParameterType selectedParameterType = (ParameterType) guitarShopManager.singleSelect(parameterType, null);
        return selectedParameterType.getType();
    }

    @Override
    public List<Entity> getAll() throws PropertyVetoException, SQLException, IOException {
        ParameterType parameterType = new ParameterType();
        return guitarShopManager.selectAll(parameterType);
    }
}
