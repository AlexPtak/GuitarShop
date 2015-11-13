package dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PURCHASE")
public class PurchaseDto {

    private Integer purchaseId;
    private Integer count;
    private Integer customerId;
    private Integer guitarId;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    @XmlAttribute(name = "purchase_id")
    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getCount() {
        return count;
    }

    @XmlElement(name = "count")
    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    @XmlElement(name = "customer_id")
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getGuitarId() {
        return guitarId;
    }

    @XmlElement(name = "guitar_id")
    public void setGuitarId(Integer guitarId) {
        this.guitarId = guitarId;
    }
}
