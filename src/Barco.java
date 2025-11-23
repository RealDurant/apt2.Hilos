import java.util.ArrayList;
import java.util.List;

public class Barco {

    private List<Pasajero> listaOcupantes;

    public Barco(List<Pasajero> listaOcupantes) {
        this.listaOcupantes = new ArrayList<>(listaOcupantes);
    }

}
