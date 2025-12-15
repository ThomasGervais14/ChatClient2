package vue;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Abdelmoumène Toudeft (Abdelmoumene.Toudeft@etsmtl.ca)
 * @version 1.0
 * @since 2023-11-01
 */
public class PanneauConfigServeur extends JPanel {
    private JTextField txtAdrServeur, txtNumPort;

    public PanneauConfigServeur(String adr, int port) {
        // A COMPLETER
        setLayout(new GridLayout(2, 2, 5, 15));

        JLabel labelAdresseServ = new JLabel("Adresse du serveur :");
        JLabel labelPortServ = new JLabel("Port du serveur :");

        JTextField texteAdresseServ = new JTextField(adr);
        JTextField textePortServ = new JTextField(String.valueOf(port));

        //ajouter les éléments au panneau
        add(labelAdresseServ);
        add(texteAdresseServ);
        add(labelPortServ);
        add(textePortServ);
    }

    public String getAdresseServeur() {
        return txtAdrServeur.getText();
    }
    public String getPortServeur() {
        return txtNumPort.getText();
    }
}
