package controleur;

import com.chat.client.ClientChat;
import vue.PanneauChat;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class EcouteurChatPrive extends EcouteurChatPublic {
    private String alias;

    public EcouteurChatPrive(String alias, ClientChat clientChat, PanneauChat panneauChat) {
        super(clientChat, panneauChat);
        this.alias = alias;
    }

    // A COMPLETER (redéfinir la méthode actionPerformed())
    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();

        if (source instanceof JButton) {
            String action = evt.getActionCommand();
            if ("ACCEPTER".equals(action)) {
                clientChat.envoyer("TTT" + alias);
            }
            else if ("INVITER".equals(action)) {
                clientChat.envoyer("TTT" + alias);
            }
            else if ("REFUSER".equals(action)) {
                clientChat.envoyer("DECLINE" + alias);
            }
        }
        else if (source instanceof JTextField) {
            JTextField field = (JTextField) source;
            String text = field.getText();
            field.setText("");
            if (!text.isEmpty()) {
                if ("QUIT".equals(text)) {
                    clientChat.envoyer("QUIT" + alias);
                }
                else if ("ABANDON".equals(text)) {
                    clientChat.envoyer("ABANDON de " + alias);
                }
                else {
                    clientChat.envoyer("PRV" + alias + " " + text);
                    panneauChat.ajouter("MOI >> " + text);
                }
            }
        }
    }
}