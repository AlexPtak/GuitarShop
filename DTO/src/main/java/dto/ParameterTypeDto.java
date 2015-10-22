package dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PARAMETER_TYPE")
public class ParameterTypeDto {

    private int parameterTypeId;
    private String type;

    public int getParameterTypeId() {
        return parameterTypeId;
    }

    @XmlAttribute(name = "parameter_type_id")
    public void setParameterTypeId(int parameterTypeId) {
        this.parameterTypeId = parameterTypeId;
    }

    public String getType() {
        return type;
    }

    @XmlElement(name = "TYPE")
    public void setType(String type) {
        this.type = type;
    }
}
