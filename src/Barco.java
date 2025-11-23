import java.util.ArrayList;
import java.util.List;

public class Barco {

    private List<Pasajero> listaOcupantes;

    public Barco(List<Pasajero> listaOcupantes) {
        this.listaOcupantes = new ArrayList<>(listaOcupantes);
    }
    public  List<Pasajero> rescatar(int plazasSolicitadas) {
        List<Pasajero> grupoSalvado = new ArrayList<>();
        int contador = 0;

        // Prioridades de 1 a 4
        for (int nivel = 1; nivel <= 4 && contador < plazasSolicitadas; nivel++) {
            for (int i = 0; i < listaOcupantes.size() && contador < plazasSolicitadas; i++) {
                if (listaOcupantes.get(i).getNivelPrioridad() == nivel) {
                    grupoSalvado.add(listaOcupantes.get(i));
                    listaOcupantes.remove(i);
                    i--;
                    contador++;
                }
            }
        }

        return grupoSalvado;
    }
}
