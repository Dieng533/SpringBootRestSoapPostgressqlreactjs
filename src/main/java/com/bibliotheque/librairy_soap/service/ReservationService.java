package com.bibliotheque.librairy_soap.service;

import com.bibliotheque.librairy_soap.wsdl.ReserverLivreRequest;
import com.bibliotheque.librairy_soap.wsdl.ReserverLivreResponse;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class ReservationService {

    private final WebServiceTemplate webServiceTemplate;

    public ReservationService(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    // Méthode pour réserver un livre via SOAP
    public String reserverLivre(Long livreId) {
        ReserverLivreRequest request = new ReserverLivreRequest();
        request.setLivreId(livreId);

        ReserverLivreResponse response = (ReserverLivreResponse) webServiceTemplate.marshalSendAndReceive(request);

        return response.getMessage(); // Supposons que la réponse SOAP a un champ "message"
    }
}
