
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

    //Metodi:
    public boolean colpita(Nave nave, int colpoX, int colpoY){
        if(nave.getX() == colpoX && nave.getY() == colpoY){
            return true;
        } else {
            return false;
        }
    }


    public boolean eAffondata(){
        for(int i = 0; i < lunghezza; i++){
            if(stato[i] == false){
                return false;
            }
        }
        return true;
    }
}