import java.util.Observable;
import java.util.Observer;

public class ObsExceso implements Observer {

    /**
     * Método al que se llama siempre que hay un cambio (exceso de velocidad)
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

        //Si la velocidad es mayor de 120, salta el aviso
        if (auxCoche.velocidad > 120){
            View.excesoVelocidad(auxCoche.matricula, auxCoche.velocidad);
        }
    }
}
