public class Cella {
    private Boolean assegnato;
    private Boolean colpito;
    private int dimensione=3;
    private int indiceMeta=1;
    char[] cella = new char[dimensione];
    public Cella(){
        assegnato=false;
        colpito=false;
        inizializzaCella();
    }
    private void inizializzaCella(){
        for(int i=0; i<dimensione; i++){
            if(i==indiceMeta){
                cella[i]=' ';
            }else{
                cella[i]='|';
            }
        }
    }
    private void assegnaCella(){
        if(colpito && assegnato){
            cella[indiceMeta]='X';
        }else if(colpito && !assegnato){
            cella[indiceMeta]='O';
        }else if(!colpito){
            cella[indiceMeta]=' ';
        }
    }
    public void printCella(){
        assegnaCella();
        for(int i=0; i<dimensione; i++){
            System.out.print(cella[i]);
        }
    }
    public void printCellaIndice(int indice){
        indice=indice+48;
        char tempChar = (char) indice;
        cella[indiceMeta]=tempChar;
        for(int i=0; i<dimensione; i++){
            System.out.print(cella[i]);
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