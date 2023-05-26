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
     * Método que muestra si la velocidad del coche excede los 120km/h, según la matrícula y velocidad recibidas
     * @param matricula del coche
     * @param v velocidad
     * @return
     */
    public static boolean excesoVelocidad(String matricula, Integer v){
        Dialog.crearDialog("Alerta! El coche con matrícula: " + matricula + " ha excedido los 120 km/h");
        return true;
    }
}
