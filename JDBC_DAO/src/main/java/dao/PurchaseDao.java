package dao;

import dto.PurchaseDto;
import myUtils.GuitarShopException;

import java.util.List;

public interface PurchaseDao {

    public PurchaseDto searchById(int id) throws GuitarShopException;
    public List<PurchaseDto> getAll() throws GuitarShopException;
}
