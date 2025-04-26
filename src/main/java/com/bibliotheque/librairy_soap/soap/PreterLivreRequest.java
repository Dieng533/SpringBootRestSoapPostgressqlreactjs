package com.bibliotheque.librairy_soap.soap;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "preterLivreRequest")
public class PreterLivreRequest {

    private Long userID;
    private Long livreID;
    private String message;
    @XmlElement
    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    @XmlElement
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

