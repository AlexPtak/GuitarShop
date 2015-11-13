package dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GUITAR_IN_PURCHASE")
public class GuitarInPurchaseDto {

    private Integer purchaseId;
    private Integer guitarId;
    private Integer count;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    @XmlAttribute(name = "purchase_id")
    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getGuitarId() {
        return guitarId;
    }

    @XmlElement(name = "guitar_id")
    public void setGuitarId(Integer guitarId) {
        this.guitarId = guitarId;
    }

    public Integer getCount() {
        return count;
    }

    @XmlElement(name = "count")
    public void setCount(Integer count) {
        this.count = count;
    }
}
