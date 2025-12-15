package controleur;

import com.chat.client.ClientChat;
import vue.PanneauInvitations;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EcouteurInvitations implements ActionListener {
    private ClientChat clientChat;
    private PanneauInvitations panneauInvitations;

    public  EcouteurInvitations(ClientChat clientChat, PanneauInvitations panneauInvitations) {
        this.clientChat = clientChat;
        this.panneauInvitations = panneauInvitations;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<String> invitChoisies = panneauInvitations.getElementsSelectionnes();

        String action = e.getActionCommand();

        for(String nom : invitChoisies) {
            if ("ACCEPTER".equals(action)) {
                clientChat.envoyer("JOIN" + nom);
            }
            else if ("REJECTER".equals(action)) {
                clientChat.envoyer("DECLINE" + nom);
            }
            panneauInvitations.retirerInvitationRecue(nom);
        }
    }
}
