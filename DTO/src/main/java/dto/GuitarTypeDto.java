package dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GUITAR_TYPE")
public class GuitarTypeDto {

    private int typeId;
    private String type;

    public int getTypeId() {
        return typeId;
    }

    @XmlAttribute(name = "type_id")
    public void setTypeId(int typeId) {
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
