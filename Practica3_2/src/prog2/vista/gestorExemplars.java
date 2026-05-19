package prog2.vista;

import javax.swing.*;

import prog2.adaptador.Adaptador;
import prog2.vista.ComponentsPersonalitzats.*;

public class gestorExemplars extends Finestra {
    private JButton botoAfegir;
    private JButton botoTornar;
    private JPanel PanelExemplars;
    private JList llista;
    private JScrollPane llistaScroll;
    private JPanel panelBotons;
    private OmplirExemplar afegirFinestra;


    public gestorExemplars(Adaptador adaptador, Finestra pare) {
        super(adaptador, pare);//Preset
        setContentPane(PanelExemplars);//Afegim el contingut
        setTitle("Exemplars");
        botoTornar.addActionListener(e -> tancar());
        botoAfegir.addActionListener(e ->{
            afegirFinestra= new OmplirExemplar(adaptador,this);
            afegirFinestra.obrir();
        });

    }

    @Override
    public void obrir(){
        super.obrir();
        updateLlista();
    }
    public void updateLlista(){
        llista.setListData(adaptador.recuperaExemplars().toArray());
    }

    private void createUIComponents() {//ss
        PanelExemplars = new Panell();
        botoAfegir = new Boto();
        botoTornar = new Boto();
        llista = new Llista();
        panelBotons = new Panell();
    }

}
