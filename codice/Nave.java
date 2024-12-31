
class Nave{
    //Attributi:

    //Nome della nave
    protected String nome;
    //Lunghezza della nave
    protected int lunghezza;
    //Stato dei segmenti della nave, se è stata colpita o meno
    protected boolean[] stato;
    //Indica se la nave è stata affondata
    protected boolean affondata;
    //Indica le coordinate della nave
    protected int x;
    protected int y;
    //Indica l'orientamento della nave
    protected PuntiCardinali orientamento;


    //Costruttore:
    public Nave(String nome, int lunghezza, int x, int y, PuntiCardinali orientamento){
        this.nome = nome;
        this.lunghezza = lunghezza;
        this.stato = new boolean[lunghezza];
        this.affondata = false;
        this.x = x;
        this.y = y;
        this.orientamento = orientamento;
    }

    //Getter:
    protected String getNome(){
        return this.nome;
    }

    protected int getLunghezza(){
        return this.lunghezza;
    }

    protected boolean[] getStato(){
        return this.stato;
    }

    protected int getX(){
        return this.x;
    }

    protected int getY(){
        return this.y;
    }

    protected PuntiCardinali getOrientamento(){
        return this.orientamento;
    }

    //Metodi:

    protected void setStato(int colpoX, int colpoY){
        if(colpita(colpoX, colpoY)){

            int indiceCoolpo = 0;

            switch(orientamento){
                case NORD:
                    indiceCoolpo = y - colpoY;
                break;

                case EST:
                    indiceCoolpo = colpoX - x;
                break;

                case SUD:
                    indiceCoolpo = colpoY - y;
                break;

                case OVEST:
                    indiceCoolpo = x - colpoX;
                break;

                default:
                break;
            }

            if(indiceCoolpo >= 0 && indiceCoolpo < lunghezza){
                stato[indiceCoolpo] = true;
            }
        }
    }

    public boolean colpita(int colpoX, int colpoY){

        if(orientamento == PuntiCardinali.NORD || orientamento == PuntiCardinali.SUD){
            return colpoX == x && colpoY >= y && colpoY > y + lunghezza;
            /*
            Se la nave è orizzontale controlla se la x è la stessa e se la coordinata y
            del colpo sia contenuta nella lunghezza della nave
            */
        } else if(orientamento == PuntiCardinali.EST || orientamento == PuntiCardinali.OVEST){
            return colpoY == y && colpoX >= x && colpoX > x + lunghezza;
            //Se la nave è verticale esegue il controllo opposto
        }

        //Il colpo non ha colpito la nave
        return false;
    }


    public boolean eAffondata(){
        //Cicla l'array stato e se anche solo un segmento non è stato colpito la nave non è affondata
        for(boolean segmento : stato){
            if(!segmento){
                return false;
            }
        }
        return true;
    }
}
