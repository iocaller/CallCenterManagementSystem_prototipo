package CallCenterManagement.Controller.Impl;

import CallCenterManagement.Controller.GestioneCallCenterEIS;
import CallCenterManagement.Controller.AuthenticationManager;
import CallCenterManagement.Controller.GestioneAmministratore;
import CallCenterManagement.Controller.GestioneAppuntamento;
import CallCenterManagement.Controller.GestioneLista;
import CallCenterManagement.Controller.ResocontoAppuntamento;
/**
* Implementazione varie funzionalità del sistema
*
*/

public class DefaultGestioneCallCenterEISBuilder extends GestioneCallCenterEIS.GestioneCallCenterEISBuilder {

    @Override
    public GestioneCallCenterEIS build() {
        AuthenticationManager authenticationManager  = new AuthenticationManagerImpl();
        GestioneAmministratore gestioneAmministratore = new GestioneAmministratoreImpl();
        GestioneAppuntamento gestioneAppuntamento = new GestioneAppuntamentoImpl();
        GestioneLista gestioneLista = new GestioneListaImpl();
        ResocontoAppuntamento resocontoAppuntamento = new ResocontoAppuntamentoImpl();
        
        return super.build(authenticationManager, gestioneAmministratore, gestioneAppuntamento, gestioneLista, resocontoAppuntamento);
    }
    
}
