package example.dto;

public class StyleDTO {
    private String parentKey;
    private ValueDTO values;

    public String getParentKey() {
        return parentKey;
    }

    public StyleDTO setParentKey(String parentKey) {
        this.parentKey = parentKey;
        return this;
    }

    public ValueDTO getValues() {
        return values;
    }

    public StyleDTO setValues(ValueDTO values) {
        this.values = values;
        return this;
    }
}
