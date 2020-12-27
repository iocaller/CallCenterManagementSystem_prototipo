package CallCenterManagement.Controller;

import CallCenterManagement.Controller.Impl.DefaultGestioneCallCenterEISBuilder;
import CallCenterManagement.Entity.*;
import java.sql.ResultSet;
import java.util.Date;

/**
 * Gestione Call Center EIS
 */


final public class GestioneCallCenterEIS {
	
private static GestioneCallCenterEIS instance;
    
    public synchronized static GestioneCallCenterEIS getInstance() {
        if (instance == null) {
            instance = new DefaultGestioneCallCenterEISBuilder().build();
        }
        return instance;
    }
    
    /**
     * Gestione Call Center EISBuilder
     */
    public abstract static class GestioneCallCenterEISBuilder {
        
        protected GestioneCallCenterEIS build(AuthenticationManager authenticationManager, GestioneAmministratore gestioneAmministratore, 
        		GestioneAppuntamento gestioneAppuntamento, GestioneLista gestioneLista, ResocontoAppuntamento resocontoAppuntamento) {
            return new GestioneCallCenterEIS(authenticationManager, gestioneAmministratore, gestioneAppuntamento, gestioneLista, resocontoAppuntamento);
        }
        
        public abstract GestioneCallCenterEIS build();
    }
    
    protected GestioneCallCenterEIS(AuthenticationManager authenticationManager, GestioneAmministratore gestioneAmministratore, 
    		GestioneAppuntamento gestioneAppuntamento, GestioneLista gestioneLista, ResocontoAppuntamento resocontoAppuntamento) {
        this.authenticationManager = authenticationManager;
        this.gestioneAmministratore = gestioneAmministratore;
        this.gestioneAppuntamento = gestioneAppuntamento;
        this.gestioneLista = gestioneLista;
        this.resocontoAppuntamento = resocontoAppuntamento;
    }
    
    //Authentication
    
    public int login(String ruolo, String email, String pass) {
    	
    	int loggato = authenticationManager.login(ruolo, email, pass);
    	
    	return loggato;
    	
    };

	public int logout() {
		
		int confirm = authenticationManager.logout();
		
		return confirm;
		
	}

	public void registration(String username, String password) {
		
		authenticationManager.registration(username, password);
		
	}
	
	//Gestione Amministratore
	
	public void aggiungeAmministratore(Amministratore a) {
		
		gestioneAmministratore.aggiungeAmministratore(a);
		
	};

	public void rimuoveAmministratore(Amministratore a) {
		
		gestioneAmministratore.rimuoveAmministratore(a);
		
	};

	public void modificaAmministratore(Amministratore a) {
		
		gestioneAmministratore.modificaAmministratore(a);
		
	};
	
	//Gestione Appuntamento
	public void creaAppuntamento(Appuntamento a) {
		
		gestioneAppuntamento.creaAppuntamento(a);
		
	};

	public Appuntamento ricercaAppuntamento(int ID) {
		
		Appuntamento a = gestioneAppuntamento.ricercaAppuntamento(ID);
		
		return a;
		
	};
	
	public void modificaNota(Appuntamento a) {
		
		gestioneAppuntamento.modificaNota(a);
		
	};

	public int cercaIDappuntamentofallito(String nomeAppuntamentofallito) {
		
		int idappuntamentofallito = gestioneAppuntamento.cercaIDappuntamentofallito(nomeAppuntamentofallito);
		
		return idappuntamentofallito;
		
	};

	public AgentediVendita getAgentediVendita(int IDAgente) {
		
		AgentediVendita a = gestioneAppuntamento.getAgentediVendita(IDAgente);
		
		return a;
		
	};
	
	public void modificaAppuntamento(Appuntamento a) {
		
		gestioneAppuntamento.modificaAppuntamento(a);
		
	};
	
	public void rimuoveAppuntamento(Appuntamento a) {
		
		gestioneAppuntamento.rimuoveAppuntamento(a);
		
	};
	
	//GestioneLista
	
	public ResultSet cercaContatti(String Citta, String Sesso, Date DataDiNascita) {
		
		ResultSet rs = gestioneLista.cercaContatti(Citta, Sesso, DataDiNascita);
		
		return rs;
		
	};
	
	public void importaContatti(ResultSet rs, int IDListaContatti) {
		
		gestioneLista.importaContatti(rs, IDListaContatti);
		
	};
	
	public void associaListaContatti(int IDContatto, int IDListaContatti) {
		
		gestioneLista.associaListaContatti(IDContatto, IDListaContatti);
		
	}
	
	public ResultSet visualizzaContatto(int IDLista) {
		
		ResultSet rs = gestioneLista.visualizzaContatto(IDLista);
		
		return rs;
		
	}

	public void creaListaContatti(ListaContatti l) {
		
		gestioneLista.creaListaContatti(l);
		
	};

	public void ricercaListaContatti(ListaContatti l) {
		
		gestioneLista.ricercaListaContatti(l);
		
	};

	public void modificaListaContatti(ListaContatti l) {
		
		gestioneLista.modificaListaContatti(l);
		
	};

	public void rimuoveListaContatti(ListaContatti l) {
		
		gestioneLista.rimuoveListaContatti(l);
		
	};
	
	//ResocontoAppuntamento
	
	public Appuntamento visualizzaAppuntamento(int ID) {
		
		Appuntamento a = resocontoAppuntamento.visualizzaAppuntamento(ID);
		
		return a;
		
	};

	public void rifiutaAppuntamento(Appuntamento a) {
		
		resocontoAppuntamento.rifiutaAppuntamento(a);
		
	};
	
	final private AuthenticationManager authenticationManager;
    final private GestioneLista gestioneLista;
    final private GestioneAmministratore gestioneAmministratore;
    final private GestioneAppuntamento gestioneAppuntamento;
    final private ResocontoAppuntamento resocontoAppuntamento;
}
