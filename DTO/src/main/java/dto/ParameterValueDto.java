package dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PARAMETER_VALUE")
public class ParameterValueDto {

    private Integer parameterValueId;
    private String value;
    private Integer parameterTypeId;

    public Integer getParameterValueId() {
        return parameterValueId;
    }

    @XmlAttribute(name = "parameter_value_id")
    public void setParameterValueId(Integer parameterValueId) {
        this.parameterValueId = parameterValueId;
    }

    public String getValue() {
        return value;
    }

    @XmlElement(name = "value")
    public void setValue(String value) {
        this.value = value;
    }

    public Integer getParameterTypeId() {
        return parameterTypeId;
    }

    @XmlElement(name = "parameter_type_id")
    public void setParameterTypeId(Integer parameterTypeId) {
        this.parameterTypeId = parameterTypeId;
    }
}
