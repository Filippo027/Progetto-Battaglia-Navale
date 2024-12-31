import java.util.ArrayList


class Giocatore{
    //Attrubuti
    private String nome;
    private Griglia griglia;
    private ArrayList<Nave> navi;

    //Costruttore
    public Giocatore(String nome, Griglia griglia){
        this.nome = nome;
        this.griglia = new Griglia();
        this.navi = new ArrayList<Nave>();
    }
    
    
}