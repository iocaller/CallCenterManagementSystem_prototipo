package CallCenterManagement.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import CallCenterManagement.Entity.Gruppo;
import CallCenterManagement.Entity.Centralinista;

/**
* Implementazione DAO GruppoCentralinista
* <p>Connessione e implementazione della Base di dati con GruppoCentralinista</p>
* <hr>
* <ul>
* <li>updateCentralinista()</li>
* <li>updateGruppo()</li>
* </ul> 
*
*/

public class GruppoCentralinistaDAO {

	/**
	 * 
	 * @param Centralinista da modificare in GruppoCentralinista del DB
	 * @return Non previsto
	 */
	public void updateCentralinista(Centralinista c) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement ps = null;
		
		try {
			
			ps = conn.prepareStatement("SELECT * FROM gruppocentralinista WHERE IDCentralinista=?");	
			ps.setInt(1, c.getID());
			ResultSet rs = ps.executeQuery();
			ps.close();
			
			ps = conn.prepareStatement("DELETE FROM gruppocentralinista WHERE IDCentralinista=?");	
			ps.setInt(1, c.getID());
			ps.executeUpdate();
			ps.close();
			
			ps = conn.prepareStatement("INSERT INTO gruppocentralinista (IDCentralinista, IDGruppo) VALUES (?, ?)");
			ps.setInt(1, c.getID());
			
			while (rs.next()) {
				
				ps.setInt(2, rs.getInt(2));
				ps.executeUpdate();
				
			}
			
			JOptionPane.showMessageDialog(null, "Centralinista aggiornato!");
			
		} finally {
			
			if (ps != null) { ps.close(); }
			
		}
		
	}

	/**
	 * 
	 * @param Gruppo da modificare in GruppoCentralinista nel DB
	 * @return Non previsto
	 */
	public void updateGruppo(Gruppo g) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement ps = null;
		
		try {
			
			ps = conn.prepareStatement("SELECT * FROM gruppocentralinista WHERE IDGruppo=?");	
			ps.setInt(1, g.getID());
			ResultSet rs = ps.executeQuery();
			ps.close();
			
			ps = conn.prepareStatement("DELETE FROM gruppocentralinista WHERE IDGruppo=?");	
			ps.setInt(1, g.getID());
			ps.executeUpdate();
			ps.close();
			
			ps = conn.prepareStatement("INSERT INTO gruppocentralinista (IDCentralinista, IDGruppo) VALUES (?, ?)");
			ps.setInt(1, g.getID());
			
			while (rs.next()) {
				
				ps.setInt(2, rs.getInt(1));
				ps.executeUpdate();
				
			}
			
			JOptionPane.showMessageDialog(null, "Gruppo aggiornato!");
			
		} finally {
			
			if (ps != null) { ps.close(); }
			
		}
		
	}

}