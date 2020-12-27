package CallCenterManagement.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JOptionPane;
import CallCenterManagement.Entity.Gruppo;

/**
* Implementazione DAO Gruppo
* <p>Connessione e implementazione della Base di dati con Gruppo</p>
* <hr>
* <ul>
* <li>readGruppo()</li>
* <li>restoreGruppo()</li>
* <li>craeteGruppo()</li>
* <li>deleteGruppo()</li>
* <li>updateGruppo()</li>
* </ul> 
*
*/

public class GruppoDAO {

	private static Map<Integer, Gruppo> persistanceMap = new java.util.HashMap<Integer, Gruppo>();
	
	/**
	 * 
	 * @param Gruppo da aggiungere nel DB
	 * @return Non previsto
	 */
	public static void createGruppo(Gruppo g) throws SQLException{
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("INSERT INTO gruppo (Descrizione) " +
					"VALUES (?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			s.setString(1, g.getDescrizione());
			
			s.executeUpdate();
			
			ResultSet generatedKeys = s.getGeneratedKeys();
			generatedKeys.next();
			int ID = generatedKeys.getInt(1);
			
			g.setID(ID);
			
			JOptionPane.showMessageDialog(null, "Gruppo creato!");
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Gruppo gia' esistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
	}
	
	/**
	 * 
	 * @param ResultSet della lettura dal Db del Gruppo
	 * @return Agente di Vendita creato nel programma
	 */
	public static Gruppo restoreGruppo(ResultSet rs) throws SQLException {
		
		Gruppo c;
		
		final int persistantID = rs.getInt("ID");
		final String descrizione = rs.getString("Descrizione");
		
		c = new Gruppo(descrizione);
		c.setID(persistantID); // Aggiungo ID!
		return c;
		
	}
	
	/**
	 * 
	 * @param ID del Gruppo
	 * @return Agente di Vendita se non era stato aggiunto nel programma
	 */
	static Gruppo readGruppo(int ID) throws SQLException {
		
		if (persistanceMap.containsKey(ID)) {
			return persistanceMap.get(ID);
		}
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("SELECT * FROM gruppo WHERE ID=?");
			s.setInt(1, ID);
			
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				Gruppo g = restoreGruppo(rs);
				persistanceMap.put(g.getID(), g);
				return g;
			}
			return null;
		} finally {
			
			if (s != null) { s.close(); }
			
		}
		
	}

	/**
	 * 
	 * @param Dati del Gruppo da modificare nel DB
	 * @return Non previsto
	 */
	public void updateGruppo(Gruppo g) throws SQLException{
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("UPDATE gruppo SET Descrizione=? WHERE ID=?");
			
			s.setString(1, g.getDescrizione());
			s.setInt(2, g.getID());
			
			s.executeUpdate();
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Gruppo inesistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
		
	}

	/**
	 * 
	 * @param ID del Gruppo da eliminare dal DB
	 * @return Non previsto
	 */
	public void deleteGruppo(Gruppo g) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("DELETE FROM gruppo WHERE ID=?");
			s.setInt(1, g.getID());
			
			s.executeUpdate();
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Gruppo inesistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
	}

}