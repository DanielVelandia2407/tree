import java.util.ArrayList;
import java.util.List;

/**
 - Mostrar ruta
 */
class RutaCorrupta {
    private List<Politico> ruta;
    private int valorTotal;

    public RutaCorrupta() {
        this.ruta = new ArrayList<>();
        this.valorTotal = 0;
    }

    public RutaCorrupta(List<Politico> ruta, int valorTotal) {
        this.ruta = new ArrayList<>(ruta);
        this.valorTotal = valorTotal;
    }

    public void agregarPolitico(Politico politico) {
        ruta.add(politico);
        valorTotal += politico.getValorCorrupcion();
    }

    public List<Politico> getRuta() { return new ArrayList<>(ruta); }
    public int getValorTotal() { return valorTotal; }
    public int getTamaño() { return ruta.size(); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dinero robado ").append(valorTotal).append("\n");
        sb.append("Estructura: \n");

        for (int i = 0; i < ruta.size(); i++) {
            String indentacion = " ".repeat(i);
            String flecha = i > 0 ? "└─ " : "";
            sb.append(indentacion).append(flecha).append(ruta.get(i)).append("\n");
        }

        return sb.toString();
    }
}
