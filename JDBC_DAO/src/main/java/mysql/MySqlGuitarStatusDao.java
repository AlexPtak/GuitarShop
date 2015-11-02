package mysql;

import dao.GuitarStatusDao;
import dto.GuitarStatusDto;
import entity.Entity;
import entity.GuitarStatus;
import myUtils.GuitarShopException;

import java.util.ArrayList;
import java.util.List;

public class MySqlGuitarStatusDao implements GuitarStatusDao {

    private GuitarShopManager guitarShopManager;

    public MySqlGuitarStatusDao() throws GuitarShopException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Override
    public GuitarStatusDto searchById(int id) throws GuitarShopException {
        GuitarStatus guitarStatus = new GuitarStatus();
        guitarStatus.setId(id);
        return (GuitarStatusDto) guitarShopManager.singleSelect(guitarStatus).createDto();
    }

    @Override
    public String getStatusById(int id) throws GuitarShopException {
        GuitarStatus guitarStatus = new GuitarStatus();
        guitarStatus.setId(id);
        GuitarStatus selectedGuitarStatus = (GuitarStatus) guitarShopManager.singleSelect(guitarStatus);
        return selectedGuitarStatus.getStatus();
    }

    @Override
    public List<GuitarStatusDto> getAll() throws GuitarShopException {
        GuitarStatus guitarStatus = new GuitarStatus();
        List<Entity> entities = guitarShopManager.selectAll(guitarStatus);
        List<GuitarStatusDto> guitarStatusDtos = new ArrayList<GuitarStatusDto>();
        for (Entity elem : entities) guitarStatusDtos.add((GuitarStatusDto) elem.createDto());
        return guitarStatusDtos;
    }
}
