import java.util.Observable;
import java.util.Observer;

public class ObserverOtro implements Observer {

    /**
     * Método al que se llama cada vez que se cambia el objeto observado
     * La aplicación llama a un objeto {@code Observable}
     * El método {@code notifyObservers} para tener todos los objetos observadores
     * notificados del cambio.
     * @param o es el observable
     * @param arg   es el argumento pasado por el observable ({@code notifyObservers})
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Yo también me enteré de que la velocidad cambió en " + arg.toString());
    }
}
