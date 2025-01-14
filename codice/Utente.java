public class Utente {
    Griglia grigliaGiocatore = new Griglia();
    String nome;
    String password;
    GestoreAccesso gestoreAccesso;


    public Utente(GestoreAccesso gestoreAccesso){
        this.gestoreAccesso = gestoreAccesso;
        chiediNomeGiocatore();
    }

    private void chiediNomeGiocatore(){
        System.out.print("Inserisci il nome del giocatore: ");
        this.nome = Leggi.unoString();

        System.out.print("Inserisci la password per il giocatore: ");
        this.password = Leggi.unoString();

        //Verifica se il giocatore esiste già nel sistema
        if (!gestoreAccesso.accediGiocatore(nome, password)) {
            System.out.println("Giocatore non trovato! Procedo con la registrazione...");
            gestoreAccesso.registraGiocatoreInterattivo(nome, password);
        }
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
        //grigliaGiocatore.inserisciNavi();
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
