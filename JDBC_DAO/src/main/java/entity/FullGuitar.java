package entity;

import dto.*;
import mysql.*;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullGuitar {

    public FullGuitarDto createFullGuitarDto(int guitarId) throws PropertyVetoException, IOException, SQLException {

        FullGuitarDto fullGuitarDto = new FullGuitarDto();
        GuitarDto guitarDto = (GuitarDto) new MySqlGuitarDao().searchById(guitarId).createDto();

        fullGuitarDto.setGuitarId(guitarDto.getGuitarId());
        fullGuitarDto.setModel(guitarDto.getModel());
        fullGuitarDto.setPrice(guitarDto.getPrice());
        fullGuitarDto.setCountry(guitarDto.getCountry());
        fullGuitarDto.setColor(guitarDto.getColor());
        fullGuitarDto.setNumberOfStrings(guitarDto.getNumberOfStrings());
        fullGuitarDto.setNumberOfFrets(guitarDto.getNumberOfFrets());

        fullGuitarDto.setGuitarStatus(new MySqlGuitarStatusDao().getStatusById(guitarDto.getGuitarStatusId()));
        fullGuitarDto.setGuitarBrand(new MySqlGuitarBrandDao().getBrandNameById(guitarDto.getGuitarBrandId()));
        fullGuitarDto.setGuitarType(new MySqlGuitarTypeDao().getTypeNameById(guitarDto.getGuitarTypeId()));

        List<Entity> parameters = new MySqlParameterDao().getAll();
        List<ParameterDto> parameterDtos = new ArrayList<ParameterDto>();
        for (Entity elem : parameters) {
            ParameterDto parameterDto = (ParameterDto) elem.createDto();
            if (parameterDto.getGuitarId() == guitarId) parameterDtos.add(parameterDto);
        }

        Map<String, String> parameterTypeValue = new HashMap<String, String>();
        for (ParameterDto elem : parameterDtos) {
            String currentType = new MySqlParameterTypeDao().getTypeById(elem.getParameterTypeId());
            String currentValue = elem.getValue();
            parameterTypeValue.put(currentType, currentValue);
        }

        fullGuitarDto.setParameterTypeValue(parameterTypeValue);

        return fullGuitarDto;
    }
}
