package dao;

import dto.ParameterValueDto;
import myUtils.GuitarShopException;

import java.util.List;

public interface ParameterValueDao {

    public ParameterValueDto searchById(int id) throws GuitarShopException;
    public List<ParameterValueDto> getAll() throws GuitarShopException;
}
