package prog2.vista;

import prog2.adaptador.Adaptador;
import prog2.vista.ComponentsPersonalitzats.*;

import javax.swing.*;

public class gestorPrestecs extends Finestra{
    private JPanel panelGrande;
    private JButton botoAfegir;
    private JButton botoRetornarPrestec;
    private JButton botoTornar;
    private JList llista;
    private JCheckBox noRetornatsCheckBox;
    private JPanel panelInferior;
    private JPanel panelSuperior;

    //Finestras fills


    public gestorPrestecs(Adaptador adaptador, Finestra pare) {
        super(adaptador, pare);//Preset
        setContentPane(panelGrande);//Afegim el contingut
        setTitle("Usuaris");//s

        noRetornatsCheckBox.addActionListener(e -> updateLlista());

        botoAfegir.addActionListener( e-> new OmplirPrestec(adaptador,this).obrir());
        botoTornar.addActionListener(e -> tancar());
        botoRetornarPrestec.addActionListener(e -> tancar());

    }

    @Override
    public void obrir() {
        super.obrir();
        updateLlista();
    }

    public void updateLlista(){
        if (noRetornatsCheckBox.isSelected())
            llista.setListData(adaptador.recuperaPrestecsNoRetornats().toArray());
        else
            llista.setListData(adaptador.recuperaPrestecs().toArray());
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        //Botos
        botoAfegir = new Boto();
        botoTornar = new Boto();
        botoRetornarPrestec = new Boto();

        //Llista
        llista = new Llista();

        //Check
        noRetornatsCheckBox = new Check();

        //Paneles
        panelGrande = new Panell();
        panelInferior  = new Panell();
        panelSuperior = new Panell();
    }
}
