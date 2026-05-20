package prog2.vista;


import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.*;

public class OmplirExemplar extends ComponentsPersonalitzats.Finestra {
    private JTextField titolTextField;
    private JTextField autoTextField;
    private JTextField IdTextField;
    private JButton botoAfegir;
    private JButton botoTornar;
    private JCheckBox llargCheckBox;
    private JLabel titolLabel;
    private JLabel autorLabel;
    private JLabel idLabel;
    private JPanel panelSuperior;
    private JPanel panelInferior;
    private JPanel panelGrande;

    public OmplirExemplar(Adaptador adaptador, Window pare) {
        super(adaptador, pare);
        setContentPane(panelGrande);
        setTitle("Afegir Exemplar");

        botoTornar.addActionListener(e-> tancar());
        botoAfegir.addActionListener(e->{
            String titol= titolTextField.getText();
            String autor=autoTextField.getText();
            String id=IdTextField.getText();
            boolean admetLlarg=llargCheckBox.isSelected();

            try{
                adaptador.afegirExemplar(id,titol,autor,admetLlarg);
                tancar();
            }catch(BiblioException exc){
                new ComponentsPersonalitzats.Missatge(this, exc.getMessage());
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        botoTornar = new ComponentsPersonalitzats.Boto();
        botoAfegir = new ComponentsPersonalitzats.Boto();
        llargCheckBox = new ComponentsPersonalitzats.Check();

        //Camps de Text
        titolTextField = new ComponentsPersonalitzats.CampText();
        autoTextField = new ComponentsPersonalitzats.CampText();
        IdTextField = new ComponentsPersonalitzats.CampText();

        //Panells
        panelGrande = new ComponentsPersonalitzats.Panell();
        panelInferior = new ComponentsPersonalitzats.Panell();
        panelSuperior = new ComponentsPersonalitzats.Panell();

        //Labels
        autorLabel = new ComponentsPersonalitzats.Etiqueta();
        idLabel = new ComponentsPersonalitzats.Etiqueta();
        titolLabel = new ComponentsPersonalitzats.Etiqueta();
    }
}