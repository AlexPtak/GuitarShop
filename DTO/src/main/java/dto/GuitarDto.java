package dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GUITAR")
public class GuitarDto {

    private Integer guitarId;
    private String model;
    private Double price;
    private String country;
    private String color;
    private Integer numberOfStrings;
    private Integer numberOfFrets;
    private Integer guitarStatusId;
    private Integer guitarBrandId;
    private Integer guitarTypeId;

    public Integer getGuitarId() {
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

    public Double getPrice() {
        return price;
    }

    @XmlElement(name = "price")
    public void setPrice(Double price) {
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

    public Integer getNumberOfStrings() {
        return numberOfStrings;
    }

    @XmlElement(name = "number_of_strings")
    public void setNumberOfStrings(Integer numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    public Integer getNumberOfFrets() {
        return numberOfFrets;
    }

    @XmlElement(name = "number_of_frets")
    public void setNumberOfFrets(Integer numberOfFrets) {
        this.numberOfFrets = numberOfFrets;
    }

    public Integer getGuitarStatusId() {
        return guitarStatusId;
    }

    @XmlElement(name = "guitar_status_id")
    public void setGuitarStatusId(Integer guitarStatusId) {
        this.guitarStatusId = guitarStatusId;
    }

    public Integer getGuitarBrandId() {
        return guitarBrandId;
    }

    @XmlElement(name = "guitar_brand_id")
    public void setGuitarBrandId(Integer guitarBrandId) {
        this.guitarBrandId = guitarBrandId;
    }

    public Integer getGuitarTypeId() {
        return guitarTypeId;
    }

    @XmlElement(name = "guitar_type_id")
    public void setGuitarTypeId(Integer guitarTypeId) {
        this.guitarTypeId = guitarTypeId;
    }

    @Override
    public String toString() {
        return "GuitarDto{" +
                "guitarId=" + guitarId +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", country='" + country + '\'' +
                ", color='" + color + '\'' +
                ", numberOfStrings=" + numberOfStrings +
                ", numberOfFrets=" + numberOfFrets +
                ", guitarStatusId=" + guitarStatusId +
                ", guitarBrandId=" + guitarBrandId +
                ", guitarTypeId=" + guitarTypeId +
                '}';
    }
}
