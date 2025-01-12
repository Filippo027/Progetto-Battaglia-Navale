public class GameManager {
    Utente giocatore1=new Utente();
    Utente giocatore2=new Utente();
    int turno=0;
    public void gestioneGioco(){
        while(!(giocatore1.haPerso() && giocatore2.haPerso())){
            if(turno%2==0){
                giocatore1.azioniGiocatore();
            }else{
                giocatore2.azioniGiocatore();
            }
            turno++;
        }
        if(giocatore1.haPerso()){
            System.out.println("ha vinito il giocatore 2 ");
        }else{
            System.out.println("ha vinto il giocatore 1 ");
        }
    }
}
