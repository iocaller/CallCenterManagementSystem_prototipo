package CallCenterManagement.Entity;

/**
* Implementazione Entità del Gruppo
**
*/

public class Gruppo {
	
	/**
	* Costruttore del Gruppo
	* @param descrizione del Gruppo
	* 
	* 
	* <br><br>Metodi del Contatto
	* <hr>
	* <ul>
	* <li>getID()</li>
	* <li>setID()</li>
	* <li>getDescrizione()</li>
	* <li>setDescrizione()</li>
	* <li>print()</li>
	* </ul>
	*/

	public Gruppo(String descrizione) {							//Costruttore
		super();
		this.descrizione = descrizione;
	}
	
	/**
	*
	* Costruttore di copia di Gruppo
	* @param g Oggetto del Gruppo
	*/
	public Gruppo(Gruppo g) {									//Costruttore di copia
		this(g.descrizione);				
	}

	
	public int getID() {										//Restituisce l'id del Gruppo
		return ID;
	}
	
	public void setID(int iD) {									//Modifica l'id del Gruppo 
		this.ID = iD;
	}
	
	public String getDescrizione() {							//Restituisce la descrizione del Gruppo
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {			//Modifica la descrizione del Gruppo
		this.descrizione = descrizione;
	}
	
	public void print(Gruppo g) {								//Stampa i dati del Gruppo
		System.out.println("Gruppo\n ID : "+ g.ID +"\nDescrizione : "+ g.descrizione);			
	}	
	
	/*
	 * Funzione di hash autogenerata
	 */
	@Override
	public int hashCode() {										//Funzione di hash autogenerata
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		return result;
	}

	/**
	 * Comparazione del Gruppo
	 * <p>- I Gruppi sono uguali se hanno lo stesso id</p>
	 * @param obj Oggetto Gruppo
	 *
	 */
	@Override
	public boolean equals(Object obj) {	//2 Gruppi sono uguali se hanno lo stesso id
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gruppo other = (Gruppo) obj;
		if (ID != other.ID)
			return false;
		return true;
	}

	private int ID;
	private String descrizione;

}