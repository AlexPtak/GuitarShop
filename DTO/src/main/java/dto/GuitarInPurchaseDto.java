package dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GUITAR_IN_PURCHASE")
public class GuitarInPurchaseDto {

    private int purchaseId;
    private int guitarId;
    private int count;

    public int getPurchaseId() {
        return purchaseId;
    }

    @XmlAttribute(name = "purchase_id")
    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getGuitarId() {
        return guitarId;
    }

    @XmlElement(name = "guitar_id")
    public void setGuitarId(int guitarId) {
        this.guitarId = guitarId;
    }

    public int getCount() {
        return count;
    }

    @XmlElement(name = "count")
    public void setCount(int count) {
        this.count = count;
    }
}
