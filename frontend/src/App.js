import React from 'react';
import ListeLivres from './ListeLivres';
import AjoutLivre from './AjoutLivre';

function App() {
  return (
    <div>
      <h1>Gestion de la Bibliothèque</h1>
      <AjoutLivre />
      <ListeLivres />
    </div>
  );
}

export default App;
