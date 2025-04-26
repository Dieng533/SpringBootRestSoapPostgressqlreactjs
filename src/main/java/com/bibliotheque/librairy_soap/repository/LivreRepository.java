package com.bibliotheque.librairy_soap.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotheque.librairy_soap.model.Livre;

public interface LivreRepository extends JpaRepository<Livre, Long> {

	 List<Livre> findByDisponible(Boolean disponible);  // Méthode pour récupérer les livres disponibles
}
