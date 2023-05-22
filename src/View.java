public class View {

    public static void crearVentana(){
        IU.crearVentana();
    }


    public static boolean mostrarVelocidad(String matricula, Integer v){
        Dialog.crearDialog("El coche con matrícula: " + matricula + " tiene una velocidad de: " + v + "km/h");
        return true;
    }
}
