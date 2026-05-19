package prog2.vista;

import prog2.adaptador.Adaptador;
import prog2.model.Usuari;
import prog2.vista.ComponentsPersonalitzats.*;

import javax.swing.*;
import java.awt.*;

public class gestorUsuaris extends Finestra {
    private JPanel PanelUsuaris;
    private JButton botoAfegir;
    private JButton botoTornar;
    private JPanel PanelBotons;
    private JList llista;
    private JScrollPane PanelLlista;
    private Finestra finestraomplir;

    public gestorUsuaris(Adaptador adaptador, Finestra pare) {
        super(adaptador, pare);//Preset
        setContentPane(PanelUsuaris);//Afegim el contingut
        setTitle("Usuaris");//s


        botoTornar.addActionListener(e -> tancar());
        botoAfegir.addActionListener(e ->{
            finestraomplir = new OmplirUsuari(adaptador,this);
            finestraomplir.obrir();
        });
    }

    @Override
    public void obrir() {
        super.obrir();
        updateLlista();
    }

    public void updateLlista(){
        llista.setListData(adaptador.recuperaUsuaris().toArray());
    }

    private void createUIComponents() {
        PanelUsuaris = new Panell();
        PanelBotons = new Panell();
        botoAfegir = new Boto();
        botoTornar = new Boto();
        llista = new Llista();
    }
}
