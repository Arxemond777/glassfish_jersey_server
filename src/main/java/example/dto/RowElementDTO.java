package example.dto;

import java.util.List;

public class RowElementDTO {
    private Long entryId;
    private List<StatesDTO> statesList;

    @Override
    public String toString() {
        return "RowElementDTO{" +
                "entryId=" + entryId +
                ", statesList=" + statesList +
                '}';
    }

    public Long getEntryId() {
        return entryId;
    }

    public RowElementDTO setEntryId(Long entryId) {
        this.entryId = entryId;
        return this;
    }

    public List<StatesDTO> getStates() {
        return statesList;
    }

    public RowElementDTO setStates(List<StatesDTO> states) {
        this.statesList = states;
        return this;
    }
}
