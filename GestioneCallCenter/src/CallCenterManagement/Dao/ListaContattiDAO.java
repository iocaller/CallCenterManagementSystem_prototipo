package CallCenterManagement.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import CallCenterManagement.Entity.*;

/**
* Implementazione DAO ListaContatti
* <p>Connessione e implementazione della Base di dati con ListaContatti</p>
* <hr>
* <ul>
* <li>createListaContatti()</li>
* <li>cercaContattiDataBanks()</li>
* <li>readListaContatti()</li>
* <li>readContatto()</li>
* <li>deleteListaContatti()</li>
* <li>updateListaContatti()</li>
* <li>importDataBanks()</li>
* </ul> 
*/

public class ListaContattiDAO {

	/**
	 * 
	 * @param Lista Contatti da aggiungere nel DB
	 * @return Non previsto
	 */
	public static void createListaContatti(ListaContatti l) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("INSERT INTO listacontatti (NomeLista, DescrizioneLista) " +
					"VALUES (?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			s.setString(1, l.getNomeLista());
			s.setString(2, l.getDescrizioneLista());
			
			s.executeUpdate();
			
			ResultSet generatedKeys = s.getGeneratedKeys();
			generatedKeys.next();
			int ID = generatedKeys.getInt(1);
	
			l.setID(ID);
			
			JOptionPane.showMessageDialog(null, "Lista contatti creata, inserisci contatti!");
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Lista contatti gia' esistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
	}

