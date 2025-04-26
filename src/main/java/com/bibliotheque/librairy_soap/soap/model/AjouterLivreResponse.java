package com.bibliotheque.librairy_soap.soap.model;

public class AjouterLivreResponse {
    private String message;
    private boolean success;

    // Getter et Setter pour message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Getter et Setter pour success
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
