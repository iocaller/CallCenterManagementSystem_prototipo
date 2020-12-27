package CallCenterManagement.Controller;

import CallCenterManagement.Entity.AgentediVendita;
import CallCenterManagement.Entity.Amministratore;
import CallCenterManagement.Entity.Appuntamento;
import CallCenterManagement.Entity.Contatto;
import CallCenterManagement.Entity.ListaContatti;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * Test Call Center EIS
 */

public class GestioneCallCenterEISTest {
    
    public GestioneCallCenterEISTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        instance = GestioneCallCenterEIS.getInstance();
        instance.login("test","test", "test");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }
    
    private static GestioneCallCenterEIS instance;
    
    /*
     * Creo un amministratore di test
     */
    private Amministratore createAmministratore() throws ParseException {
    	
    	Amministratore amministratore = new Amministratore(null, null, null, null, null, null, null, null, null, null);
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    	String DatadiNascita = "1960-06-22";
    	
    	amministratore.setNome("Giacomo");
    	amministratore.setCognome("Poretti");
    	amministratore.setDataDiNascita(formatter.parse(DatadiNascita));
    	amministratore.setResidenza("Milano");
    	amministratore.setIndirizzo("Via degli Arbusti 88");
    	amministratore.setNumeroDiTelefono("0647372811");
    	amministratore.setEmail("giacomo.poretti@unina.it");
    	amministratore.setPassword("Giacomo_2020");
    	amministratore.setCompetenze("Settore telefonico");
    	amministratore.setQualifica("Direttore");
    	
    	return amministratore;
    	
    }
    
    /*
     * Creo una lista contatti di test
     */
    private ListaContatti createListaContatti() {
    	
    	ListaContatti listacontatti = new ListaContatti(null, null);
    	
    	listacontatti.setNomeLista("Lista Test");
    	listacontatti.setDescrizioneLista("Descrizione di Test");
    	
    	return listacontatti;
    	
    }
    
    /*
     * Creo un contatto di test
     */
    private Contatto createContatto() throws ParseException {
    	
    	Contatto contatto = new Contatto(null, null, null, null, null, null, null);
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    	String DatadiNascita = "13-08-1990";
    	
    	contatto.setNome("Giacomino");
    	contatto.setCognome("Verdino");
    	contatto.setNumeroDiTelefono("0845684751");
    	contatto.setCitta("Milano");
    	contatto.setSesso("M");
    	contatto.setDataDiNascita(formatter.parse(DatadiNascita));
    	contatto.setIndirizzo("Via Milano 23");
    	
    	return contatto;
    	
    }
    
    /*
     * Creo un appuntamento di test
     */
    private Appuntamento createAppuntamento() throws ParseException {
    	
    	Appuntamento appuntamento = new Appuntamento(null, null, null, null, 0, 0);
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    	String Data = "20-07-2020";
    	
    	appuntamento.setNomeAppuntamento("Installazione parabola");
    	appuntamento.setData(formatter.parse(Data));
    	appuntamento.setOra("11:00");
    	appuntamento.setNote("Terzo piano con ascensore");
    	appuntamento.setIDappuntamentofallito(0);
    	appuntamento.setIDAgente(1);
    	
    	return appuntamento;
    	
    }
    
    /*
     * Creo un agente di vendita di test
     */
    private AgentediVendita createAgentediVendita() {
    	
    	AgentediVendita agentedivendita = new AgentediVendita(null, null, null, null, null, null);
    	
    	agentedivendita.setID(1);
    	agentedivendita.setNome("Luigi");
    	agentedivendita.setCognome("Esposito");
    	agentedivendita.setNumeroDiTelefono("0814673337");
    	agentedivendita.setEmail("luigi.esposito@unina.it");
    	agentedivendita.setPassword("Luigi_2020");
    	agentedivendita.setCompetenze("Vendita Polizze");
    	
    	return agentedivendita;
    	
    }
    
    @Test
    public void testAggiungeAmministratore() throws Exception {
        
    	Amministratore amministratore = createAmministratore();
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    	String DatadiNascita = "22-06-1960";
    	Date data = formatter.parse(DatadiNascita);
    	
    	if(amministratore.getNome().length() > 32 ) {
			fail("Inserimento errato! il nome dell'amministratore non deve superare i 32 caratteri"); //Assert che genera un fallimento
		}
    	if(amministratore.getCognome().length() > 32 ) {
			fail("Inserimento errato! il cognome dell'amministratore non deve superare i 32 caratteri"); //Assert che genera un fallimento
		}
    	if(!formatter.format(amministratore.getDataDiNascita()).equals(formatter.format(data))) { 
			fail("Formato della data di nascita errato! (il formato corretto e' dd-mm-yyyy");	//Assert che genera un fallimento
		}
    	if(amministratore.getResidenza().length() > 32 ) {
			fail("Inserimento errato! la residenza dell'amministratore non deve superare i 32 caratteri"); //Assert che genera un fallimento
		}
    	if(amministratore.getIndirizzo().length() > 32 ) {
			fail("Inserimento errato! l'indirizzo dell'amministratore non deve superare i 32 caratteri"); //Assert che genera un fallimento
		}
    	if(amministratore.getNumeroDiTelefono().length() > 10 ) {
			fail("Inserimento errato! il numero di telefono dell'amministratore non deve superare le 10 cifre"); //Assert che genera un fallimento
		}
    	if(amministratore.getEmail().length() > 32 ) {
			fail("Inserimento errato! l'email dell'amministratore non deve superare i 32 caratteri"); //Assert che genera un fallimento
		}
    	if(amministratore.getPassword().length() > 32 ) {
			fail("Inserimento errato! la password dell'amministratore non deve superare i 32 caratteri"); //Assert che genera un fallimento
		}
    	if(amministratore.getCompetenze().length() > 32 ) {
			fail("Inserimento errato! le competenze dell'amministratore non deve superare i 32 caratteri"); //Assert che genera un fallimento
		}
    	if(amministratore.getQualifica().length() > 32 ) {
			fail("Inserimento errato! la qualifica dell'amministratore non deve superare i 32 caratteri"); //Assert che genera un fallimento
		}
    	
        assertEquals(amministratore.getID(),0); // Pre
        
        instance.aggiungeAmministratore(amministratore);
        
        int generatedId = amministratore.getID();
        if(generatedId <= 0 ) {
			fail("Inserimento errato! il valore dell'id deve essere maggiore di 0"); //Assert che genera un fallimento
		}
        
    }
    

    @Test
    public void testModificaAmministratore() throws Exception {
        
    	Amministratore amministratore = createAmministratore();
    	
    	assertEquals(amministratore.getNome(),"Giacomo"); // Pre
    	assertEquals(amministratore.getCognome(),"Poretti"); // Pre
        
        instance.aggiungeAmministratore(amministratore);
        
        amministratore.setNome("Checco");
    	amministratore.setCognome("Zalone");
    	
        instance.modificaAmministratore(amministratore);
        
        assertEquals(amministratore.getNome(),"Checco"); // Post
    	assertEquals(amministratore.getCognome(),"Zalone"); // Post
    	
        
    }
    
    @Test
    public void testCreaListaContatti() throws Exception {
       
    	ListaContatti listacontatti = createListaContatti();
    	
    	if(listacontatti.getNomeLista().length() > 32 ) {
			fail("Inserimento errato! il nome della lista contatti non deve superare i 32 caratteri"); //Assert che genera un fallimento
		}
    	if(listacontatti.getDescrizioneLista().length() > 32 ) {
			fail("Inserimento errato! la descrizione della lista contatti non deve superare i 32 caratteri"); //Assert che genera un fallimento
		}
       
    	assertEquals(listacontatti.getID(),0); // Pre
    	
    	instance.creaListaContatti(listacontatti);
       
    	int generatedId = listacontatti.getID();
    	if(generatedId <= 0 ) {
			fail("Inserimento errato! il valore dell'id deve essere maggiore di 0"); //Assert che genera un fallimento
		}
       
    }
    
    @Test
    public void testCercaContatti() throws Exception {
    	
    	Contatto contatto = createContatto();
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    	String DatadiNascita = "13-08-1990";
    	
    	//Cerca contatto solo per Citta'    	
    	//contatto.setCitta("Milano");
    	//contatto.setSesso("M");
    	//contatto.setDataDiNascita(new Date());
    	
    	instance.cercaContatti(contatto.getCitta(), contatto.getSesso(), contatto.getDataDiNascita());
        
    	assertEquals(contatto.getCitta(),"Milano");
    	assertEquals(contatto.getSesso(),"M"); 
    	assertEquals(contatto.getDataDiNascita(), formatter.parse(DatadiNascita));
    }
        
    @Test
    public void testCreaAppuntamento() throws Exception {
        
    	Appuntamento appuntamento = createAppuntamento();
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    	String Data = "20-07-2020";
    	Date data = formatter.parse(Data);
    	
    	if(appuntamento.getNomeAppuntamento().length() > 32 ) {
			fail("Inserimento errato! il nome dell'appuntamento non deve superare i 32 caratteri"); //Assert che genera un fallimento
		}
    	if(!formatter.format(appuntamento.getData()).equals(formatter.format(data))) { 
			fail("Formato della data dell'appuntamento errato! (il formato corretto e' dd-mm-yyyy"); //Assert che genera un fallimento
		}
    	if(appuntamento.getOra().length() > 5 ) {
			fail("Inserimento errato! l'ora dell'appuntamento non deve superare i 5 caratteri"); //Assert che genera un fallimento
		}
    	if(appuntamento.getNote().length() > 32 ) {
			fail("Inserimento errato! le note dell'appuntamento non devono superare i 32 caratteri"); //Assert che genera un fallimento
		}
    	if(appuntamento.getIDappuntamentofallito() < 0 ) {
			fail("Inserimento errato! l'id dell'appuntamento fallito deve essere maggiore o uguale di 0"); //Assert che genera un fallimento
		}
    	if(appuntamento.getIDAgente() <= 0 ) {
			fail("Inserimento errato! l'id dell'agente di vendita deve essere maggiore di 0"); //Assert che genera un fallimento
		}
       
    	assertEquals(appuntamento.getID(),0); // Pre
    	
    	instance.creaAppuntamento(appuntamento);
       
    	int generatedId = appuntamento.getID();
    	if(generatedId <= 0 ) {
			fail("Inserimento errato! il valore dell'id deve essere maggiore di 0"); //Assert che genera un fallimento
		}
        
    }
    
    @Test
    public void testGetAgentediVendita() throws Exception {
        
    	AgentediVendita agentedivendita = createAgentediVendita();
    	
    	instance.getAgentediVendita(agentedivendita.getID());
    	
    	assertEquals(agentedivendita.getID(),1);
    	assertEquals(agentedivendita.getNome(),"Luigi");
    	assertEquals(agentedivendita.getCognome(),"Esposito");
    	assertEquals(agentedivendita.getNumeroDiTelefono(),"0814673337");
    	assertEquals(agentedivendita.getEmail(),"luigi.esposito@unina.it");
    	assertEquals(agentedivendita.getPassword(),"Luigi_2020");
    	assertEquals(agentedivendita.getCompetenze(),"Vendita Polizze");
    	
        
    }
    
    @Test
    public void testVisualizzaAppuntamento() throws Exception {
        
    	Appuntamento appuntamento = createAppuntamento();
    	
    	assertEquals(appuntamento.getID(),0); // Pre
    	
    	instance.creaAppuntamento(appuntamento);
       
    	int generatedId = appuntamento.getID();
    	if(generatedId <= 0 ) {
			fail("Inserimento errato! il valore dell'id deve essere maggiore di 0"); //Assert che genera un fallimento
		}
    	
    	Appuntamento app_cercato = instance.ricercaAppuntamento(generatedId);
    	
    	assertEquals(app_cercato.getID(),appuntamento.getID());
    	assertEquals(app_cercato.getNomeAppuntamento(),appuntamento.getNomeAppuntamento());
    	assertEquals(app_cercato.getData(),appuntamento.getData());
    	assertEquals(app_cercato.getOra(),appuntamento.getOra());
    	assertEquals(app_cercato.getIDappuntamentofallito(),appuntamento.getIDappuntamentofallito());
    	assertEquals(app_cercato.getIDAgente(),appuntamento.getIDAgente());
        
    }
    
    @Test
    public void testRifiutaAppuntamento() throws Exception {
        
    	Appuntamento appuntamento = createAppuntamento();
    	
    	assertEquals(appuntamento.getID(),0); // Pre
    	
    	instance.creaAppuntamento(appuntamento);
       
    	int generatedId = appuntamento.getID();
    	if(generatedId <= 0 ) {
			fail("Inserimento errato! il valore dell'id deve essere maggiore di 0"); //Assert che genera un fallimento
		}
    	
    	instance.rifiutaAppuntamento(appuntamento);
    	
    	assertEquals(appuntamento.getNote(),"Rifiutato");
        
    }
    
}
