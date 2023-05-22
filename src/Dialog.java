import javax.swing.*;

public class Dialog extends JDialog {
    private JPanel panel1;
    private JLabel etqVelocidad;


    public Dialog() {
        setContentPane(panel1);
        setModal(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public static void crearDialog(String mensaje) {
        Dialog dialogo = new Dialog();
        dialogo.pack();
        dialogo.etqVelocidad.setText(mensaje);
        dialogo.setVisible(true);


    }
}
