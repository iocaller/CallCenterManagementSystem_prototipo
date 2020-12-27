package CallCenterManagement.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;
import CallCenterManagement.Entity.Centralinista;

/**
* Implementazione DAO Centralinista
* <p>Connessione e implementazione della Base di dati con Centralinista</p>
* <hr>
* <ul>
* <li>createCentralinista()</li>
* <li>loginCentralinista()</li>
* <li>readCentralinista()</li>
* <li>restoreCentralinista()</li>
* <li>deleteCentralinista()</li>
* <li>updateCentralinista()</li>
* </ul> 
*
*/


public class CentralinistaDAO {

	private static Map<Integer, Centralinista> persistanceMap = new java.util.HashMap<Integer, Centralinista>();
	
	/**
	 * 
	 * @param Centralinista da aggiungee nel DB
	 * @return Non previsto
	 */
	public static void createCentralinista(Centralinista c) throws SQLException{
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("INSERT INTO centralinista (Nome, Cognome, DataDiNascita, Residenza, Indirizzo, "
					+ "NumeroDiTelefono, Email, Password, Competenze,Qualifica, Stato) " +
					"VALUES (?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			s.setString(1, c.getNome());
			s.setString(2, c.getCognome());
			s.setDate(3, (java.sql.Date)c.getDataDiNascita());
			s.setString(4, c.getResidenza());
			s.setString(5, c.getIndirizzo());
			s.setString(6, c.getNumeroDiTelefono());
			s.setString(7, c.getEmail());
			s.setString(8, c.getPassword());
			s.setString(9, c.getCompetenze());
			s.setString(10, c.getQualifica());
			s.setString(11, c.getStato());
			
			s.executeUpdate();
			
			ResultSet generatedKeys = s.getGeneratedKeys();
			generatedKeys.next();
			int ID = generatedKeys.getInt(1);
			
			c.setID(ID);
			
			JOptionPane.showMessageDialog(null, "Centralinista creato!");
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Centralinista gia' esistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
		
	}

	/**
	 * 
	 * @param ResultSet della lettura dal Db del Centralinista
	 * @return Centralinista creato nel programma
	 */
	public static Centralinista restoreCentralinista(ResultSet rs) throws SQLException {
		
		Centralinista c;
		
		final int persistantID = rs.getInt("ID");
		final String nome = rs.getString("Nome");
		final String cognome = rs.getString("Cognome");
		final Date datadinascita = rs.getDate("DataDiNascita");
		final String residenza = rs.getString("Residenza");
		final String indirizzo = rs.getString("Indirizzo");
		final String telefono = rs.getString("NumeroDiTelefono");
		final String email = rs.getString("Email");
		final String password = rs.getString("Password");
		final String competenze = rs.getString("Competenze");
		final String qualifica = rs.getString("Qualifica");
		final String stato = rs.getString("Stato");
		
		c = new Centralinista(nome,cognome,datadinascita,residenza,indirizzo,telefono,email,password,competenze,qualifica,stato);
		c.setID(persistantID); // Aggiungo ID!
		return c;
		
	}
	
	/**
	 * 
	 * @param ID del Centralinista
	 * @return Centralinista se non era stato aggiunto nel programma
	 */
	static Centralinista readCentralinista(int ID) throws SQLException {
		
		if (persistanceMap.containsKey(ID)) {
			return persistanceMap.get(ID);
		}
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("SELECT * FROM centralinista WHERE ID=?");
			s.setInt(1, ID);
			
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				Centralinista c = restoreCentralinista(rs);
				persistanceMap.put(c.getID(), c);
				return c;
			}
			return null;
		} finally {
			
			if (s != null) { s.close(); }
			
		}
		
	}
	
	/**
	 * 
	 * @param email e password del Centralinista
	 * @return Non previsto
	 */
	public static int loginCentralinista(String email, String password) throws SQLException{
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		int loggato = 0;
		
		try { 
			s = conn.prepareStatement("SELECT * FROM centralinista WHERE email=? and password=?");
			s.setString(1, email);
			s.setString(2, password);
			
			ResultSet rs = s.executeQuery();
			if (rs.next()) {
				loggato = 1;
				JOptionPane.showMessageDialog(null, "Login effettuata con successo");
			} else {
				JOptionPane.showMessageDialog(null, "Dati inseriti errati");
			}
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Centralinista non esistente");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
		
		return loggato;
		
	}

	/**
	 * 
	 * @param Dati del Centralinista da modificare nel DB
	 * @return Non previsto
	 */
	public void updateCentralinista(Centralinista c) throws SQLException{
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement(
					"UPDATE centralinista SET Nome=?, Cognome=?, DataDiNascita=?, Residenza=?, Indirizzo=?, "
					+ "NumeroDiTelefono=?, Email=?, Password=? WHERE ID=?");
			
			s.setString(1, c.getNome());
			s.setString(2, c.getCognome());
			s.setDate(3, (java.sql.Date)c.getDataDiNascita());
			s.setString(4, c.getResidenza());
			s.setString(5, c.getIndirizzo());
			s.setString(6, c.getNumeroDiTelefono());
			s.setString(7, c.getEmail());
			s.setString(8, c.getPassword());
					
			s.setInt(9, c.getID());
			
			s.executeUpdate();
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Centralinista inesistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
		
	}

	/**
	 * 
	 * @param ID del Centralinista da eliminare dal DB
	 * @return Non previsto
	 */
	public void deleteCentralinista(Centralinista c) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("DELETE FROM centralinista WHERE ID=?");
			s.setInt(1, c.getID());
			
			s.executeUpdate();
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Centralinista inesistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
	}

}