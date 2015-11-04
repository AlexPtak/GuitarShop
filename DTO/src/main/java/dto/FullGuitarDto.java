package dto;

import javax.xml.bind.annotation.*;
import java.util.Map;

@XmlRootElement(name = "FULL_GUITAR")
public class FullGuitarDto {

    private GuitarDto guitarDto;
    private String guitarStatus;
    private String guitarBrand;
    private String guitarType;
    private Map<String, String> parameterTypeValue;

    @XmlTransient
    public GuitarDto getGuitarDto() {
        return guitarDto;
    }

    public void setGuitarDto(GuitarDto guitarDto) {
        this.guitarDto = guitarDto;
    }

    public int getGuitarId() {
        return guitarDto.getGuitarId();
    }

    @XmlAttribute(name = "guitar_id")
    public void setGuitarId(int guitarId) {
        guitarDto.setGuitarId(guitarId);
    }

    public String getModel() {
        return guitarDto.getModel();
    }

    @XmlElement(name = "model")
    public void setModel(String model) {
        guitarDto.setModel(model);
    }

    public Double getPrice() {
        return guitarDto.getPrice();
    }

    @XmlElement(name = "price")
    public void setPrice(Double price) {
        guitarDto.setPrice(price);
    }

    public String getCountry() {
        return guitarDto.getCountry();
    }

    @XmlElement(name = "county")
    public void setCountry(String country) {
        guitarDto.setCountry(country);
    }

    public String getColor() {
        return guitarDto.getColor();
    }

    @XmlElement(name = "color")
    public void setColor(String color) {
        guitarDto.setColor(color);
    }

    public int getNumberOfStrings() {
        return guitarDto.getNumberOfStrings();
    }

    @XmlElement(name = "number_of_strings")
    public void setNumberOfStrings(int numberOfStrings) {
        guitarDto.setNumberOfStrings(numberOfStrings);
    }

    public int getNumberOfFrets() {
        return guitarDto.getNumberOfFrets();
    }

    @XmlElement(name = "number_of_frets")
    public void setNumberOfFrets(int numberOfFrets) {
        guitarDto.setNumberOfFrets(numberOfFrets);
    }

    public String getGuitarStatus() {
        return guitarStatus;
    }

    @XmlElement(name = "guitar_status")
    public void setGuitarStatus(String guitarStatus) {
        this.guitarStatus = guitarStatus;
    }

    public String getGuitarBrand() {
        return guitarBrand;
    }

    @XmlElement(name = "guitar_brand")
    public void setGuitarBrand(String guitarBrand) {
        this.guitarBrand = guitarBrand;
    }

    public String getGuitarType() {
        return guitarType;
    }

    @XmlElement(name = "guitar_type")
    public void setGuitarType(String guitarType) {
        this.guitarType = guitarType;
    }

    public Map<String, String> getParameterTypeValue() {
        return parameterTypeValue;
    }

    @XmlElementWrapper(name = "parameter_type-value")
    public void setParameterTypeValue(Map<String, String> parameterTypeValue) {
        this.parameterTypeValue = parameterTypeValue;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(getGuitarId() + "\n");
        builder.append(getModel() + "\n");
        builder.append(getPrice() + "\n");
        builder.append(getCountry() + "\n");
        builder.append(getColor() + "\n");
        builder.append(getNumberOfStrings() + "\n");
        builder.append(getNumberOfFrets() + "\n");
        builder.append(getGuitarStatus() + "\n");
        builder.append(getGuitarBrand() + "\n");
        builder.append(getGuitarType() + "\n");

        for (Map.Entry<String, String> elem : getParameterTypeValue().entrySet()) {
            String type = elem.getKey();
            String value = elem.getValue();
            builder.append(type + " - " + value + "\n");
        }

        return builder.toString();
    }
}
