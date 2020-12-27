package CallCenterManagement.Boundary;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
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
import javax.swing.table.DefaultTableModel;
import CallCenterManagement.Controller.GestioneCallCenterEIS;
import CallCenterManagement.Entity.AgentediVendita;
import CallCenterManagement.Entity.Appuntamento;
import net.proteanit.sql.DbUtils;
import javax.swing.UIManager;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

/**
 * <h2>Gestione Appuntamento - IOCaller</h2>
 * <hr>
 * <p>Interfaccia grafica per la gestione degli appuntamenti da parte del Centralinista</p>
 *
 */

public class AppuntamentoConsoleBoundary extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//layer
	private JLayeredPane layeredPane;
	
	//pannelli
	private JPanel contentPane;
	private JPanel PanelRicercaApp;
	private JPanel PanelCreaApp;
	private JPanel PanelVerificaDisponibilita;
	
	//tabelle
	private JTable tableAppuntamentoConsole;
	private JTable table_appuntamenti_res;
	private JTable table;
	
	//campi testo
	private JTextField AggCognome;
	private JTextField InserisciIDappfallito;
	private JTextField IDagente;
	private JTextField InserisciDataapp;
	private JTextField InserisciNoteapp;
	private JTextField AggNome;
	private JTextField InserisciNomeapp;
	private JTextField InserisciOraapp;
	private JTextField IDAppuntamento;
	
	//combobox
	private JComboBox<Integer> comboBox;


	/**
	 * Lancio del'applicazione.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
					AppuntamentoConsoleBoundary frame = new AppuntamentoConsoleBoundary(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	
	/**
	 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	 * <br> Creazione del frame.
	 */
	
	public AppuntamentoConsoleBoundary(String nome) {
		
		//Barra di sistema
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1468, 804);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 200, 765);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/*
		 * Inizio Pannello Menu
		 */
		
		JLabel lblCentralinista = new JLabel("Centralinista");
		lblCentralinista.setFont(new Font("Roboto", Font.BOLD, 15));
		lblCentralinista.setBounds(10, 11, 180, 36);
		panel.add(lblCentralinista);
		
		//pulsante Crea lista contatti
		JButton btnCreaApp = new JButton("Crea Appuntamento");
		btnCreaApp.setBackground(Color.LIGHT_GRAY);
		btnCreaApp.setForeground(UIManager.getColor("CheckBox.light"));
		btnCreaApp.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnCreaApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/**
				 * <h4> Action del pulsante "Crea Appuntamento" </h4>
				 */
				
				switch_screen(PanelCreaApp);
				
				Connection conn;
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iocaller", "root", "");
					Statement st = conn.createStatement();
					Statement st2 = conn.createStatement();
					
					ResultSet rs = st.executeQuery("SELECT * FROM appuntamento");
					ResultSet rs2 = st2.executeQuery("SELECT * FROM agentedivendita");
					
					while (rs2.next()) {
						
						int idagente = rs2.getInt("ID");
						
						comboBox.addItem(idagente);						
					}
					
					tableAppuntamentoConsole.setModel(DbUtils.resultSetToTableModel(rs));
					
					st.close();
					
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null, "Errore di connessione al DB!");
					
				}
				
			}
		});
		btnCreaApp.setBounds(10, 92, 180, 36);
		panel.add(btnCreaApp);
		
		//pulsante LOGOUT
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			
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
		btnLogout.setBackground(Color.LIGHT_GRAY);
		btnLogout.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnLogout.setBounds(10, 718, 80, 36);
		panel.add(btnLogout);
		
		//pulsante ModificaAppuntamento
		JButton btnRicercaApp = new JButton("Ricerca Appuntamento");
		btnRicercaApp.setBackground(Color.LIGHT_GRAY);
		btnRicercaApp.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnRicercaApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//switch_screen e' utile per passare da un pannello all'altro
				switch_screen(PanelRicercaApp);
				
				Connection conn;
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iocaller", "root", "");
					Statement st = conn.createStatement();
					
					ResultSet rs = st.executeQuery("SELECT * FROM appuntamento");
					table_appuntamenti_res.setModel(DbUtils.resultSetToTableModel(rs));
					
					st.close();
					
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null, "Errore di connessione al DB!");
					
				}

			}
		});
		btnRicercaApp.setBounds(10, 139, 180, 36);
		panel.add(btnRicercaApp);
		
		//pulsante RimuoviAppuntamento
		JButton btnVerificaDisp = new JButton("Verifica disponibilit\u00E0 agenti");
		btnVerificaDisp.setBackground(Color.LIGHT_GRAY);
		btnVerificaDisp.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnVerificaDisp.addActionListener(new ActionListener() {
			
			/**
			 * <h4> Action del pulsante "Rimuovi Appuntamento" </h4>
			 */
			public void actionPerformed(ActionEvent arg0) {
				
				switch_screen(PanelVerificaDisponibilita);
				
				Connection conn;
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iocaller", "root", "");
					Statement st = conn.createStatement();
					
					ResultSet rs = st.executeQuery("SELECT ID, Nome, Cognome, NumerodiTelefono, Email, Competenze FROM agentedivendita");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					st.close();
					
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null, "Errore di connessione al DB!");
					
				}
				
			}
		});
		btnVerificaDisp.setBounds(10, 186, 180, 36);
		panel.add(btnVerificaDisp);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 705, 180, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 78, 180, 2);
		panel.add(separator_1);
		
		JLabel lblNomeCentralinista = new JLabel("Nome: ");
		lblNomeCentralinista.setBounds(10, 43, 46, 14);
		panel.add(lblNomeCentralinista);
		
		JLabel lblNomeLogin = new JLabel(nome);
		lblNomeLogin.setBounds(51, 43, 139, 15);
		panel.add(lblNomeLogin);
		
		JLabel lblLogoPanelAppuntamento = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/minilogo.png"));
		lblLogoPanelAppuntamento.setIcon(img);
		lblLogoPanelAppuntamento.setBounds(25, 559, 150, 56);
		panel.add(lblLogoPanelAppuntamento);
		
		JLabel lblAltrePossibiliFunzioni = new JLabel("Altre possibili funzioni future");
		lblAltrePossibiliFunzioni.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblAltrePossibiliFunzioni.setBounds(10, 634, 148, 14);
		panel.add(lblAltrePossibiliFunzioni);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 625, 180, 2);
		panel.add(separator_4);
		
		JButton btnGestioneChiamate = new JButton("Gestione Chiamate");
		btnGestioneChiamate.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnGestioneChiamate.setBackground(Color.LIGHT_GRAY);
		btnGestioneChiamate.setBounds(10, 659, 180, 36);
		panel.add(btnGestioneChiamate);
		
		/*
		 * Fine Menu
		 */
				
		/*
		 * Pannello Creazione Appuntamento
		 */
		layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(new Color(220, 20, 60), 2));
		layeredPane.setBounds(210, 11, 1232, 743);
		contentPane.add(layeredPane);
		
		PanelCreaApp = new JPanel();
		layeredPane.setLayer(PanelCreaApp, 0);
		PanelCreaApp.setBorder(new LineBorder(new Color(220, 20, 60)));
		PanelCreaApp.setBounds(0, 0, 1231, 746);
		layeredPane.add(PanelCreaApp);
		PanelCreaApp.setLayout(null);
		
		JLabel lblCreaAppuntamento = new JLabel("Crea Appuntamento");
		lblCreaAppuntamento.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblCreaAppuntamento.setBounds(10, 11, 171, 31);
		PanelCreaApp.add(lblCreaAppuntamento);
		
		InserisciNomeapp = new JTextField();
		InserisciNomeapp.setFont(new Font("Roboto", Font.PLAIN, 11));
		InserisciNomeapp.setColumns(10);
		InserisciNomeapp.setBounds(10, 92, 297, 31);
		PanelCreaApp.add(InserisciNomeapp);
		
		InserisciOraapp = new JTextField();
		InserisciOraapp.setFont(new Font("Roboto", Font.PLAIN, 11));
		InserisciOraapp.setColumns(10);
		InserisciOraapp.setBounds(10, 204, 297, 31);
		PanelCreaApp.add(InserisciOraapp);
		
		JLabel lblnomeapp = new JLabel("Inserisci Nome appuntamento");
		lblnomeapp.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblnomeapp.setBounds(10, 78, 156, 14);
		PanelCreaApp.add(lblnomeapp);
		
		JLabel lblInsertora_app = new JLabel("Inserisci Ora appuntamento");
		lblInsertora_app.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInsertora_app.setBounds(10, 190, 156, 14);
		PanelCreaApp.add(lblInsertora_app);
		
		//Pulsante CERCA CONTATTI		
		JButton btnCreaAppuntamento = new JButton("Crea Appuntamento");
		btnCreaAppuntamento.setBackground(Color.LIGHT_GRAY);
		btnCreaAppuntamento.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnCreaAppuntamento.addActionListener(new ActionListener() {
			/**
			 * <h4> Action del pulsante "Crea Appuntamento" </h4>
			 * <p> *Se i campi sono vuoti : Error </p>
			 */
			public void actionPerformed(ActionEvent arg0) {
				
				Appuntamento a;
				
				if(InserisciNomeapp.getText().isEmpty() || InserisciDataapp.getText().isEmpty() || InserisciOraapp.getText().isEmpty()
						|| InserisciNoteapp.getText().isEmpty() || comboBox.getSelectedItem().toString().isEmpty())
				{
					
					JOptionPane.showMessageDialog(null, "Inserisci tutti i campi!");
					
				} else {
					
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					String s = InserisciDataapp.getText();
					Date dapp = null;
					int idappuntamentofallito;
					
					if (InserisciIDappfallito.getText().isEmpty()) {
						
						idappuntamentofallito = 0;
						
					} else {
						
						idappuntamentofallito = Integer.parseInt(InserisciIDappfallito.getText());
						
					}
					
					try {
						
						dapp = formatter.parse(s);		//Conversione da string a util.Date sfruttando il formato "dd/MM/yyyy"
						
						int idagente = Integer.parseInt(comboBox.getSelectedItem().toString());
						
						a = new Appuntamento(InserisciNomeapp.getText(), dapp, InserisciOraapp.getText(), 
								InserisciNoteapp.getText(), idappuntamentofallito, idagente);
						
						GestioneCallCenterEIS.getInstance().creaAppuntamento(a);
						
						InserisciNomeapp.setText("");
						InserisciDataapp.setText("");
						InserisciOraapp.setText("");
						InserisciNoteapp.setText("");
						InserisciIDappfallito.setText("");
						
					} catch (ParseException e) {
						
						JOptionPane.showMessageDialog(null, "Errore nell'inserimento della data!");
						
					}
					
				}
				
			}
		});
		btnCreaAppuntamento.setBounds(10, 466, 171, 36);
		PanelCreaApp.add(btnCreaAppuntamento);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(318, 11, 903, 725);
		PanelCreaApp.add(scrollPane);
		
		//Tabella Apputamento
		tableAppuntamentoConsole = new JTable();
		tableAppuntamentoConsole.setBackground(SystemColor.window);
		tableAppuntamentoConsole.setFont(new Font("Roboto", Font.PLAIN, 11));
		tableAppuntamentoConsole.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "NomeAppuntamento", "Data", "Ora", "Note", "IDappuntamentofallito", "IDAgente"
				}
			));
		scrollPane.setViewportView(tableAppuntamentoConsole);
		tableAppuntamentoConsole.setBorder(new LineBorder(new Color(220, 20, 60), 2, true));
		
		InserisciDataapp = new JTextField();
		InserisciDataapp.setFont(new Font("Roboto", Font.PLAIN, 11));
		InserisciDataapp.setColumns(10);
		InserisciDataapp.setBounds(10, 148, 297, 31);
		PanelCreaApp.add(InserisciDataapp);
		
		JLabel lblInsertdata_app = new JLabel("Inserisci Data appuntamento");
		lblInsertdata_app.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInsertdata_app.setBounds(10, 134, 156, 14);
		PanelCreaApp.add(lblInsertdata_app);
		
		JLabel lblInserisciNote = new JLabel("Inserisci Note");
		lblInserisciNote.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInserisciNote.setBounds(10, 246, 107, 14);
		PanelCreaApp.add(lblInserisciNote);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 53, 183, 2);
		PanelCreaApp.add(separator_2);
		
		InserisciNoteapp = new JTextField();
		InserisciNoteapp.setFont(new Font("Roboto", Font.PLAIN, 11));
		InserisciNoteapp.setColumns(10);
		InserisciNoteapp.setBounds(10, 264, 297, 75);
		PanelCreaApp.add(InserisciNoteapp);
		
		JLabel lblIDappfallito = new JLabel("Inserisci ID appuntamento fallito");
		lblIDappfallito.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblIDappfallito.setBounds(10, 351, 183, 16);
		PanelCreaApp.add(lblIDappfallito);
		
		InserisciIDappfallito = new JTextField();
		InserisciIDappfallito.setFont(new Font("Roboto", Font.PLAIN, 11));
		InserisciIDappfallito.setColumns(10);
		InserisciIDappfallito.setBounds(10, 372, 297, 26);
		PanelCreaApp.add(InserisciIDappfallito);
		
		JLabel lblIDAgente = new JLabel("Inserisci ID agente di Vendita");
		lblIDAgente.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblIDAgente.setBounds(10, 410, 194, 16);
		PanelCreaApp.add(lblIDAgente);
		
		comboBox = new JComboBox<Integer>();
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setFont(new Font("Roboto", Font.PLAIN, 11));
		comboBox.setModel(new DefaultComboBoxModel<Integer>());
		comboBox.setBounds(10, 427, 297, 27);
		PanelCreaApp.add(comboBox);
		
		/*
		 * Fine Pannello Creazione Appuntamento
		 */
		
		
		
		/*
		 * Inizio Pannello Rimuovi Appuntamento
		 */
		PanelRicercaApp = new JPanel();
		layeredPane.setLayer(PanelRicercaApp, 0);
		PanelRicercaApp.setBorder(new LineBorder(new Color(220, 20, 60)));
		PanelRicercaApp.setBounds(0, 0, 1231, 743);
		layeredPane.add(PanelRicercaApp);
		PanelRicercaApp.setLayout(null);
		
		JLabel lblRicercaAppuntamento = new JLabel("Ricerca Appuntamento");
		lblRicercaAppuntamento.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblRicercaAppuntamento.setBounds(10, 11, 193, 14);
		PanelRicercaApp.add(lblRicercaAppuntamento);
		
		JLabel lblIDApp = new JLabel("Inserisci ID Appuntamento");
		lblIDApp.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblIDApp.setBounds(10, 46, 224, 14);
		PanelRicercaApp.add(lblIDApp);
		
		IDAppuntamento = new JTextField();
		IDAppuntamento.setFont(new Font("Roboto", Font.PLAIN, 11));
		IDAppuntamento.setBounds(10, 71, 199, 30);
		PanelRicercaApp.add(IDAppuntamento);
		IDAppuntamento.setColumns(10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 179, 1208, 553);
		PanelRicercaApp.add(scrollPane_1);
		
		
		//tabella appuntamenti
		table_appuntamenti_res = new JTable();
		table_appuntamenti_res.setBackground(SystemColor.window);
		table_appuntamenti_res.setFont(new Font("Roboto", Font.PLAIN, 11));
		table_appuntamenti_res.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "NomeAppuntamento", "Data", "Ora", "Note", "IDappuntamentofallito", "IDAgente"
				}
			));
		scrollPane_1.setViewportView(table_appuntamenti_res);
		table_appuntamenti_res.setBorder(new LineBorder(new Color(220, 20, 60), 2, true));
		
		
		JButton btnRicercaAppuntamento = new JButton("Ricerca");
		btnRicercaAppuntamento.setBackground(Color.LIGHT_GRAY);
		btnRicercaAppuntamento.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnRicercaAppuntamento.addActionListener(new ActionListener() {
			/**
			 * <h4> Action del pulsante "Ricerca Appuntamenti" </h4>
			 * <p> Se l'ID appuntamento e' vuoto, Error </p>
			 * 
			 */
			public void actionPerformed(ActionEvent arg0) {
				
				if(IDAppuntamento.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Inserisci ID!");
					
				} else {
				
					int id = Integer.parseInt(IDAppuntamento.getText());
					
					Appuntamento a = GestioneCallCenterEIS.getInstance().ricercaAppuntamento(id);
					
					DefaultTableModel newModel = (DefaultTableModel) table_appuntamenti_res.getModel();
					
					while (newModel.getRowCount() > 0) {
						
						newModel.removeRow(0);
					
					}
					
					newModel.addRow(new Object [] {a.getID(), a.getNomeAppuntamento(), a.getData(), a.getOra(), 
							a.getNote(), a.getIDappuntamentofallito(), a.getIDAgente()});
					
					IDAppuntamento.setText("");
				
				}
				
			}
		});
		btnRicercaAppuntamento.setBounds(10, 112, 199, 36);
		PanelRicercaApp.add(btnRicercaAppuntamento);
		
		PanelVerificaDisponibilita = new JPanel();
		layeredPane.setLayer(PanelVerificaDisponibilita, 0);
		PanelVerificaDisponibilita.setLayout(null);
		PanelVerificaDisponibilita.setBorder(new LineBorder(new Color(220, 20, 60)));
		PanelVerificaDisponibilita.setBounds(0, 0, 1231, 743);
		layeredPane.add(PanelVerificaDisponibilita);
		
		JLabel lblIVerificaDisponib = new JLabel("Verifica Disponibilit\u00E0 degli agenti di vendita");
		lblIVerificaDisponib.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblIVerificaDisponib.setBounds(10, 11, 356, 31);
		PanelVerificaDisponibilita.add(lblIVerificaDisponib);
		
		AggNome = new JTextField();
		AggNome.setColumns(10);
		AggNome.setBounds(10, 156, 183, 31);
		PanelVerificaDisponibilita.add(AggNome);
		
		JLabel lblnome_agente = new JLabel("Inserisci Nome dell'agente di vendita");
		lblnome_agente.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblnome_agente.setBounds(10, 131, 183, 14);
		PanelVerificaDisponibilita.add(lblnome_agente);
		
		JButton btnVerificaAgente = new JButton("Verifica la disponibilit\u00E0");
		btnVerificaAgente.setBackground(Color.LIGHT_GRAY);
		btnVerificaAgente.addActionListener(new ActionListener() {
			/**
			 * <h4> Action del pulsante "Verifica disponibilita'" </h4>
			 * <p> Se IDAgente e' vuoto, Errore </p>
			 */
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(IDagente.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Inserisci ID!");
					
				} else {
					
					int id = Integer.parseInt(IDagente.getText());
					
					AgentediVendita a = GestioneCallCenterEIS.getInstance().getAgentediVendita(id);
					
					DefaultTableModel newModel = (DefaultTableModel) table.getModel();
					
					while (newModel.getRowCount() > 0) {
						
						newModel.removeRow(0);
					
					}
					
					newModel.addRow(new Object [] {a.getID(), a.getNome(), a.getCognome(), a.getNumeroDiTelefono(), 
							a.getEmail(), a.getCompetenze()});
					
					IDagente.setText("");
					AggNome.setText("");
					AggCognome.setText("");
					
				}
								
			}
		});
		btnVerificaAgente.setBounds(10, 208, 183, 36);
		PanelVerificaDisponibilita.add(btnVerificaAgente);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(417, 11, 804, 724);
		PanelVerificaDisponibilita.add(scrollPane_2);
		
		table = new JTable();
		table.setBackground(SystemColor.window);
		table.setFont(new Font("Roboto", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nome", "Cognome", "Numero di telefono", "Email", "Competenze"
				}
			));
		scrollPane_2.setViewportView(table);
		table.setBorder(new LineBorder(new Color(220, 20, 60), 2, true));
		
		AggCognome = new JTextField();
		AggCognome.setColumns(10);
		AggCognome.setBounds(208, 156, 197, 31);
		PanelVerificaDisponibilita.add(AggCognome);
		
		JLabel lblcognome_agente = new JLabel("Inserisci Cognome dell'agente di vendita");
		lblcognome_agente.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblcognome_agente.setBounds(208, 131, 197, 14);
		PanelVerificaDisponibilita.add(lblcognome_agente);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(10, 53, 383, 2);
		PanelVerificaDisponibilita.add(separator_2_1);
		
		JLabel lblIDagente = new JLabel("Inserisci l'ID dell'Agente di Vendita");
		lblIDagente.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblIDagente.setBounds(10, 67, 224, 16);
		PanelVerificaDisponibilita.add(lblIDagente);
		
		IDagente = new JTextField();
		IDagente.setBounds(10, 94, 183, 26);
		PanelVerificaDisponibilita.add(IDagente);
		IDagente.setColumns(10);
		
		JPanel panel_Home = new JPanel();
		layeredPane.setLayer(panel_Home, 1);
		panel_Home.setLayout(null);
		panel_Home.setBounds(0, 0, 1231, 743);
		layeredPane.add(panel_Home);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(317, 468, 595, 2);
		panel_Home.add(separator_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("BENVENUTO CENTRALINISTA");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 40));
		lblNewLabel_3.setBounds(10, 242, 1208, 53);
		panel_Home.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("<dynamic>");
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
		
		JTextArea txtrPuoiCreare = new JTextArea();
		txtrPuoiCreare.setText("Puoi:\r\n- Creare un appuntamento\r\n- Ricercare un appuntamento\r\n- Verificare la disponibilit\u00E0 degli agenti\r\n\r\nImplementazioni future\r\n- Gestione della chiamata");
		txtrPuoiCreare.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtrPuoiCreare.setBackground(SystemColor.control);
		txtrPuoiCreare.setBounds(317, 342, 587, 115);
		panel_Home.add(txtrPuoiCreare);
		
	}
	
	
	/**
	 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	 * <br>Fine frame 
	 */
	
	//Piccola funzione per il passaggio da un frame all'altro
	public void switch_screen(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
}
