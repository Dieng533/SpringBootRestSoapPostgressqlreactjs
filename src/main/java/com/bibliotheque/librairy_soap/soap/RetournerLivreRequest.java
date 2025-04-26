package com.bibliotheque.librairy_soap.soap;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "retournerLivreRequest")
public class RetournerLivreRequest {

    private Long userID;
    private Long livreID;

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
}

