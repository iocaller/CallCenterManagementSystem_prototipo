package CallCenterManagement.Dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;
import CallCenterManagement.Entity.Amministratore;

/**
* Implementazione DAO Amministratore
* <p>Connessione e implementazione della Base di dati con Amministratore</p>
* <hr>
* <ul>
* <li>createAmministratore()</li>
* <li>loginAmministratore()</li>
* <li>readAmministratore()</li>
* <li>deleteAmministratore()</li>
* <li>restoreAmministratore()</li>
* <li>updateAmministratore()</li>
* </ul> 
*/


public class AmministratoreDAO {

private static Map<Integer, Amministratore> persistanceMap = new java.util.HashMap<Integer, Amministratore>();
	
	/**
	 * 
	 * @param Amministratore da aggiungere nel DB
	 * @return Non previsto
	 */
	public static void createAmministratore(Amministratore a) throws SQLException{
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("INSERT INTO amministratore (Nome, Cognome, DataDiNascita, Residenza, Indirizzo, "
					+ "NumeroDiTelefono, Email, Password, Competenze,Qualifica) " +
					"VALUES (?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			s.setString(1, a.getNome());
			s.setString(2, a.getCognome());
			
			//Il casting tra util.Date e sql.Date non � consentito per questo motivo adottiamo un altro stratagemma
			//Usiamo il costruttore di sql.Date che "Constructs a Date object using the given milliseconds time value." 
			//I millisecondi da usare per costruire l'oggeto li otteniamo da getTime() metodo della classe util.Date
			
			java.sql.Date data = new java.sql.Date(a.getDataDiNascita().getTime()); 
			s.setDate(3, data);				
			s.setString(4, a.getResidenza());
			s.setString(5, a.getIndirizzo());
			s.setString(6, a.getNumeroDiTelefono());
			s.setString(7, a.getEmail());
			s.setString(8, a.getPassword());
			s.setString(9, a.getCompetenze());
			s.setString(10, a.getQualifica());
			
			s.executeUpdate();
			
			ResultSet generatedKeys = s.getGeneratedKeys();
			generatedKeys.next();
			int ID = generatedKeys.getInt(1);
			
			a.setID(ID);
			
			JOptionPane.showMessageDialog(null, "Amministratore creato!");
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Amministratore gia' esistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
	}

	/**
	 * 
	 * @param ResultSet della lettura dal Db dell'Amministratore
	 * @return Amministratore creato nel programma
	 */
	public static Amministratore restoreAmministratore(ResultSet rs) throws SQLException {
		
		Amministratore c;
		
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
		
		c = new Amministratore(nome,cognome,datadinascita,residenza,indirizzo,telefono,email,password,competenze,qualifica);
		c.setID(persistantID); // Aggiungo ID!
		return c;
		
	}
	
	/**
	 * 
	 * @param ID dell'Amministratore
	 * @return Amministratore se non era stato aggiunto nel programma
	 */
	static Amministratore readAmministratore(int ID) throws SQLException {
		
		if (persistanceMap.containsKey(ID)) {
			return persistanceMap.get(ID);
		}
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("SELECT * FROM amministratore WHERE ID=?");
			s.setInt(1, ID);
			
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				Amministratore c = restoreAmministratore(rs);
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
	 * @param email e password dell'Amministratore
	 * @return Non previsto
	 */
	public static int loginAmministratore(String email, String password) throws SQLException{
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		int loggato = 0;
		
		try { 
			s = conn.prepareStatement("SELECT * FROM amministratore WHERE email=? and password=?");
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
			
			JOptionPane.showMessageDialog(null, "Amministratore non esistente");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
		
		return loggato;
		
	}

	/**
	 * 
	 * @param Dati dell'Amministratore da modificare nel DB
	 * @return Non previsto
	 */
	public static void updateAmministratore(Amministratore a) throws SQLException{
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("UPDATE amministratore SET Nome=?, Cognome=?, DataDiNascita=?, Residenza=?, Indirizzo=?, "
					+ "NumeroDiTelefono=?, Email=?, Password=?, Competenze = ?,Qualifica = ?  WHERE ID=?");
			
			s.setString(1, a.getNome());
			s.setString(2, a.getCognome());
			
			java.sql.Date data = new java.sql.Date(a.getDataDiNascita().getTime()); 
			
			s.setDate(3, data);
			s.setString(4, a.getResidenza());
			s.setString(5, a.getIndirizzo());
			s.setString(6, a.getNumeroDiTelefono());
			s.setString(7, a.getEmail());
			s.setString(8, a.getPassword());
			s.setString(9, a.getCompetenze());
			s.setString(10, a.getQualifica());
					
			s.setInt(11, a.getID());
			
			s.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Amministratore modificato!");
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Amministratore inesistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
		
	}

	/**
	 * 
	 * @param Dati dell'Amministratore da eliminare dal DB
	 * @return Non previsto
	 */
	public static void deleteAmministratore(Amministratore a) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("DELETE FROM amministratore WHERE ID=?");
			s.setInt(1, a.getID());
			
			s.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Amministratore eliminato!");
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Amministratore inesistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
	}
	
	

}