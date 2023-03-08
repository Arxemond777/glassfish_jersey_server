package example.dto;

import java.util.List;

public class RowsDTO {
    private List<RowElementDTO> rows;
//    private Object rows;

    public List<RowElementDTO> getRows() {
        return rows;
    }

    public RowsDTO setRows(List<RowElementDTO> rows) {
        this.rows = rows;
        return this;
    }

    @Override
    public String toString() {
        return "RowsDTO{" +
                "rows=" + rows +
                '}';
    }
}
