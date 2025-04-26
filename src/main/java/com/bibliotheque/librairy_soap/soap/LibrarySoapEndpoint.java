package com.bibliotheque.librairy_soap.soap;

import com.bibliotheque.librairy_soap.model.Livre;
import com.bibliotheque.librairy_soap.repository.LivreRepository;
import com.bibliotheque.librairy_soap.soap.model.*;
import com.bibliotheque.librarysoap.soap.model.ModifierLivreRequest;


import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LibrarySoapEndpoint {

    private final LivreRepository livreRepository;

    public LibrarySoapEndpoint(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    // Ajouter un livre
    @PayloadRoot(namespace = "http://www.bibliotheque.com/soap", localPart = "ajouterLivreRequest")
    @ResponsePayload
    public AjouterLivreResponse ajouterLivre(@RequestPayload AjouterLivreRequest request) {
        Livre livre = new Livre();
        livre.setTitre(request.getTitre());
        livre.setAuteur(request.getAuteur());
        livre.setIsbn(request.getIsbn());
        livre.setDisponible(true); // par défaut disponible

        livreRepository.save(livre);

        AjouterLivreResponse response = new AjouterLivreResponse();
        response.setMessage("Livre ajouté avec succès");
        return response;
    }

    // Modifier un livre
    @PayloadRoot(namespace = "http://www.bibliotheque.com/soap", localPart = "modifierLivreRequest")
    @ResponsePayload
    public ModifierLivreResponse modifierLivre(@RequestPayload ModifierLivreRequest request) {
        ModifierLivreResponse response = new ModifierLivreResponse();

        Livre livre = livreRepository.findById(request.getLivreID()).orElse(null);
        if (livre == null) {
            response.setMessage("Livre non trouvé");
            return response;
        }

        livre.setTitre(request.getTitre());
        livre.setAuteur(request.getAuteur());
        livre.setIsbn(request.getIsbn());

        livreRepository.save(livre);

        response.setMessage("Livre modifié avec succès");
        return response;
    }

    // Supprimer un livre
    @PayloadRoot(namespace = "http://www.bibliotheque.com/soap", localPart = "supprimerLivreRequest")
    @ResponsePayload
    public SupprimerLivreResponse supprimerLivre(@RequestPayload SupprimerLivreRequest request) {
        SupprimerLivreResponse response = new SupprimerLivreResponse();

        Livre livre = livreRepository.findById(request.getLivreID()).orElse(null);
        if (livre == null) {
            response.setMessage("Livre non trouvé");
            return response;
        }

        livreRepository.delete(livre);

        response.setMessage("Livre supprimé avec succès");
        return response;
    }

    // Prêter un livre
    @PayloadRoot(namespace = "http://www.bibliotheque.com/soap", localPart = "preterLivreRequest")
    @ResponsePayload
    public PreterLivreResponse preterLivre(@RequestPayload PreterLivreRequest request) {
        PreterLivreResponse response = new PreterLivreResponse();

        Livre livre = livreRepository.findById(request.getLivreID()).orElse(null);
        if (livre == null) {
            response.setMessage("Livre non trouvé");
            return response;
        }

        if (!livre.isDisponible()) {
            response.setMessage("Le livre n'est pas disponible pour le prêt");
            return response;
        }

        livre.setDisponible(false);
        livreRepository.save(livre);

        response.setMessage("Livre prêté avec succès");
        return response;
    }

    // Retourner un livre
    @PayloadRoot(namespace = "http://www.bibliotheque.com/soap", localPart = "retournerLivreRequest")
    @ResponsePayload
    public RetournerLivreResponse retournerLivre(@RequestPayload RetournerLivreRequest request) {
        RetournerLivreResponse response = new RetournerLivreResponse();

        Livre livre = livreRepository.findById(request.getLivreID()).orElse(null);
        if (livre == null) {
            response.setMessage("Livre non trouvé");
            return response;
        }

        livre.setDisponible(true);
        livreRepository.save(livre);

        response.setMessage("Livre retourné avec succès");
        return response;
    }
}
