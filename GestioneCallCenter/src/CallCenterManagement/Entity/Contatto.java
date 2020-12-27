package CallCenterManagement.Entity;


import java.util.Date;
/**
* Implementazione Entità del Contatto
**
*/

public class Contatto {
	
	/**
	* Costruttore del Contatto
	* @param nome del Contatto
	* @param cognome del Contatto
	* @param numeroDiTelefono del Contatto
	* @param citta del Contatto
	* @param sesso del Contatto
	* @param dataDiNascita del Contatto
	* @param indirizzo del Contatto
	*
	*
	*<br><br> Metodi del Contatto
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
	* <li>getCitta()</li>
	* <li>setCitta()</li>
	* <li>getSesso()</li>
	* <li>setSesso()</li>
	* <li>print()</li>
	* </ul>
	*/
	
	public Contatto(String nome, String cognome, String numeroDiTelefono, 
			String citta, String sesso, Date dataDiNascita, String indirizzo) {		//Costruttore
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.numeroDiTelefono = numeroDiTelefono;
		this.citta = citta;
		this.sesso = sesso;
		this.dataDiNascita = dataDiNascita;
		this.indirizzo = indirizzo;
	}
	
	/**
	*
	* Costruttore di copia del Contatto
	* @param c Oggetto del Contatto
	*/
	public Contatto(Contatto c) {													//Costruttore di copia
		this(c.nome, c.cognome, c.numeroDiTelefono, 								//Richiamo il costruttore
				c.citta, c.sesso, c.dataDiNascita, c.indirizzo);				
	}

	
	public int getID() {															//Restituisce l'id del Contatto
		return ID;
	}
	
	public void setID(int iD) {														//Modifica l'id del Contatto
		this.ID = iD;
	}
	
	public String getNome() {														//Restituisce il nome del Contatto
		return nome;
	}
	
	public void setNome(String nome) {												//Modifica il nome del Contatto
		this.nome = nome;
	}
	
	public String getCognome() {													//Restituisce il cognome del Contatto
		return cognome;
	}
	
	public void setCognome(String cognome) {										//Modifica il cognome del Contatto
		this.cognome = cognome;
	}
	
	public String getNumeroDiTelefono() {											//Restituisce il numero del Contatto
		return numeroDiTelefono;
	}
	
	public void setNumeroDiTelefono(String numeroDiTelefono) {						//Modifica il numero del Contatto
		this.numeroDiTelefono = numeroDiTelefono;
	}
	
	public String getCitta() {														//Restituisce l'citta del Contatto
		return citta;
	}
	
	public void setCitta(String citta) {											//Modifica l'citta del Contatto
		this.citta = citta;
	}

	public String getSesso() {														//Restituisce la sesso del Contatto
		return sesso;
	}
	
	public void setSesso(String sesso) {											//Modifica la sesso del Contatto
		this.sesso = sesso;
	}

	public Date getDataDiNascita() {												//Restituisce la data di nascita del Contatto
		return dataDiNascita;
	}
	
	public void setDataDiNascita(Date dataDiNascita) {								//Modifica la data di nascita del Contatto
		this.dataDiNascita = dataDiNascita;
	}
	
	public String getIndirizzo() {													//Restituisce le indirizzo del Contatto
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {									//Modifica le indirizzo del Contatto
		this.indirizzo = indirizzo;
	}
	
	public void print(Contatto c) {													//Stampa i dati del Contatto
		System.out.println("Contatto\n ID : "+ c.ID +"\nNome : "+ c.nome +"\nCognome : "
				+ c.cognome +"\nNumero di Telefono : "+ c.numeroDiTelefono +"\nCitta : "
				+ c.citta +"\nSesso: "+ c.sesso+"\nIndirizzo: "+ c.indirizzo);			
	}
	
	/*
	 * Funzione di hash autogenerata
	 */
	@Override
	public int hashCode() {															//Funzione di hash autogenerata
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((citta == null) ? 0 : citta.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((dataDiNascita == null) ? 0 : dataDiNascita.hashCode());
		result = prime * result + ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroDiTelefono == null) ? 0 : numeroDiTelefono.hashCode());
		result = prime * result + ((sesso == null) ? 0 : sesso.hashCode());
		return result;
	}
	
	/**
	 * Comparazione del Contatto
	 * <p>- I contatti sono uguali se hanno lo stesso id</p>
	 * @param obj Oggetto Contatto
	 *
	 */
	@Override
	public boolean equals(Object obj) {	//2 Contatti sono uguali se hanno lo stesso id e/o numero di telefono
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contatto other = (Contatto) obj;
		if (ID != other.ID)
			return false;
		if (numeroDiTelefono == null) {
			if (other.numeroDiTelefono != null)
				return false;
		} else if (!numeroDiTelefono.equals(other.numeroDiTelefono))
			return false;
		return true;
	}

	private int ID;
	private String nome;
	private String cognome;
	private String numeroDiTelefono;
	private String citta;
	private String sesso;
	private Date dataDiNascita;
	private String indirizzo;

}