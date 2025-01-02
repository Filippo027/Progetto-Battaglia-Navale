public class Cella {
    private Boolean assegnato;
    private Boolean colpito;
    private int righe=3;
    private int colonne=5;
    char[][] cella = new char[righe][colonne];
    public Cella(){
        assegnato=false;
        colpito=false;
        inizializzaCella();
    }
    private void inizializzaCella(){
        for(int i=0; i<righe; i++){
            for(int j=0; j<colonne; j++){
                if(j==0 || j==colonne-1){
                    cella[i][j]='|';
                }else if((i==0 || i==righe-1) && (j>0 && j<colonne-1)){
                    cella[i][j]='-';
                }else{
                    cella[i][j]=' ';
                }
            }
        }
    }
    public void printCella(){
        for(int i=0; i<righe; i++){
            for(int j=0; j<colonne; j++){
                System.out.print(cella[i][j]);
            }
            if(i<righe-1){
                System.out.println();
            }
        }
    }
    public Boolean getAssegnato(){
        return assegnato;
    }
    public Boolean getColpito(){
        return colpito;
    }
    public void setColpito(){
          colpito=true;
    }
    public void setAssegnato(){
          assegnato=true;
    }
    

    
}