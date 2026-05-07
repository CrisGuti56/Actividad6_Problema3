package Observatorio;

import java.util.Comparator;

public class ComparadorPorPeriodo implements Comparator<Observacion> {

    @Override
    public int compare(Observacion o1, Observacion o2) {
        return o1.getPeriodo().compareToIgnoreCase(o2.getPeriodo());
    }
}