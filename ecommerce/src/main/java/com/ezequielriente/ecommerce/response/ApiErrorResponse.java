package com.ezequielriente.ecommerce.response;

import java.time.LocalDateTime;
import java.util.Map;

public class ApiErrorResponse {

    private LocalDateTime fecha;
    private Integer status;
    private String mensaje;
    private Map<String, String> errores;

    public ApiErrorResponse() {
        this.fecha = LocalDateTime.now();
    }

    public ApiErrorResponse(Integer status, String mensaje) {
        this.fecha = LocalDateTime.now();
        this.status = status;
        this.mensaje = mensaje;
    }

    public ApiErrorResponse(Integer status, String mensaje, Map<String, String> errores) {
        this.fecha = LocalDateTime.now();
        this.status = status;
        this.mensaje = mensaje;
        this.errores = errores;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Map<String, String> getErrores() {
        return errores;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setErrores(Map<String, String> errores) {
        this.errores = errores;
    }
}


