package services;

import dto.*;
import myUtils.GuitarShopException;
import mysql.MySqlGuitarDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Search {

    public List<FullGuitarDto> searchGuitars(FullGuitarDto filter) throws GuitarShopException {

        if (filter.getGuitarDto() != null) System.out.println("color black");

        GuitarDto guitarDto = (filter.getGuitarDto() == null) ? new GuitarDto() : filter.getGuitarDto();

        if (filter.getGuitarStatus() != null) {
            GuitarStatusDto guitarStatusDto = filter.getGuitarStatus();
            guitarDto.setGuitarStatusId(guitarStatusDto.getStatusId());
            System.out.println("status");
        }

        if (filter.getGuitarBrand() != null) {
            GuitarBrandDto guitarBrandDto = filter.getGuitarBrand();
            guitarDto.setGuitarBrandId(guitarBrandDto.getBrandId());
            System.out.println("brand");
        }

        if (filter.getGuitarType() != null) {
            GuitarTypeDto guitarTypeDto = filter.getGuitarType();
            guitarDto.setGuitarTypeId(guitarTypeDto.getTypeId());
            System.out.println("type");
        }

        List<FullGuitarDto> fullGuitarDtos = new MySqlGuitarDao().searchByDtoFilter(guitarDto);

        if (filter.getParameterTypeValueDtos() != null) {

            List<FullGuitarDto> result = new ArrayList<FullGuitarDto>();

            for (FullGuitarDto elem : fullGuitarDtos) {
                for (Map.Entry<ParameterTypeDto, ParameterValueDto> mapElem : elem.getParameterTypeValueDtos().entrySet()) {
                    ParameterValueDto currentValue = mapElem.getValue();
                    if (filter.getParameterTypeValueDtos().containsValue(currentValue)) result.add(elem);
                }
            }
            System.out.println("return result");
            return result;
        } else {
            System.out.println("return fullGuitarDtos");
            return fullGuitarDtos;
        }
    }
}