	/**
	 * 
	 * @param L'amministratore cerca la lista contatti per effettuare diverse modifiche da fare
	 * @return Non previsto 
	 */
	public static void readListaContatti(ListaContatti l) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try {
			
			s = conn.prepareStatement("SELECT * FROM listacontatti WHERE NomeLista=?");
			s.setString(1, l.getNomeLista());
						
			s.executeQuery();
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}

	}

	/**
	 * 
	 * @param ID del Contatto da leggere dal DB
	 * @return Non previsto
	 */
	static Contatto readContatto(int ID) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		Contatto c = null;
		
		try {
			
			s = conn.prepareStatement("SELECT * FROM contatto WHERE ID=?");
			s.setInt(1, ID);
			
			ResultSet rs = s.executeQuery();
			
			c = new Contatto(rs.getString("Nome"),rs.getString("Cognome"),rs.getString("NumeroDiTelefono"),
								rs.getString("Citta"),rs.getString("Sesso"),rs.getDate("DataDiNascita"),
								rs.getString("Indirizzo"));
				
			c.setID(rs.getInt("ID"));
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Contatto inesistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
		
		return c;
		
	}

	/**
	 * 
	 * @param Dati della Lista Contatti da modificare nel DB
	 * @return Non previsto
	 */
	public static void updateListaContatti(ListaContatti l) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("UPDATE listacontatti SET DescrizioneLista=? WHERE NomeLista=?");
			
			s.setString(1, l.getDescrizioneLista());
			s.setString(2, l.getNomeLista());
			
			s.executeUpdate();
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Lista contatti inesistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		}
	}

	/**
	 * 
	 * @param Dati della Lista Contatti da eliminare dal DB
	 * @return Non previsto 
	 */
	public static void deleteListaContatti(ListaContatti l) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement s = null;
		
		try { 
			s = conn.prepareStatement("DELETE FROM listacontatti WHERE NomeLista=?");
			s.setString(1, l.getNomeLista());
			
			s.executeUpdate();
			
		} catch (SQLException e){
			
			JOptionPane.showMessageDialog(null, "Lista contatti inesistente!");
			
		} finally {
			
			if (s != null) { s.close(); }
			
		
		}
		
	}
	
	/**
	 * 
	 * @param Dati dei contatti da cercare nel DataBanks DB
	 * @return ResultSet dei contatti trovati
	 */
	public static ResultSet cercaContattiDataBanks(String Citta, String Sesso, Date DataDiNascita) throws SQLException {
		
		PreparedStatement s = null;
		PreparedStatement s1 = null;
		PreparedStatement s2 = null;
		ResultSet importa = null;
		Connection conn;
		
		//GESTIONE DELLA RICERCA DEI CONTATTI
		if(Sesso.isEmpty() && DataDiNascita == null)		//Ricerca solo per citta' 
		{
			
			try
			{
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databanks", "root", "");
				s = conn.prepareStatement("SELECT * "
					            + "FROM contatto "
					            + "WHERE Citta = ? ", ResultSet.TYPE_SCROLL_SENSITIVE, 
		                        ResultSet.CONCUR_UPDATABLE);
				s.setString(1, Citta);

				importa = s.executeQuery();
				
			} 
			catch (SQLException e) 
			{
				JOptionPane.showMessageDialog(null, "Errore COD.1");
			}
			
		} 

		else if(Citta.isEmpty() && Sesso.isEmpty()) //Ricerca solo per Data di Nascita
		{
			try 
			{
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databanks", "root", "");
				s1 = conn.prepareStatement("SELECT * "
					            + "FROM contatto "
					            + "WHERE DatadiNascita = ? ", ResultSet.TYPE_SCROLL_SENSITIVE, 
		                        ResultSet.CONCUR_UPDATABLE);
				
				java.sql.Date datann = new java.sql.Date(DataDiNascita.getTime());  //Trick 
				s1.setDate(1, datann);

				importa = s1.executeQuery();
				
			} 
			catch (SQLException e) 
			{
				JOptionPane.showMessageDialog(null, "Errore COD.2");
			}
		} else {
			
			try 
			{
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/databanks", "root", "");
				
				s2 = conn.prepareStatement("SELECT * "
					            + "FROM contatto "
					            + "WHERE Citta = ? "
					            + "AND Sesso = ? "
					            + "AND DataDiNascita = ? ", ResultSet.TYPE_SCROLL_SENSITIVE, 
		                        ResultSet.CONCUR_UPDATABLE);
				s2.setString(1, Citta);
				s2.setString(2, Sesso);
				
				java.sql.Date datann = new java.sql.Date(DataDiNascita.getTime());  //Trick 
				
				s2.setDate(3, datann);
					
				importa = s2.executeQuery();
				
			} 
			catch (SQLException e) 
			{
				JOptionPane.showMessageDialog(null, "Errore COD.3");
			}
			
		}
		
		return importa;

	}


	
	/**
	 * 
	 * @param ResultSet dei contatti cercati nel DataBanksDB
	 * @return Non previsto
	 */
	public static void importDataBanks(ResultSet rs, int IDListaContatti) throws SQLException {
		
		PreparedStatement s = null;
		
		try {
			
			Connection conn2 = DBManager.getInstance().getConnection();		//Connessione ad iocaller
			
			s = conn2.prepareStatement("INSERT INTO contatto (Nome, Cognome, NumeroDiTelefono, Citta, Sesso, "
					+ "DataDiNascita, Indirizzo) " +
					"VALUES (?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);;
			
			while (rs.next()) {
				
				//Aggiunge contatti nella lista contatti
				
				s.setString(1, rs.getString("Nome"));
				s.setString(2,rs.getString("Cognome"));
				s.setString(3,rs.getString("NumeroDiTelefono"));
				s.setString(4, rs.getString("Citta"));
				s.setString(5, rs.getString("Sesso"));
				s.setDate(6,rs.getDate("DataDiNascita"));
				s.setString(7, rs.getString("Indirizzo"));
				
				s.executeUpdate();
				
				ResultSet generatedKeys = s.getGeneratedKeys();
				generatedKeys.next();
				
				ContattoListaContattiDAO.createContattoListaContatti(generatedKeys.getInt(1), IDListaContatti);
				
			} 
				
			JOptionPane.showMessageDialog(null, "Contatto/i importato/i!");
			
		} catch (SQLException e) {
			
			JOptionPane.showMessageDialog(null, "Contatto non esistente");
			
		} finally {
				
			if (s != null) { s.close(); }
				
		}

	}

}