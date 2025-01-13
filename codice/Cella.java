public class Cella {
    private Boolean assegnato; // Indica se la cella è assegnata
    private Boolean colpito; // Indica se la cella è stata colpita
    private int dimensione = 3; // Dimensione della cella
    private int indiceMeta = 1; // Indice della posizione centrale della cella
    char[] cella = new char[dimensione]; // Array di caratteri che rappresenta la cella

    // Costruttore della classe Cella
    public Cella() {
        assegnato = false;
        colpito = false;
        inizializzaCella();
    }

    // Inizializza la cella con caratteri '|', eccetto la posizione centrale che è uno spazio vuoto
    private void inizializzaCella() {
        for (int i = 0; i < dimensione; i++) {
            if (i == indiceMeta) {
                cella[i] = ' ';
            } else {
                cella[i] = '|';
            }
        }
    }

    // Assegna il carattere appropriato alla cella in base al suo stato
    private void assegnaCella() {
        if (colpito && assegnato) {
            cella[indiceMeta] = 'X'; // Colpito e assegnato

        } else if (colpito && !assegnato) {
            cella[indiceMeta] = 'O'; // Colpito ma non assegnato

        } else if (!colpito) {
            cella[indiceMeta] = ' '; // Non colpito
        }
    }

    // Stampa la cella
    public void printCella() {
        assegnaCella();
        for (int i = 0; i < dimensione; i++) {
            System.out.print(cella[i]);
        }
    }

    // Stampa la cella con un indice specifico
    public void printCellaIndice(int indice) {
        indice = indice + 48; // Converti l'indice in carattere

        char tempChar = (char) indice;

        cella[indiceMeta] = tempChar;
        
        for (int i = 0; i < dimensione; i++) {
            System.out.print(cella[i]);
        }
    }

    // Getter per la variabile assegnato
    public Boolean getAssegnato() {
        return assegnato;
    }

    // Getter per la variabile colpito
    public Boolean getColpito() {
        return colpito;
    }

    // Setter per la variabile colpito
    public void setColpito() {
        colpito = true;
    }

    // Setter per la variabile assegnato
    public void setAssegnato() {
        assegnato = true;
    }
}