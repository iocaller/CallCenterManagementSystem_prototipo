package CallCenterManagement.Controller.Impl;

import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JOptionPane;

import CallCenterManagement.Controller.GestioneAmministratore;
import CallCenterManagement.Dao.AmministratoreDAO;
import CallCenterManagement.Entity.Amministratore;

/**
 * Implementazione Gestione degli Amministratori 
 * <p><b>Aggiunge, modifica e rimuove l'amministratore</b></p>
 * <hr>
 * <ul>
 * <li>aggiungeAmministratore() - si aggiunge l'amministratore nella base di dati, passando anche le credenziali di accesso per l'amministratore</li>
 * <li>modificaAmministratore() - si modifica l'amministratore nella base di dati in casi di necessita'</li>
 * <li>rimuoveAmministratore() - si puo' rimuovere l'amministratore in caso di necessita'</li>
 *
 */
public class GestioneAmministratoreImpl implements GestioneAmministratore {

	/**
	 * 
	 * @param Aggiunta di un amministratore al DB (Richiama AmministratoreDAO.createAmministratore)
	 * @return Non previsto
	 * @throws ParseException 
	 */
	public void aggiungeAmministratore(Amministratore a) {	

		try {

			AmministratoreDAO.createAmministratore(a);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Un errore si e' verificato durante la creazione dell'amministratore!");

		}
	}

	/**
	 * 
	 * @param Rimozione di un amministratore dal DB (Richiama AmministratoreDAO.deleteAmministratore)
	 * @return Non previsto
	 */
	public void rimuoveAmministratore(Amministratore a) {

		try {

			AmministratoreDAO.deleteAmministratore(a);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Un errore si e' verificato durante la rimozione dell'amministratore!");
		}
	}


	/**
	 * 
	 * @param Modifica di un amministratore presente nel DB (Richiama AmministratoreDAO.updateAmministratore)
	 * @return Non previsto
	 */
	public void modificaAmministratore(Amministratore a) {
		
		try {

			AmministratoreDAO.updateAmministratore(a);

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "Un errore si e' verificato durante la modifica dell'amministratore!");

		}
	}

}