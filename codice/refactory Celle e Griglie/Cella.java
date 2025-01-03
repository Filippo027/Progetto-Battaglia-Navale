public class Cella {
    private boolean assegnato;
    private boolean colpito;

    public Cella() {
        assegnato = false;
        colpito = false;
    }

    // Metodo per ottenere lo stato della cella
    public char getStato() {
        if (colpito) {
            return 'X'; // Cella colpita
        } else if (assegnato) {
            return 'O'; // Cella assegnata a una nave
        } else {
            return ' '; // Cella vuota
        }
    }

    public void setAssegnato() {
        assegnato = true;
    }

    public void setColpito() {
        colpito = true;
    }
}
