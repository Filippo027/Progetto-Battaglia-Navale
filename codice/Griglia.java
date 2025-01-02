public class Griglia {
    private int righe=9;
    private int colonne=7;
    
    Cella [][] griglia;
    public Griglia(){
        inizializzaGriglia();
    }
    void inizializzaGriglia(){
        for(int i=0; i<righe; i++){
            for(int j=0; j<colonne; j++){
                griglia[i][j]=new Cella();
            }
        }
    }
}
