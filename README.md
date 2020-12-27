# Call Center Software System
La seguente trattazione è mirata al ciclo di realizzazione di un sistema software dedicato a chi gestisce, o chi vuole cominciare a gestire: un call center, un’attività di telemarketing, di prenotazioni appuntamenti, operatore telefonici oppure un’attività inhouse nella propria azienda. 
Si analizzeranno gli strumenti ed i sistemi che consentiranno il raggiungimento di un’efficienza massima, sia nel numero di chiamate che di telefonate svolte e vendite completate. **La trattazione si focalizzerà sulle funzioni e le definizioni che potranno facilitare il lavoro quotidiano di amministratori, amministratori di sistema, centralinisti e agenti vendita e la loro interazione.**   

# La nostra idea
Il nome del nostro sistema software di gestione di un call center è IOCaller Software System (aiokôlər) l’acronimo IO sta ad indicare “**Inbound e Outbound**” ove indicano le due classificazioni dei centralinisti. Sottostante una proposta di logo del sistema software in questione.

<p align="center">
  <img src="https://github.com/iocaller/CallCenterManagementSystem_prototipo/blob/main/GestioneCallCenter/images/logo.png">
</p>

# Il documento completo (Ciclo di realizzazione del Software)
La documentazione è consultabile al seguente <a href="https://github.com/iocaller/CallCenterManagementSystem_prototipo/blob/main/Documento_IS.pdf">link</a><br>
Il documento realizzato è suddiviso in sezioni:
- *Introduzione*
- *Documentazione della specifica dei dati*
- *Documentazione di Analisi*
- *Documentazione di Progettazione*
- *Documento di Implementazione*
- *Implementazione Software*
- *Documento di Testing*

<hr>

### overview del progetto>
# La soluzione al problema (Class Diagram Package Completo)

La realizzazione del diagramma dei Package Completo è stata ottenuta a partire dall’individuazione nei sequence di progettazione delle seguenti classi:
-	Classe *ConsoleBoundary*
-	Classe *Controller e ControllerImpl*
-	Classe *Entity*
-	Classe *DAO (Interazione con il Database)*

<p align="center">
  <img src="https://github.com/iocaller/CallCenterManagementSystem_prototipo/blob/main/Diagrammi/Class%20Diagram.png">
</p>


# Dal Class Diagram Package alla realizzazione del Software
Si mostra la gerarchia delle interfacce realizzate del Software, (invitiamo ovviamente al lettore che questo grafico è il risultato di un'implementazine completa presente nella repository)
<p align="center">
  <img src="https://github.com/iocaller/CallCenterManagementSystem_prototipo/blob/main/Diagrammi/GerachiaInterfaccia.JPG">
</p>



# Prova ad eseguire il nostro programmino di prova
È possibile provare il programma realizzato seguendo i seguenti passi
- <a href="https://github.com/iocaller/CallCenterManagementSystem_prototipo/blob/main/IOCaller.jar">Scaricare il file.jar</a> 
- <a href="https://github.com/iocaller/CallCenterManagementSystem_prototipo/blob/main/Database">Scaricare il database</a>

## Prerequisiti
- Java Virtual Machine
- Installazione di <a href="https://www.apachefriends.org/it/download.html">MySQL</a> sul terminale e installazione del database lasciato in dotazione

# Gli Autori (Team - 9, Progetto Ingegneria del Software)
- Antonio Romano
- Giuseppe Riccio
- Salvatore Pernice
- Giovanni Scognamiglio

# Progetto realizzato per soli scopi dimostrativi ed educativi
La seguente trattazione è mirata alla realizzazione di un progetto software per l'esame di Ingegneria del Software all'**Università degli Studi di Napoli Federico II** seguendo una documentazione adeguata.
