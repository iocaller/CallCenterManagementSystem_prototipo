package CallCenterManagement.Boundary;

import CallCenterManagement.Controller.GestioneCallCenterEIS;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.SwingConstants;


/**
 * <h2>Application Console - IOCaller</h2>
 * <hr>
 * <p><b>Autenticazione di accesso nelle sezioni di:</b></p>
 * <ul>
 * <li>Gestione Amministratore (Admin di Sistema)</li>
 * <li>Gestione Lista Contatti (Amministratore)</li>
 * <li>Gestione Appuntamenti (Centralinista)</li>
 * <li>Gestione Agente di Vendita (Agente di Vendita)</li>
 * </ul>
 * <p>Implementazione dell'interfaccia grafica con WindowsBuilder</p>
 *
 * 
 *
 * @author Antonio Romano
 * @author Giuseppe Riccio
 * @author Salvatore Pernice
 * @author Giovanni Scognamiglio
 * 
 * @version 1.26
 */

public class ApplicationConsoleBoundary extends JFrame {

	/**
	 * JElement del frame
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Email;
	private JPasswordField Pass;
	private JLabel InsertPassword;
	private JComboBox<String> comboBox;

	/**
	 * Lancio dell'applicazione.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
					ApplicationConsoleBoundary frame = new ApplicationConsoleBoundary();
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
	public ApplicationConsoleBoundary() {
		
		/**
		 * Contorno finestra di Sistema
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 486);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		/**
		 * Frame di Login
		 *  
		 */
		Email = new JTextField();
		Email.setFont(new Font("Roboto", Font.PLAIN, 11));
		Email.setBounds(261, 167, 227, 26);
		contentPane.add(Email);
		Email.setColumns(10);
		
		Pass = new JPasswordField();
		Pass.setFont(new Font("Roboto", Font.PLAIN, 11));
		Pass.setBounds(261, 204, 227, 26);
		contentPane.add(Pass);
		Pass.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Inserisci Email (Username se sei Admin");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNewLabel.setBounds(53, 171, 183, 14);
		contentPane.add(lblNewLabel);
		
		InsertPassword = new JLabel("Inserisci Password");
		InsertPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		InsertPassword.setFont(new Font("Roboto", Font.PLAIN, 14));
		InsertPassword.setBounds(53, 209, 183, 14);
		contentPane.add(InsertPassword);
		
		JLabel lblNewLabel_2 = new JLabel("Chi sei?");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(165, 251, 71, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("LOGIN / REGISTER");
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 20));
		lblNewLabel_3.setBounds(261, 113, 227, 59);
		contentPane.add(lblNewLabel_3);
		
		comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setFont(new Font("Roboto", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"amministratore", "centralinista", "agentedivendita", "admindisistema"}));
		comboBox.setBounds(261, 246, 227, 26);
		contentPane.add(comboBox);
		
		//Pulsante di Login
		final JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Roboto", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			
			/**
			 * <h4> Action del pulsante "Login" </h4>
			 * <p> Se nella combobox inserisci Amministratore, Centralinista, Agente di Vendita puoi fare l'accesso mediante Email e Password
			 * e non puoi registrarti nel sistema.
			 * <br>Se nella combobox inserisci Admin di Sistema allora oltre alla Login puoi anche fare la Registrazione al sistema.
			 * 
			 */
			@SuppressWarnings("deprecation")
			
			public void actionPerformed(ActionEvent arg0) {
				
				String ruolo = (String) comboBox.getSelectedItem();
				
				if (ruolo.isEmpty() || Email.getText().isEmpty() || Pass.getText().isEmpty()) {
					
					JOptionPane.showMessageDialog(null, "Inserisci tutti i campi!");
					
				} else {
					
					int loggato = GestioneCallCenterEIS.getInstance().login(ruolo,Email.getText(),Pass.getText());
					
					if(ruolo =="amministratore" && loggato == 1) {
						
						ListaContattiConsoleBoundary lc = new ListaContattiConsoleBoundary(Email.getText());
						lc.setVisible(true);
						dispose();
						
					} else if(ruolo =="admindisistema" && loggato == 1) {
						
						AdminConsoleBoundary lc = new AdminConsoleBoundary(Email.getText());
						lc.setVisible(true);
						dispose();
						
					} else if(ruolo =="centralinista" && loggato == 1) {
						
						AppuntamentoConsoleBoundary lc = new AppuntamentoConsoleBoundary(Email.getText());
						lc.setVisible(true);
						dispose();
						
					} else if(ruolo =="agentedivendita" && loggato == 1) {
						
						AgentediVenditaConsoleBoundary lc = new AgentediVenditaConsoleBoundary(Email.getText());
						lc.setVisible(true);
						dispose();
						
					}
					
				}
				
            }	
		});
		
		btnNewButton.setBounds(261, 298, 89, 38);
		contentPane.add(btnNewButton);

		//Pulsante di Register
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			
			/**
			 * <h4>Registrazione dell'Admin di Sistema</h4>
			 * <p>Se ha inserito tutti i campi fai la registrazione altrimenti NO.</p>
			 */
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if (comboBox.getSelectedItem() == "admindisistema") 
				{
					if(Email.getText().isEmpty() || Pass.getText().isEmpty()) 
					{
						JOptionPane.showMessageDialog(null, "Inserisci tutti i campi!");
					}
					else 
					{
						GestioneCallCenterEIS.getInstance().registration(Email.getText(),Pass.getText());
					}					
				} 
				else 
				{
					JOptionPane.showMessageDialog(null, "Non sei un Admin di Sistema non puoi registrarti!");
				}
			}
			
		});
		
		btnNewButton_1.setBounds(561, 407, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Sei un Admin di Sistema e non sei ancora registrato? ");
		lblNewLabel_4.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(271, 416, 290, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblLOGO = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/loginlogo.png"));
		lblLOGO.setIcon(img);
		lblLOGO.setBounds(233, 12, 250, 94);
		contentPane.add(lblLOGO);
		
	}
	
	/**
	 * :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
	 * <br>Fine frame login
	 */
}
