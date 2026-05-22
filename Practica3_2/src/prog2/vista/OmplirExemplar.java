package prog2.vista;


import prog2.adaptador.Adaptador;
import prog2.vista.ComponentsPersonalitzats.*;

import javax.swing.*;
import java.awt.*;

/**
 * Finestra que permet afegir Exemplars
 */
public class OmplirExemplar extends Finestra {
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

    /**
     * Constructor que llença la finestra segons les dades
     * @param adaptador Dades de la Biblio UB
     * @param pare Finestra que crida al formulari
     */
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
                if (id.isBlank() || autor.isBlank() || id.isBlank())
                    throw new Exception("No pots deixar camps buits");
                adaptador.afegirExemplar(id,titol,autor,admetLlarg);
                tancar();
            }catch(Exception exc){
                new Missatge(this, exc.getMessage(), "Error",Missatge.Tipus.ERROR);
            }
        });
    }

    /**
     * New de cada component de la UI
     */
    private void createUIComponents() {
        // TODO: place custom component creation code here
        botoTornar = new Boto();
        botoAfegir = new Boto();
        llargCheckBox = new Check();

        //Camps de Text
        titolTextField = new CampText();
        autoTextField = new CampText();
        IdTextField = new CampText();

        //Panells
        panelGrande = new Panell();
        panelInferior = new Panell();
        panelSuperior = new Panell();

        //Labels
        autorLabel = new Etiqueta();
        idLabel = new Etiqueta();
        titolLabel = new Etiqueta();
    }
}