package Observatorio;

import Observatorio.excepciones.*;

public class Prueba {

    public static void main(String[] args) {

        System.out.println("=== 1. Prueba VÁLIDOS ===");
        try {
            Ubicacion u1 = new Ubicacion(10, "N", 20, "E");
            Ubicacion u2 = new Ubicacion(15, "S", 25, "O");
            Observacion obs1 = new Observacion("Enero", 4.5, "años luz", u1);
            Observacion obs2 = new Observacion("Febrero", 4.8, "años luz", u2);
            CuerpoCeleste estrella = new CuerpoCeleste("Alpha-1", "Gas");
            estrella.agregarObservacion(obs1);
            estrella.agregarObservacion(obs2);
            System.out.println("Ubicaciones creadas OK");
            System.out.println("Observaciones creadas OK");
            System.out.println("Cuerpo celeste creado OK");
            System.out.println("Observaciones agregadas OK");
        } catch (Exception e) {
            System.out.println("ERROR Inesperado: " + e.getMessage());
        }

        System.out.println("\n=== 2. Prueba ExcepcionDeLatitudInvalida ===");
        try {
            Ubicacion uMala = new Ubicacion(200, "N", 20, "E");
            System.out.println("ERROR - Debio lanzar excepcion!!");
        } catch (ExcepcionDeLatitudInvalida e) {
            System.out.println("CON - Latitud invalida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR tipo incorrecto: " + e.getMessage());
        }

        System.out.println("\n=== 3. Prueba ExcepcionDeLongitudInvalida ===");
        try {
            Ubicacion uMala = new Ubicacion(10, "N", 500, "E");
            System.out.println("ERROR - Debio lanzar excepcion!!");
        } catch (ExcepcionDeLongitudInvalida e) {
            System.out.println("CON - Longitud invalida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR tipo incorrecto: " + e.getMessage());
        }

        System.out.println("\n=== 4. Prueba ExcepcionDeHemisferioInvalido (latitudinal) ===");
        try {
            Ubicacion uMala = new Ubicacion(10, "X", 20, "E");
            System.out.println("ERROR - Debio lanzar excepcion!!");
        } catch (ExcepcionDeHemisferioInvalido e) {
            System.out.println("CON - Hemisferio invalido: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR tipo incorrecto: " + e.getMessage());
        }

        System.out.println("\n=== 5. Prueba ExcepcionDeHemisferioInvalido (longitudinal) ===");
        try {
            Ubicacion uMala = new Ubicacion(10, "N", 20, "Z");
            System.out.println("ERROR - Debio lanzar excepcion!!");
        } catch (ExcepcionDeHemisferioInvalido e) {
            System.out.println("CON - Hemisferio invalido: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR tipo incorrecto: " + e.getMessage());
        }

        System.out.println("\n=== 6. Prueba ExcepcionDePeriodoInvalido ===");
        try {
            Ubicacion u = new Ubicacion(10, "N", 20, "E");
            Observacion obsMala = new Observacion("", 4.5, "años luz", u);
            System.out.println("ERROR - Debio lanzar excepcion!!");
        } catch (ExcepcionDePeriodoInvalido e) {
            System.out.println("CON - Periodo invalido: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR tipo incorrecto: " + e.getMessage());
        }

        System.out.println("\n=== 7. Prueba ExcepcionDeDistanciaInvalida ===");
        try {
            Ubicacion u = new Ubicacion(10, "N", 20, "E");
            Observacion obsMala = new Observacion("Marzo", -3.0, "años luz", u);
            System.out.println("ERROR - Debio lanzar excepcion!!");
        } catch (ExcepcionDeDistanciaInvalida e) {
            System.out.println("CON - Distancia invalida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR tipo incorrecto: " + e.getMessage());
        }

        System.out.println("\n=== 8. Prueba ExcepcionDeCuerpoCelesteInvalido (nombre vacio) ===");
        try {
            CuerpoCeleste cMalo = new CuerpoCeleste("", "Gas");
            System.out.println("ERROR - Debio lanzar excepcion!!");
        } catch (ExcepcionDeCuerpoCelesteInvalido e) {
            System.out.println("CON - Cuerpo celeste invalido: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR tipo incorrecto: " + e.getMessage());
        }

        System.out.println("\n=== 9. Prueba ExcepcionDeCuerpoCelesteInvalido (composicion vacia) ===");
        try {
            CuerpoCeleste cMalo = new CuerpoCeleste("Beta-1", "");
            System.out.println("ERROR - Debio lanzar excepcion!!");
        } catch (ExcepcionDeCuerpoCelesteInvalido e) {
            System.out.println("CON - Cuerpo celeste invalido: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR tipo incorrecto: " + e.getMessage());
        }

        System.out.println("\n=== 10. Prueba ExcepcionDeObservacionInvalida (agregar null) ===");
        try {
            CuerpoCeleste c = new CuerpoCeleste("Gamma-3", "Roca");
            c.agregarObservacion(null);
            System.out.println("ERROR - Debio lanzar excepcion!!");
        } catch (ExcepcionDeObservacionInvalida e) {
            System.out.println("CON - Observacion invalida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR tipo incorrecto: " + e.getMessage());
        }

        System.out.println("\n=== 11. Prueba ExcepcionDeObservacionInvalida (desplazamiento null) ===");
        try {
            Ubicacion u = new Ubicacion(10, "N", 20, "E");
            Observacion obs = new Observacion("Abril", 5.0, "años luz", u);
            obs.obtenerDesplazamiento(null);
            System.out.println("ERROR - Debio lanzar excepcion!!");
        } catch (ExcepcionDeObservacionInvalida e) {
            System.out.println("CON - Observacion invalida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR tipo incorrecto: " + e.getMessage());
        }
    }
}