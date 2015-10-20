package dto;

public class ParameterDto {

    private int parameterId;
    private int parameterTypeId;
    private String value;

    public int getParameterId() {
        return parameterId;
    }

    public void setParameterId(int parameterId) {
        this.parameterId = parameterId;
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
