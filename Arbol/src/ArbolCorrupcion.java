import java.util.ArrayList;
import java.util.List;

/**
 * - Árbol Binario
 */
public class ArbolCorrupcion {
    private Politico raiz;

    public ArbolCorrupcion(Politico jefazo) {
        this.raiz = jefazo;
    }

    /**
     * - Ruta 1: No todos aceptan sobornos
     */
    public RutaCorrupta encontrarRutaMasCorrupta() {
        if (raiz == null) {
            System.out.println("No hubo politico corrupto");
            return new RutaCorrupta();
        }

        List<RutaCorrupta> todasLasRutas = new ArrayList<>();
        List<Politico> rutaActual = new ArrayList<>();

        explorarRutas(raiz, rutaActual, todasLasRutas);

        if (todasLasRutas.isEmpty()) {
            System.out.println("No hubo ruta corrupta");
            return new RutaCorrupta();
        }

        // Encontrar la ruta con mas dinero robado
        RutaCorrupta rutaMasCorrupta = todasLasRutas.get(0);
        for (RutaCorrupta ruta : todasLasRutas) {
            if (ruta.getValorTotal() > rutaMasCorrupta.getValorTotal()) {
                rutaMasCorrupta = ruta;
            }
        }
        return rutaMasCorrupta;
    }

    /**
     * - Buscar rutas
     */
    private void explorarRutas(Politico actual, List<Politico> rutaActual, List<RutaCorrupta> todasLasRutas) {
        // Criterio: Si un político no acepta soborno, su rama no cuenta y frena esta hermosa cadena.
        if (!actual.aceptaSoborno()) {
            System.out.println("Cortar rama" + actual.getNombre());
            return;
        }

        // Agregar politico
        rutaActual.add(actual);

        // Si llega a la hoja se completa el arbol
        if (actual.esHoja()) {
            int valorTotal = rutaActual.stream().mapToInt(Politico::getValorCorrupcion).sum();
            todasLasRutas.add(new RutaCorrupta(rutaActual, valorTotal));
        } else {
            if (actual.getIzquierdo() != null) {
                explorarRutas(actual.getIzquierdo(), new ArrayList<>(rutaActual), todasLasRutas);
            }
            if (actual.getDerecho() != null) {
                explorarRutas(actual.getDerecho(), new ArrayList<>(rutaActual), todasLasRutas);
            }
        }
    }

    /**
     * - Rutas encontradas
     */
    public void mostrarTodasLasRutas() {
        List<RutaCorrupta> todasLasRutas = new ArrayList<>();
        List<Politico> rutaActual = new ArrayList<>();

        if (raiz != null) {
            explorarRutas(raiz, rutaActual, todasLasRutas);
        }

        if (todasLasRutas.isEmpty()) {
            System.out.println("No hay rutas");
            return;
        }

        System.out.println("Se encontraron las siguientes rutas: " + todasLasRutas.size());

        for (int i = 0; i < todasLasRutas.size(); i++) {
            System.out.println("\nRuta " + (i + 1));
            System.out.println(todasLasRutas.get(i));
        }
    }

    /**
     * - Arbol
     */
    public void mostrarEstructuraArbol() {
        System.out.println("Arbol");
        if (raiz != null) {
            mostrarNodo(raiz, "", true);
        }
    }

    private void mostrarNodo(Politico nodo, String prefijo, boolean esUltimo) {
        if (nodo != null) {
            System.out.println(prefijo + (esUltimo ? "└── " : "├── ") + nodo);

            String nuevoPrefijo = prefijo + (esUltimo ? " " : "│ ");

            if (nodo.getIzquierdo() != null || nodo.getDerecho() != null) {
                if (nodo.getDerecho() != null) {
                    mostrarNodo(nodo.getDerecho(), nuevoPrefijo, nodo.getIzquierdo() == null);
                }
                if (nodo.getIzquierdo() != null) {
                    mostrarNodo(nodo.getIzquierdo(), nuevoPrefijo, true);
                }
            }
        }
    }
}
