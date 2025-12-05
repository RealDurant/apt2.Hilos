import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Barco {
    private List<Pasajero> listaOcupantes;
    private Semaphore controlAcceso;

    public Barco(List<Pasajero> listaOcupantes) {
        this.listaOcupantes = new ArrayList<>(listaOcupantes);
        this.controlAcceso = new Semaphore(1); // Semáforo binario
    }

    public List<Pasajero> rescatar(int plazasSolicitadas) {
        List<Pasajero> grupoSalvado = new ArrayList<>();

        try {
            controlAcceso.acquire();

            int contador = 0;

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

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            controlAcceso.release(); // SALE de la sección crítica
        }

        return grupoSalvado;
    }

    public int ocupantesPendientes() {
        try {
            controlAcceso.acquire();
            return listaOcupantes.size();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return -1;
        } finally {
            controlAcceso.release();
        }
    }
}
