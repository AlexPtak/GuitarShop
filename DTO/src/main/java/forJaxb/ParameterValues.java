package forJaxb;

import dto.ParameterValueDto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "PARAMETER_VALUES")
public class ParameterValues {

    private List<ParameterValueDto> parameterValueDtos;

    public List<ParameterValueDto> getParameterValueDtos() {
        return parameterValueDtos;
    }

    @XmlElement(name = "PARAMETER_VALUE")
    public void setParameterValueDtos(List<ParameterValueDto> parameterValueDtos) {
        this.parameterValueDtos = parameterValueDtos;
    }
}