package CallCenterManagement.Boundary;

import CallCenterManagement.Controller.GestioneCallCenterEIS;
import CallCenterManagement.Entity.ListaContatti;
import net.proteanit.sql.DbUtils;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
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
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JComboBox;

/**
 * <h2>Gestione Lista Contatti - IOCaller</h2>
 * <hr>
 * <p>Implementazione dell'interfaccia grafica con WindowsBuilder</p>
 *
 */

public class ListaContattiConsoleBoundary extends JFrame {

	/**
	 * JElement della Console di Lista Contatti
	 */
	private static final long serialVersionUID = 1L;

	//Textfield
	private JTextField NomeLista;
	private JTextField DescrizioneLista;
	private JTextField InserisciCitta;
	private JTextField InserisciSesso;
	private JTextField InserisciData;
	private JTextField insnomelista;

	//LayeredPanel
	private JLayeredPane layeredPane;
	
	//Pannelli
	private JPanel PanelVisualizzaContatti;
	private JPanel PanelImportaContatti;
	private JPanel PanelCreaListaContatti;
	private JPanel contentPane;

	//Combobox
	private JComboBox<Integer> comboBox;
	
	//Tabelle
	private JTable table_visual_liste;
	private JTable table_lista_import;
	private JTable table_contatti;
	private JTable table_ResVisualizza;
	private JTable table_VisualizzaContatti;
	private JTable table_Liste;
	
	//Variabile globale di utilit�
	ResultSet contatti;


	/**
	 * Lancio dell' applicazione.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
					ListaContattiConsoleBoundary frame = new ListaContattiConsoleBoundary(null);
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
	public ListaContattiConsoleBoundary(String nome) {
		
		//Barra di sistema
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1464, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		/*
		 * Pannello sinistro - Menu
		 *   
		 */
				
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(210, 11, 1228, 739);
		contentPane.add(layeredPane);
		
		PanelImportaContatti = new JPanel();
		PanelImportaContatti.setBorder(new LineBorder(new Color(220, 20, 60)));
		PanelImportaContatti.setBounds(0, 0, 1228, 739);
		layeredPane.add(PanelImportaContatti);
		PanelImportaContatti.setLayout(null);
		
		/*
		 * Inizio Pannello Importa contatti
		 */

		//Pulsante Importa Contatti
		JLabel lblImportaContatti = new JLabel("Importa Contatti");
		lblImportaContatti.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblImportaContatti.setBounds(10, 0, 171, 31);
		PanelImportaContatti.add(lblImportaContatti);
		
		InserisciCitta = new JTextField();
		InserisciCitta.setFont(new Font("Roboto", Font.PLAIN, 11));
		InserisciCitta.setBounds(10, 159, 213, 31);
		PanelImportaContatti.add(InserisciCitta);
		InserisciCitta.setColumns(10);
		
		InserisciSesso = new JTextField();
		InserisciSesso.setFont(new Font("Roboto", Font.PLAIN, 11));
		InserisciSesso.setColumns(10);
		InserisciSesso.setBounds(10, 212, 213, 31);
		PanelImportaContatti.add(InserisciSesso);
		
		InserisciData = new JTextField();
		InserisciData.setFont(new Font("Roboto", Font.PLAIN, 11));
		InserisciData.setColumns(10);
		InserisciData.setBounds(10, 267, 213, 31);
		PanelImportaContatti.add(InserisciData);
		
		JLabel lblCitta = new JLabel("Inserisci Citt\u00E0");
		lblCitta.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblCitta.setBounds(10, 144, 107, 14);
		PanelImportaContatti.add(lblCitta);
		
		JLabel lblsesso = new JLabel("Inserisci Sesso (M/F)");
		lblsesso.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblsesso.setBounds(10, 199, 171, 14);
		PanelImportaContatti.add(lblsesso);
		
		JLabel lblInsertdata = new JLabel("Inserisci Data di Nascita (yyyy/MM/dd)");
		lblInsertdata.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInsertdata.setBounds(10, 253, 213, 14);
		PanelImportaContatti.add(lblInsertdata);
		
