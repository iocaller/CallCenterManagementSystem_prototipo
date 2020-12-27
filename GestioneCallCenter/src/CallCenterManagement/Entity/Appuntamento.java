package CallCenterManagement.Entity;

import java.util.Date;
/**
* Implementazione Entità dell'Appuntamento
**
*/

public class Appuntamento {
	
	/**
	* Costruttore dell'Amministratore
	* @param nome dell'Appuntamento
	* @param data dell'Appuntamento
	* @param ora dell'Appuntamento	
	* @param note dell'Appuntamento
	* @param iDappunamentofallito possibile id relativo a un Appuntamento 
	* @param iDAgente iD dell'Agente che si occupa dell'Appuntamento
	*
	*
	*<br><br> Metodi dell'Agente di Vendita
	* <hr>
	* <ul>
	* <li>getID()</li>
	* <li>setID()</li>
	* <li>getnomeAppuntamento()</li>
	* <li>setnomeAppuntamento()</li>
	* <li>getData()</li>
	* <li>setData()</li>
	* <li>getOra()</li>
	* <li>setOra()</li>
    * <li>getNote()</li>
	* <li>setNote()</li>
	* <li>getIDappuntamentofallitoo()</li>
	* <li>setIDappuntamentofallito()</li>
	* <li>getIDAgente()</li>
	* <li>setIDAgente()</li>
	* <li>print()</li>
	* </ul>
	*/
	

	public Appuntamento(String nomeAppuntamento, Date data, String ora, //Costruttore
			String note, int iDappuntamentofallito, int iDAgente) {
		super();
		this.nomeAppuntamento = nomeAppuntamento;
		this.data = data;
		this.ora = ora;
		this.note = note;
		this.IDappuntamentofallito = iDappuntamentofallito;
		this.IDAgente = iDAgente;
	}
	
	/**
	*
	* Costruttore di copia dell'Appuntamento
	* @param a Oggetto dell'Appuntamento
	*/
	public Appuntamento(Appuntamento a) {								//Costruttore di copia
		this(a.nomeAppuntamento, a.data, a.ora, a.note, 				//Richiamo il costruttore
				a.IDappuntamentofallito, a.IDAgente);
	}
	
	
	public int getID() {												//Restituisce l'id dell'Appuntamento
		return ID;
	}
	
	public void setID(int iD) {											//Modifica l'id dell'Appuntamento
		this.ID = iD;
	}
	
	public String getNomeAppuntamento() {								//Restituisce il nome dell'Appuntamento
		return nomeAppuntamento;
	}
	
	public void setNomeAppuntamento(String nomeAppuntamento) {			//Modifica il nome dell'Appuntamento
		this.nomeAppuntamento = nomeAppuntamento;
	}
	
	public Date getData() {												//Restituisce la data dell'Appuntamento
		return data;
	}
	
	public void setData(Date data) {									//Modifica la data dell'Appuntamento
		this.data = data;
	}
	
	public String getOra() {											//Restituisce l'ora dell'Appuntamento
		return ora;
	}
	
	public void setOra(String ora) {									//Modifica l'ora dell'Appuntamento
		this.ora = ora;
	}
	
	public String getNote() {											//Restituisce le note dell'Appuntamento
		return note;
	}
	
	public void setNote(String note) {									//modifica le note dell'Appuntamento
		this.note = note;
	}
	
	public int getIDappuntamentofallito() {								//Restituisce l'id dell'appuntamento fallito
		return IDappuntamentofallito;
	}
	
	public void setIDappuntamentofallito(int iDappuntamentofallito) {	//Modifica l'id dell'appuntamento fallito
		this.IDappuntamentofallito = iDappuntamentofallito;
	}
	
	public int getIDAgente() {											//Restituisce l'id dell'agente di vendita
		return IDAgente;
	}
	
	public void setIDAgente(int iDAgente) {								//Modifica l'id dell'agente di vendita
		this.IDAgente = iDAgente;
	}
	
	public void print(Appuntamento a) {									//Stampa i dati dell'Appuntamento
		System.out.println("Appuntamento\n ID : "+ a.ID +"\n Nome : "
				+ a.nomeAppuntamento +"\n Data : "+ a.data +"\nOra : "
				+ a.ora +"\nNote : "+ a.note);			
	}	
	
	/*
	 * Funzione di hash autogenerata
	 */
	@Override
	public int hashCode() {												
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + IDappuntamentofallito;
		result = prime * result + IDAgente;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((nomeAppuntamento == null) ? 0 : nomeAppuntamento.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		result = prime * result + ((ora == null) ? 0 : ora.hashCode());
		return result;
	}
	
	/**
	 * Comparazione dell'Appuntamento
	 * <p>- Gli Appuntamenti sono uguali se hanno lo stesso id</p>
	 * @param obj Oggetto Appuntamento
	 *
	 */	
	@Override
	public boolean equals(Object obj) {	//2 Appuntamenti sono uguali se hanno lo stesso id
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appuntamento other = (Appuntamento) obj;
		if (ID != other.ID)
			return false;
		return true;
	}

	private int ID;
	private String nomeAppuntamento;
	private Date data;
	private String ora;
	private String note;
	private int IDappuntamentofallito;
	private int IDAgente;

}