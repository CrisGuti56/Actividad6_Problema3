package Observatorio;

public class Desplazamiento {

    private double latitudDelta;
    private double longitudDelta;
    private double distanciaDelta;

    public Desplazamiento(double latitudDelta, double longitudDelta, double distanciaDelta) {
        this.latitudDelta = latitudDelta;
        this.longitudDelta = longitudDelta;
        this.distanciaDelta = distanciaDelta;
    }

    public double getLatitudDelta() {
        return latitudDelta;
    }

    public double getLongitudDelta() {
        return longitudDelta;
    }

    public double getDistanciaDelta() {
        return distanciaDelta;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Desplazamiento d = (Desplazamiento) obj;

        return Double.compare(latitudDelta, d.latitudDelta) == 0 &&
                Double.compare(longitudDelta, d.longitudDelta) == 0 &&
                Double.compare(distanciaDelta, d.distanciaDelta) == 0;
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(latitudDelta);
        result = 31 * result + Double.hashCode(longitudDelta);
        result = 31 * result + Double.hashCode(distanciaDelta);
        return result;
    }

    @Override
    public String toString() {
        return "Observatorio.Desplazamiento:\n" +
                "  -Latitud Delta: " + latitudDelta + "\n" +
                "  -Longitud Delta: " + longitudDelta + "\n" +
                "  -Distancia Delta: " + distanciaDelta + "\n";
    }
}