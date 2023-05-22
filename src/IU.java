import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IU {
    private JPanel panel1;
    private JButton bCrearCoche;
    private JButton bSubirV;
    private JButton bBajarV;
    private JTextField textModelo;
    private JTextField textMatricula;
    private JLabel etqMatricula;
    private JLabel etqModelo;



    public IU(){

        bCrearCoche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.crearCoche(textModelo.getText(),textMatricula.getText());
            }
        });

        bSubirV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.aumentarVelocidad(textMatricula.getText(),20);
            }
        });

        bBajarV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller.reducirVelocidad(textMatricula.getText(),20);
            }
        });
    }


    public static void crearVentana(){
        JFrame frame = new JFrame("MVC Coches");
        frame.setContentPane(new IU().panel1);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(3);
    }
}