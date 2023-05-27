public class Periferico {
    private int nivel=0;
    String nombre;

    public Periferico(String nombre) {
        this.nivel = 0;
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void subirNivel(){
        nivel++;
    }
}
