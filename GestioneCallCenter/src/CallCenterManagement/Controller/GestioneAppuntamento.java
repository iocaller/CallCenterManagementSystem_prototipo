package CallCenterManagement.Controller;

import CallCenterManagement.Entity.*;

/**
 * Interface class Gestione Appuntamento
 *  	
 * 
 */

public interface GestioneAppuntamento {
	
	public void creaAppuntamento(Appuntamento a);

	public Appuntamento ricercaAppuntamento(int ID);
	
	public void modificaNota(Appuntamento a);

	public int cercaIDappuntamentofallito(String nomeAppuntamentofallito);

	public AgentediVendita getAgentediVendita(int IDAgente);
	
	public void modificaAppuntamento(Appuntamento a);
	
	public void rimuoveAppuntamento(Appuntamento a);

}