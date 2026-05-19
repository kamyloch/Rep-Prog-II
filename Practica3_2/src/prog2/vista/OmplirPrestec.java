package prog2.vista;
import prog2.adaptador.Adaptador;
import prog2.vista.ComponentsPersonalitzats.*;
import javax.swing.*;

public class OmplirPrestec extends Finestra {
    private JPanel panelGrande;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JCheckBox prestecLlargCheckBox;
    private JButton botoAfegir;
    private JButton botoTornar;
    private JLabel exemplarLabel;
    private JLabel usuariLabel;
    private JPanel panelSuperior;
    private JPanel panelInferior;

    public OmplirPrestec(Adaptador ad, gestorPrestecs pare){
        super(ad, pare);
        setContentPane(panelGrande);
        botoTornar.addActionListener(e->tancar());
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        //Paneles
        panelGrande = new Panell();
        panelInferior = new Panell();
        panelSuperior = new Panell();

        //Botos
        botoAfegir = new Boto();
        botoTornar = new Boto();

        //albes
        usuariLabel = new Etiqueta();
        exemplarLabel = new Etiqueta();

        //Chek
        prestecLlargCheckBox = new Check();
    }
}
