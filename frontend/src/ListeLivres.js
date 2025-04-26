import { useEffect, useState } from 'react';
import './ListeLivres.css'; // 🧹 On importe le CSS

function ListeLivres() {
  const [livres, setLivres] = useState([]);
  const [livreEnCours, setLivreEnCours] = useState(null);
  const [nouveauTitre, setNouveauTitre] = useState('');
  const [nouvelAuteur, setNouvelAuteur] = useState('');

  useEffect(() => {
    chargerLivres();
  }, []);

  function chargerLivres() {
    fetch('http://localhost:8080/api/livres')
      .then((response) => response.json())
      .then((data) => setLivres(data))
      .catch((err) => console.error('Erreur de chargement des livres', err));
  }

  function commencerModification(livre) {
    setLivreEnCours(livre);
    setNouveauTitre(livre.titre);
    setNouvelAuteur(livre.auteur);
  }

  function modifierLivre() {
    fetch(`http://localhost:8080/api/livres/${livreEnCours.id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        ...livreEnCours,
        titre: nouveauTitre,
        auteur: nouvelAuteur,
      }),
    })
      .then((response) => response.json())
      .then(() => {
        chargerLivres();
        setLivreEnCours(null);
        setNouveauTitre('');
        setNouvelAuteur('');
      })
      .catch((err) => console.error('Erreur lors de la modification du livre', err));
  }

  function supprimerLivre(id) {
    fetch(`http://localhost:8080/api/livres/${id}`, {
      method: 'DELETE',
    })
      .then(() => {
        chargerLivres();
      })
      .catch((err) => console.error('Erreur lors de la suppression du livre', err));
  }

  function reserverLivre(id) {
    fetch('http://localhost:8080/api/livres/reservations', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(id),
    })
      .then((response) => response.text())
      .then((message) => {
        alert(message);
        chargerLivres();
      })
      .catch((err) => console.error('Erreur lors de la réservation', err));
  }

  return (
    <div className="livre-container">
      <h2>Liste des Livres</h2>
      <ul className="livre-list">
        {livres.map((livre) => (
          <li key={livre.id} className="livre-item">
            <strong>{livre.titre}</strong> — {livre.auteur}
            <div className="livre-actions">
              <button onClick={() => commencerModification(livre)} className="btn modifier">
                Modifier
              </button>
              <button onClick={() => supprimerLivre(livre.id)} className="btn supprimer">
                Supprimer
              </button>
              <button onClick={() => reserverLivre(livre.id)} className="btn reserver">
                Réserver
              </button>
            </div>
          </li>
        ))}
      </ul>

      {livreEnCours && (
        <div className="form-modification">
          <h3>Modifier le livre</h3>
          <input
            type="text"
            value={nouveauTitre}
            onChange={(e) => setNouveauTitre(e.target.value)}
            placeholder="Titre"
            className="input-modif"
          />
          <input
            type="text"
            value={nouvelAuteur}
            onChange={(e) => setNouvelAuteur(e.target.value)}
            placeholder="Auteur"
            className="input-modif"
          />
          <button onClick={modifierLivre} className="btn enregistrer">
            Enregistrer
          </button>
        </div>
      )}
    </div>
  );
}

export default ListeLivres;
