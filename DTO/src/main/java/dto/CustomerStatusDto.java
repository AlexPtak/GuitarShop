package dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CUSTOMER_STATUS")
public class CustomerStatusDto {

    private int statusId;
    private char status;
    private String desc;

    public int getStatusId() {
        return statusId;
    }

    @XmlAttribute(name = "status_id")
    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public char getStatus() {
        return status;
    }

    @XmlElement(name = "status")
    public void setStatus(char status) {
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
