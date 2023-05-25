import java.util.Observable;
import java.util.Observer;

public class ObserverVelocidad implements Observer {

    /**
     * Método al que se llama siempre que hay un cambio
     * El observable cuando hace el notifyObservers
     * 'dispara' todos los update de los Observers
     * @param o es el observable (Model)
     * @param arg es el argumento pasado por el observable ({@code notifyObservers}), el coche actualizado
     */
    @Override
    public void update(Observable o, Object arg) {
        //El argumento es de tipo Object, porque es general
        // Le hacemos un cast para poder trabajar con un objeto Coche
        Coche auxCoche = (Coche) arg;
        System.out.println("Se ha cambiado la velocidad: " + auxCoche.velocidad.toString());
        // Le comunicamos a la Vista que muestre la velocidad
        View.mostrarVelocidad(auxCoche.matricula, auxCoche.velocidad);

    }
}
