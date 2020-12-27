package CallCenterManagement.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import CallCenterManagement.Entity.AdmindiSistema;

/**
* Implementazione DAO Admin di Sistema
* <p>Connessione e implementazione della Base di dati con Admin di Sistema</p>
* <hr>
* <ul>
* <li>createAdminDiSistema()</li>
* <li>loginAdminDiSistema()</li>
* <li>readAdminDiSistema()</li>
* <li>deleteAdminDiSistema()</li>
* <li>updateAdminDiSistema()</li>
* </ul> 
*
*/

public class AdminDiSistemaDAO {
	
	/**
	 * 
	 * @param Admin Di Sistema da aggiungere nel DB
	 * @return Non previsto
	 */
	public static void createAdminDiSistema(AdmindiSistema a) throws SQLException{
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("INSERT INTO admindisistema (Username, Password) " +
					"VALUES (?,?)");
			
			s.setString(1, a.getUsername());
			s.setString(2, a.getPassword());
			
			s.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Admin Di Sistema registrato!");
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Admin Di Sistema gia' esistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
	}
	
	/**
	 * 
	 * @param ID dell'Admin Di Sistema
	 * @return Non previsto
	 */
	static void readAdminDiSistema(String username) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("SELECT * FROM admindisistema WHERE Username=?");
			s.setString(1, username);
			
			s.executeQuery();
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
		
	}
	
	/**
	 * 
	 * @param email e password dell'Admin Di Sistema
	 * @return Non previsto
	 */
	public static int loginAdminDiSistema(String username, String password) throws SQLException{
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		int loggato = 0;
		
		try { 
			s = conn.prepareStatement("SELECT * FROM admindisistema WHERE Username=? and Password=?");
			s.setString(1, username);
			s.setString(2, password);
			
			ResultSet rs = s.executeQuery();
			if (rs.next()) {
				loggato = 1;
				JOptionPane.showMessageDialog(null, "Login effettuata con successo");
			} else {
				JOptionPane.showMessageDialog(null, "Dati inseriti errati");
			}
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Admin Di Sistema non esistente");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
		
		return loggato;
		
	}

	/**
	 * 
	 * @param Dati dell'Admin Di Sistema da modificare nel DB
	 * @return Non previsto
	 */
	public void updateAdminDiSistema(AdmindiSistema a) throws SQLException{
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("UPDATE admindisistema SET Password=? WHERE Username=?");
			
			s.setString(1, a.getPassword());
			s.setString(2, a.getUsername());
			
			s.executeUpdate();
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Admin Di Sistema inesistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
		
	}

	/**
	 * 
	 * @param ID dell'Admin Di Sistema da eliminare dal DB
	 * @return Non previsto
	 */
	public void deleteAdminDiSistema(AdmindiSistema a) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("DELETE FROM admindisistema WHERE Username=?");
			s.setString(1, a.getUsername());
			
			s.executeUpdate();
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Admin Di Sistema inesistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
	}

}