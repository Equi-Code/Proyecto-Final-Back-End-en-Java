package com.ezequielriente.ecommerce.response;

import java.time.LocalDateTime;

public class ApiResponseDTO {

    private boolean success;
    private String mensaje;
    private LocalDateTime timestamp;

    public ApiResponseDTO(boolean success, String mensaje) {
        this.success = success;
        this.mensaje = mensaje;
        this.timestamp = LocalDateTime.now();
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
