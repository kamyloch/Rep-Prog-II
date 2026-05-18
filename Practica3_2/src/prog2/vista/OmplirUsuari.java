package prog2.vista;

import prog2.adaptador.Adaptador;
import prog2.vista.ComponentsPersonalitzats.*;
import javax.swing.*;
import java.awt.*;

public class OmplirUsuari extends Finestra {

    private JTextField nomTextField;
    private JButton afegirButton;
    private JButton tornarButton;
    private JTextField adreçaTextField;
    private JPanel PanellOmplirUs;
    private JPanel panellDades;
    private JPanel panellAT;
    private JTextField emailTextField;
    private JCheckBox professorCheckBox;

    public OmplirUsuari(Adaptador adaptador, Finestra pare) {
        super(adaptador, pare);
        setContentPane(PanellOmplirUs);
        setTitle("Afegir usuari");
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        afegirButton = new Boto();
        tornarButton = new Boto();
        PanellOmplirUs = new Panell();
        panellAT = new Panell();
        panellDades = new Panell();
    }
}
