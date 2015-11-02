package dao;

import dto.FullGuitarDto;
import dto.GuitarDto;
import myUtils.GuitarShopException;

import java.util.List;

public interface GuitarDao {

    public GuitarDto searchById(int id) throws GuitarShopException;
    public List<GuitarDto> getAll() throws GuitarShopException;
    public FullGuitarDto getFullGuitarById(int id) throws GuitarShopException;
}
