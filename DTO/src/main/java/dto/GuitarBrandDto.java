package dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GUITAR_BRAND")
public class GuitarBrandDto {

    private Integer brandId;
    private String brand;

    public Integer getBrandId() {
        return brandId;
    }

    @XmlAttribute(name = "guitar_brand_id")
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrand() {
        return brand;
    }

    @XmlElement(name = "brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }
}
