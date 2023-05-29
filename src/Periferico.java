public class Periferico {
    private int nivel=0;
    String nombre;
    Boolean gold=false;

    public Periferico(String nombre) {
        this.nivel = 0;
        this.nombre = nombre;
        this.gold = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getGold() {
        return gold;
    }

    public void setGold(Boolean gold) {
        this.gold = gold;
    }


    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void subirNivel(){
        if(nivel<=4){nivel++;}
    }
}
