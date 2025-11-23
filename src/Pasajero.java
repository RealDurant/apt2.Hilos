public class Pasajero {

    private int codigo;
    private String categoria;
    private int nivelPrioridad; // 1 = más urgente

    public Pasajero(int codigo, String categoria, int nivelPrioridad) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.nivelPrioridad = nivelPrioridad;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getNivelPrioridad() {
        return nivelPrioridad;
    }

    @Override
    public String toString() {
        return "P" + codigo + "(" + categoria + ", prioridad=" + nivelPrioridad + ")";
    }
}