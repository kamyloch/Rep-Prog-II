package prog2.vista;

import javax.swing.*;

import prog2.adaptador.Adaptador;
import prog2.vista.ComponentsPersonalitzats.*;

import java.awt.*;

public class gestorExemplars extends Finestra {
    private JButton botoMostra;
    private JButton botoAfegir;
    private JButton botoTornar;
    private JPanel PanelExemplars;
    private Finestra afegirFinestra;

    public gestorExemplars(Adaptador adaptador, Finestra pare) {
        super(adaptador, pare);//Preset
        setContentPane(PanelExemplars);//Afegim el contingut
        afegirFinestra = new OmplirUsuari(adaptador, pare);
        setTitle("Exemplars");
        botoTornar.addActionListener(e -> tancar());
        botoAfegir.addActionListener(e -> afegirFinestra.obrir());
    }

    private void createUIComponents() {//ss
        PanelExemplars = new Panell();
        botoMostra = new Boto();
        botoAfegir = new Boto();
        botoTornar = new Boto();
    }

}
