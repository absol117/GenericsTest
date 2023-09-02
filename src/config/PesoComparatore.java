package config;

import model.Frutta;

import java.util.Comparator;

public class PesoComparatore implements Comparator<Frutta> {

    @Override
    public int compare(Frutta o1, Frutta o2) {
        return Integer.compare(o1.getPeso(), o2.getPeso());
    }
}
