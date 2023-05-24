public class View {

    /**
     * Constructor de la ventana
     */
    public static void crearVentana(){
        IU.crearVentana();
    }


    /**
     * Método que muestra la velocidad del coche al crearlo, según la matrícula y velocidad recibidas
     * @param matricula del coche
     * @param v velocidad
     * @return true
     */
    public static boolean mostrarVelocidad(String matricula, Integer v){
        Dialog.crearDialog("El coche con matrícula: " + matricula + " tiene una velocidad de: " + v + "km/h");
        return true;
    }

    /**
     * Método que muestra el coche, según la matrícula, modelo y velocidad recibidos
     * @param matricula del coche que queremos que nos muestre
     * @param modelo del coche que queremos que nos muestre
     * @param v velocidad del coche que queremos que nos muestre
     * @return true
     */
    public static boolean mostrarCoche(String matricula, String modelo, Integer v) {
        Dialog.crearDialog("El coche con matrícula: " + matricula + " y modelo: " + modelo + " tiene una velocidad de: " + v + "km/h");
        return true;
    }
}
