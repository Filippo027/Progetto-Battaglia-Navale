public class GameManager {
    GestoreAccesso gestoreAccesso = new GestoreAccesso("utenti.txt"); // Oggetto GestoreAccesso
    Utente giocatore1;
    Utente giocatore2;
    int turno = 0;

    public GameManager() {
        // Creiamo i giocatori passandogli il gestore degli accessi
        giocatore1 = new Utente(gestoreAccesso);
        giocatore2 = new Utente(gestoreAccesso);
    }

    public void gestioneGioco() {
        // Introdurre il gioco con i nomi dei giocatori
        System.out.println("Benvenuti al gioco di Battaglia Navale!");
        System.out.println("Giocatore 1: " + giocatore1.getNome());
        System.out.println("Giocatore 2: " + giocatore2.getNome());
        System.out.println("Inizia la partita!\n");

        // Ciclo del gioco: continua fino a che entrambi i giocatori non perdono
        while (!(giocatore1.haPerso() && giocatore2.haPerso())) {
            if (turno % 2 == 0) {
                System.out.println("=== Turno di " + giocatore1.getNome() + " ===");
                giocatore1.azioniGiocatore();
            } else {
                System.out.println("=== Turno di " + giocatore2.getNome() + " ===");
                giocatore2.azioniGiocatore();
            }
            turno++;
            System.out.println();  // Righe vuote per separare i turni
        }

        // Alla fine del gioco, determiniamo chi ha vinto
        if (giocatore1.haPerso()) {
            System.out.println("\n==> Ha vinto il " + giocatore2.getNome() + "!");
        } else {
            System.out.println("\n==> Ha vinto il " + giocatore1.getNome() + "!");
        }

        // Messaggio finale
        System.out.println("\nLa partita è terminata. Grazie per aver giocato!");
    }

    public static void main(String[] args) {
        // Crea e avvia il gioco
        GameManager gameManager = new GameManager();
        gameManager.gestioneGioco();
    }
}
