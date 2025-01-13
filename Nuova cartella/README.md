Relazione
Componenti del gruppo:
  •	Querini Matteo
  •	Zampis Gabriele
  •	Martellossi Filippo
  
Obiettivi del progetto:
  •	Implementare un sistema di gioco della Battaglia Navale con Java.
  •	Consentire la gestione delle modalità di gioco.
  •	Implementare un sistema di accesso e registrazione dei giocatori.
  •	Fornire feedback visivo per i colpi (colpito, mancato, affondato).
  
Requisiti funzionali:
  •	Accesso e registrazione: i giocatori devono poter registrarsi con un nome utente e password per poter accedere successivamente.
  •	Salvataggio dei dati: il sistema salva il nome utente, la password e il numero di vittorie dei giocatori in un file.
  •	Posizionamento delle navi: il giocatore deve poter posizionare le proprie navi su una griglia di sei colonne e nove righe.
  •	Modalità di gioco: possibilità di giocare contro un avversario umano o contro il computer (se possibile implementarlo).
  •	Interfaccia grafica: l’utente deve poter interagire con una griglia visiva.
  •	Riconoscimento colpi: il sistema deve evidenziare se un colpo è andato a segno o se è andato a vuoto.
  •	Gestione delle vittorie: il sistema deve determinare il vincitore quando tutte le navi di un giocatore sono state affondate e aggiornare il file delle vittorie.
  
Requisiti non funzionali:
  •	Performance: il gioco deve essere fluido e reattivo.
  •	Usabilità: l’interfaccia deve essere intuitiva e semplice da usare.
  •	Portabilità: il gioco deve essere eseguibile su diversi sistemi operativi con Java.
  •	Modularità: il codice deve essere organizzato in classi separate (ad esempio, Griglia, Giocatore, Gioco, etc.) per facilitarne la manutenzione.
  
Interfaccia grafica, verrà sviluppata sul terminale, con le seguenti caratteristiche:
  •	Feedback visivo: uso di diversi caratteri per indicare lo stato delle caselle (libera, colpita, nave affondata, etc.).
  
Interazioni utente:
  •	Accesso e Registrazione: l’utente deve accedere o registrarsi con un nome utente e una password.
  •	Posizionamento navi: l’utente fornisce le coordinate di inizio e fine per la creazione della nave e il programma la genera automaticamente.
  •	Sparare: l’utente fornisce le coordinate per sparare un colpo sulla griglia avversaria.
  •	Feedback: l’utente riceve un riscontro sul risultato del colpo.
  
Flusso del gioco:
  •	Accesso o registrazione del giocatore.
  •	Fase di posizionamento delle navi per entrambi i giocatori.
  •	I giocatori si alternano per sparare colpi sulla griglia avversaria.
  •	Quando tutte le navi di un giocatore vengono affondate, il gioco termina.
  •	Viene aggiornato il file delle vittorie.
  
Piano di sviluppo:
  •	Fase 1: Creazione della logica di gioco in Java (classi Gioco, Giocatore, Griglia e Nave).
  •	Fase 2: Implementazione del sistema di accesso e registrazione dei giocatori.
  •	Fase 3: Implementazione dell’IA per la modalità contro il computer (se possibile).
  •	Fase 4: Test e correzione di bug.
  
Tecnologie utilizzate:
  •	Java: per la logica di gioco.
  
Problematiche: 
  •	Utilizzo di Processing: Inizialmente, abbiamo provato a utilizzare Processing per la parte grafica del progetto. Tuttavia, a causa della complessità di questo approccio, abbiamo deciso di semplificare la grafica e        svilupparla interamente tramite il terminale.
  •	Controllo dell'assegnamento delle navi: Il posizionamento delle navi sulla griglia ha richiesto un'attenta gestione per evitare sovrapposizioni e posizionamenti errati. Questo si è rivelato più complesso del previsto.
  •	Modifiche al progetto: Nel corso del tempo, il progetto ha subito diverse modifiche, che hanno richiesto la rimozione di alcune classi già sviluppate. Questo ha comportato una perdita di tempo, poiché è stato       
    necessario ripensare e riorganizzare alcune parti del codice.
  •	Modalità Giocatore vs Computer: A causa del tempo ridotto, non siamo riusciti a implementare la modalità che consente a un utente di giocare contro una CPU. Questo è stato un obiettivo iniziale che non è stato 
    possibile raggiungere entro i tempi previsti.
    
Conclusioni
  Il progetto 'Battaglia Navale' è un'applicazione che combina logica di gioco, gestione grafica e interazioni utente, con l’accesso e la registrazione dei giocatori. La separazione dei moduli garantisce la facilità di     manutenzione e l'espansione del progetto.

