package controleur;

import com.chat.client.ClientChat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcouteurTicTacToe implements ActionListener {
    private ClientChat clientChat;

    // Attributs élève
//    private int ligne;
//    private int colonne;
    public EcouteurTicTacToe(ClientChat clientChat) {
        this.clientChat = clientChat;
    }

    /**
     * *** FAIT ***
     * @param e évènement à processer
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof String) {
            String pos = (String)e.getActionCommand();
//            ligne = pos.charAt(0);
//            colonne = pos.charAt(1);
            clientChat.envoyer("COUP" + pos);
        }
    }


}
