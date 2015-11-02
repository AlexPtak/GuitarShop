package mysql;

import dao.GuitarInPurchaseDao;
import dto.GuitarInPurchaseDto;
import entity.Entity;
import entity.GuitarInPurchase;
import myUtils.GuitarShopException;

import java.util.ArrayList;
import java.util.List;

public class MySqlGuitarInPurchaseDao implements GuitarInPurchaseDao {

    private GuitarShopManager guitarShopManager;

    public MySqlGuitarInPurchaseDao() throws GuitarShopException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Override
    public GuitarInPurchaseDto searchById(int id) throws GuitarShopException {
        GuitarInPurchase guitarInPurchase = new GuitarInPurchase();
        guitarInPurchase.setPurchaseId(id);
        return (GuitarInPurchaseDto) guitarShopManager.singleSelect(guitarInPurchase).createDto();
    }

    @Override
    public List<GuitarInPurchaseDto> getAll() throws GuitarShopException {
        GuitarInPurchase guitarInPurchase = new GuitarInPurchase();
        List<Entity> entities = guitarShopManager.selectAll(guitarInPurchase);
        List<GuitarInPurchaseDto> guitarInPurchaseDtos = new ArrayList<GuitarInPurchaseDto>();
        for (Entity elem : entities) guitarInPurchaseDtos.add((GuitarInPurchaseDto) elem.createDto());
        return guitarInPurchaseDtos;
    }
}
