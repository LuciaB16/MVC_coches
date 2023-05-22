public class View {

    public static void crearVentana(){
        IU.crearVentana();
    }


    public static boolean mostrarVelocidad(String matricula, Integer v){
        //System.out.println(matricula + ": " + v + "km/h");
        //Dialog.crearDialog(String.valueOf(v));
        Dialog.crearDialog("El coche con matrícula: " + matricula + " tiene una velocidad de: " + v + "km/h");
        return true;
    }
}
