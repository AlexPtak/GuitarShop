package mysql;

import dao.GuitarDao;
import dto.*;
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
        GuitarStatusDto guitarStatusDto = new MySqlGuitarStatusDao().searchById(guitarDto.getGuitarStatusId());
        GuitarBrandDto guitarBrandDto = new MySqlGuitarBrandDao().selectById(guitarDto.getGuitarBrandId());
        GuitarTypeDto guitarTypeDto = new MySqlGuitarTypeDao().searchById(guitarDto.getGuitarTypeId());

        fullGuitarDto.setGuitarDto(guitarDto);
        fullGuitarDto.setGuitarStatus(guitarStatusDto);
        fullGuitarDto.setGuitarBrand(guitarBrandDto);
        fullGuitarDto.setGuitarType(guitarTypeDto);

        List<ParameterDto> parameterDtos = new MySqlParameterDao().searchById(guitarDto.getGuitarId());
        Map<ParameterTypeDto, ParameterValueDto> parameterTypeValue = new HashMap<ParameterTypeDto, ParameterValueDto>();
        for (ParameterDto elem : parameterDtos) {
            ParameterTypeDto currentParameterTypeDto = new MySqlParameterTypeDao().searchById(elem.getParameterTypeId());
            ParameterValueDto currentParameterValueDto = new MySqlParameterValueDao().searchById(Integer.parseInt(elem.getValue()));
            parameterTypeValue.put(currentParameterTypeDto, currentParameterValueDto);
        }

        fullGuitarDto.setParameterTypeValueDtos(parameterTypeValue);

        fullGuitarDto.getGuitarDto().setGuitarStatusId(null);
        fullGuitarDto.getGuitarDto().setGuitarBrandId(null);
        fullGuitarDto.getGuitarDto().setGuitarTypeId(null);

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
