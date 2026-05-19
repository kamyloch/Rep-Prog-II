package prog2.vista;

import prog2.adaptador.Adaptador;
import prog2.model.Exemplar;
import prog2.vista.ComponentsPersonalitzats.*;

import javax.swing.*;
import java.awt.*;

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
    private OmplirPrestec finestraAfegir;


    public gestorPrestecs(Adaptador adaptador, Window pare) {
        super(adaptador, pare);//Preset
        setContentPane(panelGrande);//Afegim el contingut
        setTitle("Usuaris");//s
        updateLlista();

        noRetornatsCheckBox.addActionListener(e -> updateLlista());
        botoAfegir.addActionListener( e->{
            finestraAfegir=new OmplirPrestec(adaptador,this);
            finestraAfegir.obrir();
        });
        botoTornar.addActionListener(e -> tancar());
        botoRetornarPrestec.addActionListener(e -> {


            try{
                if(llista.isSelectionEmpty())
                    throw new Exception("Si us plau en tria un de la lista");
                int seleccio = llista.getSelectedIndex();
                if (noRetornatsCheckBox.isSelected())
                    adaptador.retornarPrestec(seleccio);
                else
                    throw new RuntimeException("Activa los no retornats");

                updateLlista();
            }catch (Exception exew){
                new Missatge(this, exew.getMessage());
            }
        });

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
