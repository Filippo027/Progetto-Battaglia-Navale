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


    //Costruttore:
    public Nave(String nome, int lunghezza, int x, int y){
        this.nome = nome;
        this.lunghezza = lunghezza;
        this.stato = new boolean[lunghezza];
        this.affondata = false;
        this.x = x;
        this.y = y;
    }
}