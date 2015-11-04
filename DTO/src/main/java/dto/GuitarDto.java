package dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GUITAR")
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

    @XmlAttribute(name = "guitar_id")
    public void setGuitarId(int guitarId) {
        this.guitarId = guitarId;
    }

    public String getModel() {
        return model;
    }

    @XmlElement(name = "model")
    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    @XmlElement(name = "price")
    public void setPrice(double price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    @XmlElement(name = "county")
    public void setCountry(String country) {
        this.country = country;
    }

    public String getColor() {
        return color;
    }

    @XmlElement(name = "color")
    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    @XmlElement(name = "number_of_strings")
    public void setNumberOfStrings(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    public int getNumberOfFrets() {
        return numberOfFrets;
    }

    @XmlElement(name = "number_of_frets")
    public void setNumberOfFrets(int numberOfFrets) {
        this.numberOfFrets = numberOfFrets;
    }

    public int getGuitarStatusId() {
        return guitarStatusId;
    }

    @XmlElement(name = "guitar_status_id")
    public void setGuitarStatusId(int guitarStatusId) {
        this.guitarStatusId = guitarStatusId;
    }

    public int getGuitarBrandId() {
        return guitarBrandId;
    }

    @XmlElement(name = "guitar_brand_id")
    public void setGuitarBrandId(int guitarBrandId) {
        this.guitarBrandId = guitarBrandId;
    }

    public int getGuitarTypeId() {
        return guitarTypeId;
    }

    @XmlElement(name = "guitar_type_id")
    public void setGuitarTypeId(int guitarTypeId) {
        this.guitarTypeId = guitarTypeId;
    }
}
