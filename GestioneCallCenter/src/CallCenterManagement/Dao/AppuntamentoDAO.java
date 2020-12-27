package CallCenterManagement.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JOptionPane;
import CallCenterManagement.Entity.Appuntamento;

/**
* Implementazione DAO Appuntamento
* <p>Connessione e implementazione della Base di dati con Appuntamento</p>
* <hr>
* <ul>
* <li>createAppuntamento()</li>
* <li>loginAppuntamento()</li>
* <li>readAppuntamento()</li>
* <li>readIDAppuntamentofallito()</li>
* <li>deleteAppuntamento()</li>
* <li>restoreAppuntamento()</li>
* <li>updateAppuntamento()</li>
* </ul> 
*/

public class AppuntamentoDAO {

	private static Map<Integer, Appuntamento> persistanceMap = new java.util.HashMap<Integer, Appuntamento>();
	
	/**
	 * 
	 * @param Appuntamento da aggiungere nel DB
	 * @return non previsto
	 */
	public static void createAppuntamento(Appuntamento a) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("INSERT INTO appuntamento (NomeAppuntamento, Data, Ora, Note, IDappuntamentofallito, IDAgente) " +
					"VALUES (?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			s.setString(1, a.getNomeAppuntamento());
			
			//Il casting tra util.Date e sql.Date non � consentito per questo motivo adottiamo un altro stratagemma
			//Usiamo il costruttore di sql.Date che "Constructs a Date object using the given milliseconds time value." 
			//I millisecondi da usare per costruire l'oggeto li otteniamo da getTime() metodo della classe util.Date
			
			java.sql.Date data = new java.sql.Date(a.getData().getTime());
			
			s.setDate(2, data);
			s.setString(3, a.getOra());
			s.setString(4, a.getNote());
			s.setInt(5, a.getIDappuntamentofallito());
			s.setInt(6, a.getIDAgente());
			
			s.executeUpdate();
			
			ResultSet generatedKeys = s.getGeneratedKeys();
			generatedKeys.next();
			int ID = generatedKeys.getInt(1);
	
			a.setID(ID);
			
			JOptionPane.showMessageDialog(null, "Appuntamento creato!");
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Appuntamento gia' esistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
	}
	
	/**
	 * 
	 * @param ResultSet della lettura dal Db dell'Appuntamento
	 * @return Appuntamento creato nel programma
	 */
	public static Appuntamento restoreAppuntamento(ResultSet rs) throws SQLException {
		
		Appuntamento c;
		
		final int persistantID = rs.getInt("ID");
		final String nome = rs.getString("NomeAppuntamento");
		final Date data = rs.getDate("Data");
		final String ora = rs.getString("Ora");
		final String note = rs.getString("Note");
		final int idappuntamentofallito = rs.getInt("IDappuntamentofallito");
		final int idagente = rs.getInt("IDAgente");
		
		c = new Appuntamento(nome, data, ora, note, idappuntamentofallito, idagente);
		c.setID(persistantID); // Aggiungo ID!
		return c;
		
	}
	
	/**
	 * 
	 * @param ID dell'Appuntamento
	 * @return Agente di Vendita se non era stato aggiunto nel programma
	 */
	public static Appuntamento readAppuntamento(int ID) throws SQLException {
		
		if (persistanceMap.containsKey(ID)) {
			return persistanceMap.get(ID);
		}
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("SELECT * FROM appuntamento WHERE ID=?");
			s.setInt(1, ID);
			
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				Appuntamento c = restoreAppuntamento(rs);
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
	 * @param Nome dell'Appuntamento fallito
	 * @return ID dell'appuntamento fallito
	 */
	public static int readIDAppuntamentofallito(String nomeAppuntamentofallito) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("SELECT ID FROM appuntamento WHERE NomeAppuntamento=?");
			s.setString(1, nomeAppuntamentofallito);
			
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("ID");
				return id;				
			}
			return 0;
		} finally {
			
			if (s != null) { s.close(); }
			
		}
		
	}

	/**
	 * 
	 * @param Dati dell' Appuntamento da modificare nel DB
	 * @return Non previsto
	 */
	public static void updateAppuntamento(Appuntamento a) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("UPDATE appuntamento SET NomeAppuntamento=?, Data=?, Ora=?, Note=?, IDappuntamentofallito=? "
					+ "WHERE ID=?");
			
			s.setString(1, a.getNomeAppuntamento());
			
			java.sql.Date data = new java.sql.Date(a.getData().getTime());
			s.setDate(2, data);
			
			s.setString(3, a.getOra());
			s.setString(4, a.getNote());
			s.setInt(5, a.getIDappuntamentofallito());
					
			s.setInt(6, a.getID());
			
			s.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Appuntamento modificato!");
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Appuntamento inesistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
			}
	}

	/**
	 * 
	 * @param Id dell'appunatamento da rimuovere dal db
	 * @return Non previsto
	 */
	public static void deleteAppuntamento(Appuntamento a) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("DELETE FROM appuntamento WHERE ID=?");
			s.setInt(1, a.getID());
			
			s.executeUpdate();
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Appuntamento inesistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
	}

}