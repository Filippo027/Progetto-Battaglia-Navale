public class Griglia {
    private int righe = 10; // Numero di righe della griglia
    private int colonne = 7; // Numero di colonne della griglia
    private int numeroCelleNavi; // Numero totale di celle occupate dalle navi
    private int numeroCelleNaviAssegnabili; // Numero di celle delle navi ancora assegnabili

    Cella[][] griglia = new Cella[righe][colonne]; // Matrice di oggetti Cella che rappresenta la griglia

    // Costruttore della classe Griglia
    public Griglia() {
        inizializzaGriglia(); // Inizializza la griglia con oggetti Cella
        numeroCelleNavi = 16; // Imposta il numero totale di celle occupate dalle navi
        numeroCelleNaviAssegnabili = 16; // Imposta il numero di celle delle navi ancora assegnabili
    }

    // Metodo per inizializzare la griglia
    private void inizializzaGriglia() {
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                griglia[i][j] = new Cella(); // Crea una nuova Cella per ogni posizione nella griglia
            }
        }
    }

    // Metodo per stampare la griglia
    public void printGriglia() {
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                if (i == 0 && j != 0) {
                    griglia[i][j].printCellaIndice(j); // Stampa l'indice della colonna nella prima riga
                } else if (j == 0 && i != 0) {
                    griglia[i][j].printCellaIndice(i); // Stampa l'indice della riga nella prima colonna
                } else if (j == 0 && i == 0) {
                    griglia[i][j].printCellaIndice(-44); // Stampa un carattere speciale nell'angolo in alto a sinistra
                } else {
                    griglia[i][j].printCella(); // Stampa la cella normale
                }
            }
            System.out.println(); // Nuova riga dopo ogni riga della griglia
        }
    }

    // Metodo per verificare se le coordinate sono all'interno dei limiti della griglia
    private boolean checkNumeriCorretti(int rigaInizio, int colonnaInizio) {
        if ((rigaInizio > 0 && rigaInizio < 10) && (colonnaInizio > 0 && colonnaInizio < 7)) {
            return true;
        } else {
            System.out.println("\u001B[31mHai inserito dei numeri che non stanno nel campo da gioco, reinserisci\u001B[0m");
            return false;
        }
    }

    // Metodo per impostare una cella come colpita
    public boolean setCellaColpita(int rigaInizio, int colonnaInizio) {
        if (!checkNumeriCorretti(rigaInizio, colonnaInizio)) {
            System.out.println("\u001B[31mCoordinate non valide, reinseriscile\u001B[0m");
            return false;
        }

        if (!griglia[rigaInizio][colonnaInizio].getColpito()) {
            griglia[rigaInizio][colonnaInizio].setColpito();
            System.out.println("\u001B[32mHai colpito una parte della nave!\u001B[0m");
        } else {
            System.out.println("\u001B[31mCella già colpita precedentemente, reinserisci le coordinate\u001B[0m");
            return false;
        }

        cambiaStatoCella(rigaInizio, colonnaInizio);
        return true;
    }

    // Metodo per cambiare lo stato di una cella dopo che è stata colpita
    private void cambiaStatoCella(int rigaInizio, int colonnaInizio) {
        if (griglia[rigaInizio][colonnaInizio].getColpito() && griglia[rigaInizio][colonnaInizio].getAssegnato()) {
            numeroCelleNavi--;
        }
    }

    // Metodo per determinare la dimensione della nave da assegnare
    private int sceltaNave() {
        if (numeroCelleNaviAssegnabili == 16) {
            numeroCelleNaviAssegnabili -= 5;
            return 5;
        } else if (numeroCelleNaviAssegnabili == 11 || numeroCelleNaviAssegnabili == 8) {
            numeroCelleNaviAssegnabili -= 3;
            return 3;
        } else if (numeroCelleNaviAssegnabili == 5 || numeroCelleNaviAssegnabili == 3) {
            numeroCelleNaviAssegnabili -= 2;
            return 2;
        } else if (numeroCelleNaviAssegnabili == 1) {
            numeroCelleNaviAssegnabili--;
            return 1;
        }
        return numeroCelleNaviAssegnabili;
    }

    // Metodo per inserire le navi nella griglia
    public void inserisciNavi() {
        do {
            int naveDaAssegnare = sceltaNave();
            posizionaNave(naveDaAssegnare);
        } while (numeroCelleNaviAssegnabili != 0);
    }

    // Metodo per verificare la posizione delle navi
    private boolean checkPosizione(int rigaInizio, int colonnaInizio, int rigaFine, int colonnaFine, int naveDaAssegnare) {
        if ((rigaInizio != rigaFine) && (colonnaInizio != colonnaFine)) {
            System.out.println("\u001B[31mLe due coordinate non hanno né la stessa riga, né la stessa colonna, reinserisci\u001B[0m");
            return false;
        }
        if (naveDaAssegnare != 1) {
            if ((rigaInizio == rigaFine) && (colonnaInizio == colonnaFine)) {
                System.out.println("\u001B[31mHai inserito due coordinate uguali, reinserisci\u001B[0m");
                return false;
            }
        } else if (naveDaAssegnare == 1) {
            if ((rigaInizio == rigaFine) && (colonnaInizio == colonnaFine)) {
                return true;
            }
        }
        if ((rigaInizio == rigaFine) && (colonnaInizio != colonnaFine)) {
            return true;
        }
        if ((rigaInizio != rigaFine) && (colonnaInizio == colonnaFine)) {
            return true;
        }
        return false;
    }

    // Metodo per verificare la distanza delle navi
    private boolean checkDistanza(int rigaInizio, int colonnaInizio, int rigaFine, int colonnaFine, int naveDaAssegnare) {
        int distanza = 0;
        if (naveDaAssegnare != 1) {
            if (rigaInizio == rigaFine) {
                if (colonnaInizio < colonnaFine) {
                    distanza = colonnaFine - colonnaInizio + 1;
                } else {
                    distanza = colonnaInizio - colonnaFine + 1;
                }
            } else if (colonnaInizio == colonnaFine) {
                if (rigaInizio < rigaFine) {
                    distanza = rigaFine - rigaInizio + 1;
                } else {
                    distanza = rigaInizio - rigaFine + 1;
                }
            }
        } else {
            if ((rigaInizio == rigaFine) && (colonnaInizio == colonnaFine)) {
                return true;
            }
        }

        if (distanza == naveDaAssegnare) {
            return true;
        } else {
            System.out.println("\u001B[31mLe coordinate inserite non hanno la giusta distanza, quest'ultima dev'essere uguale a " + naveDaAssegnare + "\u001B[0m");
            return false;
        }
    }

    // Metodo per verificare l'assegnamento delle navi
    private boolean checkAssegnamento(int rigaInizio, int colonnaInizio, int rigaFine, int colonnaFine, int naveDaAssegnare) {
        if (naveDaAssegnare != 1) {
            if (rigaInizio == rigaFine) {
                if (colonnaInizio < colonnaFine) {
                    for (int j = colonnaInizio; j <= colonnaFine; j++) {
                        if (griglia[rigaInizio][j].getAssegnato()) {
                            System.out.println("\u001B[31mUna delle celle da assegnare alla nave è già assegnata, reinserisci\u001B[0m");
                            return false;
                        } else {
                            griglia[rigaInizio][j].setAssegnato();
                        }
                    }
                } else {
                    for (int j = colonnaFine; j <= colonnaInizio; j++) {
                        if (griglia[rigaInizio][j].getAssegnato()) {
                            System.out.println("\u001B[31mUna delle celle da assegnare alla nave è già assegnata, reinserisci\u001B[0m");
                            return false;
                        } else {
                            griglia[rigaInizio][j].setAssegnato();
                        }
                    }
                }
            }

            if (colonnaInizio == colonnaFine) {
                if (rigaInizio < rigaFine) {
                    for (int j = rigaInizio; j <= rigaFine; j++) {
                        if (griglia[rigaInizio][j].getAssegnato()) {
                            System.out.println("\u001B[31mUna delle celle da assegnare alla nave è già assegnata\u001B[0m");
                            return false;
                        } else {
                            griglia[colonnaInizio][j].setAssegnato();
                        }
                    }
                } else {
                    for (int j = rigaFine; j <= rigaInizio; j++) {
                        if (griglia[colonnaInizio][j].getAssegnato()) {
                            System.out.println("\u001B[31mUna delle celle da assegnare alla nave è già assegnata\u001B[0m");
                            return false;
                        } else {
                            griglia[colonnaInizio][j].setAssegnato();
                        }
                    }
                }
            }
        } else {
            if (!griglia[rigaInizio][colonnaInizio].getAssegnato()) {
                griglia[rigaInizio][colonnaInizio].setAssegnato();
            } else {
                return false;
            }
        }
        return true;
    }

    // Metodo per verificare se le coordinate sono corrette per il posizionamento della nave
    private boolean checkCoordinateCorrette(int rigaInizio, int colonnaInizio, int rigaFine, int colonnaFine, int naveDaAssegnare) {
        if (!(checkNumeriCorretti(rigaInizio, colonnaInizio) && checkNumeriCorretti(rigaFine, colonnaFine))) {
            return false;
        }

        if (!checkPosizione(rigaInizio, colonnaInizio, rigaFine, colonnaFine, naveDaAssegnare)) {
            return false;
        }

        if (!checkDistanza(rigaInizio, colonnaInizio, rigaFine, colonnaFine, naveDaAssegnare)) {
            return false;
        }

        if (!checkAssegnamento(rigaInizio, colonnaInizio, rigaFine, colonnaFine, naveDaAssegnare)) {
            return false;
        }
        return true;
    }

    // Metodo per posizionare una nave nella griglia
    private void posizionaNave(int naveDaAssegnare) {
        int rigaInizio = 0;
        int colonnaInizio = 0;
        int rigaFine = 0;
        int colonnaFine = 0;

        do {
            System.out.println("\nInserisci la prima coordinata x e y per l'inizio della nave, dimensione: " + naveDaAssegnare);
            System.out.println("Ricorda, per il corretto assegnamento o la colonna o la riga devono essere uguali, perchè la nave non può essere assegnata in diagonale");
            System.out.print("Inserisci la coordinata della prima riga:");
            rigaInizio = Leggi.unInt();

            System.out.print("Inserisci la coordinata della prima colonna:");
            colonnaInizio = Leggi.unInt();

            System.out.print("Inserisci la coordinata della seconda riga:");
            rigaFine = Leggi.unInt();

            System.out.print("Inserisci la coordinata della seconda colonna:");
            colonnaFine = Leggi.unInt();

        } while (!checkCoordinateCorrette(rigaInizio, colonnaInizio, rigaFine, colonnaFine, naveDaAssegnare));
    }

    // Metodo per verificare se il giocatore ha perso
    public boolean haPerso() {
        return numeroCelleNavi == 0;
    }
}
