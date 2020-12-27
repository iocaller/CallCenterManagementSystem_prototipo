package CallCenterManagement.Controller;

import CallCenterManagement.Entity.*;

/**
 * Interface Class Resoconto Appuntamento
 */

public interface ResocontoAppuntamento {
	
	public Appuntamento visualizzaAppuntamento(int ID);

	public void rifiutaAppuntamento(Appuntamento a);
	
}