package Observatorio;

import Observatorio.excepciones.ExcepcionDeCuerpoCelesteInvalido;
import Observatorio.excepciones.ExcepcionDeObservacionInvalida;

import java.util.ArrayList;
import java.util.List;

public class CuerpoCeleste implements Comparable<CuerpoCeleste> {

    private String nombre;
    private String composicion;
    private List<Observacion> observaciones;

    public CuerpoCeleste(String nombre, String composicion)
            throws ExcepcionDeCuerpoCelesteInvalido {

        if (nombre == null || nombre.trim().isEmpty())
            throw new ExcepcionDeCuerpoCelesteInvalido("El nombre del cuerpo celeste no puede ser nulo o vacío.");

        if (composicion == null || composicion.trim().isEmpty())
            throw new ExcepcionDeCuerpoCelesteInvalido("La composición del cuerpo celeste no puede ser nula o vacía.");

        this.nombre = nombre;
        this.composicion = composicion;
        this.observaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getComposicion() {
        return composicion;
    }

    public List<Observacion> getObservaciones() {
        return observaciones;
    }

    public void agregarObservacion(Observacion observacion)
            throws ExcepcionDeObservacionInvalida {

        if (observacion == null)
            throw new ExcepcionDeObservacionInvalida("La observación no puede ser null.");

        observaciones.add(observacion);
    }

    @Override
    public int compareTo(CuerpoCeleste otra) {
        int r = 0;
        if ((r = this.nombre.compareToIgnoreCase(otra.nombre)) != 0)
            return r;
        if ((r = this.composicion.compareToIgnoreCase(otra.composicion)) != 0)
            return r;
        return Integer.compare(this.observaciones.size(), otra.observaciones.size());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CuerpoCeleste c = (CuerpoCeleste) obj;
        return nombre.equalsIgnoreCase(c.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuerpo Celeste:\n");
        sb.append("  Nombre: ").append(nombre).append("\n");
        sb.append("  Composición: ").append(composicion).append("\n");
        sb.append("  Observaciones:\n");
        for (Observacion o : observaciones) {
            sb.append("  -------------------\n");
            sb.append(o).append("\n");
        }
        return sb.toString();
    }
}
