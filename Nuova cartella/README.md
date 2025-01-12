# Progetto-Battaglia-Navale
DOCUMENTO DI PROGETTAZIONE DEL GIOCO 'BATTAGLIA NAVALE'
1. Introduzione: Il presente documento descrive la progettazione del gioco 'Battaglia Navale' realizzato in Java. L’obiettivo è creare un'applicazione interattiva in cui due giocatori possano sfidarsi seguendo le regole classiche del gioco della Battaglia Navale.
________________________________________
2. Obiettivi del progetto
  •	Implementare un sistema di gioco della Battaglia Navale con Java.

  •	Consentire la gestione delle modalità di gioco Giocatore vs Giocatore e Giocatore vs Computer (se possibile implementarla).

  •	Implementare un sistema di accesso e registrazione dei giocatori.

  •	Fornire feedback visivo per i colpi (colpito, mancato, affondato).
________________________________________
3. Requisiti funzionali
  •	Accesso e registrazione: i giocatori devono poter registrarsi con un nome utente e accedere successivamente.

  •	Salvataggio dei dati: il sistema salva il nome utente e il numero di vittorie dei giocatori in un file.

  •	Posizionamento delle navi: il giocatore deve poter posizionare le proprie navi su una griglia 10x10.

  •	Modalità di gioco: possibilità di giocare contro un avversario umano o contro il computer (se possibile implementarlo).

  •	Interfaccia grafica: l’utente deve poter interagire con una griglia visiva.

  •	Riconoscimento colpi: il sistema deve evidenziare se un colpo è andato a segno o è stato un errore.

  •	Gestione delle vittorie: il sistema deve determinare il vincitore quando tutte le navi di un giocatore sono state affondate e aggiornare il file delle vittorie.
________________________________________
4. Requisiti non funzionali
  •	Performance: il gioco deve essere fluido e reattivo.

  •	Usabilità: l’interfaccia deve essere intuitiva e semplice da usare.

  •	Portabilità: il gioco deve essere eseguibile su diversi sistemi operativi con Java.

  •	Modularità: il codice deve essere organizzato in classi separate (ad esempio, Griglia, Giocatore, Gioco, etc.) per facilitare la manutenzione.
________________________________________
5. Architettura del sistema è suddivisa in diversi moduli principali:
  •	Modulo Logica di Gioco: gestione delle regole, verifica dei colpi, gestione dello stato della partita.

  •	Modulo Gestione Input: gestione delle azioni del giocatore.

  •	Modulo Accesso e Registrazione: gestione dell’accesso e della registrazione dei giocatori, con salvataggio dei dati in un file.
________________________________________
6. Interfaccia grafica verrà sviluppata sul terminale, con le seguenti caratteristiche:
  •	Indicatori di stato: messaggi di stato come "Colpito!", "Mancato!" o "Affondato!".

  •	Feedback visivo: uso di colori per indicare lo stato delle caselle (libera, colpita, nave affondata, etc.).
________________________________________
7. Interazioni utente
  •	Accesso e Registrazione: l’utente deve accedere o registrarsi con un nome utente.

  •	Posizionamento navi: l’utente fornisce le coordinate di inizio e fine per la creazione della nave.

  •	Sparare: l’utente fornisce le coordinate per sparare un colpo sulla griglia avversaria.

  •	Feedback: l’utente riceve un feedback sul risultato del colpo.
________________________________________
8. Flusso del gioco
  •	Accesso o registrazione del giocatore.

  •	Fase di posizionamento delle navi per entrambi i giocatori.

  •	I giocatori si alternano per sparare colpi sulla griglia avversaria.

  •	Quando tutte le navi di un giocatore vengono affondate, il gioco termina.

  •	Viene aggiornato il file delle vittorie.
________________________________________
9. Piano di sviluppo
  •	Fase 1: Creazione della logica di gioco in Java (classi Gioco, Giocatore, Griglia e Nave).

  •	Fase 2: Implementazione del sistema di accesso e registrazione dei giocatori.

  •	Fase 3: Implementazione dell’IA per la modalità contro il computer (se possibile).

  •	Fase 4: Test e correzione di bug.
________________________________________
10. Tecnologie utilizzate
  •	Java: per la logica di gioco.
________________________________________
11. Conclusioni: Il progetto 'Battaglia Navale' è un'applicazione che combina logica di gioco, gestione grafica e interazioni utente, con l’accesso e la registrazione dei giocatori. La separazione dei moduli garantisce la facilità di manutenzione e l’espansione del progetto.

