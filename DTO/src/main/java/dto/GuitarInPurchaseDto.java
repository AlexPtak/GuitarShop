package dto;

public class GuitarInPurchaseDto {

    private int purchaseId;
    private int guitarId;
    private int count;

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getGuitarId() {
        return guitarId;
    }

    public void setGuitarId(int guitarId) {
        this.guitarId = guitarId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
