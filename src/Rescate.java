public class Rescate implements Runnable{

    private Balsa embarcacion;
    private Barco navio;

    public Rescate(Balsa embarcacion, Barco navio) {
        this.embarcacion = embarcacion;
        this.navio = navio;
    }

    @Override
    public void run() {
        while(true){}
    }
}
