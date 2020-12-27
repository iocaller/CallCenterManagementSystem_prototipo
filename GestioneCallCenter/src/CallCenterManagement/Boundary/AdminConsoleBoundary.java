package CallCenterManagement.Boundary;

import CallCenterManagement.Controller.GestioneCallCenterEIS;
import CallCenterManagement.Entity.Amministratore;
import net.proteanit.sql.DbUtils;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

/**
 * <h2>Gestione Amministratore - IOCaller</h2>
 * <hr>
 * <p>Implementazione dell'interfaccia grafica con WindowsBuilder</p>
 *
 */

public class AdminConsoleBoundary extends JFrame {

	private static final long serialVersionUID = 1L;
	
	//Pannelli
	private JPanel contentPane;
	private JPanel PanelRimuoviAmm;
	private JPanel PanelModificaAmm;
	private JPanel PanelAmministratore;
	
	//tabelle
	private JTable table_rimuoviTable;
	private JTable table;
	private JTable table_modificaAmm;
	
	//layer
	private JLayeredPane layeredPane;

	//campi testo
	private JTextField ModificaID;
	private JTextField Nome;
	private JTextField Residenza;
	private JTextField RimNome;
	private JTextField RimCognome;
	private JTextField RimuoviID;
	private JTextField Data_nascita;
	private JTextField Cognome;
	private JTextField Email;
	private JTextField NumerodiTelefono;
	private JTextField Indirizzo;
	private JTextField AggNome;
	private JTextField AggResidenza;
	private JTextField AggData;
	private JTextField AggCognome;
	private JTextField AggEmail;
	private JTextField AggNumero;
	private JTextField AggIndirizzo;
	private JTextField AggCompetenze;
	private JTextField AggQualifica;
	private JTextField Competenze;
	private JTextField Qualifica;
	
	//campi password
	private JPasswordField Password;
	private JPasswordField AggPassword;
	



