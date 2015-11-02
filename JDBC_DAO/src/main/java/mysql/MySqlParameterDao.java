package mysql;

import dao.ParameterDao;
import dto.ParameterDto;
import entity.Entity;
import entity.Parameter;
import myUtils.GuitarShopException;

import java.util.ArrayList;
import java.util.List;

public class MySqlParameterDao implements ParameterDao {

    private GuitarShopManager guitarShopManager;

    public MySqlParameterDao() throws GuitarShopException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Override
    public List<ParameterDto> searchById(int guitarId) throws GuitarShopException {
        Parameter parameter = new Parameter();
        parameter.setId(guitarId);
        List<Entity> entities = guitarShopManager.select(parameter);
        List<ParameterDto> parameterDtos = new ArrayList<ParameterDto>();
        for (Entity elem : entities) parameterDtos.add((ParameterDto) elem.createDto());
        return parameterDtos;
    }

    @Override
    public List<ParameterDto> getAll() throws GuitarShopException {
        Parameter parameter = new Parameter();
        List<Entity> entities = guitarShopManager.selectAll(parameter);
        List<ParameterDto> parameterDtos = new ArrayList<ParameterDto>();
        for (Entity elem : entities) parameterDtos.add((ParameterDto) elem.createDto());
        return parameterDtos;
    }
}
