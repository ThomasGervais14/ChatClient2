package vue;

import com.chat.tictactoe.EtatPartieTicTacToe;
import controleur.EcouteurTicTacToe;
import observer.Observable;
import observer.Observateur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanneauTicTacToe extends JPanel implements Observateur {
    private JButton[][] boutons = new JButton[3][3];
    private EtatPartieTicTacToe partie;
    private ActionListener ecouteurTicTacToe;

    // <editor-fold desc="- CONSTRUCTEUR et SETTER -"
    public PanneauTicTacToe(EtatPartieTicTacToe partie) {
        this.partie = partie;
        char[][] etatPlateau = partie.getEtatPlateau();

        this.setLayout(new GridLayout(3, 3));
        ecouteurTicTacToe = new EcouteurTicTacToe(null);

        for (int i = 0; i < boutons.length; i++)
            for (int j = 0; j < boutons[i].length; j++) {
                boutons[i][j] = new JButton();
                boutons[i][j].setActionCommand(i + "" + j);
                boutons[i][j].setBackground(Color.WHITE);
                this.add(boutons[i][j]);

                if (etatPlateau[i][j] != '.')
                    boutons[i][j].setIcon(ServiceImages.getIconePourSymbole(etatPlateau[i][j]));
            }

        //Connecter l'observateur sur l'observable :
        partie.ajouterObservateur(this); // ERREUR : ajouterObservateur
    }

    public void setEcouteurTicTacToe(ActionListener ecouteurTicTacToe) {
        this.ecouteurTicTacToe = ecouteurTicTacToe;

        for (int i = 0; i < boutons.length; i++) {
            for (int j = 0; j < boutons[i].length; j++) {
                boutons[i][j].addActionListener(ecouteurTicTacToe);
            }
        }
    }
    //</editor-fold>

    /**
     * FINI ?
     * @param observable
     */
    @Override
    public void seMettreAJour(Observable observable) {
        if (observable instanceof EtatPartieTicTacToe) {    // ERREUR
            EtatPartieTicTacToe partie = (EtatPartieTicTacToe) observable; // ERREUR : (EtatPartieTicTacToe) observable
            char[][] etatPlateau = partie.getEtatPlateau();

            for (int i = 0; i < boutons.length; i++) {
                for (int j = 0; j < boutons[i].length; j++) {
                    if (etatPlateau[i][j] == '.') {
                        boutons[i][j].setIcon(null);
                    }
                    else {
                        boutons[i][j].setIcon(ServiceImages.getIconePourSymbole(etatPlateau[i][j]));
                    }
                }
            }
        }
    }
}