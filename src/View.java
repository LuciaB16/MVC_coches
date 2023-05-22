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
}
