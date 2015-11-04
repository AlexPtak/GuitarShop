package dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PURCHASE")
public class PurchaseDto {

    private int purchaseId;
    private int count;
    private int customerId;
    private int guitarId;

    public int getPurchaseId() {
        return purchaseId;
    }

    @XmlAttribute(name = "purchase_id")
    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getCount() {
        return count;
    }

    @XmlElement(name = "count")
    public void setCount(int count) {
        this.count = count;
    }

    public int getCustomerId() {
        return customerId;
    }

    @XmlElement(name = "customer_id")
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getGuitarId() {
        return guitarId;
    }

    @XmlElement(name = "guitar_id")
    public void setGuitarId(int guitarId) {
        this.guitarId = guitarId;
    }
}
