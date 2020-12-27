package CallCenterManagement.Controller;

import CallCenterManagement.Entity.Amministratore;

/**
 * Interface Class Gestione Amministratore
 */

public interface GestioneAmministratore {
	
	public void aggiungeAmministratore(Amministratore a);

	public void rimuoveAmministratore(Amministratore a);

	public void modificaAmministratore(Amministratore a);
}