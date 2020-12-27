package CallCenterManagement.Controller.Impl;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import CallCenterManagement.Controller.GestioneAppuntamento;
import CallCenterManagement.Dao.AgentediVenditaDAO;
import CallCenterManagement.Dao.AppuntamentoDAO;
import CallCenterManagement.Entity.*;

/**
 * Implementazione Gestione degli Appuntamenti
 * <p><b>Crea, ricerca e rimuove Appuntamento</b></p>
 * <hr>
 * <ul>
 * <li>creaAppuntamento() - si crea l'appuntamento nella base di dati</li>
 * <li>modificaAppuntamento() - si modifica l'appuntamento nella base di dati in casi di necessita'</li>
 * <li>rimuoveAppuntamento() - si puo' rimuovere l'appuntamento in caso di necessita'</li>
 * <li>ricercaAppuntamento() - si pu� cercare l'appuntamento per rilevare le note e il nome di esso </li>
 * <li>modificaNota() - si pu� modificare la nota in caso di necessita'</li>
 * <li>getAgentediVendita() - si pu� rilevare l'agente di vendita incaricato per l'appuntamento </li>
 * <ul>
 */

public class GestioneAppuntamentoImpl implements GestioneAppuntamento {
	
	/**
	 * 
	 * @param a Appuntamento 
	 * @return Non previsto
	 */
	public void creaAppuntamento(Appuntamento a) {
		
		try {
			
			AppuntamentoDAO.createAppuntamento(a);
				
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Un errore si e' verificato durante la creazione dell'appuntamento!");
			
		}
		
	}

	/**
	 * 
	 * @param Nome dell'Appuntamento da cercare
	 * @return Appuntamento cercato
	 */
	public Appuntamento ricercaAppuntamento(int ID) {
		
		Appuntamento a = null;
		
		try {
			
			a = AppuntamentoDAO.readAppuntamento(ID);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Un errore si e' verificato durante la ricerca dell'appuntamento!");
			
		}
		
		return a;
		
	}
	
	/**
	 * 
	 * @param Appuntamento di cui modificare la nota
	 * @return Non previsto
	 */
	public void modificaNota(Appuntamento a) {
		
		Appuntamento app = new Appuntamento(a);
		
		app.setNote("Rifiutato");
		
		try {
			
			AppuntamentoDAO.updateAppuntamento(app);
			
			JOptionPane.showMessageDialog(null, "Nota dell'appuntamento modificata!");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Impossibile modificare la nota dell'appuntamento!");
			
		}
		
	}

	/**
	 * 
	 * @param Nome dell'Appuntamento fallito di cui cercare l'id
	 * @return Id dell'Appuntamento fallito
	 */
	public int cercaIDappuntamentofallito(String nomeAppuntamentofallito) {
		
		int id = 0;
		
		try {
			
			id = AppuntamentoDAO.readIDAppuntamentofallito(nomeAppuntamentofallito);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Un errore si e' verificato durante la ricerca dell'id dell'appuntamento fallito!");
			
		}
		
		return id;
		
	}

	/**
	 * 
	 * @param ID dell'Agente di Vendita da cercare
	 * @return Agente di Vendita cercato
	 */
	public AgentediVendita getAgentediVendita(int IDAgente) {
		
		AgentediVendita a = null;
		
		try {
			
			a = AgentediVenditaDAO.readAgentediVendita(IDAgente);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Un errore si e' verificato durante la ricerca dell'agente di vendita!");
			
		}
		
		return a;
		
	}

	/**
	 * 
	 * @param Appuntamento da modificare
	 * @return Non previsto
	 */
	public void modificaAppuntamento(Appuntamento a) {
		
		try {
			
			AppuntamentoDAO.updateAppuntamento(a);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Impossibile modificare l'appuntamento!");
			
		}
		
	}

	/**
	 * 
	 * @param Appuntamento da rimuovere
	 * @return Non previsto
	 */
	public void rimuoveAppuntamento(Appuntamento a) {
		
		try {
			
			AppuntamentoDAO.deleteAppuntamento(a);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Impossibile eliminare l'appuntamento!");
			
		}
		
	}

}