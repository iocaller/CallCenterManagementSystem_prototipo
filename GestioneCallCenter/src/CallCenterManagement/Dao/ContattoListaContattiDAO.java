package CallCenterManagement.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import CallCenterManagement.Entity.Contatto;
import CallCenterManagement.Entity.ListaContatti;

/**
* Implementazione DAO ContattoListaContatti
* <p>Connessione e implementazione della Base di dati con ContattoListaContatti</p>
* <hr>
* <ul>
* <li>craeteContattoListaContatti()</li>
* <li>updateContatto()</li>
* <li>updateListaContatti()</li>
* </ul> 
*
*/


public class ContattoListaContattiDAO {

	/**
	 * 
	 * @param Contatto da modificare in ContattoListaContatti del DB
	 * @return Non previsto
	 */
	public static void createContattoListaContatti(int IDContatto, int IDListaContatti) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement ps = null;
		
		try {
			
			ps = conn.prepareStatement("INSERT INTO contattolistacontatti (IDContatto, IDListaContatti) VALUES (?,?)");	
			ps.setInt(1, IDContatto);
			ps.setInt(2, IDListaContatti);
			ps.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Contatto aggiunto "+ IDContatto +" alla lista contatti "+ IDListaContatti +" !");
			
		} finally {
			
			if (ps != null) { ps.close(); }
			
		}
		
	}
	
	/**
	 * 
	 * @param Contatto da modificare in ContattoListaContatti del DB
	 * @return Non previsto
	 */
	public void updateContatto(Contatto c) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement ps = null;
		
		try {
			
			ps = conn.prepareStatement("SELECT * FROM contattolistacontatti WHERE IDContatto=?");	
			ps.setInt(1, c.getID());
			ResultSet rs = ps.executeQuery();
			ps.close();
			
			ps = conn.prepareStatement("DELETE FROM contattolistacontatti WHERE IDContatto=?");	
			ps.setInt(1, c.getID());
			ps.executeUpdate();
			
			ps = conn.prepareStatement("INSERT INTO contattolistacontatti (IDContatto, IDListaContatti) VALUES (?, ?)");
			ps.setInt(1, c.getID());
			
			while (rs.next()) {
				
				ps.setInt(2, rs.getInt(2));
				ps.executeUpdate();
				
			}
			
			JOptionPane.showMessageDialog(null, "Contatto/i aggiornato/i!");
			
		} finally {
			
			if (ps != null) { ps.close(); }
			
		}
		
	}

	/**
	 * 
	 * @param Lista Contatti da modificare in ContattoListaContatti del DB
	 * @return Non previsto
	 */
	public void updateListaContatti(ListaContatti L) throws SQLException {
		
		Connection conn = DBManager.getInstance().getConnection();
		PreparedStatement ps = null;
		
		try {
			
			ps = conn.prepareStatement("SELECT * FROM contattolistacontatti WHERE IDListaContatti=?");	
			ps.setInt(1, L.getID());
			ResultSet rs = ps.executeQuery();
			ps.close();
			
			ps = conn.prepareStatement("DELETE FROM contattolistacontatti WHERE IDListaContatti=?");	
			ps.setInt(1, L.getID());
			ps.executeUpdate();
			
			ps = conn.prepareStatement("INSERT INTO contattolistacontatti (IDContatto, IDListaContatti) VALUES (?, ?)");
			ps.setInt(1, L.getID());
			
			while (rs.next()) {
				
				ps.setInt(2, rs.getInt(1));
				ps.executeUpdate();
				
			}
			
			JOptionPane.showMessageDialog(null, "Lista Contatti aggiornata!");
			
		} finally {
			
			if (ps != null) { ps.close(); }
			
		}
		
	}

}