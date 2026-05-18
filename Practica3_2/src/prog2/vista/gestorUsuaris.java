package prog2.vista;

import prog2.adaptador.Adaptador;
import prog2.vista.ComponentsPersonalitzats.*;

import javax.swing.*;
import java.awt.*;

public class gestorUsuaris extends Finestra {
    private JPanel PanelUsuaris;
    private JButton botoAfegir;
    private JButton botoMostra;
    private JButton botoTornar;
    private JPanel PanelBotons;
    private JList llista;
    private JScrollPane PanelLlista;

    public gestorUsuaris(Adaptador adaptador, Finestra pare) {
        super(adaptador, pare);//Preset
        setContentPane(PanelUsuaris);//Afegim el contingut
        setTitle("Usuaris");//s
        botoTornar.addActionListener(e -> tancar());
        botoMostra.addActionListener(e -> llista.setListData(adaptador.recuperaUsuaris().toArray()));

        botoAfegir.addActionListener(e -> {
            new OmplirUsuari(adaptador, this);
            setBloquejar(true);

        });
        botoMostra.addActionListener(e -> {

        });

    }

    private void createUIComponents() {
        PanelUsuaris = new Panell();
        PanelBotons = new Panell();
        botoMostra = new Boto();
        botoAfegir = new Boto();
        botoTornar = new Boto();
        llista = new Llista();
    }
}
