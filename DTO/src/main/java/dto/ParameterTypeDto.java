package dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ParameterTypeDto {

    private int parameterTypeId;
    private String type;

    public int getParameterTypeId() {
        return parameterTypeId;
    }

    @XmlAttribute
    public void setParameterTypeId(int parameterTypeId) {
        this.parameterTypeId = parameterTypeId;
    }

    public String getType() {
        return type;
    }

    @XmlElement
    public void setType(String type) {
        this.type = type;
    }
}
