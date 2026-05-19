package prog2;

import javax.swing.*;

import prog2.adaptador.Adaptador;
import prog2.vista.BiblioException;
import prog2.vista.ComponentsPersonalitzats.*;
import prog2.vista.gestorPrestecs;

public class RetornaPrestec extends Finestra{
    private JButton botoRetornar;
    private JButton botoTornar;
    private JComboBox prestecsComboBox;
    private JPanel retornarPanell;
    private JPanel comboPanell;
    private JPanel botonsPanell;

    public RetornaPrestec(Adaptador adaptador, gestorPrestecs pare){
        super(adaptador, pare);
        setContentPane(retornarPanell);
        setTitle("Retornar préstec");
        botoTornar.addActionListener(e->pare.obrir());
        botoTornar.addActionListener(e-> tancar());
        botoRetornar.addActionListener(e->{
            int numPrestec=prestecsComboBox.getSelectedIndex();
            try{
                adaptador.retornarPrestec(numPrestec);
            }catch(BiblioException exxx){}
            pare.updateLlista();
            tancar();
        });
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here

        botoRetornar=new Boto();
        botoTornar=new Boto();

        comboPanell=new Panell();
        botonsPanell=new Panell();
        retornarPanell=new Panell();

        prestecsComboBox=new JComboBox<>(adaptador.recuperaPrestecsNoRetornats().toArray());
    }
}
