package mysql;

import dao.GuitarBrandDao;
import dto.GuitarBrandDto;
import entity.Entity;
import entity.GuitarBrand;
import myUtils.GuitarShopException;

import java.util.ArrayList;
import java.util.List;

public class MySqlGuitarBrandDao implements GuitarBrandDao {

    private GuitarShopManager guitarShopManager;

    public MySqlGuitarBrandDao() throws GuitarShopException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Override
    public GuitarBrandDto selectById(int id) throws GuitarShopException {
        GuitarBrand guitarBrand = new GuitarBrand();
        guitarBrand.setId(id);
        return (GuitarBrandDto) guitarShopManager.singleSelect(guitarBrand).createDto();
    }

    @Override
    public List<GuitarBrandDto> selectByBrand(String brand) throws GuitarShopException {
        GuitarBrand guitarBrand = new GuitarBrand();
        guitarBrand.setBrand(brand);
        List<Entity> entities = guitarShopManager.select(guitarBrand);
        List<GuitarBrandDto> guitarBrandDtos = new ArrayList<GuitarBrandDto>();
        for (Entity elem : entities) guitarBrandDtos.add((GuitarBrandDto) elem.createDto());
        return guitarBrandDtos;
    }

    @Override
    public String getBrandNameById(int id) throws GuitarShopException {
        GuitarBrand guitarBrand = new GuitarBrand();
        guitarBrand.setId(id);
        GuitarBrand selectedGuitarBrand = (GuitarBrand) guitarShopManager.singleSelect(guitarBrand);
        return selectedGuitarBrand.getBrand();
    }

    @Override
    public List<GuitarBrandDto> getAll() throws GuitarShopException {
        GuitarBrand guitarBrand = new GuitarBrand();
        List<Entity> entities = guitarShopManager.selectAll(guitarBrand);
        List<GuitarBrandDto> guitarBrandDtos = new ArrayList<GuitarBrandDto>();
        for (Entity elem : entities) guitarBrandDtos.add((GuitarBrandDto) elem.createDto());
        return guitarBrandDtos;
    }
}
