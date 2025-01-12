public class Griglia {
    private int righe=10;
    private int colonne=7;
    private int numeroCelleNavi;
    private int numeroCelleNaviAssegnabili;

    Cella [][] griglia= new Cella[righe][colonne];
    public Griglia(){
        inizializzaGriglia();
        numeroCelleNavi=16;
        numeroCelleNaviAssegnabili=16;
    }
    private void inizializzaGriglia(){
        for(int i=0; i<righe; i++){
            for(int j=0; j<colonne; j++){
                griglia[i][j]=new Cella();
            }
        }
    }
    public void printGriglia(){
        for(int i=0; i<righe; i++){
            for(int j=0; j<colonne; j++){
                if(i==0 && j!=0){
                    griglia[i][j].printCellaIndice(j);

                }else if(j==0 && i!=0){
                    griglia[i][j].printCellaIndice(i);

                }else if(j==0 && i==0){
                    griglia[i][j].printCellaIndice(-44);

                }else{
                    griglia[i][j].printCella();
                }
            }
            System.out.println();
        }
    }
    //sistema oper inserire e colpire una cella con relativi errori 
    private boolean checkNumeriCorretti(int rigaInizio,int colonnaInizio){
        if((rigaInizio>0 && rigaInizio<10) && (colonnaInizio>0 && colonnaInizio<7)){
            return true;

        }else{
            System.out.println("Hai inserito dei numeri che non stanno nel campo da gioco, reinserisci");
            return false;
        }
    }    
    public boolean setCellaColpita(int rigaInizio,int colonnaInizio){
        if(!checkNumeriCorretti(rigaInizio, colonnaInizio)){
            System.out.println("Coordinate non valide, reinseriscile");
            return false;
        }

        if(!griglia[rigaInizio][colonnaInizio].getColpito()){
            griglia[rigaInizio][colonnaInizio].setColpito();
            System.out.println("Hai colpito una parte della nave!");

        }else{
            System.out.println("Cella già colpita precedentemente, reinserisci le coordinate");
            return false;
        }

        cambiaStatoCella(rigaInizio, colonnaInizio);
        return true;
    }
    private void cambiaStatoCella(int rigaInizio, int colonnaInizio){
        if(griglia[rigaInizio][colonnaInizio].getColpito() && griglia[rigaInizio][colonnaInizio].getAssegnato()){
            numeroCelleNavi--;
        }
    }

    //fine delle righe per il sistema di attaco di una cella 
    private int sceltaNave(){
        if(numeroCelleNaviAssegnabili==16){
            numeroCelleNaviAssegnabili=numeroCelleNaviAssegnabili-5;
            return 5;

        }else if(numeroCelleNaviAssegnabili==11 || numeroCelleNaviAssegnabili == 8){
            numeroCelleNaviAssegnabili=numeroCelleNaviAssegnabili-3;
            return 3;

        }else if(numeroCelleNaviAssegnabili==5 || numeroCelleNaviAssegnabili==3){
            numeroCelleNaviAssegnabili=numeroCelleNaviAssegnabili-2;
            return 2;

        }else if(numeroCelleNaviAssegnabili==1){
            numeroCelleNaviAssegnabili--;
            return 1;
        }
        return numeroCelleNaviAssegnabili;

    }
    public void inserisciNavi(){
        do{
            int naveDaAssegnare=sceltaNave();
            posizionaNave(naveDaAssegnare);
        }while(numeroCelleNaviAssegnabili!=0);

    }

    //controlli per l'inserimento quindi la configurazione della nave
    private boolean checkPosizione(int rigaInizio, int colonnaInizio, int rigaFine, int colonnaFine, int naveDaAssegnare){
        if((rigaInizio != rigaFine) && (colonnaInizio != colonnaFine) ){
            System.out.println("Le due coordinate non hanno ne la stessa riga, ne la stessa colonna, reinserisci");
            return false;

        }
        if(naveDaAssegnare!=1){
            if((rigaInizio == rigaFine) && (colonnaInizio == colonnaFine)){
                System.out.println("Hai inserito due coordinate uguali, reinserisci");
                return false;

            }
        }else if(naveDaAssegnare==1){
            if((rigaInizio == rigaFine) && (colonnaInizio == colonnaFine)){
                return true;

            }
        }
        if((rigaInizio==rigaFine) && (colonnaInizio!=colonnaFine)){
            return true;

        }
        if((rigaInizio!=rigaFine) && (colonnaInizio==colonnaFine)){
            return true;
        }
        return false;
    }

    private boolean checkDistanza(int rigaInizio,int colonnaInizio,int rigaFine,int colonnaFine, int naveDaAssegnare){
        int distanza=0;
        if(naveDaAssegnare!=1){
            if(rigaInizio==rigaFine){
                if(colonnaInizio<colonnaFine){
                    distanza=colonnaFine-colonnaInizio+1;

                }else{
                    distanza=colonnaInizio-colonnaFine+1;
                }

            }else if(colonnaInizio==colonnaFine){
                if(rigaInizio<rigaFine){
                    distanza=rigaFine-rigaInizio+1;

                }else{
                    distanza=rigaInizio-rigaFine+1;
                }
            }
        }else{
            if((rigaInizio == rigaFine) && (colonnaInizio == colonnaFine)){
                return true;
            }
        }
       
        if(distanza==naveDaAssegnare){
            return true;

        }else{
            System.out.println("Le coordinate inserite non hanno la giusta distanza, quest'ultima dev'essere uguale a "+naveDaAssegnare);
            return false;
        }
    }

    private boolean checkAssegnamento(int rigaInizio,int colonnaInizio,int rigaFine,int colonnaFine, int naveDaAssegnare){
        if(naveDaAssegnare!=1){
            if(rigaInizio == rigaFine){
                if(colonnaInizio<colonnaFine){
                    for(int j=colonnaInizio; j<=colonnaFine; j++){
                        if(griglia[rigaInizio][j].getAssegnato()){
                            System.out.println("Una delle celle da assegnare alla nave è gia assegnata, reinserisci");
                            return false;

                        }else{
                            griglia[rigaInizio][j].setAssegnato();
                        }
                    }
                }else{
                    for(int j=colonnaFine; j<=colonnaInizio; j++){
                        if(griglia[rigaInizio][j].getAssegnato()){
                            System.out.println("Una delle celle da assegnare alla nave è gia assegnata, reinserisci");
                            return false;
                        }else{
                            griglia[rigaInizio][j].setAssegnato();
                        }
                    }
                }
            }

            if(colonnaInizio == colonnaFine){
                if(rigaInizio<rigaFine){
                    for(int j=rigaInizio; j<=rigaFine; j++){
                        if(griglia[rigaInizio][j].getAssegnato()){
                            System.out.println("Una delle celle da assegnare alla nave è gia assegnata");
                            
                            return false;
                        }else{
                            griglia[colonnaInizio][j].setAssegnato();
                        }
                    }

                }else{
                    for(int j=rigaFine; j<=rigaInizio; j++){
                        if(griglia[colonnaInizio][j].getAssegnato()){
                            System.out.println("Una delle celle da assegnare alla nave è gia assegnata");
                            return false;

                        }else{
                            griglia[colonnaInizio][j].setAssegnato();
                        }
                    }
                }
            }
        }else{
            if(!griglia[rigaInizio][colonnaInizio].getAssegnato()){
                griglia[rigaInizio][colonnaInizio].setAssegnato();

            }else{
                return false;
            }
        }
        return true;
    }
    //fine della zezione per il controllo delle coordinat per quanto riguarda il posizionamento 
    //funzione per controllare il corretto posizionamento della nave 
    private boolean checkCoordinateCorrette(int rigaInizio,int colonnaInizio,int rigaFine,int colonnaFine, int naveDaAssegnare){
        if(!(checkNumeriCorretti(rigaInizio,colonnaInizio) && checkNumeriCorretti(rigaFine,colonnaFine))){
            return false;
        }

        if(!checkPosizione(rigaInizio,colonnaInizio,rigaFine,colonnaFine,naveDaAssegnare)){
            return false;
        }

        if(!checkDistanza(rigaInizio,colonnaInizio,rigaFine,colonnaFine,naveDaAssegnare)){
            return false;
        }

        if(!checkAssegnamento(rigaInizio, colonnaInizio, rigaFine, colonnaFine, naveDaAssegnare)){
            return false;
        }
        return true;
    }
    
    //funzione derivante per il posizionamento della nave che prende le coordinate e le spedisce al controllo con checkcoordinatecorrette
    private void posizionaNave(int naveDaAssegnare){
        int rigaInizio=0;
        int colonnaInizio=0;
        int rigaFine=0;
        int colonnaFine=0;

        do {
            System.out.println("Inserisci la prima coordinata x e y per l'inizio della nave, dimensione: "+naveDaAssegnare);
            System.out.println("Ricorda, per il corretto assegnamento o la colonna o la riga devono essere uguali, perchè la nave non può essere assegnata in diagonale");
            System.out.print("Inserisci la coordinata della prima riga:");
            rigaInizio=Leggi.unInt();

            System.out.print("Inserisci la coordinata della prima colonna:");
            colonnaInizio=Leggi.unInt();

            System.out.print("Inserisci la coordinata della seconda riga:");
            rigaFine=Leggi.unInt();

            System.out.print("Inserisci la coordinata della seconda colonna:");
            colonnaFine=Leggi.unInt();

        } while (!checkCoordinateCorrette(rigaInizio,colonnaInizio,rigaFine,colonnaFine,naveDaAssegnare));
    }
    
    //funzione per vedere se il giocatore hga perso, tramite la griglia che conta la qunatita di celle 
    public boolean haPerso(){
        if(numeroCelleNavi==0){
            return true;
        }else{
            return false;
        }
    }
}
