package dao;

import dto.ParameterDto;
import myUtils.GuitarShopException;

import java.util.List;

public interface ParameterDao {

    public List<ParameterDto> searchById(int guitarId) throws GuitarShopException;
    public List<ParameterDto> getAll() throws GuitarShopException;
}
