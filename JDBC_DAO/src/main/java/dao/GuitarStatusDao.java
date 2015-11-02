package dao;

import dto.GuitarStatusDto;
import myUtils.GuitarShopException;

import java.util.List;

public interface GuitarStatusDao {

    public GuitarStatusDto searchById(int id) throws GuitarShopException;
    public String getStatusById(int id) throws GuitarShopException;
    public List<GuitarStatusDto> getAll() throws GuitarShopException;
}
