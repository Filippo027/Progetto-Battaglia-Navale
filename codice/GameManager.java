public class GameManager {
    GestoreAccesso gestoreAccesso = new GestoreAccesso("utenti.txt");
    Utente giocatore1;
    Utente giocatore2;
    int turno = 0;

    public GameManager() {
        giocatore1 = new Utente(gestoreAccesso);
        giocatore2 = new Utente(gestoreAccesso);
    }

    public void gestioneGioco() {
        System.out.println("Benvenuti al gioco di Battaglia Navale!");
        System.out.println("Giocatore 1: " + giocatore1.getNome());
        System.out.println("Giocatore 2: " + giocatore2.getNome());
        System.out.println("Inizia la partita!\n");


        while (!(giocatore1.haPerso() && giocatore2.haPerso())) {
            if (turno % 2 == 0) {
                System.out.println("=== Turno di " + giocatore1.getNome() + " ===");
                giocatore1.azioniGiocatore();
            } else {
                System.out.println("=== Turno di " + giocatore2.getNome() + " ===");
                giocatore2.azioniGiocatore();
            }
            turno++;
            System.out.println();
        }


        if (giocatore1.haPerso()) {
            System.out.println("\n==> Ha vinto il " + giocatore2.getNome() + "!");
        } else {
            System.out.println("\n==> Ha vinto il " + giocatore1.getNome() + "!");
        }

        System.out.println("\nLa partita è terminata. Grazie per aver giocato!");
    }

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.gestioneGioco();
    }
}
