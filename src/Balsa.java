public class Balsa {

    private String idBalsa;
    private int plazasMaximas;
    private double cicloSegundos;

    public Balsa(String idBalsa, int plazasMaximas, double cicloSegundos) {
        this.idBalsa = idBalsa;
        this.plazasMaximas = plazasMaximas;
        this.cicloSegundos = cicloSegundos;
    }
    public String getIdBalsa() {
        return idBalsa;
    }

    public int getPlazasMaximas() {
        return plazasMaximas;
    }

    public double getCicloSegundos() {
        return cicloSegundos;
    }

    @Override
    public String toString() {
        return "Balsa{ idBalsa='" + idBalsa + '\'' +
                ", plazasMaximas=" + plazasMaximas +
                ", cicloSegundos=" + cicloSegundos + " }";
    }
}
