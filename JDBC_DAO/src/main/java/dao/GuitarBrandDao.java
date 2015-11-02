package dao;

import dto.GuitarBrandDto;
import myUtils.GuitarShopException;

import java.util.List;

public interface GuitarBrandDao {

    public GuitarBrandDto selectById(int id) throws GuitarShopException;
    public List<GuitarBrandDto> selectByBrand(String brand) throws GuitarShopException;
    public String getBrandNameById(int id) throws GuitarShopException;
    public List<GuitarBrandDto> getAll() throws GuitarShopException;
}
