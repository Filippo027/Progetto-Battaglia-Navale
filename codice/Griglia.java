public class Griglia {
    private int righe=9;
    private int colonne=7;

    Cella [][] griglia= new Cella[righe][colonne];
    public Griglia(){
        inizializzaGriglia();
    }
    private void inizializzaGriglia(){
        for(int i=0; i<righe; i++){
            for(int j=0; j<colonne; j++){
                griglia[i][j]=new Cella();
            }
        }
    }
    public void printGriglia(){
        for(int i=0; i<righe; i++){
            for(int j=0; j<colonne; j++){
                //if(j==0 || i==0){
                    //System.out.print("hdhd");
                //}else{
                    griglia[i][j].printCella();
                //}
            }
        }
    }
    public static void main(String[] args) {
        Griglia griglia=new Griglia();
        griglia.printGriglia();
    }
}