		//Pulsante Cerca Contatti		
		JButton btnCercaContatti = new JButton("Cerca Contatti");
		btnCercaContatti.setBackground(Color.LIGHT_GRAY);
		btnCercaContatti.addActionListener(new ActionListener() {
			
			/**
			 * <h4> Action del pulsante "Cerca Contatti" </h4>
			 * <p> Se non inserisci la data nel carattere valido o lasci vuoto, Messaggio di Errore.
			 * 
			 */
			
			public void actionPerformed(ActionEvent arg0) {
							
				//Gestione della DATA
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				
				try {
					
					java.util.Date Date = null;
					
					if (!InserisciData.getText().isEmpty()) {
						
						Date = formatter.parse(InserisciData.getText());
						
					}
					
					contatti = GestioneCallCenterEIS.getInstance().cercaContatti(InserisciCitta.getText(), InserisciSesso.getText(), Date);
					
					table_ResVisualizza.setModel(DbUtils.resultSetToTableModel(contatti));
					
				} catch (ParseException e) {
					
					JOptionPane.showMessageDialog(null, "Errore nella conversione della data!");
					
				}

			}
		});
		btnCercaContatti.setBounds(10, 312, 133, 36);
		PanelImportaContatti.add(btnCercaContatti);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(234, 44, 984, 372);
		PanelImportaContatti.add(scrollPane_2);
		
		//Tabella Contatti
		table_contatti = new JTable();
		scrollPane_2.setViewportView(table_contatti);
		table_contatti.setBackground(SystemColor.window);
		table_contatti.setModel(new DefaultTableModel(
				new Object[][] {					
				},
				new String[] {
					"ID", "Nome", "Cognome", "Numero di telefono", "Citta'", "Sesso", "Data Di Nascita", "Indirizzo"
				}
		));
		table_contatti.setFont(new Font("Roboto", Font.PLAIN, 11));
		table_contatti.setBorder(new LineBorder(new Color(220, 20, 60), 0, true));
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOpaque(true);
		separator_2.setBackground(SystemColor.controlShadow);
		separator_2.setForeground(SystemColor.controlShadow);
		separator_2.setBounds(10, 324, 1208, 0);
		PanelImportaContatti.add(separator_2);
		
		JLabel lblContattiDaImportare = new JLabel("Contatti da importare nella lista da selezionare:");
		lblContattiDaImportare.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblContattiDaImportare.setBounds(10, 439, 333, 31);
		PanelImportaContatti.add(lblContattiDaImportare);
		
