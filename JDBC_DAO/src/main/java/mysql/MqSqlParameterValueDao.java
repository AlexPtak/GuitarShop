package mysql;

import dao.ParameterValueDao;
import dto.ParameterValueDto;
import entity.Entity;
import entity.ParameterValue;
import myUtils.GuitarShopException;

import java.util.ArrayList;
import java.util.List;

public class MqSqlParameterValueDao implements ParameterValueDao {

    private GuitarShopManager guitarShopManager;

    public MqSqlParameterValueDao() throws GuitarShopException {
        guitarShopManager = GuitarShopManager.getInstance();

    }

    @Override
    public ParameterValueDto searchById(int id) throws GuitarShopException {
        ParameterValue parameterValue = new ParameterValue();
        parameterValue.setId(id);
        return (ParameterValueDto) guitarShopManager.singleSelect(parameterValue).createDto();
    }

    @Override
    public List<ParameterValueDto> getAll() throws GuitarShopException {
        ParameterValue parameterValue = new ParameterValue();
        List<Entity> entities = guitarShopManager.selectAll(parameterValue);
        List<ParameterValueDto> parameterValueDtos = new ArrayList<ParameterValueDto>();
        for (Entity elem : entities) parameterValueDtos.add((ParameterValueDto) elem.createDto());
        return parameterValueDtos;
    }
}
