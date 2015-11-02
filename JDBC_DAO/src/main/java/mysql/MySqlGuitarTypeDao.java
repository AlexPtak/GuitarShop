package mysql;

import dao.GuitarTypeDao;
import dto.GuitarTypeDto;
import entity.Entity;
import entity.GuitarType;
import myUtils.GuitarShopException;

import java.util.ArrayList;
import java.util.List;

public class MySqlGuitarTypeDao implements GuitarTypeDao {

    private GuitarShopManager guitarShopManager;

    public MySqlGuitarTypeDao() throws GuitarShopException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Override
    public GuitarTypeDto searchById(int id) throws GuitarShopException {
        GuitarType guitarType = new GuitarType();
        guitarType.setId(id);
        return (GuitarTypeDto) guitarShopManager.singleSelect(guitarType).createDto();
    }

    @Override
    public String getTypeNameById(int id) throws GuitarShopException {
        GuitarType guitarType = new GuitarType();
        guitarType.setId(id);
        GuitarType selectedGuitarType = (GuitarType) guitarShopManager.singleSelect(guitarType);
        return selectedGuitarType.getType();
    }

    @Override
    public List<GuitarTypeDto> getAll() throws GuitarShopException {
        GuitarType guitarType = new GuitarType();
        List<Entity> entities = guitarShopManager.selectAll(guitarType);
        List<GuitarTypeDto> guitarTypeDtos = new ArrayList<GuitarTypeDto>();
        for (Entity elem : entities) guitarTypeDtos.add((GuitarTypeDto) elem.createDto());
        return guitarTypeDtos;
    }
}
