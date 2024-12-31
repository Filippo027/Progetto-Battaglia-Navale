public class Cella {
    Boolean assegnato;
    Boolean colpito;
    int r = 0;
    int g = 0;
    int b = 0;

    public Cella(){
        assegnato=false;
        colpito=false; 
    }

    private void coloreCella(){
        if(assegnato && colpito){
            r = 0;
            g = 0;
            b = 0;

        }else if(colpito && !assegnato){
            r = 0;
            g = 76;
            b = 153;

        }else{
            r = 102;
            g = 178;
            b = 255;
        } 
    }

    public void drawCella(int posX,int posY, int lato){
        coloreCella();
        rect(posX,posY,lato,lato);
        fill(r,g,b);
    }

    public void drawCellaIndice(int posX,int posY, int lato, int indice){
      
    }

    public Boolean getAssegnato(){
      return assegnato;
    }

    public Boolean getColpito(){
      return colpito;
    }
}
