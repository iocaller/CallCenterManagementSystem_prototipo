package CallCenterManagement.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JOptionPane;
import CallCenterManagement.Entity.AgentediVendita;


/**
* Implementazione DAO Agente di Vendita
* <p>Connessione e implementazione della Base di dati con Agente di Vendita</p>
* <hr>
* <ul>
* <li>createAgenteDiVendita()</li>
* <li>loginAgenteDiVendita()</li>
* <li>readAgenteDiVendita()</li>
* <li>deleteAgenteDiVendita()</li>
* <li>restoreAgenteDiVendita()</li>
* <li>updateAgenteDiVendita()</li>
* </ul> 
*
*/


public class AgentediVenditaDAO {

private static Map<Integer, AgentediVendita> persistanceMap = new java.util.HashMap<Integer, AgentediVendita>();
	
	/**
	 * 
	 * @param Agente di Vendita da aggiungere nel DB
	 * @return Non previsto
	 */
	public static void createAgentediVendita(AgentediVendita a) throws SQLException{
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("INSERT INTO agentedivendita (Nome, Cognome, NumeroDiTelefono, "
					+ "Email, Password, Competenze) VALUES (?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			s.setString(1, a.getNome());
			s.setString(2, a.getCognome());
			s.setString(3, a.getNumeroDiTelefono());
			s.setString(4, a.getEmail());
			s.setString(5, a.getPassword());
			s.setString(6, a.getCompetenze());
			
			s.executeUpdate();
			
			ResultSet generatedKeys = s.getGeneratedKeys();
			generatedKeys.next();
			int ID = generatedKeys.getInt(1);
			
			a.setID(ID);
			
			JOptionPane.showMessageDialog(null, "Agente di Vendita creato!");
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Agente di Vendita gia' esistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
	}

	/**
	 * 
	 * @param ResultSet della lettura dal Db dell'Agente di Vendita
	 * @return Agente di Vendita creato nel programma
	 */
	public static AgentediVendita restoreAgentediVendita(ResultSet rs) throws SQLException {
		
		AgentediVendita c;
		
		final int persistantID = rs.getInt("ID");
		final String nome = rs.getString("Nome");
		final String cognome = rs.getString("Cognome");
		final String telefono = rs.getString("NumeroDiTelefono");
		final String email = rs.getString("Email");
		final String password = rs.getString("Password");
		final String competenze = rs.getString("Competenze");
		
		c = new AgentediVendita(nome,cognome,telefono,email,password,competenze);
		c.setID(persistantID); // Aggiungo ID!
		return c;
		
	}
	
	/**
	 * 
	 * @param ID dell'Agente di Vendita
	 * @return Agente di Vendita se non era stato aggiunto nel programma
	 */
	public static AgentediVendita readAgentediVendita(int ID) throws SQLException {
		
		if (persistanceMap.containsKey(ID)) {
			return persistanceMap.get(ID);
		}
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("SELECT * FROM agentedivendita WHERE ID=?");
			s.setInt(1, ID);
			
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				AgentediVendita c = restoreAgentediVendita(rs);
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
	 * @param email e password dell'Agente di Vendita
	 * @return Non previsto
	 */
	public static int loginAgentediVendita(String email, String password) throws SQLException{
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		int loggato = 0;
		
		try { 
			s = conn.prepareStatement("SELECT * FROM agentedivendita WHERE email=? and password=?");
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
			
			JOptionPane.showMessageDialog(null, "Agente di Vendita non esistente");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
		return loggato;
	}

	/**
	 * 
	 * @param Dati dell'Agente di Vendita da modificare nel DB
	 * @return Non previsto
	 */
	public void updateAgentediVendita(AgentediVendita a) throws SQLException{
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("UPDATE agentedivendita SET Nome=?, Cognome=?, NumeroDiTelefono=?, Email=?, Password=? "
					+ "WHERE ID=?");
			
			s.setString(1, a.getNome());
			s.setString(2, a.getCognome());
			s.setString(3, a.getNumeroDiTelefono());
			s.setString(4, a.getEmail());
			s.setString(5, a.getPassword());
					
			s.setInt(6, a.getID());
			
			s.executeUpdate();
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Agente di Vendita inesistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
		
	}

	/**
	 * 
	 * @param ID dell'Agente di Vendita da eliminare dal DB
	 * @return Non previsto
	 */
	public void deleteAgentediVendita(AgentediVendita a) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("DELETE FROM agentedivendita WHERE ID=?");
			s.setInt(1, a.getID());
			
			s.executeUpdate();
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Agente di Vendita inesistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
	}

}