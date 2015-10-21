package mysql;

import dao.ParameterValueDao;
import entity.Entity;
import entity.ParameterValue;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MqSqlParameterValueDao implements ParameterValueDao {

    private GuitarShopManager guitarShopManager;

    public MqSqlParameterValueDao() throws PropertyVetoException, SQLException, IOException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Override
    public Entity searchById(int id) throws PropertyVetoException, SQLException, IOException {
        ParameterValue parameterValue = new ParameterValue();
        parameterValue.setId(id);
        return guitarShopManager.singleSelect(parameterValue, null);
    }

    @Override
    public List<Entity> getAll() throws PropertyVetoException, SQLException, IOException {
        ParameterValue parameterValue = new ParameterValue();
        return guitarShopManager.selectAll(parameterValue);
    }
}
