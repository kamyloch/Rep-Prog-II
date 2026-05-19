package prog2.vista;
import prog2.adaptador.Adaptador;
import prog2.vista.ComponentsPersonalitzats.*;
import javax.swing.*;
import java.util.ArrayList;

public class OmplirPrestec extends Finestra {
    private JPanel panelGrande;
    private JComboBox usuariComboBox;
    private JComboBox exemplarComboBox;
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
        botoAfegir.addActionListener(e->{
        int numUsuari=usuariComboBox.getSelectedIndex();
        int numExemplar=exemplarComboBox.getSelectedIndex();
        boolean llarg=prestecLlargCheckBox.isSelected();
        try{
            adaptador.afegirPrestec(numExemplar,numUsuari,llarg);
        }catch(BiblioException exepcionnnn){}
        pare.updateLlista();
        tancar();
        });
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

        //ComboBox
        usuariComboBox=new JComboBox<>(adaptador.recuperaUsuaris().toArray());
        exemplarComboBox=new JComboBox<>(adaptador.recuperaExemplars().toArray());
    }
}
