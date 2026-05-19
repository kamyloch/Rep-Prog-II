package prog2;

import prog2.adaptador.Adaptador;
import prog2.vista.ComponentsPersonalitzats.*;

import javax.swing.*;

public class gestorPrestecs extends Finestra{
    private JPanel panelGrande;
    private JButton botoAfegir;
    private JButton botoRetornarPrestec;
    private JButton botoTornar;
    private JList llista;
    private JCheckBox retornatsCheckBox;
    private JPanel panelInferior;
    private JPanel panelSuperior;


    public gestorPrestecs(Adaptador adaptador, Finestra pare) {
        super(adaptador, pare);//Preset
        setContentPane(panelGrande);//Afegim el contingut
        setTitle("Usuaris");//s
        retornatsCheckBox.addActionListener(e -> updateLlista());


        botoTornar.addActionListener(e -> tancar());

    }

    @Override
    public void obrir() {
        super.obrir();
        updateLlista();
    }

    public void updateLlista(){
        if (retornatsCheckBox.isSelected())
            llista.setListData(adaptador.recuperaPrestecsNoRetornats().toArray());
        else
            llista.setListData(adaptador.recuperaPrestecs().toArray());
    }


}
