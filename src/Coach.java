public class Coach extends Boost implements Duracion{
    private String rango;
    private int duracion=0;

    public Coach(String nombre) {
        super(nombre);
    }

    @Override
    public void sumarDuracion() {
        duracion++;
    }

    @Override
    public void restarDuracion() {
         duracion--;
    }
}
