public class eloboost extends Boost implements Duracion{
    private float multiplicador;
    private int duracion=0;

    public eloboost(String nombre) {
        super(nombre);
    }
    public float getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(float multiplicador) {
        this.multiplicador = multiplicador;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
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
