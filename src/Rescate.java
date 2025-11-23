import java.util.List;

public class Rescate implements Runnable{

    private Balsa embarcacion;
    private Barco navio;

    public Rescate(Balsa embarcacion, Barco navio) {
        this.embarcacion = embarcacion;
        this.navio = navio;
    }

    @Override
    public void run() {
        while (true) {
            try {
                // capacidad de la balsa
                List<Pasajero> grupoRescatado = navio.rescatar(embarcacion.getPlazasMaximas());

                if (grupoRescatado.isEmpty()) {
                    // No quedan pasajeros
                    break;
                }

                // número de pasajeros rescatados
                System.out.println("Balsa " + embarcacion.getIdBalsa() +
                        " ha rescatado " + grupoRescatado.size() + " pasajeros");

                // tiempo de rescate
                Thread.sleep((long) (embarcacion.getCicloSegundos() * 1000));

                System.out.println("Balsa regresada: " + embarcacion.getIdBalsa());
            } catch (InterruptedException ex) {
                ex.printStackTrace();

            }
        }
    }
}
