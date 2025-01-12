public class Utente {
    Griglia grigliaGiocatore = new Griglia();
    public Utente(){
        inizializzazione();
    }
    public void inizializzazione(){
        grigliaGiocatore.inserisciNavi();
    }
    private void attacco(){
        int riga=0;
        int colonna=0;
        
        do{
            System.out.println("inserisci la riga che vuoi bersagliare");
            riga = Leggi.unInt();
            System.out.println("inserisci la colonna che vuoi bersagliare");
            colonna = Leggi.unInt();
        }while(!grigliaGiocatore.setCellaColpita(riga,colonna));
    }
    public void azioniGiocatore(){
        grigliaGiocatore.printGriglia();
        attacco();
    }
    public boolean haPerso(){
        return grigliaGiocatore.haPerso();
    }
}
