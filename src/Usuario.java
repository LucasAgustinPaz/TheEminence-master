import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Usuario {
    private List<String> skins = new ArrayList<>();
    private int xp=0;
    private int nivel=0;
    private int coins=0;
    private int horasJugadas=0;
    private int torneosJugados=0;
    private String rol;

    public List<String> getSkins() {
        return skins;
    }

    public void setSkins(List<String> skins) {
        this.skins = skins;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getHorasJugadas() {
        return horasJugadas;
    }

    public void setHorasJugadas(int horasJugadas) {
        this.horasJugadas = horasJugadas;
    }

    public int getTorneosJugados() {
        return torneosJugados;
    }

    public void setTorneosJugados(int torneosJugados) {
        this.torneosJugados = torneosJugados;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuario(){
        skins.add("");
        coins=2000;
    }

    public void subirNivel(){
        nivel++;
    }

    public void subirXP(int mount){
        xp += mount;
    }
    public void agregarSkin(String nueva){
        skins.add(nueva);
    }
    public void compra(int gasto){
        coins -= gasto;
    }
}
