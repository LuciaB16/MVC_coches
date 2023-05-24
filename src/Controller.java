public class Controller {

    /**
     * Método main a través del cual llamo a la View para ver la ventana     *
     * @param args
     */
    public static void main(String[] args) {

        View.crearVentana();


        /*Model miModelo = new Model();
        View miVista = new View();

        // Crear tres coches

        miModelo.crearCoche("LaFerrari", "SBC 1234");
        miModelo.crearCoche("Alpine", "HYU 4567");
        miModelo.crearCoche("Aston Martin", "FGH 3333");

        Coche ferrari = miModelo.getCoche("SBC 1234");
        // modifica la velocidad
        miModelo.cambiarVelocidad("SBC 1234", 30);

        // sube la velocidad
        miModelo.subirVelocidad("SBC 1234", 60);

        // baja la velocidad
        miModelo.bajarVelocidad("SBC 1234", 20);

        // recoje la velocidad y la muestra (tarea de la View)
        boolean hecho = miVista.muestraVelocidad("SBC 1234", miModelo.getVelocidad("SBC 1234"));

        System.out.println(hecho);*/

    }


    /**
     * Método que crea un coche y muestra su velocidad según modelo y matricula     *
     * @param modelo    del coche
     * @param matricula del coche
     */
    public static void crearCoche(String modelo, String matricula) {
        Coche aux = Model.crearCoche(modelo, matricula);
        if (aux != null) {
            View.mostrarVelocidad(aux.matricula, aux.velocidad);
        }
    }

    /**
     * Método que reduce la velocidad según la matricula y la velocidad recibida (llama a Model para bajarla y la muestra con View)
     * @param matricula del coche
     * @param v velocidad a reducir
     */
    public static void reducirVelocidad(String matricula, int v) {
        int aux = Model.bajarVelocidad(matricula, v);
        View.mostrarVelocidad(matricula, aux);
    }

    /**
     * Método que aumenta la velocidad según la matricula y la velocidad recibida (llama a Model para subirla y la muestra con View)
     * @param matricula del coche
     * @param v velocidad a aumentar
     */
    public static void aumentarVelocidad(String matricula, int v) {
        int aux = Model.subirVelocidad(matricula, v);
        View.mostrarVelocidad(matricula, aux);
    }

    /**
     * Método que busca un coche según la matricula (llama a Model para buscarlo y lo muestra con View)
     * @param matricula del coche que queremos buscar
     * @return el coche con su respectiva matricula, modelo y velocidad
     */
    public static Coche buscarCoche (String matricula){
        Coche aux= Model.getCoche(matricula);
        if (aux != null)
            View.mostrarCoche(aux.matricula, aux.modelo, aux.velocidad);
        return aux;
    }
}
