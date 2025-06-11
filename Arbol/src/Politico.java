/**
 * - Politicos
 */
class Politico {
    private int valorCorrupcion;
    private boolean aceptaSoborno;
    private Politico izquierdo;
    private Politico derecho;
    private String nombre;

    public Politico(String nombre, int valorCorrupcion, boolean aceptaSoborno) {
        this.nombre = nombre;
        this.valorCorrupcion = valorCorrupcion;
        this.aceptaSoborno = aceptaSoborno;
        this.izquierdo = null;
        this.derecho = null;
    }

    // Getters y Setters
    public int getValorCorrupcion() {
        return valorCorrupcion;
    }

    public boolean aceptaSoborno() {
        return aceptaSoborno;
    }

    public Politico getIzquierdo() {
        return izquierdo;
    }

    public Politico getDerecho() {
        return derecho;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIzquierdo(Politico izquierdo) {
        this.izquierdo = izquierdo;
    }

    public void setDerecho(Politico derecho) {
        this.derecho = derecho;
    }

    public boolean esHoja() {
        return izquierdo == null && derecho == null;
    }

    @Override
    public String toString() {
        return String.format("%s (Corrupción: $%d, Acepta soborno: %s)",
                nombre, valorCorrupcion, aceptaSoborno ? "Sí" : "No");
    }
}
