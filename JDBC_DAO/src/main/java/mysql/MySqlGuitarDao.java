package mysql;

import dao.GuitarDao;
import dto.FullGuitarDto;
import dto.GuitarDto;
import dto.ParameterDto;
import entity.Entity;
import entity.Guitar;
import myUtils.GuitarShopException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySqlGuitarDao implements GuitarDao {

    private GuitarShopManager guitarShopManager;

    public MySqlGuitarDao() throws GuitarShopException {
        guitarShopManager = GuitarShopManager.getInstance();
    }

    @Override
    public GuitarDto searchById(int id) throws GuitarShopException {
        Guitar guitar = new Guitar();
        guitar.setId(id);
        return (GuitarDto) guitarShopManager.singleSelect(guitar).createDto();
    }

    @Override
    public List<GuitarDto> getAll() throws GuitarShopException {
        Guitar guitar = new Guitar();
        List<Entity> entities = guitarShopManager.selectAll(guitar);
        List<GuitarDto> guitarDtos = new ArrayList<GuitarDto>();
        for (Entity elem : entities) guitarDtos.add((GuitarDto) elem.createDto());
        return guitarDtos;
    }

    @Override
    public FullGuitarDto getFullGuitarById(int id) throws GuitarShopException {

        FullGuitarDto fullGuitarDto = new FullGuitarDto();
        GuitarDto guitarDto = new MySqlGuitarDao().searchById(id);
        fullGuitarDto.setGuitarDto(guitarDto);

        fullGuitarDto.setGuitarStatus(new MySqlGuitarStatusDao().getStatusById(guitarDto.getGuitarStatusId()));
        fullGuitarDto.setGuitarBrand(new MySqlGuitarBrandDao().getBrandNameById(guitarDto.getGuitarBrandId()));
        fullGuitarDto.setGuitarType(new MySqlGuitarTypeDao().getTypeNameById(guitarDto.getGuitarTypeId()));

        List<ParameterDto> parameterDtos = new MySqlParameterDao().getAll();
        Map<String, String> parameterTypeValue = new HashMap<String, String>();
        for (ParameterDto elem : parameterDtos) {
            if (elem.getGuitarId() == id) {
                String currentType = new MySqlParameterTypeDao().getTypeById(elem.getParameterTypeId());
                String currentValue = elem.getValue();
                parameterTypeValue.put(currentType, currentValue);
            }
        }

        fullGuitarDto.setParameterTypeValue(parameterTypeValue);

        return fullGuitarDto;
    }

    @Override
    public List<FullGuitarDto> getAllFullGuitar() throws GuitarShopException {
        List<GuitarDto> guitarDtos = new MySqlGuitarDao().getAll();
        List<FullGuitarDto> fullGuitarDtos = new ArrayList<FullGuitarDto>();
        for (GuitarDto elem : guitarDtos) fullGuitarDtos.add(getFullGuitarById(elem.getGuitarId()));
        return fullGuitarDtos;
    }
}
