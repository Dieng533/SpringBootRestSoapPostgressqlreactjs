package com.bibliotheque.librairy_soap.soap.model;

public class SupprimerLivreRequest {
    private Long livreID;
    private String message;
    public Long getLivreID() {
        return livreID;
    }

    public void setLivreID(Long livreID) {
        this.livreID = livreID;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
