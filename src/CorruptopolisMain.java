/**
 * - El Árbol 🌳de la Corrupción 💰: Un Cuento de Políticos y Sobornos
 */
public class CorruptopolisMain {

    public static void main(String[] args) {
        System.out.println("En el mágico y sombrío reino macondiano de Corruptópolis, los polirratas no se miden por su ética, \nsino por su habilidad para sobornar sin que los pillen o logren inculpar, el objetivo es mantener la etiqueta de \"buenos muchachos\". ");
        ArbolCorrupcion arbol = crearEscenarioEjemplo();

// Mostrar la estructura del árbol
        arbol.mostrarEstructuraArbol();

// Encontrar y mostrar la ruta más corrupta
        System.out.println("\nSi acepta sobornos: Es el camino trazado desde 1492 y Sigue la cadena de corrupción.");

        RutaCorrupta rutaMasCorrupta = arbol.encontrarRutaMasCorrupta();

        if (rutaMasCorrupta.getTamaño() > 0) {
            System.out.println("Ruta corrupta");
            System.out.println(rutaMasCorrupta);

            System.out.println("Resumen:");
            System.out.println("Políticos involucrados: " + rutaMasCorrupta.getTamaño());
            System.out.println("Dinero público robado: $" + rutaMasCorrupta.getValorTotal());
        }

        // Mostrar análisis completo
        arbol.mostrarTodasLasRutas();
    }

    /**
     * Data prueba
     */
    private static ArbolCorrupcion crearEscenarioEjemplo() {
        // Raíz
        Politico elJefazo = new Politico("El Jefazo Supremo", 1000000, true);

        // Nodo conexión
        Politico ministroLeal = new Politico("Ministro Leal", 500000, true);
        Politico ministroAmbicioso = new Politico("Ministro Ambicioso", 750000, true);

        // Tercer nivel
        Politico secretarioHonesto = new Politico("Secretario Honesto", 100000, false);
        Politico secretarioCodicioso = new Politico("Secretario Codicioso", 300000, true);
        Politico directorCorrupto = new Politico("Director Corrupto", 400000, true);
        Politico asesorInutil = new Politico("Asesor Inútil", -50000, true); // Perdió dinero

        // Cuarto nivel (hojas)
        Politico lamebotas1 = new Politico("Lamebotas Número 1", 50000, true);
        Politico lamebotas2 = new Politico("Lamebotas Número 2", 75000, true);
        Politico lamebotas3 = new Politico("Lamebotas Número 3", 25000, true);

        elJefazo.setIzquierdo(ministroLeal);
        elJefazo.setDerecho(ministroAmbicioso);

        ministroLeal.setIzquierdo(secretarioHonesto);
        ministroLeal.setDerecho(secretarioCodicioso);

        ministroAmbicioso.setIzquierdo(directorCorrupto);
        ministroAmbicioso.setDerecho(asesorInutil);

        secretarioCodicioso.setIzquierdo(lamebotas1);
        directorCorrupto.setDerecho(lamebotas2);
        asesorInutil.setIzquierdo(lamebotas3);

        return new ArbolCorrupcion(elJefazo);
    }
}