	/**
	 * Lancio dell'applicazione.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
					AdminConsoleBoundary frame = new AdminConsoleBoundary(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	 * <br>Creaziome del frame 
	 * 
	 */
	public AdminConsoleBoundary(String Username) {
		
		//Barra superiore
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1468, 804);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		/*
		 * Inizio pannello Menu
		 */
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 200, 765);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAmministratore = new JLabel("Admin di Sistema");
		lblAmministratore.setFont(new Font("Roboto", Font.BOLD, 15));
		lblAmministratore.setBounds(10, 11, 180, 36);
		panel.add(lblAmministratore);
		
		//pulsante AggiungiAmministratore
		JButton btnAggiungiAmm = new JButton("Aggiungi amministratore");
		btnAggiungiAmm.setBackground(Color.LIGHT_GRAY);
		btnAggiungiAmm.setForeground(UIManager.getColor("CheckBox.light"));
		btnAggiungiAmm.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnAggiungiAmm.addActionListener(new ActionListener() {
			
			/**
			 * <h4> Action del pulsante "Aggiungi Amministratore" </h4>
			 */
			
			public void actionPerformed(ActionEvent arg0) {
				
				switch_screen(PanelAmministratore);
				
				Connection conn;
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iocaller", "root", "");
					Statement st = conn.createStatement();
					
					ResultSet rs = st.executeQuery("SELECT * FROM amministratore");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					st.close();
					
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null, "Errore di connessione al DB!");
					
				}
				
			}
		});
		btnAggiungiAmm.setBounds(10, 92, 180, 36);
		panel.add(btnAggiungiAmm);
		
		//pulsante LOGOUT
		JButton btnGestioneListaContatti_2_1 = new JButton("Logout");
		btnGestioneListaContatti_2_1.addActionListener(new ActionListener() {
			
			/**
			 * <h4> Action del pulsante "Logout" </h4>
			 */
			public void actionPerformed(ActionEvent arg0) {
				
				//Collegamento all applicationConsoleBoundary
				int confirm = GestioneCallCenterEIS.getInstance().logout();
	            if (confirm == JOptionPane.YES_OPTION) {
	            	
	            	ApplicationConsoleBoundary a = new ApplicationConsoleBoundary();
					a.setVisible(true);
					dispose();
					
	            }
			}
		});
		btnGestioneListaContatti_2_1.setBackground(Color.LIGHT_GRAY);
		btnGestioneListaContatti_2_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnGestioneListaContatti_2_1.setBounds(10, 718, 80, 36);
		panel.add(btnGestioneListaContatti_2_1);
		
		//pulsante ModificaAmministratore
		JButton btnModificaAmministratore = new JButton("Modifica amministratore");
		btnModificaAmministratore.setBackground(Color.LIGHT_GRAY);
		btnModificaAmministratore.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnModificaAmministratore.addActionListener(new ActionListener() {
			/**
			 * <h4> Action del pulsante "Modifica Amministratore" </h4>
			 */
			public void actionPerformed(ActionEvent arg0) {
				
				//switch_screen e' utile per passare da un pannello all'altro
				switch_screen(PanelModificaAmm);
				
				Connection conn;
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iocaller", "root", "");
					Statement st = conn.createStatement();
					
					ResultSet rs = st.executeQuery("SELECT * FROM amministratore");
					table_modificaAmm.setModel(DbUtils.resultSetToTableModel(rs));
					
					st.close();
					
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null, "Errore di connessione al DB!");
					
				}

			}
		});
		btnModificaAmministratore.setBounds(10, 139, 180, 36);
		panel.add(btnModificaAmministratore);
		
		//pulsante RimuoviAmministratore
		JButton btnRimuoviAmm = new JButton("Rimuovi Amministratori");
		btnRimuoviAmm.setBackground(Color.LIGHT_GRAY);
		btnRimuoviAmm.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnRimuoviAmm.addActionListener(new ActionListener() {
			/**
			 * <h4> Action del pulsante "Rimuovi Amministratore" </h4>
			 */
			public void actionPerformed(ActionEvent arg0) {
				
				switch_screen(PanelRimuoviAmm);
				
				Connection conn;
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iocaller", "root", "");
					Statement st = conn.createStatement();
					
					ResultSet rs = st.executeQuery("SELECT * FROM amministratore");
					table_rimuoviTable.setModel(DbUtils.resultSetToTableModel(rs));
					
					st.close();
					
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null, "Errore di connessione al DB!");
					
				}
			}
		});
		btnRimuoviAmm.setBounds(10, 186, 180, 36);
		panel.add(btnRimuoviAmm);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 705, 180, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 78, 180, 2);
		panel.add(separator_1);
		
		JLabel lblNomeAmministratore = new JLabel("Nome: ");
		lblNomeAmministratore.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNomeAmministratore.setBounds(10, 43, 46, 14);
		panel.add(lblNomeAmministratore);
		
		JLabel lblNewLabel = new JLabel(Username);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabel.setBounds(51, 43, 139, 15);
		panel.add(lblNewLabel);
		
		JLabel lblLogoPanelAdmin = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/minilogo.png"));
		lblLogoPanelAdmin.setIcon(img);
		lblLogoPanelAdmin.setBounds(25, 637, 150, 56);
		panel.add(lblLogoPanelAdmin);
		
		/*
		 * Fine pannello Menu
		 */
				
		
		/*
		 * Inizio Pannello Aggiungi Amministratore
		 */
		layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(new Color(220, 20, 60), 2));
		layeredPane.setBounds(210, 11, 1232, 743);
		contentPane.add(layeredPane);
		
		PanelAmministratore = new JPanel();
		PanelAmministratore.setLayout(null);
		PanelAmministratore.setBorder(new LineBorder(new Color(220, 20, 60)));
		PanelAmministratore.setBounds(0, 0, 1231, 743);
		layeredPane.add(PanelAmministratore);
		
		JLabel lblIAggiungiAmministratore = new JLabel("Aggiungi Amministratore");
		lblIAggiungiAmministratore.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblIAggiungiAmministratore.setBounds(10, 9, 171, 31);
		PanelAmministratore.add(lblIAggiungiAmministratore);
		
		AggNome = new JTextField();
		AggNome.setColumns(10);
		AggNome.setBounds(10, 85, 183, 31);
		PanelAmministratore.add(AggNome);
		
		AggResidenza = new JTextField();
		AggResidenza.setColumns(10);
		AggResidenza.setBounds(210, 151, 183, 31);
		PanelAmministratore.add(AggResidenza);
		
		JLabel lblnome_1 = new JLabel("Inserisci Nome");
		lblnome_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblnome_1.setBounds(10, 71, 107, 14);
		PanelAmministratore.add(lblnome_1);
		
		JLabel lblInsertResidenza_1 = new JLabel("Inserisci Residenza");
		lblInsertResidenza_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInsertResidenza_1.setBounds(210, 137, 156, 14);
		PanelAmministratore.add(lblInsertResidenza_1);
		
		JButton btnAggiungi = new JButton("Aggiungi Amministratore");
		btnAggiungi.setBackground(Color.LIGHT_GRAY);
		btnAggiungi.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnAggiungi.addActionListener(new ActionListener() {
			
			/**
			 * <h4> Action del pulsante "Aggiungi Amministratore" </h4>
			 * <p> Se i campi sono vuoti, error.
			 */
			public void actionPerformed(ActionEvent arg0) {
				Amministratore a;
				String pass = new String (AggPassword.getPassword()); //getPassword restituisce un array di char, il campo che mi interessa � una stringa per questo motivo richiamo il costruttore della classe string
				if(AggNome.getText().isEmpty() || AggCognome.getText().isEmpty() || AggData.getText().isEmpty()|| AggResidenza.getText().isEmpty() 
						|| AggIndirizzo.getText().isEmpty() || AggNumero.getText().isEmpty() || AggEmail.getText().isEmpty() 
						|| pass.isEmpty() || AggCompetenze.getText().isEmpty() || AggQualifica.getText().isEmpty())
				{
					
					JOptionPane.showMessageDialog(null, "Inserisci tutti i campi!");
					
				} else {
					
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String s = AggData.getText();
				Date ddn = null;
				
				try {
					ddn = formatter.parse(s);		//Conversione da string a util.Date sfruttando il formato "dd/MM/yyyy"
					
					a = new Amministratore(AggNome.getText(), AggCognome.getText(), ddn, AggResidenza.getText(), AggIndirizzo.getText(), AggNumero.getText(), 
							AggEmail.getText(), pass, AggCompetenze.getText(), AggQualifica.getText());
					
					GestioneCallCenterEIS.getInstance().aggiungeAmministratore(a);
					
					//Aggiunta in real life
			//		DefaultTableModel model = (DefaultTableModel) table.getModel();
			//		model.addRow(new Object [] {a.getID(),AggNome.getText(), AggCognome.getText(), ddn, AggResidenza.getText(), AggIndirizzo.getText(), AggNumero.getText(), 	PARTI FORSE INUTILI
			//				AggEmail.getText(), pass, AggCompetenze.getText(), AggQualifica.getText()});
					
				} catch (ParseException e) {
					
					JOptionPane.showMessageDialog(null, "Errore nell'inserimento della data!");
					
				}
			 }
		  }
		});
		btnAggiungi.setBounds(10, 371, 183, 36);
		PanelAmministratore.add(btnAggiungi);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(417, 11, 804, 724);
		PanelAmministratore.add(scrollPane_1);
		
		//tabella amministratori
		table = new JTable();
		table.setFont(new Font("Roboto", Font.PLAIN, 11));
		table.setBackground(SystemColor.window);
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Cognome", "Data di Nascita", "Residenza", "Indirizzo", "Numero di Telefono", "Email", "Password", "Competenze", "Qualifica"
			}
		));
		table.getColumnModel().getColumn(7).setPreferredWidth(120);
		table.setBorder(new LineBorder(new Color(220, 20, 60), 0));
		
		AggData = new JTextField();
		AggData.setColumns(10);
		AggData.setBounds(10, 151, 183, 31);
		PanelAmministratore.add(AggData);
		
		JLabel lblInsertdata_1_1 = new JLabel("Inserisci Data di Nascita (dd/MM/yyyy) ");
		lblInsertdata_1_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInsertdata_1_1.setBounds(10, 137, 156, 14);
		PanelAmministratore.add(lblInsertdata_1_1);
		
		AggCognome = new JTextField();
		AggCognome.setColumns(10);
		AggCognome.setBounds(210, 85, 183, 31);
		PanelAmministratore.add(AggCognome);
		
		JLabel lblInserisciCognome_1 = new JLabel("Inserisci Cognome");
		lblInserisciCognome_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInserisciCognome_1.setBounds(210, 71, 107, 14);
		PanelAmministratore.add(lblInserisciCognome_1);
		
		AggPassword = new JPasswordField();
		AggPassword.setColumns(10);
		AggPassword.setBounds(210, 263, 183, 31);
		PanelAmministratore.add(AggPassword);
		
		AggEmail = new JTextField();
		AggEmail.setColumns(10);
		AggEmail.setBounds(10, 263, 183, 31);
		PanelAmministratore.add(AggEmail);
		
		AggNumero = new JTextField();
		AggNumero.setColumns(10);
		AggNumero.setBounds(210, 207, 183, 31);
		PanelAmministratore.add(AggNumero);
		
		AggIndirizzo = new JTextField();
		AggIndirizzo.setColumns(10);
		AggIndirizzo.setBounds(10, 207, 183, 31);
		PanelAmministratore.add(AggIndirizzo);
		
		JLabel lblInsertIndirizzo_1 = new JLabel("Inserisci Indirizzo");
		lblInsertIndirizzo_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInsertIndirizzo_1.setBounds(10, 193, 156, 14);
		PanelAmministratore.add(lblInsertIndirizzo_1);
		
		JLabel lblnum_di_telefono_1 = new JLabel("Inserisci Numero di telefono");
		lblnum_di_telefono_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblnum_di_telefono_1.setBounds(210, 193, 171, 14);
		PanelAmministratore.add(lblnum_di_telefono_1);
		
		JLabel lblInsertEmail_1 = new JLabel("Inserisci Email");
		lblInsertEmail_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInsertEmail_1.setBounds(10, 249, 156, 14);
		PanelAmministratore.add(lblInsertEmail_1);
		
		JLabel lblInserisciPassword_1 = new JLabel("Inserisci Password");
		lblInserisciPassword_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInserisciPassword_1.setBounds(210, 249, 156, 14);
		PanelAmministratore.add(lblInserisciPassword_1);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(10, 51, 383, 2);
		PanelAmministratore.add(separator_2_1);
		
		AggCompetenze = new JTextField();
		AggCompetenze.setColumns(10);
		AggCompetenze.setBounds(10, 316, 183, 31);
		PanelAmministratore.add(AggCompetenze);
		
		JLabel lblInsertCompetenze_1 = new JLabel("Inserisci Competenze");
		lblInsertCompetenze_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInsertCompetenze_1.setBounds(10, 303, 156, 14);
		PanelAmministratore.add(lblInsertCompetenze_1);
		
		AggQualifica = new JTextField();
		AggQualifica.setColumns(10);
		AggQualifica.setBounds(210, 316, 183, 31);
		PanelAmministratore.add(AggQualifica);
		
		JLabel lblInsertQualifica_1 = new JLabel("Inserisci Qualifica");
		lblInsertQualifica_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInsertQualifica_1.setBounds(210, 303, 156, 14);
		PanelAmministratore.add(lblInsertQualifica_1);
		
		PanelModificaAmm = new JPanel();
		PanelModificaAmm.setBorder(new LineBorder(new Color(220, 20, 60)));
		PanelModificaAmm.setBounds(0, 0, 1231, 743);
		layeredPane.add(PanelModificaAmm);
		PanelModificaAmm.setLayout(null);
		
		JLabel lblImportaContatti = new JLabel("Modifica Amministratore");
		lblImportaContatti.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblImportaContatti.setBounds(10, 11, 171, 31);
		PanelModificaAmm.add(lblImportaContatti);
		
		ModificaID = new JTextField();
		ModificaID.setFont(new Font("Roboto", Font.PLAIN, 11));
		ModificaID.setBounds(10, 106, 183, 31);
		PanelModificaAmm.add(ModificaID);
		ModificaID.setColumns(10);
		
		Nome = new JTextField();
		Nome.setFont(new Font("Roboto", Font.PLAIN, 11));
		Nome.setColumns(10);
		Nome.setBounds(10, 196, 183, 31);
		PanelModificaAmm.add(Nome);
		
		Residenza = new JTextField();
		Residenza.setFont(new Font("Roboto", Font.PLAIN, 11));
		Residenza.setColumns(10);
		Residenza.setBounds(210, 262, 183, 31);
		PanelModificaAmm.add(Residenza);
		
		JLabel lblModificaAmm = new JLabel("Modifica Amministratore con ID:");
		lblModificaAmm.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblModificaAmm.setBounds(10, 81, 183, 14);
		PanelModificaAmm.add(lblModificaAmm);
		
		JLabel lblnome = new JLabel("Inserisci Nome");
		lblnome.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblnome.setBounds(10, 182, 107, 14);
		PanelModificaAmm.add(lblnome);
		
		JLabel lblInsertResidenza = new JLabel("Inserisci Residenza");
		lblInsertResidenza.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInsertResidenza.setBounds(210, 248, 156, 14);
		PanelModificaAmm.add(lblInsertResidenza);
		

		JButton btnModAmministratore = new JButton("Modifica Amministratore");
		btnModAmministratore.setBackground(Color.LIGHT_GRAY);
		btnModAmministratore.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnModAmministratore.addActionListener(new ActionListener() {
			/**
			 * <h4> Action del pulsante "Modifica Amministratore" </h4>
			 * <p> Se i campi sono vuoti, error </p>
			 */
			public void actionPerformed(ActionEvent arg0) {
				Amministratore a;
				String pass = new String (Password.getPassword());//getPassword restituisce un array di char, il campo che mi interessa � una stringa per questo motivo richiamo il costruttore della classe string
				
				if(Nome.getText().isEmpty() || Cognome.getText().isEmpty() || Data_nascita.getText().isEmpty()|| Residenza.getText().isEmpty() 
						|| Indirizzo.getText().isEmpty() || NumerodiTelefono.getText().isEmpty() || Email.getText().isEmpty() 
						|| pass.isEmpty() || Competenze.getText().isEmpty() || Qualifica.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Inserisci tutti i campi!");
				
				else {
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String s = Data_nascita.getText();
				Date ddn = null;
				try {
					
					ddn = formatter.parse(s);		//Conversione da string a util.Date sfruttando il formato "dd/MM/yyyy"
					
				} catch (ParseException e) {
					
					JOptionPane.showMessageDialog(null, "Errore nell'inserimento della data!");
					
				}
				
				a = new Amministratore(Nome.getText(), Cognome.getText(), ddn, Residenza.getText(), Indirizzo.getText(), NumerodiTelefono.getText(), Email.getText(), pass, Competenze.getText(), Qualifica.getText());
				a.setID(Integer.parseInt(ModificaID.getText())); //Uso parseInt per passare da string a int
				GestioneCallCenterEIS.getInstance().modificaAmministratore(a);
				//DefaultTableModel model = (DefaultTableModel) table.getModel();
				//model.addRow(new Object [] {a.getID(),AggNome.getText(), AggCognome.getText(), ddn, AggResidenza.getText(), AggIndirizzo.getText(), AggNumero.getText(),     PARTI FORSE INUTILI
				//AggEmail.getText(), pass, AggCompetenze.getText(), AggQualifica.getText()});
				}
			}
		});
		btnModAmministratore.setBounds(10, 497, 183, 36);
		PanelModificaAmm.add(btnModAmministratore);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(417, 11, 804, 724);
		PanelModificaAmm.add(scrollPane);
		
		//Tabella Amministratori modificati
		table_modificaAmm = new JTable();
		table_modificaAmm.setFont(new Font("Roboto", Font.PLAIN, 11));
		table_modificaAmm.setBackground(SystemColor.window);
		scrollPane.setViewportView(table_modificaAmm);
		table_modificaAmm.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Cognome", "Data di Nascita", "Residenza", "Email", "Password", "Competenze", "Qualifica"
			}
		));
		table_modificaAmm.getColumnModel().getColumn(5).setPreferredWidth(120);
		table_modificaAmm.setBorder(new LineBorder(new Color(220, 20, 60), 0, true));
		
		Data_nascita = new JTextField();
		Data_nascita.setFont(new Font("Roboto", Font.PLAIN, 11));
		Data_nascita.setColumns(10);
		Data_nascita.setBounds(10, 262, 183, 31);
		PanelModificaAmm.add(Data_nascita);
		
		JLabel lblInsertdata_1 = new JLabel("Inserisci Data di Nascita (dd/MM/yyyy)");
		lblInsertdata_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInsertdata_1.setBounds(10, 248, 156, 14);
		PanelModificaAmm.add(lblInsertdata_1);
		
		Cognome = new JTextField();
		Cognome.setFont(new Font("Roboto", Font.PLAIN, 11));
		Cognome.setColumns(10);
		Cognome.setBounds(210, 196, 183, 31);
		PanelModificaAmm.add(Cognome);
		
		JLabel lblInserisciCognome = new JLabel("Inserisci Cognome");
		lblInserisciCognome.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInserisciCognome.setBounds(210, 182, 107, 14);
		PanelModificaAmm.add(lblInserisciCognome);
		
		Password = new JPasswordField();
		Password.setFont(new Font("Roboto", Font.PLAIN, 11));
		Password.setColumns(10);
		Password.setBounds(210, 374, 183, 31);
		PanelModificaAmm.add(Password);
		
		Email = new JTextField();
		Email.setFont(new Font("Roboto", Font.PLAIN, 11));
		Email.setColumns(10);
		Email.setBounds(10, 374, 183, 31);
		PanelModificaAmm.add(Email);
		
		NumerodiTelefono = new JTextField();
		NumerodiTelefono.setFont(new Font("Roboto", Font.PLAIN, 11));
		NumerodiTelefono.setColumns(10);
		NumerodiTelefono.setBounds(210, 318, 183, 31);
		PanelModificaAmm.add(NumerodiTelefono);
		
		Indirizzo = new JTextField();
		Indirizzo.setFont(new Font("Roboto", Font.PLAIN, 11));
		Indirizzo.setColumns(10);
		Indirizzo.setBounds(10, 318, 183, 31);
		PanelModificaAmm.add(Indirizzo);
		
		JLabel lblInsertIndirizzo = new JLabel("Inserisci Indirizzo");
		lblInsertIndirizzo.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInsertIndirizzo.setBounds(10, 304, 156, 14);
		PanelModificaAmm.add(lblInsertIndirizzo);
		
		JLabel lblnum_di_telefono = new JLabel("Inserisci Numero di telefono");
		lblnum_di_telefono.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblnum_di_telefono.setBounds(210, 304, 171, 14);
		PanelModificaAmm.add(lblnum_di_telefono);
		
		JLabel lblInsertEmail = new JLabel("Inserisci Email");
		lblInsertEmail.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInsertEmail.setBounds(10, 360, 156, 14);
		PanelModificaAmm.add(lblInsertEmail);
		
		JLabel lblInserisciPassword = new JLabel("Inserisci Password");
		lblInserisciPassword.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInserisciPassword.setBounds(210, 360, 156, 14);
		PanelModificaAmm.add(lblInserisciPassword);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 148, 383, 2);
		PanelModificaAmm.add(separator_2);
		
		Competenze = new JTextField();
		Competenze.setFont(new Font("Roboto", Font.PLAIN, 11));
		Competenze.setColumns(10);
		Competenze.setBounds(10, 437, 183, 31);
		PanelModificaAmm.add(Competenze);
		
		Qualifica = new JTextField();
		Qualifica.setFont(new Font("Roboto", Font.PLAIN, 11));
		Qualifica.setColumns(10);
		Qualifica.setBounds(210, 437, 183, 31);
		PanelModificaAmm.add(Qualifica);
		
		JLabel lblInsertCompetenze = new JLabel("Inserisci Competenze");
		lblInsertCompetenze.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInsertCompetenze.setBounds(10, 416, 156, 14);
		PanelModificaAmm.add(lblInsertCompetenze);
		
		JLabel lblInsertQualifica = new JLabel("Inserisci Qualifica");
		lblInsertQualifica.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInsertQualifica.setBounds(210, 416, 156, 14);
		PanelModificaAmm.add(lblInsertQualifica);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setBounds(10, 68, 383, 2);
		PanelModificaAmm.add(separator_2_2);
		
		/*
		 * Pannello Rimuovi Amministratore
		 */
		PanelRimuoviAmm = new JPanel();
		PanelRimuoviAmm.setBorder(new LineBorder(new Color(220, 20, 60)));
		PanelRimuoviAmm.setBounds(0, 0, 1231, 743);
		layeredPane.add(PanelRimuoviAmm);
		PanelRimuoviAmm.setLayout(null);
		
		JLabel lblRimuoviAmm = new JLabel("Rimuovi Amministratore");
		lblRimuoviAmm.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblRimuoviAmm.setBounds(10, 17, 193, 14);
		PanelRimuoviAmm.add(lblRimuoviAmm);
		
		JLabel lblNewLabel_1_1 = new JLabel("Inserisci Nome Amministratore");
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(10, 130, 224, 14);
		PanelRimuoviAmm.add(lblNewLabel_1_1);
		
		RimNome = new JTextField();
		RimNome.setFont(new Font("Roboto", Font.PLAIN, 11));
		RimNome.setBounds(10, 155, 199, 30);
		PanelRimuoviAmm.add(RimNome);
		RimNome.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(428, 11, 790, 721);
		PanelRimuoviAmm.add(scrollPane_2);
		
		table_rimuoviTable = new JTable();
		table_rimuoviTable.setBackground(SystemColor.window);
		scrollPane_2.setViewportView(table_rimuoviTable);
		table_rimuoviTable.setBorder(new LineBorder(new Color(220, 20, 60), 2, true));
		table_rimuoviTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nome", "Cognome", "Data di Nascita", "Residenza", "Indirizzo", "Numero di Telefono", "Email", "Password", "Competenze", "Qualifica"
				}
			));
		table_rimuoviTable.getColumnModel().getColumn(7).setPreferredWidth(120);
		table_rimuoviTable.setBorder(new LineBorder(new Color(220, 20, 60), 0));
		
		//Operazione Rimozione funzionante 
		JButton btnRimuoviAmministratore = new JButton("Rimuovi Amministratore");
		btnRimuoviAmministratore.setBackground(Color.LIGHT_GRAY);
		btnRimuoviAmministratore.addActionListener(new ActionListener() {
			/**
			 * <h4> Action del pulsante "Rimuovi Amministratore" </h4>
			 * <p> Se il Campo ID e' vuoto, error </p>
			 */
			public void actionPerformed(ActionEvent arg0) {
				Amministratore a;
				a = new Amministratore(RimNome.getText(), RimCognome.getText(), null, null, null, null, null, null, null, null);
				
				if(RimuoviID.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Inserisci ID!");
					
				} else {
					
					a.setID(Integer.parseInt(RimuoviID.getText())); //Uso parseInt per passare da string a int
					GestioneCallCenterEIS.getInstance().rimuoveAmministratore(a);
				}
			}
		});
		btnRimuoviAmministratore.setBounds(10, 213, 193, 36);
		PanelRimuoviAmm.add(btnRimuoviAmministratore);
		
		JLabel lblCognomeAmm = new JLabel("Cognome Amministratore");
		lblCognomeAmm.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblCognomeAmm.setBounds(219, 130, 224, 14);
		PanelRimuoviAmm.add(lblCognomeAmm);
		
		RimCognome = new JTextField();
		RimCognome.setFont(new Font("Roboto", Font.PLAIN, 11));
		RimCognome.setColumns(10);
		RimCognome.setBounds(219, 155, 199, 30);
		PanelRimuoviAmm.add(RimCognome);
		
		RimuoviID = new JTextField();
		RimuoviID.setFont(new Font("Roboto", Font.PLAIN, 11));
		RimuoviID.setColumns(10);
		RimuoviID.setBounds(10, 72, 199, 30);
		PanelRimuoviAmm.add(RimuoviID);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Inserisci ID");
		lblNewLabel_1_1_2.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblNewLabel_1_1_2.setBounds(10, 47, 224, 14);
		PanelRimuoviAmm.add(lblNewLabel_1_1_2);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 117, 408, 2);
		PanelRimuoviAmm.add(separator_4);
		
		JPanel panel_Home = new JPanel();
		layeredPane.setLayer(panel_Home, 1);
		panel_Home.setLayout(null);
		panel_Home.setBounds(0, 0, 1231, 743);
		layeredPane.add(panel_Home);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBackground(UIManager.getColor("TextArea.disabledBackground"));
		separator_3_1.setBounds(317, 419, 595, 2);
		panel_Home.add(separator_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("BENVENUTO ADMIN DI SISTEMA");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 40));
		lblNewLabel_3.setBounds(10, 252, 1208, 53);
		panel_Home.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel(Username);
		lblNewLabel_2_1.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(353, 316, 144, 15);
		panel_Home.add(lblNewLabel_2_1);
		
		JLabel lblCiao = new JLabel("Ciao: ");
		lblCiao.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblCiao.setBounds(317, 316, 46, 14);
		panel_Home.add(lblCiao);
		
		JLabel lblNewLabel_4 = new JLabel("");
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/logo.png"));
		lblNewLabel_4.setIcon(img2);
		lblNewLabel_4.setBounds(365, 39, 500, 188);
		panel_Home.add(lblNewLabel_4);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(317, 303, 595, 2);
		panel_Home.add(separator_3);
		
		JTextArea txtrPuoiAggiungere = new JTextArea();
		txtrPuoiAggiungere.setText("Puoi:\r\n- Aggiungere Amministratori al sistema\r\n- Modificare Amministratori nel sistema\r\n- Rimuovere gli Amministratori nel sistema");
		txtrPuoiAggiungere.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtrPuoiAggiungere.setBackground(UIManager.getColor("TextArea.disabledBackground"));
		txtrPuoiAggiungere.setBounds(317, 342, 587, 84);
		panel_Home.add(txtrPuoiAggiungere);
			
	}
	
	
	/**
	 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	 * <br>Fine frame Admin di Sistema
	 */
	
	//Piccola funzione per il passaggio da un frame all'altro
	public void switch_screen(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
}
