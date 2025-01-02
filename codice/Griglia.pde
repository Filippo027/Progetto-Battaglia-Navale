public class Griglia {
    private int grandezzaCella=80;
    private int righe=9;
    private int colonne=7;
    private int margine=5;
    protected Cella [][] griglia;

    //costeruttore
    public Griglia(){
        griglia=new Cella[righe][colonne];
    }

    //inizializzazione della matrice 
    void inizializzaGriglia(){
        for(int i=0; i<righe; i++){
            for(int j=0; j<colonne; j++){
                griglia[i][j]=new Cella();
            }
        }
    }
    
    void displayGriglia(){
        int posX=margine;
        int posY=margine;
        for(int i=0; i<righe; i++){
            for(int j=0; j<colonne; j++){
                //if(i==0){
                   // griglia[i][j].drawCellaIndice(posX,posY,grandezzaCella,1);
                //}else if(j==0){
                   // griglia[i][j].drawCellaIndice(posX,posY,grandezzaCella,1);
                //}else{
                  //  griglia[i][j].drawCella(posX,posY,grandezzaCella);
                //}
                griglia[i][j].drawCella(posX,posY,grandezzaCella);
                
                
                posX=posX+grandezzaCella+margine;
            }
            posX=margine;
            posY=posY+grandezzaCella+margine;
        }
    }
}
