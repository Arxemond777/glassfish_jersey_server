package example.dto;

public class RequestStatesJsonDTO {
    private RowsDTO model;
    private String statusMessage;
    private String status;

    public RowsDTO getModel() {
        return model;
    }

    public RequestStatesJsonDTO setModel(RowsDTO model) {
        this.model = model;
        return this;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public RequestStatesJsonDTO setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public RequestStatesJsonDTO setStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "RequestStatesJsonDTO{" +
                "model=" + model +
                ", statusMessage='" + statusMessage + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
