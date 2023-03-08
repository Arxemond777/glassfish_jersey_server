package example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValueDTO {
    @JsonProperty("style-name")
    private String styleName;
    @JsonProperty("background-color")
    private String backgroundColor;

    public String getStyleName() {
        return styleName;
    }

    public ValueDTO setStyleName(String styleName) {
        this.styleName = styleName;
        return this;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public ValueDTO setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }
}
