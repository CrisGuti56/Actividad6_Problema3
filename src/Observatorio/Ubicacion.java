package Observatorio;

import Observatorio.excepciones.ExcepcionDeHemisferioInvalido;
import Observatorio.excepciones.ExcepcionDeLatitudInvalida;
import Observatorio.excepciones.ExcepcionDeLongitudInvalida;

public class Ubicacion {

    private double latitud;
    private String hemisferioLatitudinal;
    private double longitud;
    private String hemisferioLongitudinal;

    private static final double LATITUD_MINIMA  = 0;
    private static final double LATITUD_MAXIMA  = 180;
    private static final double LONGITUD_MINIMA = 0;
    private static final double LONGITUD_MAXIMA = 180;

    public Ubicacion(double latitud, String hemisferioLatitudinal,
                     double longitud, String hemisferioLongitudinal)
            throws ExcepcionDeLatitudInvalida,
            ExcepcionDeLongitudInvalida,
            ExcepcionDeHemisferioInvalido {

        if (latitud < LATITUD_MINIMA || latitud > LATITUD_MAXIMA)
            throw new ExcepcionDeLatitudInvalida(
                    "La latitud debe estar entre " + LATITUD_MINIMA + " y " + LATITUD_MAXIMA + "°. Se recibió: " + latitud);

        if (longitud < LONGITUD_MINIMA || longitud > LONGITUD_MAXIMA)
            throw new ExcepcionDeLongitudInvalida(
                    "La longitud debe estar entre " + LONGITUD_MINIMA + " y " + LONGITUD_MAXIMA + "°. Se recibió: " + longitud);

        if (!hemisferioLatitudinal.equalsIgnoreCase("N") && !hemisferioLatitudinal.equalsIgnoreCase("S"))
            throw new ExcepcionDeHemisferioInvalido(
                    "El hemisferio latitudinal solo puede ser 'N' o 'S'. Se recibió: " + hemisferioLatitudinal);

        if (!hemisferioLongitudinal.equalsIgnoreCase("E") && !hemisferioLongitudinal.equalsIgnoreCase("O"))
            throw new ExcepcionDeHemisferioInvalido(
                    "El hemisferio longitudinal solo puede ser 'E' u 'O'. Se recibió: " + hemisferioLongitudinal);

        this.latitud = latitud;
        this.hemisferioLatitudinal = hemisferioLatitudinal;
        this.longitud = longitud;
        this.hemisferioLongitudinal = hemisferioLongitudinal;
    }

    public double getLatitud() { return latitud; }
    public String getHemisferioLatitudinal() { return hemisferioLatitudinal; }
    public double getLongitud() { return longitud; }
    public String getHemisferioLongitudinal() { return hemisferioLongitudinal; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ubicacion u = (Ubicacion) obj;
        return Double.compare(latitud, u.latitud) == 0 &&
                Double.compare(longitud, u.longitud) == 0 &&
                hemisferioLatitudinal.equalsIgnoreCase(u.hemisferioLatitudinal) &&
                hemisferioLongitudinal.equalsIgnoreCase(u.hemisferioLongitudinal);
    }

    @Override
    public int hashCode() {
        int result = Double.hashCode(latitud);
        result = 31 * result + Double.hashCode(longitud);
        result = 31 * result + hemisferioLatitudinal.toLowerCase().hashCode();
        result = 31 * result + hemisferioLongitudinal.toLowerCase().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Observatorio.Ubicacion:\n" +
                "  Latitud: " + latitud + "° " + hemisferioLatitudinal + "\n" +
                "  Longitud: " + longitud + "° " + hemisferioLongitudinal + "\n";
    }
}