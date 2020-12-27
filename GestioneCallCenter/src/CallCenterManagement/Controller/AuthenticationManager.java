package CallCenterManagement.Controller;


/**
 * Interface class AuthenticationManager
 * 
 */

public interface AuthenticationManager {
	
	public int login(String ruolo, String email, String pass);

	public int logout();

	public void registration(String username, String password);
	
}