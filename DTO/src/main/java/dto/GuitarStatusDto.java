package dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GUITAR_STATUS")
public class GuitarStatusDto {

    private Integer statusId;
    private String status;
    private String desc;

    public Integer getStatusId() {
        return statusId;
    }

    @XmlAttribute(name = "status_id")
    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    @XmlElement(name = "status")
    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    @XmlElement(name = "desc")
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
