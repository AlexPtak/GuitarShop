package dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GUITAR_TYPE")
public class GuitarTypeDto {

    private Integer typeId;
    private String type;

    public Integer getTypeId() {
        return typeId;
    }

    @XmlAttribute(name = "type_id")
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    @XmlElement(name = "type")
    public void setType(String type) {
        this.type = type;
    }
}
