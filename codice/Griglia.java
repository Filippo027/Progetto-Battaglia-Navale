public class Griglia {
    private int righe=9;
    private int colonne=7;
    private int numeroCelleNavi;
    private int numeroCelleNaviAssegnabili;

    Cella [][] griglia= new Cella[righe][colonne];
    public Griglia(){
        inizializzaGriglia();
        numeroCelleNavi=16;
        numeroCelleNaviAssegnabili=16;
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
                if(i==0 && j!=0){
                    griglia[i][j].printCellaIndice(j);
                }else if(j==0 && i!=0){
                    griglia[i][j].printCellaIndice(i);
                }else if(j==0 && i==0){
                    griglia[i][j].printCellaIndice(-44);
                }else{
                    griglia[i][j].printCella();
                }
            }
            System.out.println();
        }
    }
    //sistema oper inserire e colpire una cella con relativi errori 
    private boolean checkNumeriCorretti(int riga,int colonna){
        if((riga>0 && riga<9) && (colonna>0 && colonna<7)){
            return true;
        }else{
            return false;
        }
    }    
    public boolean setCellaColpita(int riga,int colonna){
        if(!checkNumeriCorretti(riga, colonna)){
            System.out.println("coordinate non valide, reinseriscile");
            return false;
        }
        if(!griglia[riga][colonna].getColpito()){
            griglia[riga][colonna].setColpito();
        }else{
            System.out.println("cella già colpita precedentemente, reinserisci le coordinate");
            return false;
        }
        cambiaStatoCella(riga, colonna);
        return true;
    }
    private void cambiaStatoCella(int riga, int colonna){
        if(griglia[riga][colonna].getColpito() && griglia[riga][colonna].getAssegnato()){
            numeroCelleNavi--;
        }
    }
    //fine delle righe per il sistema di attaco di una cella 
    private int sceltaNave(){
        if(numeroCelleNaviAssegnabili==16){
            numeroCelleNaviAssegnabili=numeroCelleNaviAssegnabili-5;
            return 5;
        }else if(numeroCelleNaviAssegnabili==11 || numeroCelleNaviAssegnabili == 8){
            numeroCelleNaviAssegnabili=numeroCelleNaviAssegnabili-3;
            return 3;
        }else if(numeroCelleNaviAssegnabili==5 || numeroCelleNaviAssegnabili==3){
            numeroCelleNaviAssegnabili=numeroCelleNaviAssegnabili-2;
        }else if(numeroCelleNaviAssegnabili==1){
            numeroCelleNaviAssegnabili--;
            return 1;
        }
        return numeroCelleNaviAssegnabili;

    }
    public void inserisciNavi(){
        do{
            int naveDaAssegnare=sceltaNave();
        }while(numeroCelleNaviAssegnabili!=0);

    }


    public static void main(String[] args) {
        Griglia griglia=new Griglia();
        griglia.setCellaColpita(3, 5);
        griglia.printGriglia();
    }
}
