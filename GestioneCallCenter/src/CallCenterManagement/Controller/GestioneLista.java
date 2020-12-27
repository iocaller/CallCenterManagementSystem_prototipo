package CallCenterManagement.Controller;

import java.sql.ResultSet;
import java.util.Date;
import CallCenterManagement.Entity.ListaContatti;

/**
 * Interface Class Gestione Lista Contatti
 */

public interface GestioneLista {
	
	public ResultSet cercaContatti(String Citta, String Sesso, Date DataDiNascita);
	
	public void importaContatti(ResultSet rs, int IDListaContatti);
	
	public void associaListaContatti(int IDContatto, int IDListaContatti);
	
	public ResultSet visualizzaContatto(int IDLista);

	public void creaListaContatti(ListaContatti l);

	public void ricercaListaContatti(ListaContatti l);

	public void modificaListaContatti(ListaContatti l);

	public void rimuoveListaContatti(ListaContatti l);

}