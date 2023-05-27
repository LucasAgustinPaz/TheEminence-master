import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MiHashMap<K, V>{
    private HashMap<K, V> hashMap;

    public MiHashMap() {
        hashMap = new HashMap<>();
    }

    public void agregarElemento(K clave, V valor) {
        hashMap.put(clave, valor);
    }

    public void setPrimero(K clave) {
        V valor = hashMap.get(clave);
        if (valor != null) {
            reubicarClaveAlPrincipio(clave);
        }
    }

    public void reubicarClaveAlPrincipio(K clave) {
        if (hashMap.containsKey(clave)) {
            V valor = hashMap.get(clave);
            hashMap.remove(clave);
            HashMap<K, V> nuevoHashMap = new HashMap<>();
            nuevoHashMap.put(clave, valor);
            nuevoHashMap.putAll(hashMap);
            hashMap.clear();
            hashMap.putAll(nuevoHashMap);
        }
    }

    public V obtenerElemento(K clave) {
        return hashMap.get(clave);
    }

    public Set<K> obtenerClaves() {
        return hashMap.keySet();
    }


}
