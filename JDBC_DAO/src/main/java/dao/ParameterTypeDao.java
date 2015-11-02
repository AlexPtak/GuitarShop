package dao;

import dto.ParameterTypeDto;
import myUtils.GuitarShopException;

import java.util.List;

public interface ParameterTypeDao {

    public ParameterTypeDto searchById(int id) throws GuitarShopException;
    public String getTypeById(int id) throws GuitarShopException;
    public List<ParameterTypeDto> getAll() throws GuitarShopException;
}
