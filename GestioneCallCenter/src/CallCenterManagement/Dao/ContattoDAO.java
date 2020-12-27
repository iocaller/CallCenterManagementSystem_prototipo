package CallCenterManagement.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import CallCenterManagement.Entity.Contatto;

/**
* Implementazione DAO Contatto
* <p>Connessione e implementazione della Base di dati con Contatto</p>
* <hr>
* <ul>
* <li>readContatto()</li>
* <li>readListaContatto()</li>
* <li>craeteContatto()</li>
* <li>deleteContatto()</li>
* <li>updateContatto()</li>
* </ul> 
*
*/


public class ContattoDAO {

	/**
	 * 
	 * @param Contatto da aggiungere al DB
	 * @return Non previsto 
	 */
	public void createContatti(Contatto C) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("INSERT INTO contatto (Nome, Cognome, NumeroDiTelefono, Citta, Sesso, DataDiNascita, Indirizzo) " + "VALUES (?,?,?,?,?,?,?)");
			
			s.setString(1, C.getNome());
			s.setString(2, C.getCognome());
			s.setString(3, C.getNumeroDiTelefono());
			s.setString(3, C.getCitta());
			s.setString(4, C.getSesso());
			s.setDate(5, (java.sql.Date)C.getDataDiNascita());
			s.setString(6, C.getIndirizzo());
			
			s.executeUpdate();
			
			ResultSet generatedKeys = s.getGeneratedKeys();
			generatedKeys.next();
			int ID = generatedKeys.getInt(1);
			
			C.setID(ID);
			
			JOptionPane.showMessageDialog(null, "Contatto/i creato/i!");
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Contatto/i gia' esistente/i!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
	}

	/**
	 * 
	 * @param ID della Lista Contatti per prendere tutti i contatti che contiene
	 * @return Non previsto 
	 */
	public static ResultSet readContatti(int IDlista) throws SQLException {
			
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		ResultSet rs = null;
		
		//Quando si vuole leggere i contatti, visualizziamo tutti i contatti nella lista contatti
		try {
			
			//al posto di ID '=' metti IN, altrimenti ELIO si arrabbia, testato anche su mysql
			s = conn.prepareStatement("SELECT * FROM contatto WHERE ID IN (SELECT IDContatto "
					+ "FROM contattolistacontatti WHERE IDListaContatti=?)", ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
			
			s.setInt(1, IDlista);
			
			rs = s.executeQuery();
			
			return rs;
			
		} finally {
			
		//	if (s != null) { s.close(); }
			
		}
		
	}

	/**
	 * 
	 * @param ID del Contatto per prendere tutte le liste contatti in cui è presente
	 * @return Non previsto 
	 */
	static void readListaContatti(int IDcontatto) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		//Quando si vuole leggere la lista contatti, visualizziamo tutte le liste contatti in cui è presente il contatto
		try {
			
			s = conn.prepareStatement("SELECT * FROM listacontatti WHERE ID=(SELECT IDListaContatti "
					+ "FROM contattolistacontatti WHERE IDContatto=?)");
			
			s.setInt(1, IDcontatto);
			s.executeQuery();
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}

	}

	/**
	 * 
	 * @param Dati del Contatto da modificare nel DB
	 * @return Non previsto 
	 */
	public void updateContatti(Contatto C) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		//Puo essere fatta la modifica solo sul numero di telefono (?)
		//In caso di FORM, passare solo Nome, cognome, citta e indirizzo per identificare il contatto da modificare
		
		try { 
			s = conn.prepareStatement("UPDATE contatto SET NumeroDiTelefono=? WHERE Nome=? AND Cognome=? AND Citta=? AND Indirizzo=?");
			
			s.setString(1, C.getNome());
			s.setString(2, C.getCognome());
			s.setString(3, C.getCitta());
			s.setString(4, C.getIndirizzo());
			
			s.executeUpdate();
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Contatto inesistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
	}

	/**
	 * 
	 * @param Dati del Contatto da eliminare dal DB
	 * @return Non previsto 
	 */
	public void deleteContatti(Contatto C) throws SQLException {
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("DELETE FROM contatto WHERE Nome=? AND Cognome=? AND Citta=? AND Indirizzo=?");
			s.setString(1, C.getNome());
			s.setString(2, C.getCognome());
			s.setString(3, C.getCitta());
			s.setString(4, C.getIndirizzo());
			
			s.executeUpdate();
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Contatto inesistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
	}

}