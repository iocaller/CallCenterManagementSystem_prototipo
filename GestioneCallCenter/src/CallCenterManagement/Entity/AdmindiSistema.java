package CallCenterManagement.Entity;

/**
* Implementazione Entità dell'Admin di Sistema
**
*/

public class AdmindiSistema {

	/**
	* Costruttore dell'Admin di Sistema
	* @param username dell'Admin di Sistema
	* @param password dell'Admin di Sistema
	*
	*
	*<br><br> Metodi dell'Admin di Sistema
	* <hr>
	* <ul>
	* <li>getUsername()</li>
	* <li>setUsername()</li>
	* <li>getPassword()</li>
	* <li>setPassword()</li>
	* </ul>
	*/
	public AdmindiSistema(String username, String password) {	//Costruttore
		super();
		this.username = username;
		this.password = password;
	}

	/**
	* Costruttore di copia dell'Admin di Sistema
	* @param a Oggetto dell' Admin di Sistema
	*/
	public AdmindiSistema(AdmindiSistema a) {					//Costruttore di copia
		this(a.username, a.password);							//Richiamo il costruttore
	}
	
	public String getUsername() {								//Restituisce lo username 
		return username;
	}
	
	public void setUsername(String username) {					//Modifica lo username
		this.username = username;
	}
	
	public String getPassword() {								//Restituisce la password
		return password;
	}
	
	public void setPassword(String password) {					//Modifica la password
		this.password = password;
	}
	
	public void print(AdmindiSistema a) {						//Stampa Username dell'Admin di Sistema
		System.out.println("Admin di Sistema\n Username : "+ a.username);			
	}	
	
	/*
	 * Funzione di hash autogenerata
	 */
	@Override													
	public int hashCode() {										
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
	/**
	 * Comparazione degli Admin di Sistema
	 * <p>- Gli Admin di sistema sono uguali se hanno lo stesso username(piu' casi generali)</p>
	 * @param obj Oggetto dell'Admin di Sistema
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
		AdmindiSistema other = (AdmindiSistema) obj;
		if (username == null) {					
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	private String username;
	private String password;

}