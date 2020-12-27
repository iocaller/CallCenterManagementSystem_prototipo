package CallCenterManagement.Controller.Impl;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import CallCenterManagement.Dao.AppuntamentoDAO;
import CallCenterManagement.Controller.ResocontoAppuntamento;
import CallCenterManagement.Entity.Appuntamento;

/**
 * Implementazione Reseconto dell'Appuntamento
 * <p><b>Visualizza e rifiuta l'appuntamento</b></p>
 * <hr>
 * <ul>
 * <li>rifiutaAppuntamento() - si puo' rifiutare l'appuntamento in caso di necessita'</li>
 * <li>visualizzaAppuntamento() - si visualizzano tutti gli appuntamenti creati dal centralinista </li>
 * <ul>
 */

public class ResocontoAppuntamentoImpl implements ResocontoAppuntamento {
	
	public Appuntamento visualizzaAppuntamento(int ID) {
		
		Appuntamento a = null;
		
		try {
			
			a = AppuntamentoDAO.readAppuntamento(ID);
			
			a.print(a);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Impossibile visualizzare l'appuntamento!");
			
		}
		
		return a;
		
	}

	public void rifiutaAppuntamento(Appuntamento a) {
		
		a.setNote("Rifiutato");
		
		try {
			
			AppuntamentoDAO.updateAppuntamento(a);
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Impossibile rifiutare l'appuntamento!");
			
		}
		
	}
	
}