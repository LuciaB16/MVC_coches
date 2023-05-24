import java.util.ArrayList;

public class Model {

    /**
     * Creo un ArrayList de tipo Coche para guardar los coches que se vayan creando
     */
    static ArrayList<Coche> parking = new ArrayList<>();


    /**
     * Crea un coche y lo mete en ArrayList parking
     * @param modelo del coche
     * @param matricula identificador unico
     * @return el coche creado
     */
    public static Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Método que busca un coche según la matrícula recibida
     * @param matricula a buscar
     * @return coche o null si no existe
     */
    public static Coche getCoche(String matricula){
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e: parking) {
            //si la matricula es del coche que le introdujimos, lo devuelve (busca el coche por matricula)
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }


    /**
     * Método que cambia la velocidad
     * @param matricula
     * @param v nueva velocidad
     * @return velocidad modificada
     */
    /*
     public Integer cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;
        // retorna la nueva velocidad
        return getCoche(matricula).velocidad;
    }
    */



    /**
     * Método que sube la velocidad de un coche según la matrícula y velocidad recibidas
     * @param matricula del coche
     * @param v velocidad a subir
     * @return velocidad aumentada
     */

    public static Integer subirVelocidad (String matricula, int v){
        getCoche(matricula).velocidad=getCoche(matricula).velocidad+v;
        return getCoche(matricula).velocidad;
    }

    /**
     * Método que reduce la velocidad de un coche según la matrícula y velocidad recibidas
     * @param matricula del coche
     * @param v velocidad a bajar
     * @return velocidad reducida
     */
    public static Integer bajarVelocidad (String matricula, int v){
        getCoche(matricula).velocidad=getCoche(matricula).velocidad-v;
        return getCoche(matricula).velocidad;
    }


    /**
     * Método que devuelve la velocidad de un coche según la matrícula recibida
     * @param matricula del coche
     * @return la velocidad del coche
     */
    public static Integer getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }
}



