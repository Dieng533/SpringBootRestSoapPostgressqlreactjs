package com.bibliotheque.librarysoap.soap.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "modifierLivreRequest")
public class ModifierLivreRequest {

    private Long livreID;
    private String titre;
    private String auteur;
    private String isbn;

    @XmlElement
    public Long getLivreID() {
        return livreID;
    }

    public void setLivreID(Long livreID) {
        this.livreID = livreID;
    }

    @XmlElement
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @XmlElement
    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    @XmlElement
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
