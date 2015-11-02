package dao;

import dto.GuitarTypeDto;
import myUtils.GuitarShopException;

import java.util.List;

public interface GuitarTypeDao {

    public GuitarTypeDto searchById(int id) throws GuitarShopException;
    public String getTypeNameById(int id) throws GuitarShopException;
    public List<GuitarTypeDto> getAll() throws GuitarShopException;
}
