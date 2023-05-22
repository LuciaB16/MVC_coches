public class Controller {

    public static void main(String[] args) {
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


        View.crearVentana();
    }

        public static void crearCoche(String modelo, String matricula) {
            Coche aux = Model.crearCoche(modelo, matricula);
            if (aux != null) {
                View.mostrarVelocidad(aux.matricula, aux.velocidad);
            }
        }

        public static void reducirVelocidad(String matricula, int v){
                int aux= Model.bajarVelocidad(matricula,v);
                View.mostrarVelocidad(matricula,aux);
        }

        public static void aumentarVelocidad(String matricula, int v){
                int aux= Model.subirVelocidad(matricula,v);
                View.mostrarVelocidad(matricula,aux);
            }
    }
