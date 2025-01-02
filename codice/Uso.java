
class Uso{
    public static void main(String[] args) {
        Nave nave = new Nave("Battello", 3, 5, 5, PuntiCardinali.EST);

        //si
        nave.setStato(6, 5);
        System.out.println("Colpo 1: Colpita? " + nave.colpita(6, 5));

        //no
        nave.setStato(9, 5);
        System.out.println("Colpo 2: Colpita? " + nave.colpita(9, 5));

        //si
        nave.setStato(5, 5);
        System.out.println("Colpo 3: Colpita? " + nave.colpita(5, 5));

        //no
        System.out.println("La nave è affondata? " + nave.eAffondata());

        //si
        nave.setStato(7, 5);
        System.out.println("Colpo 4: Colpita? " + nave.colpita(7, 5));

        //si
        System.out.println("La nave è affondata? " + nave.eAffondata());
    }
}



