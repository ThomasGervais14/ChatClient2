package observer;

import com.chat.tictactoe.EtatPartieTicTacToe;

/**
 * @author A. Toudeft
 * @since 2002
 * @version 1.0
 */
public interface Observateur {
	//Permet à l'observateur de se mettre à jour lorsqu'il est notifié par
	//l'objet Observable qu'il observe :
	public void seMettreAJour(Observable observable);
}

