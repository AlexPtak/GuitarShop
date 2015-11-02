package mysql;

import dao.ParameterTypeDao;
import dto.ParameterTypeDto;
import entity.Entity;
import entity.ParameterType;
import myUtils.GuitarShopException;

import java.util.ArrayList;
import java.util.List;

public class MySqlParameterTypeDao implements ParameterTypeDao {

    private GuitarShopManager guitarShopManager;

    public MySqlParameterTypeDao() throws GuitarShopException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Override
    public ParameterTypeDto searchById(int id) throws GuitarShopException {
        ParameterType parameterType = new ParameterType();
        parameterType.setId(id);
        return (ParameterTypeDto) guitarShopManager.singleSelect(parameterType).createDto();
    }

    @Override
    public String getTypeById(int id) throws GuitarShopException {
        ParameterType parameterType = new ParameterType();
        parameterType.setId(id);
        ParameterType selectedParameterType = (ParameterType) guitarShopManager.singleSelect(parameterType);
        return selectedParameterType.getType();
    }

    @Override
    public List<ParameterTypeDto> getAll() throws GuitarShopException {
        ParameterType parameterType = new ParameterType();
        List<Entity> entities = guitarShopManager.selectAll(parameterType);
        List<ParameterTypeDto> parameterTypeDtos = new ArrayList<ParameterTypeDto>();
        for (Entity elem : entities) parameterTypeDtos.add((ParameterTypeDto) elem.createDto());
        return parameterTypeDtos;
    }
}
