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

    protected void aggiungiNave(Nave nave){
        this.navi.add(nave);
    }

    public List<Nave> getNavi() {
        return navi;
    }

    protected boolean spara(Giocatore avvesrasio, int colpoX, int colpoY){
        //Cicla le navi dell'avversario e controlla se una delle navi è stata colpita
        for(Nave nave : avversario.getNavi()){

            if(nave.colpita(colpoX, colpoY)){
                nave.setStato(colpoX, colpoY){
                return true;
                }
            }
        }
        return false;
    }
}