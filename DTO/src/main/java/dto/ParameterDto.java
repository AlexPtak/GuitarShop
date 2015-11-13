package dto;

public class ParameterDto {

    private Integer guitarId;
    private Integer parameterTypeId;
    private String value;

    public Integer getGuitarId() {
        return guitarId;
    }

    public void setGuitarId(Integer guitarId) {
        this.guitarId = guitarId;
    }

    public Integer getParameterTypeId() {
        return parameterTypeId;
    }

    public void setParameterTypeId(Integer parameterTypeId) {
        this.parameterTypeId = parameterTypeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
