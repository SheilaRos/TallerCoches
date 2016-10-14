import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Taller {
    //TreeMap es más lento que HashMap, pero ordena las keys segun el comparador que se le pasa en el constructor, en este caso el num de la SS.
    private Map<Persona, Coche> reparaciones = new TreeMap<>(Comparator.comparing(Persona::getNumSS));

    public void registrarReparacion(Persona persona, Coche coche){
        reparaciones.putIfAbsent(persona, coche);
    }

    public Coche obtenerCoche(Persona persona){
        return reparaciones.get(persona);
    }

    public Set<Persona> obtenerClientes(){
        return reparaciones.keySet();
    }
}
