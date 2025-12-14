package controleur;

import com.chat.client.ClientChat;
import vue.PanneauChat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class EcouteurChatPublic implements ActionListener {
    protected ClientChat clientChat;
    protected PanneauChat panneauChat;

    public EcouteurChatPublic(ClientChat clientChat, PanneauChat panneauChat) {
        this.clientChat = clientChat;
        this.panneauChat = panneauChat;
    }

    /**
     * *** FAIT ***
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource() instanceof JTextField) {
            JTextField champDeSaisie = (JTextField)evt.getSource();
            String champText = champDeSaisie.getText();

            if(!(champText.isEmpty())) {
                clientChat.envoyer("MSG " + champText);
                panneauChat.ajouter("MOI >> " + champText);
                champDeSaisie.setText("");
            }
        }
    }
}