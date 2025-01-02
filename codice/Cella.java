public class Cella {
    private Boolean assegnato;
    private Boolean colpito;
    private int rows=3;
    private int columns=5;
    char[][] cella = new char[rows][columns];
    public Cella(){
        assegnato=false;
        colpito=false;
        inizializzaCella();
    }
    private void inizializzaCella(){
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(j==0 || j==columns-1){
                    cella[i][j]='|';
                }else if((i==0 || i==rows-1) && (j>0 && j<columns-1)){
                    cella[i][j]='-';
                }else{
                    cella[i][j]=' ';
                }
            }
        }
    }
    private void printCella(){
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                System.out.print(cella[i][j]);
            }
            System.out.println();
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
    public static void main(String[] args) {
        Cella cella= new Cella();
        cella.printCella();
    }

    
}