package dao;

import dto.GuitarInPurchaseDto;
import myUtils.GuitarShopException;

import java.util.List;

public interface GuitarInPurchaseDao {

    public GuitarInPurchaseDto searchById(int id) throws GuitarShopException;
    public List<GuitarInPurchaseDto> getAll() throws GuitarShopException;
}