		JButton btnImportaNelDatabase = new JButton("Importa nella lista");
		btnImportaNelDatabase.setBackground(Color.LIGHT_GRAY);
		btnImportaNelDatabase.addActionListener(new ActionListener() {
			
			/**
			 * <h4> Action del pulsante "Importa nella lista" </h4>
			 * 
			 */
			
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					contatti.beforeFirst();
					
					int idlista = Integer.parseInt(comboBox.getSelectedItem().toString());
					
					GestioneCallCenterEIS.getInstance().importaContatti(contatti, idlista);
					
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null, "Attenzione ResultSet non resettato!");
					
				}
				
			}
		});
		btnImportaNelDatabase.setBounds(962, 692, 256, 36);
		PanelImportaContatti.add(btnImportaNelDatabase);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 481, 942, 200);
		PanelImportaContatti.add(scrollPane_3);
		
		//tabella dei Contatti della lista
		table_ResVisualizza = new JTable();
		scrollPane_3.setViewportView(table_ResVisualizza);
		table_ResVisualizza.setBackground(SystemColor.window);
		table_ResVisualizza.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Cognome", "Numero di Telefono", "Citta'", "Sesso", "Data di Nascita", "Indirizzo"
			}
		));
		table_ResVisualizza.setFont(new Font("Roboto", Font.PLAIN, 11));
		
		JTextPane txtpnCercaIContatti = new JTextPane();
		txtpnCercaIContatti.setFont(new Font("Roboto", Font.PLAIN, 11));
		txtpnCercaIContatti.setBackground(SystemColor.control);
		txtpnCercaIContatti.setText("Cerca i contatti nel database esterno\r\nPuoi filtrare per\r\n- Solo Citta'\r\n- Citta', Sesso e data di nascita\r\n- Solo per data di nascita\r\n");
		txtpnCercaIContatti.setBounds(10, 44, 213, 98);
		PanelImportaContatti.add(txtpnCercaIContatti);
		
		//comboBox delle liste contatti
		comboBox = new JComboBox<Integer>();
		comboBox.setFont(new Font("Roboto", Font.PLAIN, 11));
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setModel(new DefaultComboBoxModel<Integer>());
		comboBox.setBounds(1161, 444, 57, 22);
		PanelImportaContatti.add(comboBox);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(962, 481, 256, 200);
		PanelImportaContatti.add(scrollPane_5);
		
		//tabella associazione id e nome lista contatti
		table_lista_import = new JTable();
		table_lista_import.setFont(new Font("Roboto", Font.PLAIN, 11));
		scrollPane_5.setViewportView(table_lista_import);
		table_lista_import.setBackground(SystemColor.window);
		table_lista_import.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome Lista"
			}
		));
		
		JLabel lblNewLabel = new JLabel("Scegli ID associato al nome della lista");
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblNewLabel.setBounds(958, 448, 213, 14);
		PanelImportaContatti.add(lblNewLabel);
		
		JLabel lblDatabaseEsterno = new JLabel("Database Esterno");
		lblDatabaseEsterno.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblDatabaseEsterno.setBounds(1085, 11, 133, 31);
		PanelImportaContatti.add(lblDatabaseEsterno);
		
		PanelCreaListaContatti = new JPanel();
		PanelCreaListaContatti.setBorder(new LineBorder(new Color(220, 20, 60), 1, true));
		PanelCreaListaContatti.setBounds(0, 0, 1228, 739);
		layeredPane.add(PanelCreaListaContatti);
		PanelCreaListaContatti.setLayout(null);
		
		/*
		 * Fine pannello importa Contatti
		 */
		
		
		
		/*
		 * Pannello Crea Lista contatti
		 */
		JLabel lblCreaListaContatti = new JLabel("Crea Lista Contatti");
		lblCreaListaContatti.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblCreaListaContatti.setBounds(10, 12, 177, 14);
		PanelCreaListaContatti.add(lblCreaListaContatti);
		
		NomeLista = new JTextField();
		NomeLista.setBounds(10, 94, 201, 31);
		PanelCreaListaContatti.add(NomeLista);
		NomeLista.setColumns(10);
		
		DescrizioneLista = new JTextField();
		DescrizioneLista.setColumns(10);
		DescrizioneLista.setBounds(10, 156, 201, 31);
		PanelCreaListaContatti.add(DescrizioneLista);
		
		JLabel lblInserisciNomeLista = new JLabel("Inserisci il Nome della lista contatti");
		lblInserisciNomeLista.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInserisciNomeLista.setBounds(10, 69, 177, 14);
		PanelCreaListaContatti.add(lblInserisciNomeLista);
		
		JLabel lblInserisciDescrizioneDellalista = new JLabel("Inserisci Descrizione Lista Contatti");
		lblInserisciDescrizioneDellalista.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInserisciDescrizioneDellalista.setBounds(10, 136, 177, 14);
		PanelCreaListaContatti.add(lblInserisciDescrizioneDellalista);
		
		JButton btnCreaLista = new JButton("Crea lista");
		btnCreaLista.setBackground(Color.LIGHT_GRAY);
		btnCreaLista.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnCreaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/**
				 * <h4> Action del pulsante "Crea Lista" </h4>
				 * <p> L'amministratore crea la lista contatti per i centralinisti </p>
				 * 
				 */
			
				//verifico se vengono passati i parametri nei TextField
				if(NomeLista.getText().isEmpty() || DescrizioneLista.getText().isEmpty()) 
				{
					JOptionPane.showMessageDialog(null, "Inserisci tutti i campi!");
				}
				else 
				{
					ListaContatti listacontatti = new ListaContatti(NomeLista.getText(), DescrizioneLista.getText());
					GestioneCallCenterEIS.getInstance().creaListaContatti(listacontatti);				
					DefaultTableModel model = (DefaultTableModel) table_Liste.getModel();
					model.addRow(new Object [] {NomeLista.getText(), DescrizioneLista.getText()});
				}
		  }
		});
		btnCreaLista.setBounds(10, 211, 89, 37);
		PanelCreaListaContatti.add(btnCreaLista);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		scrollPane_1.setBounds(221, 12, 997, 716);
		PanelCreaListaContatti.add(scrollPane_1);
		
		//Tabella delle liste create
		table_Liste = new JTable();
		table_Liste.setBackground(SystemColor.window);
		scrollPane_1.setViewportView(table_Liste);
		table_Liste.setBorder(new LineBorder(new Color(220, 20, 60), 0));
		table_Liste.setForeground(Color.BLACK);
		table_Liste.setFont(new Font("Roboto", Font.PLAIN, 12));
		table_Liste.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome Lista", "Descrizione Lista"
			}
		));
		table_Liste.getColumnModel().getColumn(0).setMinWidth(20);
		table_Liste.getColumnModel().getColumn(1).setMinWidth(20);
		
		/*
		 * Fine Pannello Crea Lista Contatti
		 */
		
		
		
		/*
		 * Inizio Pannello VisualizzaContatti
		 * 
		 */
		PanelVisualizzaContatti = new JPanel();
		PanelVisualizzaContatti.setBorder(new LineBorder(new Color(220, 20, 60)));
		PanelVisualizzaContatti.setBounds(0, 0, 1228, 739);
		layeredPane.add(PanelVisualizzaContatti);
		PanelVisualizzaContatti.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Visualizza Lista Contatti");
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 11, 193, 14);
		PanelVisualizzaContatti.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Inserisci la lista contatti da visualizzare");
		lblNewLabel_1_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(10, 51, 210, 14);
		PanelVisualizzaContatti.add(lblNewLabel_1_1);
		
		insnomelista = new JTextField();
		insnomelista.setBounds(10, 76, 199, 30);
		PanelVisualizzaContatti.add(insnomelista);
		insnomelista.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		scrollPane.setBounds(10, 304, 1208, 424);
		PanelVisualizzaContatti.add(scrollPane);
		
		//tabella Contatti da visualizzare
		table_VisualizzaContatti = new JTable();
		table_VisualizzaContatti.setBackground(SystemColor.window);
		scrollPane.setViewportView(table_VisualizzaContatti);
		table_VisualizzaContatti.setFont(new Font("Roboto", Font.PLAIN, 11));
		table_VisualizzaContatti.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Cognome", "Numero di telefono", "Citta'", "Sesso", "Data di Nascita", "Indirizzo"
			}
		));
		table_VisualizzaContatti.getColumnModel().getColumn(6).setPreferredWidth(98);
		table_VisualizzaContatti.setBorder(new LineBorder(SystemColor.controlHighlight, 0, true));
		
		
		JButton btnVisualizzaLaLista = new JButton("Visualizza la lista");
		btnVisualizzaLaLista.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnVisualizzaLaLista.setBackground(Color.LIGHT_GRAY);
		btnVisualizzaLaLista.addActionListener(new ActionListener() {
			
			/**
			 * <h4> Action del pulsante "Visualizza la lista" </h4>
			 * <p> Visualizzazione dei contatti nella lista indicata nel text field </p>
			 */
			
			public void actionPerformed(ActionEvent arg0) {
				
				ResultSet rs = null;
				
				int idlista = Integer.parseInt(insnomelista.getText());
				
				rs = GestioneCallCenterEIS.getInstance().visualizzaContatto(idlista);
				
				table_VisualizzaContatti.setModel(DbUtils.resultSetToTableModel(rs));
				
			}
		});
		btnVisualizzaLaLista.setBounds(10, 118, 127, 36);
		PanelVisualizzaContatti.add(btnVisualizzaLaLista);
		
		JLabel lblNewLabel_1_2 = new JLabel("Contatti della lista contatti scelta");
		lblNewLabel_1_2.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 279, 384, 14);
		PanelVisualizzaContatti.add(lblNewLabel_1_2);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(247, 12, 971, 247);
		PanelVisualizzaContatti.add(scrollPane_4);
		
		//tabella delle liste
		table_visual_liste = new JTable();
		table_visual_liste.setBackground(SystemColor.window);
		scrollPane_4.setViewportView(table_visual_liste);
		table_visual_liste.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome Lista", "Descrizione Lista"
			}
		));
		
		/*
		 * Pannello Home di Benvenuto
		 */
		JPanel panel_Home = new JPanel();
		layeredPane.setLayer(panel_Home, 1);
		panel_Home.setBounds(0, 0, 1228, 739);
		layeredPane.add(panel_Home);
		panel_Home.setLayout(null);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(317, 489, 595, 2);
		panel_Home.add(separator_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("BENVENUTO AMMINISTRATORE");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 40));
		lblNewLabel_3.setBounds(10, 252, 1208, 53);
		panel_Home.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel(nome);
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
		txtrPuoiCreare.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtrPuoiCreare.setBackground(SystemColor.control);
		txtrPuoiCreare.setText("Puoi:\r\n- Creare una lista contatti per i Centralinisti\r\n- Importare i Contatti nelle liste contatti create\r\n- Visualizzare i Contatti in una delle liste create\"\r\n\r\nImplementazioni future\r\n- Assegnare lista contatti ai centralinisiti\r\n- Visualizza lo stato dei centralinisti");
		txtrPuoiCreare.setBounds(317, 342, 587, 136);
		panel_Home.add(txtrPuoiCreare);
		
		/*
		 * Fine pannello Home
		 */
		
		/*
		 * Pannello Menu
		 */
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 200, 761);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAmministratore = new JLabel("Amministratore");
		lblAmministratore.setFont(new Font("Roboto", Font.BOLD, 15));
		lblAmministratore.setBounds(10, 11, 180, 36);
		panel.add(lblAmministratore);
		
		//pulsante Crea lista contatti
		JButton btnCreaListaContatti = new JButton("Crea Lista Contatti");
		btnCreaListaContatti.setBackground(Color.LIGHT_GRAY);
		btnCreaListaContatti.setForeground(UIManager.getColor("controlHighlightt"));
		btnCreaListaContatti.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnCreaListaContatti.addActionListener(new ActionListener() {
			
			/**
			 * <h4> Action del pulsante "Crea Lista Contatti" </h4>
			 */
			
			public void actionPerformed(ActionEvent arg0) {

				//switch del panel
				switch_screen(PanelCreaListaContatti);
				
				Connection conn;
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iocaller", "root", "");
					Statement st = conn.createStatement();
					
					ResultSet rs = st.executeQuery("SELECT NomeLista, DescrizioneLista FROM listacontatti");
					table_Liste.setModel(DbUtils.resultSetToTableModel(rs));
					
					st.close();
					
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null, "Errore di connessione al DB!");
					
				}
				
				
			}
		});
		btnCreaListaContatti.setBounds(10, 92, 180, 36);
		panel.add(btnCreaListaContatti);
		
		//pulsante GestioneCentralinisti (IMPLEMENTAZIONE FUTURA)
		JButton btnGestioneCentralinisti = new JButton("Gestione Centralinisti");
		btnGestioneCentralinisti.setBackground(Color.LIGHT_GRAY);
		btnGestioneCentralinisti.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnGestioneCentralinisti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGestioneCentralinisti.setBounds(10, 607, 180, 36);
		panel.add(btnGestioneCentralinisti);
		
		//pulsante Visualizza stato centralinisti (IMPLEMENTAZIONE FUTURA)
		JButton lblVisualizzaStatoCentralinisti = new JButton("Visualizza stato dei Centralinisti");
		lblVisualizzaStatoCentralinisti.setBackground(Color.LIGHT_GRAY);
		lblVisualizzaStatoCentralinisti.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblVisualizzaStatoCentralinisti.setBounds(10, 654, 180, 36);
		panel.add(lblVisualizzaStatoCentralinisti);
		
		//pulsante LOGOUT
		JButton btnGestioneListaContatti_2_1 = new JButton("Logout");
		btnGestioneListaContatti_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//LOGOUT
				int confirm = GestioneCallCenterEIS.getInstance().logout();
	            // JOptionPane.setRootFrame(null);
	            if (confirm == JOptionPane.YES_OPTION) {
	            	
	            	ApplicationConsoleBoundary a = new ApplicationConsoleBoundary();
					a.setVisible(true);
					dispose();
					
	            }
				
			}
		});
		btnGestioneListaContatti_2_1.setBackground(Color.LIGHT_GRAY);
		btnGestioneListaContatti_2_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnGestioneListaContatti_2_1.setBounds(10, 714, 80, 36);
		panel.add(btnGestioneListaContatti_2_1);
		
		//pulsante ImportaContatti
		JButton btnImportaContatti = new JButton("Importa contatti");
		btnImportaContatti.setBackground(Color.LIGHT_GRAY);
		btnImportaContatti.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnImportaContatti.addActionListener(new ActionListener() {
			
			/**
			 * <h4> Action del pulsante "Importa Contatti" </h4>
			 */
			public void actionPerformed(ActionEvent arg0) {
				
				//switch_screen e' utile per passare da un pannello all'altro
				switch_screen(PanelImportaContatti);
							
				//connessione al database esterno
				Connection conn1;
				Connection conn;
				try {
					conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/databanks", "root", "");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iocaller", "root", "");
					Statement st = conn1.createStatement();
					Statement st2 = conn.createStatement();
					
					ResultSet rst = st.executeQuery("SELECT `ID`, `Nome`, `Cognome`, `NumeroDiTelefono`, `Citta`, `Sesso`, `DataDiNascita`, `Indirizzo` FROM `contatto`");
					ResultSet rs2 = st2.executeQuery("SELECT ID, 'NomeLista' FROM listacontatti");
					
					while (rs2.next()) {
						
						int idlista = rs2.getInt("ID");
						
						comboBox.addItem(idlista);	

					}
					
					table_contatti.setModel(DbUtils.resultSetToTableModel(rst));
					
					
					
					st.close();
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Errore di connessione al DB!");
				}
				
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iocaller", "root", "");
					Statement st = conn.createStatement();
					
					ResultSet rs = st.executeQuery("SELECT ID, NomeLista FROM listacontatti");
					table_lista_import.setModel(DbUtils.resultSetToTableModel(rs));
					
					st.close();
					
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null, "Errore di connessione al DB!");
					
				}
				
				

			}
		});
		btnImportaContatti.setBounds(10, 139, 180, 36);
		panel.add(btnImportaContatti);
		
		//pulsante VisualizzaContatti
		JButton btnVisualizzaContatti = new JButton("Visualizza contatti");
		btnVisualizzaContatti.setBackground(Color.LIGHT_GRAY);
		btnVisualizzaContatti.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnVisualizzaContatti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/**
				 * <h4> Action del pulsante "Visualizza Contatti" </h4>
				 */
				switch_screen(PanelVisualizzaContatti);
				
				try {
					Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/iocaller", "root", "");
					Statement st = conn1.createStatement();
					
					
					ResultSet rst = st.executeQuery("SELECT * FROM `listacontatti`");
					table_visual_liste.setModel(DbUtils.resultSetToTableModel(rst));
					
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Errore di connessione al DB!");
				}
				
			}
		});
		btnVisualizzaContatti.setBounds(10, 186, 180, 36);
		panel.add(btnVisualizzaContatti);
		
		JLabel lblInfo = new JLabel("Altre possibili funzioni future");
		lblInfo.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInfo.setBounds(10, 582, 148, 14);
		panel.add(lblInfo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 701, 180, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 78, 180, 2);
		panel.add(separator_1);
		
		JLabel lblNomeAmministratore = new JLabel("Nome: ");
		lblNomeAmministratore.setBounds(10, 43, 46, 14);
		panel.add(lblNomeAmministratore);
		
		JLabel lblNewLabel_2 = new JLabel(nome);
		lblNewLabel_2.setBounds(51, 43, 139, 15);
		panel.add(lblNewLabel_2);
				
		JLabel lblLogoPanelLista = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/minilogo.png"));
		lblLogoPanelLista.setIcon(img);
		lblLogoPanelLista.setBounds(25, 501, 150, 56);
		panel.add(lblLogoPanelLista);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 569, 180, 2);
		panel.add(separator_4);
		/*
		 * Fine Menu
		 */
		
		
	}
	
	/**
	 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	 * <br>Fine frame login
	 */
	
	//Piccola funzione per il passaggio da un frame all'altro
	public void switch_screen(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
}
