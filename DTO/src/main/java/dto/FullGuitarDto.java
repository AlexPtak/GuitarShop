package dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Map;

@XmlRootElement(name = "FULL_GUITAR")
@XmlType(propOrder={"guitarDto", "guitarBrand", "guitarType", "guitarStatus", "parameterTypeValueDtos"})
public class FullGuitarDto {

    private GuitarDto guitarDto;
    private GuitarStatusDto guitarStatus;
    private GuitarBrandDto guitarBrand;
    private GuitarTypeDto guitarType;
    private Map<ParameterTypeDto, ParameterValueDto> parameterTypeValueDtos;

    public GuitarDto getGuitarDto() {
        return guitarDto;
    }

    @XmlElement(name = "guitar")
    public void setGuitarDto(GuitarDto guitarDto) {
        this.guitarDto = guitarDto;
    }

    public GuitarStatusDto getGuitarStatus() {
        return guitarStatus;
    }

    @XmlElement(name = "guitar_status")
    public void setGuitarStatus(GuitarStatusDto guitarStatus) {
        this.guitarStatus = guitarStatus;
    }

    public GuitarBrandDto getGuitarBrand() {
        return guitarBrand;
    }

    @XmlElement(name = "guitar_brand")
    public void setGuitarBrand(GuitarBrandDto guitarBrand) {
        this.guitarBrand = guitarBrand;
    }

    public GuitarTypeDto getGuitarType() {
        return guitarType;
    }

    @XmlElement(name = "guitar_type")
    public void setGuitarType(GuitarTypeDto guitarType) {
        this.guitarType = guitarType;
    }

    public Map<ParameterTypeDto, ParameterValueDto> getParameterTypeValueDtos() {
        return parameterTypeValueDtos;
    }

    @XmlElementWrapper(name = "parameter_Type-Value")
    public void setParameterTypeValueDtos(Map<ParameterTypeDto, ParameterValueDto> parameterTypeValueDtos) {
        this.parameterTypeValueDtos = parameterTypeValueDtos;
    }
}
