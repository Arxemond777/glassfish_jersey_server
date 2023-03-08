package example.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatesDTO {
    private Long start;
    private Long end;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String label;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private StyleDTO style;

    public Long getStart() {
        return start;
    }

    public StatesDTO setStart(Long start) {
        this.start = start;
        return this;
    }

    public Long getEnd() {
        return end;
    }

    public StatesDTO setEnd(Long end) {
        this.end = end;
        return this;
    }

    @Override
    public String toString() {
        return "StatesDTO{" +
                "start=" + start +
                ", end=" + end +
                ", label=" + label +
                ", style=" + style +
                '}';
    }

    public String getLabel() {
        return label;
    }

    public StatesDTO setLabel(String label) {
        this.label = label;
        return this;
    }

    public StyleDTO getStyle() {
        return style;
    }

    public StatesDTO setStyle(StyleDTO style) {
        this.style = style;
        return this;
    }
}
