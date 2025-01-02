import java.util.ArrayList


class Giocatore{
    //Attrubuti
    private String nome;
    private ArrayList<Nave> navi;
    private Griglia griglia;
    

    //Costruttore
    public Giocatore(String nome, Griglia griglia){
        this.nome = nome;
        this.griglia = new Griglia();
        this.navi = new ArrayList<Nave>();
    }

    protected void aggiungiNave(String nome, int lunghezza, int x, int y, PuntiCardinali orientamento){
        Nave nuovaNave = new Nave(nome, lunghezza, x, y, orientamento);
        this.navi.add(nuovaNave);
    }
    
    
}