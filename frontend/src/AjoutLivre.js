import { useState } from 'react';
import './AjoutLivre.css';

function AjoutLivre({ onLivreAjoute }) {
  const [titre, setTitre] = useState('');
  const [auteur, setAuteur] = useState('');
  const [isbn, setIsbn] = useState('');
  const [disponible, setDisponible] = useState(true);

  const handleSubmit = (e) => {
    e.preventDefault();

    const nouveauLivre = {
      titre,
      auteur,
      isbn,
      disponible,
    };

    fetch('http://localhost:8080/api/livres', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(nouveauLivre),
    })
      .then((response) => response.json())
      .then((data) => {
        onLivreAjoute(data); // pour rafraîchir la liste
        setTitre('');
        setAuteur('');
        setIsbn('');
        setDisponible(true);
      })
      .catch((err) => console.error('Erreur ajout livre', err));
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Ajouter un Livre</h2>

      <input
        type="text"
        placeholder="Titre"
        value={titre}
        onChange={(e) => setTitre(e.target.value)}
        required
      /><br />

      <input
        type="text"
        placeholder="Auteur"
        value={auteur}
        onChange={(e) => setAuteur(e.target.value)}
        required
      /><br />

      <input
        type="text"
        placeholder="ISBN"
        value={isbn}
        onChange={(e) => setIsbn(e.target.value)}
        required
      /><br />

      <label>
        Disponible:
        <input
          type="checkbox"
          checked={disponible}
          onChange={(e) => setDisponible(e.target.checked)}
        />
      </label><br />

      <button type="submit">Ajouter</button>
    </form>
  );
}

export default AjoutLivre;
