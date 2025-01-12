public class GameManager {
    GestoreAccesso gestoreAccesso = new GestoreAccesso("utenti.txt");
    Utente giocatore1;
    Utente giocatore2;
    int turno = 0;

    public GameManager() {
        giocatore1 = new Utente(gestoreAccesso);
        giocatore2 = new Utente(gestoreAccesso);
    }

    public void menu() {
        boolean continua = true;

        while (continua) {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Aggiungi nuovo utente");
            System.out.println("2. Gioca");
            System.out.println("3. Visualizza vittorie");
            System.out.println("4. Esci");
            System.out.print("Scegli un'opzione: ");

            int scelta = Leggi.unInt();

            switch (scelta) {
                case 1:
                    gestoreAccesso.registraGiocatoreInterattivo();
                    break;

                case 2:
                    gestisciPartita();
                    break;

                case 3:
                    visualizzaVittorie();
                    break;

                case 4:
                    System.out.println("Arrivederci!");
                    continua = false;
                    break;

                default:
                    System.out.println("Opzione non valida, riprova.");
            }
        }
    }

    public void gestionePartita(){
        System.out.println("Benvenuti al gioco di Battaglia Navale!");
        System.out.println("Giocatore 1: " + giocatore1.getNome());
        System.out.println("Giocatore 2: " + giocatore2.getNome());
        System.out.println("Inizia la partita!\n");
        
        turno = 0;

        while(!(giocatore1.haPerso() && giocatore2.haPerso())){
            if(turno%2==0){
                System.out.println("=== Turno di " + giocatore1.getNome() + " ===");
                giocatore1.azioniGiocatore();

            }else{
                System.out.println("=== Turno di " + giocatore2.getNome() + " ===");
                giocatore2.azioniGiocatore();
            }
            turno++;
            System.out.println();
        }
        if(giocatore1.haPerso()){
            System.out.println("\n==> Ha vinto il " + giocatore2.getNome() + "!");

        }else{
            System.out.println("\n==> Ha vinto il " + giocatore1.getNome() + "!");
        }

        System.out.println("\nLa partita è terminata. Grazie per aver giocato!");
    }

    public void visualizzaVittorie() {

        System.out.print("\nInserisci il nome del giocatore per visualizzare le vittorie: ");
        String nome = Leggi.unoString();

        int vittorie = gestoreAccesso.getVittorie(nome);
        System.out.println("Il giocatore " + nome + " ha vinto " + vittorie + " partite.");
    }

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.menu();
    }
}
