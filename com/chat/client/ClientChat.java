package com.chat.client;

import com.chat.commun.net.Connexion;
import com.chat.tictactoe.EtatPartieTicTacToe;

/**
 * Cette classe étend la classe Client pour lui ajouter des fonctionnalités
 * spécifiques au chat et au jeu d'échecs en réseau.
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-09-01
 */
public class ClientChat extends Client {
    private EtatPartieTicTacToe etatPartieTicTacToe;
    private String alias;

    // NOUVEAUX ATTRIBUTS
    private Connexion connexion;

    //<editor-fold desc=- CONSTRUCTEUR et GETTER/SETTER ->
    public EtatPartieTicTacToe getEtatPartieTicTacToe() {
        return etatPartieTicTacToe;
    }

    public void setEtatPartieTicTacToe(EtatPartieTicTacToe etatPartieEchecs) {
        this.etatPartieTicTacToe = etatPartieTicTacToe;
    }

    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * A COMPLETER
     * @param adresseServeur
     */
    public void setAdrServeur(String adresseServeur) {

    }
    /**
     * A COMPLETER -
     * @param port
     */
    public void setPortServeur(int port) {
    }
    //</editor-fold>

    //<editor-fold desc=- METHODES ->
    public void nouvellePartie() {
        this.etatPartieTicTacToe = new EtatPartieTicTacToe();
    }

    public void envoyer(String texte) {
        connexion.envoyer(texte);
    }

    /**
     * A COMPLETER
     * @return
     */
    public Boolean isConnected() {

        return true;
    }

    /**
     * A COMPLETER
     */
    public void deconnected() {

    }

    /**
     * A COMPLETER
     * @param gestionnaireEvenementClient2
     */
    public void setGestionnaireEvenementClient(GestionnaireEvenementClient2 gestionnaireEvenementClient2) {

    }
    //</editor-fold>
}
