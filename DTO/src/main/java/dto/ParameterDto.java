package dto;

public class ParameterDto {

    private int guitarId;
    private int parameterTypeId;
    private String value;

    public int getGuitarId() {
        return guitarId;
    }

    public void setGuitarId(int guitarId) {
        this.guitarId = guitarId;
    }

    public int getParameterTypeId() {
        return parameterTypeId;
    }

    public void setParameterTypeId(int parameterTypeId) {
        this.parameterTypeId = parameterTypeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
