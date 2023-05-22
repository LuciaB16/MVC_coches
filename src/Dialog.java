import javax.swing.*;

public class Dialog extends JDialog {
    private JPanel panel1;
    private JLabel etqVelocidad;


    /**
     * Constructor por defecto de la clase Dialog para instanciar los componentes necesarios
     */
    public Dialog() {
        setContentPane(panel1);
        setModal(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }


    /**
     * Método para instanciar la ventana de diálogo, recibiendo un mensaje
     * @param mensaje
     */
    public static void crearDialog(String mensaje) {
        Dialog dialogo = new Dialog();
        dialogo.pack();
        dialogo.etqVelocidad.setText(mensaje);
        dialogo.setVisible(true);


    }
}
