public class Griglia {
    private final int righe;
    private final int colonne;
    private final Cella[][] griglia;

    public Griglia(int righe, int colonne) {
        this.righe = righe;
        this.colonne = colonne;
        griglia = new Cella[righe][colonne];
        inizializzaGriglia();
    }

    private void inizializzaGriglia() {
        for (int i = 0; i < righe; i++) {
            for (int j = 0; j < colonne; j++) {
                griglia[i][j] = new Cella();
            }
        }
    }

    // Metodo per stampare la griglia
    public void printGriglia() {
        System.out.println("   " + generaIntestazioneColonne());
        for (int i = 0; i < righe; i++) {
            System.out.print((i + 1) + " "); // Numerazione delle righe
            if (i < 9) System.out.print(" "); // Allinea i numeri delle righe
            for (int j = 0; j < colonne; j++) {
                System.out.print("|" + griglia[i][j].getStato());
            }
            System.out.println("|");
        }
    }

    private String generaIntestazioneColonne() {
        StringBuilder intestazione = new StringBuilder();
        for (int j = 0; j < colonne; j++) {
            intestazione.append(" ").append((char) ('A' + j));
        }
        return intestazione.toString();
    }
}
