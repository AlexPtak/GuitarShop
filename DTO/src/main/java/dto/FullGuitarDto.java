package dto;

import java.util.Map;

public class FullGuitarDto {

    private int guitarId;
    private String model;
    private Double price;
    private String country;
    private String color;
    private int numberOfStrings;
    private int numberOfFrets;
    private String guitarStatus;
    private String guitarBrand;
    private String guitarType;
    private Map<String, String> parameterTypeValue;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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

    public String getGuitarStatus() {
        return guitarStatus;
    }

    public void setGuitarStatus(String guitarStatus) {
        this.guitarStatus = guitarStatus;
    }

    public String getGuitarBrand() {
        return guitarBrand;
    }

    public void setGuitarBrand(String guitarBrand) {
        this.guitarBrand = guitarBrand;
    }

    public String getGuitarType() {
        return guitarType;
    }

    public void setGuitarType(String guitarType) {
        this.guitarType = guitarType;
    }

    public Map<String, String> getParameterTypeValue() {
        return parameterTypeValue;
    }

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
            builder.append(type + " " + value + "\n");
        }

        return builder.toString();
    }
}
