package mysql;

import dao.PurchaseDao;
import dto.PurchaseDto;
import entity.Entity;
import entity.Purchase;
import myUtils.GuitarShopException;

import java.util.ArrayList;
import java.util.List;

public class MqSqlPurchaseDao implements PurchaseDao {

    private GuitarShopManager guitarShopManager;

    public MqSqlPurchaseDao() throws GuitarShopException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Override
    public PurchaseDto searchById(int id) throws GuitarShopException {
        Purchase purchase = new Purchase();
        purchase.setId(id);
        return (PurchaseDto) guitarShopManager.singleSelect(purchase).createDto();
    }

    @Override
    public List<PurchaseDto> getAll() throws GuitarShopException {
        Purchase purchase = new Purchase();
        List<Entity> entities = guitarShopManager.selectAll(purchase);
        List<PurchaseDto> purchaseDtos = new ArrayList<PurchaseDto>();
        for (Entity elem : entities) purchaseDtos.add((PurchaseDto) elem.createDto());
        return purchaseDtos;
    }
}
