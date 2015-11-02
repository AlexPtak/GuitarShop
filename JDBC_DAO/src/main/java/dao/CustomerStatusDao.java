package dao;

import dto.GuitarStatusDto;
import myUtils.GuitarShopException;

import java.util.List;

public interface CustomerStatusDao {

    public GuitarStatusDto searchById(int id) throws GuitarShopException;
    public List<GuitarStatusDto> getAll() throws GuitarShopException;
}
