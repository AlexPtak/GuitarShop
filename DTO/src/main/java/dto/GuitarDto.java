package dto;

public class GuitarDto {

    private int guitarId;
    private String model;
    private double price;
    private String country;
    private String color;
    private int numberOfStrings;
    private int numberOfFrets;
    private int guitarStatusId;
    private int guitarBrandId;
    private int guitarTypeId;

    public int getGuitarId() {
        return guitarId;
    }

    public void setGuitarId(int guitarId) {
        this.guitarId = guitarId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    public void setNumberOfStrings(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    public int getNumberOfFrets() {
        return numberOfFrets;
    }

    public void setNumberOfFrets(int numberOfFrets) {
        this.numberOfFrets = numberOfFrets;
    }

    public int getGuitarStatusId() {
        return guitarStatusId;
    }

    public void setGuitarStatusId(int guitarStatusId) {
        this.guitarStatusId = guitarStatusId;
    }

    public int getGuitarBrandId() {
        return guitarBrandId;
    }

    public void setGuitarBrandId(int guitarBrandId) {
        this.guitarBrandId = guitarBrandId;
    }

    public int getGuitarTypeId() {
        return guitarTypeId;
    }

    public void setGuitarTypeId(int guitarTypeId) {
        this.guitarTypeId = guitarTypeId;
    }
}
