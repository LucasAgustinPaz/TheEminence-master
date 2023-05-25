import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Usuario {
    private List<String> skins = new ArrayList<>();
    private int xp=0;
    private int nivel=0;
    private int coins=0;
    private boolean promoGanada=false;
    private int horasJugadas=0;
    private int torneosJugados=0;
    private int tapsCount=0;
    private int vecesSmufeado=1;
    private String RolPrincipal = "Duelista";
    private HashMap<String, Integer> Roles = new HashMap<>();;
    {
        Roles.put("Duelista", 0);
        Roles.put("Centinela", 0);
        Roles.put("Smoker", 0);
        Roles.put("Iniciador", 0);
    }

    public int getVecesSmufeado() {
        return vecesSmufeado;
    }

    public void setVecesSmufeado(int vecesSmufeado) {
        this.vecesSmufeado = vecesSmufeado;
    }

    public boolean isPromoGanada() {
        return promoGanada;
    }

    public void setPromoGanada(boolean promoGanada) {
        this.promoGanada = promoGanada;
    }

    public int getTapsCount() {
        return tapsCount;
    }

    public void setTapsCount(int tapsCount) {
        this.tapsCount = tapsCount;
    }

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
        return RolPrincipal;
    }

    public void setRol(String rol) {
        this.RolPrincipal = rol;
        reubicarClaveAlPrincipio(rol);

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
    public void agregarCoins(int monto){
        coins += monto;
    }
    public void reubicarClaveAlPrincipio(String clave) {
        // Verificar si la clave está presente en el HashMap
        if (Roles.containsKey(clave)) {
            // Obtener el valor asociado a la clave
            Integer valor = Roles.get(clave);

            // Eliminar la entrada original del HashMap
            Roles.remove(clave);

            // Crear una nueva entrada con la misma clave y valor
            // y agregarla al principio del HashMap
            HashMap<String, Integer> nuevoHashMap = new HashMap<>();
            nuevoHashMap.put(clave, valor);
            nuevoHashMap.putAll(Roles);

            // Limpiar el HashMap original
            Roles.clear();

            // Copiar las entradas del nuevo HashMap al original
            Roles.putAll(nuevoHashMap);
        }
    }
       public int obtenerNivelRango() {
           if (RolPrincipal != null && Roles.containsKey(RolPrincipal)) {
               return Roles.get(RolPrincipal);
           } else {
               // Manejar el caso cuando la clave no existe o el valor es nulo
               // Puedes retornar un valor predeterminado o lanzar una excepción, según tu necesidad
               return 0; // Valor predeterminado en caso de no encontrar la clave
           }

       }

       public void subirNivelRango(){
        Roles.put(RolPrincipal,(obtenerNivelRango()+1));
       }

       public void aumentarBoosteoSmurf(){
        vecesSmufeado += 2;
       }

       public void setearNivelesRol(){
           Roles.put("Duelista", 0);
           Roles.put("Centinela", 0);
           Roles.put("Smoker", 0);
           Roles.put("Iniciador", 0);
       }

       public void borrarSkins(){
        skins.clear();
       }



}
