package dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PARAMETER_TYPE")
public class ParameterTypeDto {

    private Integer parameterTypeId;
    private String type;

    public Integer getParameterTypeId() {
        return parameterTypeId;
    }

    @XmlAttribute(name = "parameter_type_id")
    public void setParameterTypeId(Integer parameterTypeId) {
        this.parameterTypeId = parameterTypeId;
    }

    public String getType() {
        return type;
    }

    @XmlElement(name = "type")
    public void setType(String type) {
        this.type = type;
    }
}
