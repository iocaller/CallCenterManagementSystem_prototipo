package CallCenterManagement.Controller.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import CallCenterManagement.Controller.GestioneLista;
import CallCenterManagement.Dao.ContattoDAO;
import CallCenterManagement.Dao.ContattoListaContattiDAO;
import CallCenterManagement.Dao.ListaContattiDAO;
import CallCenterManagement.Entity.ListaContatti;


/**
 * Implementazione Gestione della Lista contatti
 * <p><b>Crea, Importa e Visualizza la lista contatti</b></p>
 * <hr>
 * <ul>
 * <li>creaListaContatti() - si crea la lista contatti nella base di dati</li>
 * <li>importaContatti() - si importano i contatti nella lista contatti selezionata</li>
 * <li>rimuoveListaContatti() - si puo' rimuovere lista contatti in caso di necessita'</li>
 * <li>cercaContatti() - si pu� cercare il contatto per rilevare i dati di esso </li>
 * <li>modificaListaContatti() - si pu� modificare la lista contatti</li>
 * <li>getAgentediVendita() - si pu� rilevare l'agente di vendita incaricato per l'appuntamento </li>
 * <li>visualiaContatto() - si visualizzano tutti i dati del contatto
 * <ul>
 */



public class GestioneListaImpl implements GestioneLista {
	
	/**
	 * Cerca Contatti
	 */
	public ResultSet cercaContatti(String Citta, String Sesso, Date DataDiNascita) {
		
		try {
        	
			ResultSet rs = ListaContattiDAO.cercaContattiDataBanks(Citta, Sesso, DataDiNascita);
			
			return rs;
            
        } catch (SQLException exception) {
        	
            exception.printStackTrace();
            
        }
		
		return null;
		
	}
	
	/**
	 * Importa Contatti
	 */
	public void importaContatti(ResultSet rs, int IDListaContatti) {
		
		try {
        	
			ListaContattiDAO.importDataBanks(rs, IDListaContatti);
            
        } catch (SQLException exception) {
        	
            exception.printStackTrace();
            
        }
		
	}
	
	/**
	 * Associa La Lista Contatti
	 */
	public void associaListaContatti(int IDContatto, int IDListaContatti) {
		
		try {
        	
			ContattoListaContattiDAO.createContattoListaContatti(IDContatto, IDListaContatti);
            
        } catch (SQLException exception) {
        	
            exception.printStackTrace();
            
        }

	}
	
	/**
	 * Visualizza il Contatto
	 */
	public ResultSet visualizzaContatto(int IDLista) {
		
		ResultSet rs = null;
		
		try {
        	
			rs = ContattoDAO.readContatti(IDLista);
            
        } catch (SQLException exception) {
        	
            exception.printStackTrace();
            
        }
		
		return rs;

	}

	/**
	 * Crea la lista contatti
	 */
	public void creaListaContatti(ListaContatti l) {
		
		try {
        	
			ListaContattiDAO.createListaContatti(l);
            
        } catch (SQLException exception) {
        	
            exception.printStackTrace();
            
        }

	}

	/**
	 * Ricerca la lista contatti
	 */
	public void ricercaListaContatti(ListaContatti l) {
		
		try {
        	
			ListaContattiDAO.readListaContatti(l);
            
        } catch (SQLException exception) {
        	
            exception.printStackTrace();
            
        }

	}

	/**
	 * Modifica la lista contatti
	 */
	public void modificaListaContatti(ListaContatti l) {
		
		try {
        	
			ListaContattiDAO.updateListaContatti(l);
            
        } catch (SQLException exception) {
        	
            exception.printStackTrace();
            
        }
	}

	/**
	 * Rimuove la lista contatti
	 */
	public void rimuoveListaContatti(ListaContatti l) {
		
		try {
        	
			ListaContattiDAO.deleteListaContatti(l);
            
        } catch (SQLException exception) {
        	
            exception.printStackTrace();
            
        }
	}

}