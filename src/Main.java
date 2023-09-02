import model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Mela mela = new Mela(1);
        Pesca pesca = new Pesca(3);
        Arancia arancia = new Arancia(2);

        ArrayList<Frutta> frutta = new ArrayList<>();
        frutta.add(mela);
        frutta.add(pesca);
        frutta.add(arancia);

        Cesto<Frutta> cesto = new Cesto<>(frutta);

        Pesca pesca2 = new Pesca(2);
        Pesca pesca3= new Pesca(3);

        Cesto<Pesca> cestoPesca = new Cesto<>(List.of(pesca2,pesca3));



        ArrayList<Cesto<?>> cesti = new ArrayList<>();
        cesti.add(cesto);
        cesti.add(cestoPesca);

        /*
        for (Cesto<?> cesto1 : cesti) {
            for (Frutta frutta1 : cesto1.getElencoFrutti()) {
                System.out.println(frutta1.getClass().getName() + "\n" + frutta1.getPeso() + "\n" + frutta1.toString());
            }
        }
        */

        for (Cesto<?> cesto1 : cesti) {
            for (Frutta frutta1 : cesto1.getElencoFrutti()) {
                if (frutta1 instanceof Pesca pesca1) {
                    System.out.println(pesca1.getPeso() + " " + pesca1.getClass().getName() + " " + pesca1);
                }
            }
        }


    }
}