package model;



import exc.PesoExc;

import java.util.ArrayList;
import java.util.List;

public class Cesto <T extends Frutta>{

    private List<T> elencoFrutti = new ArrayList<>();
    private int peso = 0;


    public Cesto(List<T> elencoFrutti) {
        this.elencoFrutti = elencoFrutti;
    }

    public List<T> getElencoFrutti() {
        return elencoFrutti;
    }

    public void setElencoFrutti(List<T> elencoFrutti) {
        this.elencoFrutti = elencoFrutti;
    }

    public int getPesoTot() {
        int ris = 0;
        for(T frutto : elencoFrutti) {
            ris += frutto.getPeso();
        }
        return ris;
    }

    public boolean aggiungi(T frutto) {
        if(peso + frutto.getPeso() > 5) {
            try {
                throw new PesoExc("il cesto puo solo sopportare 5 kg");
            } catch (PesoExc e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(frutto.getClass().getName());
        return elencoFrutti.add(frutto);
    }
}
