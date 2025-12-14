package com.chat.client;

import com.chat.commun.net.Connexion;
import observer.Observable;

public class Client extends Observable {
    String portServeur, adresseServeur;
    Connexion connexion;

    public String getPortServeur() {
         return portServeur;
    }
    public String getAdrServeur() {
        return adresseServeur;
    }

    /**
     * A COMPLETER
     */
    public boolean connecter() {
        return true;
    }

    public void envoyer(String texte) {
        connexion.envoyer(texte);
    }

    /**
     * A COMPLETER
     */
    public boolean isConnected() {
        return true;
    }
}
