package com.bibliotheque.librairy_soap.rest;

import org.springframework.web.bind.annotation.*;

import com.bibliotheque.librairy_soap.model.Livre;
import com.bibliotheque.librairy_soap.repository.LivreRepository;
import com.bibliotheque.librairy_soap.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/api/livres")
public class LivreRestController {

    private final LivreRepository livreRepository;
    private final ReservationService reservationService;

    public LivreRestController(LivreRepository livreRepository, ReservationService reservationService) {
        this.livreRepository = livreRepository;
        this.reservationService = reservationService;
    }

    // Récupération de tous les livres
    @GetMapping
    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    // Ajouter un livre
    @PostMapping
    public Livre createLivre(@RequestBody Livre livre) {
        return livreRepository.save(livre);
    }

    // Récupérer un livre par son ID
    @GetMapping("/{id}")
    public Livre getLivreById(@PathVariable Long id) {
        return livreRepository.findById(id).orElse(null);
    }

    // Récupérer les livres disponibles (non prêtés et non réservés)
    @GetMapping("/disponibles")
    public List<Livre> getLivresDisponibles() {
        return livreRepository.findByDisponible(true);
    }

    // Modifier un livre
    @PutMapping("/{id}")
    public Livre updateLivre(@PathVariable Long id, @RequestBody Livre updatedLivre) {
        return livreRepository.findById(id).map(livre -> {
            livre.setTitre(updatedLivre.getTitre());
            livre.setAuteur(updatedLivre.getAuteur());
            livre.setIsbn(updatedLivre.getIsbn());
            livre.setDisponible(updatedLivre.isDisponible());
            return livreRepository.save(livre);
        }).orElse(null);
    }

    // Supprimer un livre
    @DeleteMapping("/{id}")
    public void deleteLivre(@PathVariable Long id) {
        livreRepository.deleteById(id);
    }

    // Réserver un livre via SOAP
    @PostMapping("/reservations")
    public String reserverLivre(@RequestBody Long livreId) {
        return reservationService.reserverLivre(livreId);
    }
}
