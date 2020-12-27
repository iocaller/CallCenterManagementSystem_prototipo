package CallCenterManagement.Controller.Impl;

import javax.swing.JOptionPane;
import CallCenterManagement.Controller.AuthenticationManager;
import CallCenterManagement.Dao.AdminDiSistemaDAO;
import CallCenterManagement.Dao.AgentediVenditaDAO;
import CallCenterManagement.Dao.AmministratoreDAO;
import CallCenterManagement.Dao.CentralinistaDAO;
import CallCenterManagement.Entity.AdmindiSistema;

/**
* Implementazione Autenticazione Utenti del sistema
* <p><b>Login, Logout e Register di Admin di Sistema, Amministratore, Centralinista, Agente di Vendita</b></p>
* <hr>
* <ul>
* <li>login() - utile per l'accesso al sistema, se e' presente nel DB, accedi, altrimenti no</li>
* <li>logout() - torna in Application Console</li>
* <li>reagistration() - se nella combobox si seleziona Admin di sistema, allora può registrarti, altrimenti no</li>
* </ul> 
*
*/

public class AuthenticationManagerImpl implements AuthenticationManager{
	
	
	/**
	 * Login 
	 * <ul>
	 * <li>tramite Email per Amministratore, Centralinista, Agente di Vendita
	 * <li>tramite Username per Admin di Sistema
	 * </ul>
	 */
	public int login(String ruolo, String email, String pass) {
		
		int loggato = 0;
		
		if (ruolo == "centralinista") {
					
			try {
	        	
				loggato = CentralinistaDAO.loginCentralinista(email, pass);
	            
	            
	        } catch (Exception exception) {
	        	
	            exception.printStackTrace();
	            
	        }
			
		} else if (ruolo == "amministratore") {
			
			try {
	        	
	            loggato = AmministratoreDAO.loginAmministratore(email, pass);
	            
	            
	        } catch (Exception exception) {
	        	
	            exception.printStackTrace();
	            
	        }
			
		} else if (ruolo == "admindisistema") {
			
			try {
	        	
	            loggato = AdminDiSistemaDAO.loginAdminDiSistema(email, pass);
	            
	            
	        } catch (Exception exception) {
	        	
	            exception.printStackTrace();
	            
	        }
			
		} else if (ruolo == "agentedivendita") {
			
			try {
	        	
	            loggato = AgentediVenditaDAO.loginAgentediVendita(email, pass);
	            
	            
	        } catch (Exception exception) {
	        	
	            exception.printStackTrace();
	            
	        }
			
		}
		
		return loggato;
	}

	public int logout() {
		
		int conf = JOptionPane.showConfirmDialog(null, "Are you sure?");
		
		return conf;
		
	}

	public void registration(String username, String password) {
		
		AdmindiSistema a = new AdmindiSistema(username,password);
		
        try {
        	
            AdminDiSistemaDAO.createAdminDiSistema(a);
            
        } catch (Exception exception) {
        	
            exception.printStackTrace();
            
        }
        
	}
	
}