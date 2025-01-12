public class Utente {
    Griglia grigliaGiocatore = new Griglia();
    String nome;
    GestoreAccesso gestoreAccesso;


    public Utente(GestoreAccesso gestoreAccesso){
        this.gestoreAccesso = gestoreAccesso;
        chiediNomeGiocatore();
        inizializzazione();
    }

    private void chiediNomeGiocatore(){
        System.out.print("Inserisci il nome del giocatore: ");
        this.nome = Leggi.unoString();

        //Verifica se il giocatore esiste già nel sistema
        if (!gestoreAccesso.accediGiocatore(nome)) {
            System.out.println("Giocatore non registrato! Procedo con la registrazione...");
            gestoreAccesso.registraGiocatoreInterattivo(nome);
        }
    }

    public void inizializzazione(){
        grigliaGiocatore.inserisciNavi();
    }

    private void attacco(){
        int riga=0;
        int colonna=0;
        
        do{
            System.out.print("Inserisci la riga che vuoi bersagliare:");
            riga = Leggi.unInt();

            System.out.print("Inserisci la colonna che vuoi bersagliare:");
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

    public void salvaVittoria(){
        gestoreAccesso.salvaVittoria(nome);
    }

    public String getNome(){
        return nome;
    }
}
