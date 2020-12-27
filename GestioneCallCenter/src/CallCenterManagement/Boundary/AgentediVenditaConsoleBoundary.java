package CallCenterManagement.Boundary;

import CallCenterManagement.Controller.GestioneCallCenterEIS;
import CallCenterManagement.Entity.Appuntamento;
import net.proteanit.sql.DbUtils;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

/**
 * <h2>Agente di Vendita Console - IOCaller</h2>
 * <hr>
 * <p><b>Visualizzazione del resoconto appuntamento da parte dell'agente di vendita</b></p>
 * <p>Implementazione dell'interfaccia grafica con WindowsBuilder</p>
 *
 */

public class AgentediVenditaConsoleBoundary extends JFrame {

	/**
	 * JElement Agente di Vendita
	 */
	private static final long serialVersionUID = 1L;
	
	//pannelli
	private JPanel contentPane;
	private JPanel PanelAgentediVendita;
	
	//layer
	private JLayeredPane layeredPane;

	//tabella
	private JTable table;
	
	//campo testo
	private JTextField InserisciIDapprifiutato;


	/**
	 * Lancio Applicazione.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
					AgentediVenditaConsoleBoundary frame = new AgentediVenditaConsoleBoundary(null);
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
	public AgentediVenditaConsoleBoundary(final String nome) {
		
		//Barra di sistema
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1468, 804);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		/*
		 * Pannello Menu
		 */
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 200, 765);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAgente = new JLabel("Agente di Vendita");
		lblAgente.setFont(new Font("Roboto", Font.BOLD, 15));
		lblAgente.setBounds(10, 11, 180, 36);
		panel.add(lblAgente);
		
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
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 705, 180, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 78, 180, 2);
		panel.add(separator_1);
		
		JLabel lblNomeAgentediVendita = new JLabel("Nome: ");
		lblNomeAgentediVendita.setBounds(10, 43, 46, 14);
		panel.add(lblNomeAgentediVendita);
		
		JLabel lblNomeLogin = new JLabel(nome);
		lblNomeLogin.setBounds(51, 43, 139, 15);
		panel.add(lblNomeLogin);
		
		JButton btnVisualizza = new JButton("Visualizza Appuntamenti");
		btnVisualizza.setBackground(Color.LIGHT_GRAY);
		btnVisualizza.setFont(new Font("Roboto", Font.PLAIN, 11));
		btnVisualizza.addActionListener(new ActionListener() {
			
			/**
			 * <h4> Action del pulsante "Visualizza Appuntamenti" </h4>
			 */
			public void actionPerformed(ActionEvent arg0) {
				
				switch_screen(PanelAgentediVendita);
				
				Connection conn;
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iocaller", "root", "");
					Statement st = conn.createStatement();
					
					ResultSet rs = st.executeQuery("SELECT * FROM appuntamento WHERE IDAgente = (SELECT ID FROM agentedivendita WHERE Email = '"+ nome +" ')");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					st.close();
					
				} catch (SQLException e) {
					
					JOptionPane.showMessageDialog(null, "Errore di connessione al DB!");
					
				}
				
			}
		});
		btnVisualizza.setBounds(10, 91, 180, 36);
		panel.add(btnVisualizza);
		
		JLabel lblLogoPanelAgente = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/minilogo.png"));
		lblLogoPanelAgente.setIcon(img);
		lblLogoPanelAgente.setBounds(25, 637, 150, 56);
		panel.add(lblLogoPanelAgente);
		
		/*
		 * Fine Pannello 
		 */
				
		layeredPane = new JLayeredPane();
		layeredPane.setBorder(new LineBorder(new Color(220, 20, 60), 2));
		layeredPane.setBounds(210, 11, 1232, 743);
		contentPane.add(layeredPane);
		
		PanelAgentediVendita = new JPanel();
		PanelAgentediVendita.setLayout(null);
		PanelAgentediVendita.setBorder(new LineBorder(new Color(220, 20, 60)));
		PanelAgentediVendita.setBounds(0, 0, 1231, 743);
		layeredPane.add(PanelAgentediVendita);
		
		JLabel lbIVisualizzaAppuntamento = new JLabel("Visualizza Appuntamenti");
		lbIVisualizzaAppuntamento.setFont(new Font("Roboto", Font.PLAIN, 15));
		lbIVisualizzaAppuntamento.setBounds(10, 11, 215, 31);
		PanelAgentediVendita.add(lbIVisualizzaAppuntamento);
		
		JButton btnRifiuta = new JButton("Rifiuta Appuntamento");
		btnRifiuta.setFont(new Font("Dialog", Font.BOLD, 11));
		btnRifiuta.setBackground(Color.LIGHT_GRAY);
		btnRifiuta.addActionListener(new ActionListener() {
			
			/**
			 * <h4> Action del pulsante "Rifiuta Appuntamento" </h4>
			 */
			
			public void actionPerformed(ActionEvent arg0) {
								
				int id = Integer.parseInt(InserisciIDapprifiutato.getText());
				
				Appuntamento a = GestioneCallCenterEIS.getInstance().visualizzaAppuntamento(id);
				
				a.print(a);
				
				GestioneCallCenterEIS.getInstance().rifiutaAppuntamento(a);
				
			}
		});
		btnRifiuta.setBounds(1064, 696, 157, 36);
		PanelAgentediVendita.add(btnRifiuta);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 1211, 598);
		PanelAgentediVendita.add(scrollPane);
		
		table = new JTable();
		table.setBackground(SystemColor.window);
		table.setFont(new Font("Roboto", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "NomeAppuntamento", "Data", "Ora", "Note", "IDappuntamentofallito", "IDAgente"
				}
			));
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(220, 20, 60), 2, true));
		
		InserisciIDapprifiutato = new JTextField();
		InserisciIDapprifiutato.setFont(new Font("Roboto", Font.PLAIN, 11));
		InserisciIDapprifiutato.setColumns(10);
		InserisciIDapprifiutato.setBounds(857, 696, 202, 36);
		PanelAgentediVendita.add(InserisciIDapprifiutato);
		
		JLabel lblInsertIDAppuntamentoRifiutato = new JLabel("Inserisci ID dell'appuntamento che vuoi rifiutare");
		lblInsertIDAppuntamentoRifiutato.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblInsertIDAppuntamentoRifiutato.setBounds(857, 670, 321, 14);
		PanelAgentediVendita.add(lblInsertIDAppuntamentoRifiutato);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(855, 689, 366, 2);
		PanelAgentediVendita.add(separator_2_1);
		
		JPanel panel_Home = new JPanel();
		layeredPane.setLayer(panel_Home, 1);
		panel_Home.setLayout(null);
		panel_Home.setBounds(0, 0, 1231, 743);
		layeredPane.add(panel_Home);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(317, 393, 595, 2);
		panel_Home.add(separator_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("BENVENUTO AGENTE DI VENDITA");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 40));
		lblNewLabel_3.setBounds(10, 252, 1208, 53);
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
		
		JTextArea txtrPuoiVisualizzare = new JTextArea();
		txtrPuoiVisualizzare.setText("Puoi:\r\n- Visualizzare i tuoi appuntamenti\r\n- Rimuovere i tuoi appuntamenti");
		txtrPuoiVisualizzare.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtrPuoiVisualizzare.setBackground(SystemColor.control);
		txtrPuoiVisualizzare.setBounds(317, 342, 587, 53);
		panel_Home.add(txtrPuoiVisualizzare);
		
		
	}
	
	/**
	 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	 * <br>Fine frame login
	 */
	
	//Piccola funzione per il passaggio da un panel all'altro
		public void switch_screen(JPanel panel) {
			layeredPane.removeAll();
			layeredPane.add(panel);
			layeredPane.repaint();
			layeredPane.revalidate();
		}
	
}
