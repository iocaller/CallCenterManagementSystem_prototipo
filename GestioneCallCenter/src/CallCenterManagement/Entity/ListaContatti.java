package CallCenterManagement.Entity;

/**
* Implementazione Entità della ListaContatti
**
*/


public class ListaContatti {
	
	/**
	* Costruttore della ListaContatti
	* @param nomeLista della Lista Contatti
	* @param descrizione della Lista Contatti 
	* 
	* 
	* <br><br>Metodi di Lista Contatti
	* <hr>
	* <ul>
	* <li>getID()</li>
	* <li>setID()</li>
	* <li>getNomeLista()</li>
	* <li>setNomeLista()</li> 
	* <li>getDescrizione()</li>
	* <li>setDescrizione()</li>
	* <li>print()</li>
	* </ul>
	*/

	public ListaContatti(String nomeLista, String descrizioneLista) {		//Costruttore
		
		super();
		this.nomeLista = nomeLista;
		this.descrizioneLista = descrizioneLista;
		
	}
	
	/**
	*
	* Costruttore di copia di ListaContatti
	* @param l Oggetto del ListaContatti
	*/
	
	public ListaContatti(ListaContatti l) {									//Costruttore di copia
		this(l.nomeLista,l.descrizioneLista);								//Richiamo il costruttore
	}
	
	
	public int getID() {													//Restituisce l'ID della lista contatti
		return ID;
	}
	
	public void setID(int ID) {												//Modifica l'ID della lista contatti
		this.ID = ID;
	}
	
	public String getNomeLista() {											//Restituisce il nome della lista contatti
		return nomeLista;
	}
	
	public void setNomeLista(String nomeLista) {							//Modifica il nome della lista contatti
		this.nomeLista = nomeLista;
	}
	
	public String getDescrizioneLista() {									//Restituisce la descrizione della lista contatti
		return descrizioneLista;
	}
	
	public void setDescrizioneLista(String descrizioneLista) {				//Modifica la descrizione della lista contatti
		this.descrizioneLista = descrizioneLista;
	}
	
	public void print(ListaContatti l) {									//Stampa ID, nome e descrizione della Lista Contatti
		System.out.println("Lista Contatti\n ID : "+ l.ID +"\nNome Lista : "
				+ l.nomeLista +"\nDescrizione Lista : "+ l.descrizioneLista);			
	}
	
	/*
	 * Funzione di hash autogenerata
	 */
	@Override
	public int hashCode() {													//Funzione di hash autogenerata
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrizioneLista == null) ? 0 : descrizioneLista.hashCode());
		result = prime * result + ID;
		result = prime * result + ((nomeLista == null) ? 0 : nomeLista.hashCode());
		return result;
	}
	
	/**
	 * Comparazione della Lista Contatti
	 * <p>- Le liste contatti sono uguali se hanno lo stesso id</p>
	 * @param obj Oggetto Lista Contatti
	 *
	 */
	@Override
	public boolean equals(Object obj) {	//2 Liste Contatti sono uguali se hanno lo stesso ID
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaContatti other = (ListaContatti) obj;
		if (ID != other.ID)
			return false;
		return true;
	}
	
	private int ID;
	private String nomeLista;
	private String descrizioneLista;
	
}