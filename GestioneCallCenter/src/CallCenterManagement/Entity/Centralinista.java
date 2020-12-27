package CallCenterManagement.Entity;



import java.util.Date;
/**
* Implementazione Entità del Centralinista
**
*/

public class Centralinista {
	
	/**
	* Costruttore del Centralinista
	* @param nome del Centralinista
	* @param cognome del Centralinista 
	* @param dataDiNascita del Centralinista
	* @param residenza del Centralinista
	* @param indirizzo del Centralinista
	* @param numeroDiTelefono del Centralinista
	* @param email del Centralinista
	* @param password del Centralinista
	* @param competenze del Centralinista
	* @param qualifica del Centralinista
	* @param stato del Centralinista
	*
	*
	*<br><br> Metodi del Centralinista
	* <hr>
	* <ul>
	* <li>getID()</li>
	* <li>setID()</li>
	* <li>getNome()</li>
	* <li>setNome()</li>
	* <li>getCognome()</li>
	* <li>setCognome()</li>
	* <li>getdataDiNascita()</li>
	* <li>setdataDiNascita()</li>
	* <li>getResidenza()</li>
	* <li>setResidenza()</li>
    * <li>getIndirizzo()</li>
	* <li>setIndirizzo()</li>
	* <li>getNumeroDiTelefono()</li>
	* <li>setNumeroDiTelefono()</li>
	* <li>getEmail()</li>
	* <li>setEmail()</li>
	* <li>getPassword()</li>
	* <li>setPassword()</li>
	* <li>getCompetenze()</li>
	* <li>setCompetenze()</li>
	* <li>getQualifica()</li>
	* <li>setQualifica()</li>
	* <li>getStato()</li>
	* <li>setStato()</li>
	* <li>print()</li>
	* </ul>
	*/

	public Centralinista(String nome, String cognome, Date dataDiNascita,		//Costruttore
			String residenza, String indirizzo, String numeroDiTelefono, String email, String password, 
			String competenze, String qualifica, String stato) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.residenza = residenza;
		this.indirizzo = indirizzo;
		this.numeroDiTelefono = numeroDiTelefono;
		this.email = email;
		this.password = password;
		this.competenze = competenze;
		this.qualifica = qualifica;
		this.stato = stato;
	}
	
	/**
	*
	* Costruttore di copia del Centralinista
	* @param c Oggetto del Centralinista
	*/
	
	public Centralinista(Centralinista c) {										//Costruttore di copia
		this(c.nome, c.cognome, c.dataDiNascita, c.residenza, c.indirizzo,		//Richiamo il costruttore
			c.numeroDiTelefono, c.email, c.password, c.competenze, c.qualifica, c.stato);				
	}
	
	public int getID() {														//Restituisce l'id del Centralinista
		return ID;
	}
	
	public void setID(int iD) {													//Modifica l'id del Centralinista
		this.ID = iD;
	}
	
	public String getNome() {													//Restituisce il nome del Centralinista
		return nome;
	}
	
	public void setNome(String nome) {											//Modifica il nome del Centralinista
		this.nome = nome;
	}
	
	public String getCognome() {												//Restituisce il cognome del Centralinista
		return cognome;
	}
	
	public void setCognome(String cognome) {									//Modifica il cognome del Centralinista
		this.cognome = cognome;
	}
	
	public Date getDataDiNascita() {											//Restituisce la data di nascita del Centralinista
		return dataDiNascita;
	}
	
	public void setDataDiNascita(Date dataDiNascita) {							//Modifica la data di nascita del Centralinista
		this.dataDiNascita = dataDiNascita;
	}
	
	public String getResidenza() {												//Restituisce la residenza del Centralinista
		return residenza;
	}
	
	public void setResidenza(String residenza) {								//Modifica la residenza del Centralinista
		this.residenza = residenza;
	}
	
	public String getIndirizzo() {												//Restituisce l'indirizzo del Centralinista
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {								//Modifica l'indirizzo del Centralinista
		this.indirizzo = indirizzo;
	}
	
	public String getNumeroDiTelefono() {										//Restituisce il numero del Centralinista
		return numeroDiTelefono;
	}
	
	public void setNumeroDiTelefono(String numeroDiTelefono) {					//Modifica il numero del Centralinista
		this.numeroDiTelefono = numeroDiTelefono;
	}
	
	public String getEmail() {													//Restituisce l'email del Centralinista
		return email;
	}
	
	public void setEmail(String email) {										//Modifica l'email del Centralinista
		this.email = email;
	}
	
	public String getPassword() {												//Restituisce la password del Centralinista
		return password;
	}
	
	public void setPassword(String password) {									//Modifica la password del Centralinista
		this.password = password;
	}
	
	public String getCompetenze() {												//Restituisce le competenze del Centralinista
		return competenze;
	}
	
	public void setCompetenze(String competenze) {								//Modifica le competenze del Centralinista
		this.competenze = competenze;
	}
	
	public String getQualifica() {												//Restituisce la qualifica del Centralinista
		return qualifica;
	}
	
	public void setQualifica(String qualifica) {								//Modifica la qualifica del Centralinista
		this.qualifica = qualifica;
	}
	
	public String getStato() {													//Restituisce lo stato del Centralinista
		return stato;
	}
	
	public void setStato(String stato) {										//Modifica lo stato del Centralinista
		this.stato = stato;
	}
	
	public void print(Centralinista c) {										//Stampa i dati del Centralinista
		System.out.println("Centralinista\n ID : "+ c.ID +"\nNome : "+ c.nome +"\nCognome : "+ c.cognome +
				"\nNumero di Telefono : "+ c.numeroDiTelefono +"\nEmail : "+ c.email +"\nCompetenze: "
				+ c.competenze +"\nStato : "+ c.stato);			
	}
	
	/*
	 * Funzione di hash autogenerata
	 */
	@Override
	public int hashCode() {														//Funzione di hash autogenerata
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((competenze == null) ? 0 : competenze.hashCode());
		result = prime * result + ((dataDiNascita == null) ? 0 : dataDiNascita.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroDiTelefono == null) ? 0 : numeroDiTelefono.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((qualifica == null) ? 0 : qualifica.hashCode());
		result = prime * result + ((residenza == null) ? 0 : residenza.hashCode());
		result = prime * result + ((stato == null) ? 0 : stato.hashCode());
		return result;
	}
	
	/**
	 * Comparazione del Centralinista
	 * <p>- I centralinisti sono uguali se hanno lo stesso id</p>
	 * @param obj Oggetto Centralinista
	 *
	 */	
	@Override
	public boolean equals(Object obj) {	//2 Centralinisti sono uguali se hanno lo stesso id
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Centralinista other = (Centralinista) obj;
		if (ID != other.ID)
			return false;
		return true;
	}
	
	private int ID;
	private String nome;
	private String cognome;
	private Date dataDiNascita;
	private String residenza;
	private String indirizzo;
	private String numeroDiTelefono;
	private String email;
	private String password;
	private String competenze;
	private String qualifica;
	private String stato;
	
}