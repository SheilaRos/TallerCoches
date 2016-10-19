import java.util.*;
import java.util.stream.Collectors;

public class RegistroVehiculos {
    //La diferencia es que con HashSet no pueden haber duplicados.
    private Set<Coche> coches = new HashSet<>();

    public void registrarVehiculo(Coche coche) {

        coches.add(coche);
    }

    // Optional<Coche> es una nueva funcionalidad de Java 8 para evitar trabajar con null
    // Lo puedes omitir si trabajas con Java 7
    public Optional<Coche> obtenerVehiculo(String matricula) {
        //java 8
        return coches.
                stream().
                filter(coche -> coche.getMatricula().equals(matricula)).
                findFirst();

        /* Java 7
        public Coche obtenerVehiculo(String matricula){
        Coche resultado=null;
            for(Coche c: coches){
                if(c.getMatricula().equals(matricula)){
                    resultado=c;
                }
            }
            return resultado;
        }
        */
    }

    public void eliminarVehiculo(String matricula){
        //Java 8
        coches.removeIf(coche -> coche.getMatricula().equals(matricula));

        /*Java 7
        for(Coche c: coches){
            if(c.getMatricula().equals(matricula)){
                coches.remove(c);
            }
        }*/
    }



    public Optional<Coche> obtenerVehiculoPrecioMax(){
        //se puede usar paralelstream(), lo que hace es comparar en bloques y guarda el máximo de cada bloque(útil para casos en los que hay muchos objetos)
        //Java 8
        return coches.
                stream().
                max(Comparator.comparing(Coche::getPrecio));

        /*Java 7
            public Coche obtenerVehiculoPrecioMax(){
            int max=0;
            Coche resultado = null;
            for(Coche c: coches){
                if(c.getPrecio()>max){
                    max=c.getPrecio();
                    resultado=c;
                }
            }
            return resultado;
            }
         */
    }

    public List<Coche> obtenerVehiculosMarca(String marca){
        //Java 8
        return  coches.
                stream().
                filter(coche -> coche.getMarca().equals(marca)).
                collect(Collectors.toList());

         /* Java 7
            Coche resultado=null;
            for(Coche c: coches){
                if(c.getMarca().equals(marca)){
                    resultado=c;
                }
            }
            return resultado;
        */


    }



    public List<Coche> obtenerTodos(){
        //Java 8
        return coches.
                stream().
                collect(Collectors.toList());

        /*Java 7
        return new ArrayList<>(coches);
         */

    }
}
