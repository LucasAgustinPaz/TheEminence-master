public class Periferico extends Boost {
    Boolean gold = false;

    public Periferico(String nombre) {
        super(nombre);
    }


    public Boolean getGold() {
        return gold;
    }

    public void setGold(Boolean gold) {
        this.gold = gold;
    }


    public void subirNivel() {
        if (getNivel() <= 4) {
            int aux = getNivel();
            setNivel(aux++);
        }
    }
}
