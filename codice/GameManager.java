
public class GameManager {
    GestoreAccesso gestoreAccesso = new GestoreAccesso("utenti.txt");
    Utente giocatore1;
    Utente giocatore2;
    int turno = 0;

    public GameManager() {
        giocatore1 = new Utente(gestoreAccesso);
        giocatore2 = new Utente(gestoreAccesso);
    }

    public void menuPrincipale() {
        
        int scelta;

        do {
            System.out.println("\n--- Menu Principale ---");
            System.out.println("1. Aggiungi nuovo utente");
            System.out.println("2. Gioca");
            System.out.println("3. Visualizza vittorie");
            System.out.println("4. Esci");
            System.out.print("Scegli un'opzione: ");

            scelta = Leggi.unInt();

            switch (scelta) {
                case 1:
                    aggiungiNuovoUtente();
                    break;
                case 2:
                    gestioneGioco();
                    break;
                case 3:
                    visualizzaVittorie();
                    break;
                case 4:
                    System.out.println("Uscita dal programma. Grazie per aver giocato!");
                    break;
                default:
                    System.out.println("Opzione non valida. Riprova.");
            }
        } while (scelta != 4);
    }

    public void aggiungiNuovoUtente() {
        System.out.println("\n--- Aggiungi Nuovo Utente ---");
        System.out.print("Inserisci il nome del nuovo utente: ");
        String nome = Leggi.unoString();

        System.out.print("Inserisci la password: ");
        String password = Leggi.unoString();

        gestoreAccesso.registraGiocatoreInterattivo(nome, password);
    }

    public void visualizzaVittorie() {
        System.out.println("\n--- Visualizza Vittorie ---");
        System.out.print("Inserisci il nome del giocatore: ");
        String nome = Leggi.unoString();
        
        int vittorie = gestoreAccesso.getVittorie(nome);
        System.out.println("Il giocatore " + nome + " ha vinto " + vittorie + " partite.");
    }

    public void gestioneGioco() {
        System.out.println("\n--- Gioco di Battaglia Navale ---");
        System.out.println("Giocatore 1: " + giocatore1.getNome());
        System.out.println("Giocatore 2: " + giocatore2.getNome());
        System.out.println("Inizia la partita!\n");



        giocatore1.grigliaGiocatore.printGriglia();



        System.out.println("=== Turno di " + giocatore1.getNome() + " ===");
        giocatore1.grigliaGiocatore.inserisciNavi();

        System.out.println("=== Turno di " + giocatore2.getNome() + " ===");
        giocatore2.grigliaGiocatore.inserisciNavi();




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
            giocatore2.salvaVittoria();
        } else {
            System.out.println("\n==> Ha vinto il " + giocatore1.getNome() + "!");
            giocatore1.salvaVittoria();
        }

        System.out.println("\nLa partita è terminata. Grazie per aver giocato!");
    }
}
