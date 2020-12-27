package CallCenterManagement.Entity;

/**
* Implementazione Entità dell'Agente di Vendita
**
*/

public class AgentediVendita {
	
	/**
	* Costruttore dell'Agente di Vendita
	* @param nome dell'Agente di Vendita
	* @param cognome dell'Agente di Vendita
	* @param numeroDiTelefono dell'Agente di Vendita
	* @param email dell'Agente di Vendita
	* @param password dell'Agente di Vendita
	* @param competenze dell'Agente di Vendita
	* 
	* 
	* <br><br>Metodi dell'Agente di Vendita
	* <hr>
	* <ul>
	* <li>getID()</li>
	* <li>setID()</li>
	* <li>getNome()</li>
	* <li>setNome()</li>
	* <li>getCognome()</li>
	* <li>setCognome()</li>
	* <li>getNumeroDiTelefono()</li>
	* <li>setNumeroDiTelefono()</li>
	* <li>getEmail()</li>
	* <li>setEmail()</li>
	* <li>getPassword()</li>
	* <li>setPassword()</li>
	* <li>getCompetenze()</li>
	* <li>setCompetenze()</li>
	* <li>print()</li>
	* </ul>
	*/

	public AgentediVendita(String nome, String cognome, String numeroDiTelefono,	//Costruttore 
			String email, String password, String competenze) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.numeroDiTelefono = numeroDiTelefono;
		this.email = email;
		this.password = password;
		this.competenze = competenze;
	}
	
	/**
	* Costruttore di copia dell'Agente di Vendita
	* @param a Oggetto dell' Agente di Vendita
	*/
	public AgentediVendita(AgentediVendita a) {										//Costruttore di copia
		this(a.nome, a.cognome, a.numeroDiTelefono, 								//Richiamo il costruttore
				a.email, a.password, a.competenze);				
	}

	public int getID() {															//Restituisce l'id dell'Agente di Vendita
		return ID;
	}
	
	public void setID(int iD) {														//Modifica l'id dell'Agente di Vendita
		this.ID = iD;
	}
	
	public String getNome() {														//Restituisce il nome dell'Agente di Vendita
		return nome;
	}
	
	public void setNome(String nome) {												//Modifica il nome dell'Agente di Vendita
		this.nome = nome;
	}
	
	public String getCognome() {													//Restituisce il cognome dell'Agente di Vendita
		return cognome;
	}
	
	public void setCognome(String cognome) {										//Modifica il cognome dell'Agente di Vendita
		this.cognome = cognome;
	}
	
	public String getNumeroDiTelefono() {											//Restituisce il numero dell'Agente di Vendita
		return numeroDiTelefono;
	}
	
	public void setNumeroDiTelefono(String numeroDiTelefono) {						//Modifica il numero dell'Agente di Vendita
		this.numeroDiTelefono = numeroDiTelefono;
	}
	
	public String getEmail() {														//Restituisce l'email dell'Agente di Vendita
		return email;
	}
	
	public void setEmail(String email) {											//Modifica l'email dell'Agente di Vendita
		this.email = email;
	}
	
	public String getCompetenze() {													//Restituisce le competenze dell'Agente di Vendita
		return competenze;
	}
	
	public void setCompetenze(String competenze) {									//Modifica le competenze dell'Agente di Vendita
		this.competenze = competenze;
	}
	
	public String getPassword() {													//Restituisce la password dell'Agente di Vendita
		return password;
	}
	
	public void setPassword(String password) {										//Modifica la password dell'Agente di Vendita
		this.password = password;
	}
	
	public void print(AgentediVendita a) {											//Stampa i dati dell'Agente di Vendita
		System.out.println("Agente di Vendita\n ID : "+ a.ID +"\nNome : "+ a.nome +"\nCognome : "+ a.cognome +
				"\nNumero di Telefono : "+ a.numeroDiTelefono +"\nEmail : "+ a.email +"\nCompetenze: "+ a.competenze);			
	}
	
	/*
	 * Funzione di hash autogenerata
	 */
	@Override
	public int hashCode() {															
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((competenze == null) ? 0 : competenze.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroDiTelefono == null) ? 0 : numeroDiTelefono.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	/**
	 * Comparazione dell'Agente di Vendita
	 * <p>- Gli Agenti di Vendita sono uguali se hanno lo stesso id</p>
	 * @param obj Oggetto dell'Agente di Vendita
	 *
	 */
	@Override
	public boolean equals(Object obj) {	
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgentediVendita other = (AgentediVendita) obj;
		if (ID != other.ID)
			return false;
		return true;
	}

	private int ID;
	private String nome;
	private String cognome;
	private String numeroDiTelefono;
	private String email;
	private String password;
	private String competenze;

}