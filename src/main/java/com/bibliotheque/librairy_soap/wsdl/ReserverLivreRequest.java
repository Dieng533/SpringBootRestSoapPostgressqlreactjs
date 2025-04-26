package com.bibliotheque.librairy_soap.wsdl;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ReserverLivreRequest")
public class ReserverLivreRequest {

    private Long livreId;

    @XmlElement
    public Long getLivreId() {
        return livreId;
    }

    public void setLivreId(Long livreId) {
        this.livreId = livreId;
    }
}
