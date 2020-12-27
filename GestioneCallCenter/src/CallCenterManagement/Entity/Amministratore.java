package CallCenterManagement.Entity;




import java.util.Date;
/**
* Implementazione Entità dell'Amministratore
**
*/


public class Amministratore {

	/**
	* Costruttore dell'Amministratore
	* @param nome dell'Amministratore
	* @param cognome dell'Amministratore
	* @param dataDiNascita dell'Amministratore
	* @param residenza dell'Amministratore
	* @param indirizzo dell'Amministratore 
	* @param numeroDiTelefono dell'Amministratore 
	* @param email dell'Amministratore 
	* @param password dell'Amministratore 
	* @param competenze dell'Amministratore 
	* @param qualifica dell'Amministratore
	*
	*
	* <br><br>Metodi dell'Amministratore
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
	* <li>print()</li>
	* </ul>
	*/
	
	public Amministratore(String nome, String cognome, Date dataDiNascita,		//Costruttore
			String residenza, String indirizzo, String numeroDiTelefono, String email, String password, 
			String competenze, String qualifica) {
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
	}
	
	/**
	*
	* Costruttore di copia dell'Amministratore
	* @param a Oggetto dell' Amministratore
	*/
	public Amministratore(Amministratore a) {									//Costruttore di copia
		this(a.nome, a.cognome, a.dataDiNascita, a.residenza, a.indirizzo,		//Richiamo il costruttore
			a.numeroDiTelefono, a.email, a.password, a.competenze, a.qualifica);				
	}
	
	
	public int getID() {														//Restituisce l'id dell'Amministratore
		return ID;
	}
	
	public void setID(int iD) {													//Modifica l'id dell'Amministratore
		this.ID = iD;
	}
	
	public String getNome() {													//Restituisce il nome dell'Amministratore
		return nome;
	}
	
	public void setNome(String nome) {											//Modifica il nome dell'Amministratore
		this.nome = nome;
	}
	
	public String getCognome() {												//Restituisce il cognome dell'Amministratore
		return cognome;
	}
	
	public void setCognome(String cognome) {									//Modifica il cognome dell'Amministratore
		this.cognome = cognome;
	}
	
	public Date getDataDiNascita() {											//Restituisce la data di nascita dell'Amministratore
		return dataDiNascita;
	}
	
	public void setDataDiNascita(Date dataDiNascita) {							//Modifica la data di nascita dell'Amministratore
		this.dataDiNascita = dataDiNascita;
	}
	
	public String getResidenza() {												//Restituisce la residenza dell'Amministratore
		return residenza;
	}
	
	public void setResidenza(String residenza) {								//Modifica la residenza dell'Amministratore
		this.residenza = residenza;
	}
	
	public String getIndirizzo() {												//Restituisce l'indirizzo dell'Amministratore
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {								//Modifica l'indirizzo dell'Amministratore
		this.indirizzo = indirizzo;
	}
	
	public String getNumeroDiTelefono() {										//Restituisce il numero dell'Amministratore
		return numeroDiTelefono;
	}
	
	public void setNumeroDiTelefono(String numeroDiTelefono) {					//Modifica il numero dell'Amministratore
		this.numeroDiTelefono = numeroDiTelefono;
	}
	
	public String getEmail() {													//Restituisce l'email dell'Amministratore
		return email;
	}
	
	public void setEmail(String email) {										//Modifica l'email dell'Amministratore
		this.email = email;
	}
	
	public String getPassword() {												//Restituisce la password dell'Amministratore
		return password;
	}
	
	public void setPassword(String password) {									//Modifica la password dell'Amministratore
		this.password = password;
	}
	
	public String getCompetenze() {												//Restituisce le competenze dell'Amministratore
		return competenze;
	}
	
	public void setCompetenze(String competenze) {								//Modifica le competenze dell'Amministratore
		this.competenze = competenze;
	}
	
	public String getQualifica() {												//Restituisce la qualifica dell'Amministratore
		return qualifica;
	}
	
	public void setQualifica(String qualifica) {								//Modifica la qualifica dell'Amministratore
		this.qualifica = qualifica;
	}
	
	public void print(Amministratore a) {										//Stampa i dati dell'Amministratore
		System.out.println("Amministratore\n ID : "+ a.ID +"\nNome : "+ a.nome +"\nCognome : "+ a.cognome +
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
		result = prime * result + ((dataDiNascita == null) ? 0 : dataDiNascita.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroDiTelefono == null) ? 0 : numeroDiTelefono.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((qualifica == null) ? 0 : qualifica.hashCode());
		result = prime * result + ((residenza == null) ? 0 : residenza.hashCode());
		return result;
	}
	
	/**
	 * Comparazione dell'Amministratore
	 * <p>- Gli Amministratori sono uguali se hanno lo stesso id</p>
	 * @param obj Oggetto Amministratore
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
		Amministratore other = (Amministratore) obj;
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

}