package com.bibliotheque.librairy_soap.soap.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ajouterLivreRequest")
public class AjouterLivreRequest {

    private String titre;
    private String auteur;
    private String isbn;

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

	public Long getLivreID() {
		// TODO Auto-generated method stub
		return null;
	}
}
