package com.chat.tictactoe;

import observer.Observateur;

import java.util.Observable;

public class EtatPartieTicTacToe extends Observable {
    private char[][] etatPlateau = new char[3][3];

    public EtatPartieTicTacToe() {
        etatPlateau = new char[][]{
                {'.', '.', '.'},
                {'.', '.', '.'},
                {'.', '.', '.'}
        };
    }

    public char[][] getEtatPlateau() {
        return etatPlateau;
    }
    public void setEtatPlateau(char[][] etatPlateau) {
        this.etatPlateau = etatPlateau;
    }

    //<editor-fold-fold desc="- METHODS -
    /**
     * *** FAIT ***
     * @param strCoup coup à jouer
     * @return si le coup a été effectué
     */
    public boolean coup(String strCoup) {
        boolean res = false;

        // verifier si le coup est valide
        if (strCoup.length() == 5) {
            // Découpage de la commande : ex "X 2 1"
            String[] coup = strCoup.split(" ");
            char symbole = coup[0].charAt(0);

            // Vérifier le symbole
            if (symbole == 'X' || symbole == 'O') {
                int ligne = Integer.parseInt(coup[1]);
                int colonne = Integer.parseInt(coup[2]);

                // Vérifier les bornes
                if (ligne < 0 || ligne > 2 || colonne < 0 || colonne > 2) {
                    if (etatPlateau[ligne][colonne] != '.') {   // Vérifier que la case est libre
                        etatPlateau[ligne][colonne] = symbole;
                        notifyObservers();
                        res = true;
                    }
                }
            }
        }
        return res;
    }

    @Override
    public String toString() {
        String s = "";

        for (byte i = 0; i < etatPlateau.length; i++) {
            for (int j = 0; j < etatPlateau[i].length; j++) {
                s += etatPlateau[i][j] + " ";
            }
            s += "\n";
        }
        return s;
    }
    //</editor-fold>
}
