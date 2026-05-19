package prog2.vista;

import javax.swing.*;

import prog2.adaptador.Adaptador;
import prog2.vista.ComponentsPersonalitzats.*;

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

    public OmplirExemplar(Adaptador adaptador, gestorExemplars pare) {
        super(adaptador, pare);
        setContentPane(panelGrande);
        setTitle("Afegir Exemplar");

        botoTornar.addActionListener(e-> tancar());
        botoTornar.addActionListener(e->pare.obrir());
        botoAfegir.addActionListener(e->{
            String titol= titolTextField.getText();
            String autor=autoTextField.getText();
            String id=IdTextField.getText();
            boolean admetLlarg=llargCheckBox.isSelected();

            try{
                adaptador.afegirExemplar(id,titol,autor,admetLlarg);
            }catch(BiblioException exc){

            }
            pare.updateLlista();
            tancar();

        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        botoTornar = new Boto();
        botoAfegir = new Boto();
    }
}
