import java.util.*;

public class Usuario {
    private List<String> skins;
    private int xp;
    private int nivel;
    private int coins;
    private boolean promoGanada;
    private long minutosJugados;
    private long startTime;
    private long endTime;
    private int torneosJugados;
    private int tapsCount;
    private int vecesSmufeado;
    private Inversiones inversiones;
    private String RolPrincipal;
    private double experienceMultiplier;
    private HashMap<String, Integer> Roles;
    private Coach[] coach;

    private eloboost[] eloboost;

    private Periferico[] perifericos;

    public Usuario(){
        skins = new ArrayList<>();
        skins.add("resources\\sprites\\Assets\\skins armas\\vandal_base.png");
        xp=0;
        nivel=0;
        coins=3000;
        promoGanada=false;
        minutosJugados=0;
        startTime=0;
        endTime=0;
        torneosJugados=0;
        tapsCount=0;
        vecesSmufeado=0;
        inversiones = new Inversiones();
        inversiones.setInversion1(0);
        inversiones.setInversion2(0);
        inversiones.setInversion3(0);
        RolPrincipal = "Duelista";
        experienceMultiplier = 1;
        Roles = new HashMap<>();
            Roles.put("Duelista", 0);
            Roles.put("Centinela", 0);
            Roles.put("Smoker", 0);
            Roles.put("Iniciador", 0);
            coach  = new Coach[5];
            coach[0] = new Coach("1");
            coach[1] = new Coach("2");
            coach[2] = new Coach("3");
            coach[3] = new Coach("4");
            coach[4] = new Coach("5");
            eloboost = new eloboost[5];
            eloboost[0] = new eloboost("1");
            eloboost[1] = new eloboost("2");
            eloboost[2] = new eloboost("3");
            eloboost[3] = new eloboost("4");
            eloboost[4] = new eloboost("5");
            perifericos = new Periferico[5];
            perifericos[0] = new Periferico("Teclado");
            perifericos[1] = new Periferico("Mouse");
            perifericos[2] = new Periferico("Auriculares");
            perifericos[3] = new Periferico("Rgb");
            perifericos[4] = new Periferico("MousePad");
    }
    public String getRolPrincipal() {
        return RolPrincipal;
    }
    public Coach[] getCoach() {
        return coach;
    }
    public eloboost[] getEloboost() {
        return eloboost;
    }
    public Periferico[] getPerifericos() {
        return perifericos;
    }
    public double getExperienceMultiplier() {
        return experienceMultiplier;
    }
    public void aumentaExperienceMultiplier(){
        experienceMultiplier += 0.6;
    }
    public Inversiones getInversiones() {
        return inversiones;
    }
    public int getVecesSmufeado() {return vecesSmufeado;}
    public void setPromoGanada(boolean promoGanada) {
        this.promoGanada = promoGanada;
    }
    public int getTapsCount() {
        return tapsCount;
    }
    public List<String> getSkins() {return skins;}
    public int getXp() {return xp;}
    public void setXp(int xp) {this.xp = xp;}
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public int getCoins() {
        return coins;
    }
    public int getTorneosJugados() {
        return torneosJugados;
    }
    public String getRol() {
        return RolPrincipal;
    }
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    public void setRol(String rol) {
        this.RolPrincipal = rol;
        reubicarClaveAlPrincipio(rol);
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
       public void aumentarBoosteoSmurf(){
        vecesSmufeado += 100;
       }
       public void setearNivelesRol(){
           Roles.put("Duelista", 0);
           Roles.put("Centinela", 0);
           Roles.put("Smoker", 0);
           Roles.put("Iniciador", 0);
       }
       public void sumarClick(){
        tapsCount++;
       }
       public void sumarTorneos(){
        torneosJugados++;
       }
       public void gananciaInversiones(){
        agregarCoins((int)(inversiones.getInversion1()+ inversiones.getInversion2()+ inversiones.getInversion3()));
       }
       public long sumarMinutos(){
           long totalTimePlayed = endTime - startTime;
           minutosJugados = totalTimePlayed/ (1000 * 60);
           return minutosJugados;
    }
    public int sumarBoost(){
        int aux=0;

        if(nivel>= 5){
        for(Periferico dato : perifericos) {
            if (dato.getGold() == true) {
                aux += dato.getNivel();
            }
        }
        }else{
            for(Periferico dato : perifericos){
                aux += dato.getNivel();
            }
        }

        return aux;
    }
    public Coach coachMayor(){
        Coach aux = new Coach("aux");
        for(Coach c : coach){
            if(c.getNivel()>aux.getNivel()){
                aux.setNivel(c.getNivel());
            }
        }
        return aux;
    }
    public eloboost eloboostMayor(){
         eloboost aux = new eloboost("aux");
        for(eloboost e : eloboost){
            if(e.getNivel()>aux.getNivel()){
                aux.setNivel(e.getNivel());
            }
        }
        return aux;
    }
}

