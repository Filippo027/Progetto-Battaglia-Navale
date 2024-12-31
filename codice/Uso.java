
class Uso{
    public static void main(String[] args){
        Nave n = new Nave("portaerei", 4, 3, 3, PuntiCardinali.NORD);
        System.out.println(n);

        boolean c = n.colpita(n, 3, 3);
        System.out.println(c);
        boolean a = n.eAffondata();
        System.out.println(a);

        for(int i = 0; i < 4; i++){
            System.out.println(n.stato[i]);
        }
    }
}



