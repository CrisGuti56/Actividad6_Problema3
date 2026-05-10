package Observatorio;

import Observatorio.excepciones.ExcepcionDeDistanciaInvalida;
import Observatorio.excepciones.ExcepcionDeObservacionInvalida;
import Observatorio.excepciones.ExcepcionDePeriodoInvalido;

import java.util.Arrays;
import java.util.List;

public class Observacion implements Comparable<Observacion> {

    private String periodo;
    private double distancia;
    private String unidadDistancia;
    private Ubicacion ubicacion;

    private static final List<String> MESES_VALIDOS = Arrays.asList(
            "enero", "febrero", "marzo", "abril", "mayo", "junio",
            "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"
    );

    public Observacion(String periodo, double distancia, String unidadDistancia, Ubicacion ubicacion)
            throws ExcepcionDePeriodoInvalido,
            ExcepcionDeDistanciaInvalida {

        if (periodo == null || periodo.trim().isEmpty())
            throw new ExcepcionDePeriodoInvalido("El período no puede ser nulo o vacío.");

        if (!MESES_VALIDOS.contains(periodo.trim().toLowerCase()))
            throw new ExcepcionDePeriodoInvalido(
                    "El período debe ser un mes válido. Se recibió: " + periodo);

        if (distancia <= 0)
            throw new ExcepcionDeDistanciaInvalida(
                    "La distancia debe ser mayor a 0. Se recibió: " + distancia);

        this.periodo = periodo;
        this.distancia = distancia;
        this.unidadDistancia = unidadDistancia;
        this.ubicacion = ubicacion;
    }

    public String getPeriodo() { return periodo; }
    public double getDistancia() { return distancia; }
    public String getUnidadDistancia() { return unidadDistancia; }
    public Ubicacion getUbicacion() { return ubicacion; }

    public Desplazamiento obtenerDesplazamiento(Observacion observacionComparada)
            throws ExcepcionDeObservacionInvalida {

        if (observacionComparada == null)
            throw new ExcepcionDeObservacionInvalida("La observación comparada no puede ser null.");

        double lat1 = this.ubicacion.getHemisferioLatitudinal().equalsIgnoreCase("S")
                ? -this.ubicacion.getLatitud() : this.ubicacion.getLatitud();
        double lat2 = observacionComparada.getUbicacion().getHemisferioLatitudinal().equalsIgnoreCase("S")
                ? -observacionComparada.getUbicacion().getLatitud() : observacionComparada.getUbicacion().getLatitud();
        double lon1 = this.ubicacion.getHemisferioLongitudinal().equalsIgnoreCase("O")
                ? -this.ubicacion.getLongitud() : this.ubicacion.getLongitud();
        double lon2 = observacionComparada.getUbicacion().getHemisferioLongitudinal().equalsIgnoreCase("O")
                ? -observacionComparada.getUbicacion().getLongitud() : observacionComparada.getUbicacion().getLongitud();

        return new Desplazamiento(lat1 - lat2, lon1 - lon2, this.distancia - observacionComparada.getDistancia());
    }

    @Override
    public int compareTo(Observacion otra) {
        int r = 0;
        if ((r = Double.compare(this.distancia, otra.distancia)) != 0) return r;
        if ((r = this.periodo.compareToIgnoreCase(otra.periodo)) != 0) return r;
        if ((r = this.unidadDistancia.compareToIgnoreCase(otra.unidadDistancia)) != 0) return r;
        if ((r = Double.compare(this.ubicacion.getLatitud(), otra.ubicacion.getLatitud())) != 0) return r;
        return Double.compare(this.ubicacion.getLongitud(), otra.ubicacion.getLongitud());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Observacion o = (Observacion) obj;
        return Double.compare(distancia, o.distancia) == 0 &&
                periodo.equalsIgnoreCase(o.periodo) &&
                unidadDistancia.equalsIgnoreCase(o.unidadDistancia) &&
                ubicacion.equals(o.ubicacion);
    }

    @Override
    public int hashCode() {
        int result = periodo.toLowerCase().hashCode();
        result = 31 * result + Double.hashCode(distancia);
        result = 31 * result + unidadDistancia.toLowerCase().hashCode();
        result = 31 * result + ubicacion.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Observatorio.Observacion:\n" +
                "  Periodo: " + periodo + "\n" +
                "  Distancia: " + distancia + " " + unidadDistancia + "\n" +
                ubicacion;
    }
}