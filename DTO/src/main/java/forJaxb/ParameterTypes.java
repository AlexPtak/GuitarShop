package forJaxb;

import dto.ParameterTypeDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "PARAMETER_TYPES")
public class ParameterTypes {

    private List<ParameterTypeDto> parameterTypeDtos;

    public List<ParameterTypeDto> getParameterTypeDtos() {
        return parameterTypeDtos;
    }

    @XmlElement(name = "PARAMETER_TYPE")
    public void setParameterTypeDtos(List<ParameterTypeDto> parameterTypeDtos) {
        this.parameterTypeDtos = parameterTypeDtos;
    }
}
