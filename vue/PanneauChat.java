package vue;

import com.chat.client.ClientChat;
import controleur.EcouteurChatPrive;
import controleur.EcouteurChatPublic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauChat extends JPanel {
    protected JTextArea zoneChat;
    protected JTextField champDeSaisie;

    /**
     * *** FAIT ***
     */
    public PanneauChat() {
        JPanel panelChat = new JPanel();

        // BorderLayout
        panelChat.setLayout(new BorderLayout());

        // Zone de chat
        zoneChat = new JTextArea();
        zoneChat.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(zoneChat);
        panelChat.add(scrollPane, BorderLayout.CENTER);

        // Champ de saisie
        champDeSaisie = new JTextField();
        panelChat.add(champDeSaisie, BorderLayout.SOUTH);
    }

    /**
     * *** FAIT ***
     * <br>Enregistre l'écouteur auprès du champ de saisie</br>
     * @param ecouteur type d'écouteur
     */
    public void setEcouteur(ActionListener ecouteur) {
        champDeSaisie.addActionListener(ecouteur);
    }

    //<editor-fold desc="- METHODS -"
    public void ajouter(String msg) {
        zoneChat.append("\n" + msg);
    }

    public void vider() {
        this.zoneChat.setText("");
        this.zoneChat.setText("");
    }
    //</editor-fold>
}