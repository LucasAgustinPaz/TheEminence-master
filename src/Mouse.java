public class Mouse extends Periferico{
    Boolean sensorOptico = false;

    public Mouse(String nombre, Boolean sensorOptico) {
        super(nombre);
        this.sensorOptico = sensorOptico;
    }
}
