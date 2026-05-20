package prog2.vista;
import prog2.adaptador.Adaptador;
import prog2.model.Exemplar;
import prog2.model.Usuari;
import prog2.vista.ComponentsPersonalitzats.*;
import javax.swing.*;
import java.awt.*;
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
        setMinimumSize(new Dimension(1000, 500));
        setContentPane(panelGrande);
        botoTornar.addActionListener(e->tancar());
        botoAfegir.addActionListener(e->{
            int numUsuari=usuariComboBox.getSelectedIndex();
            int numExemplar=exemplarComboBox.getSelectedIndex();
            boolean llarg=prestecLlargCheckBox.isSelected();
            try{
                adaptador.afegirPrestec(numExemplar,numUsuari,llarg);
                pare.updateLlista();
                tancar();
            }catch(BiblioException exepcionnnn){
                new Missatge(this,exepcionnnn.getMessage());
            }
            });
        updateLlistas();
        setLocationRelativeTo(pare);
        pack();
    }

    public void updateLlistas (){
        usuariComboBox.removeAll();
        exemplarComboBox.removeAll();
        for (Usuari u : adaptador.recuperaUsuaris())
            usuariComboBox.addItem(u);
        for (Exemplar e : adaptador.recuperaExemplars())
            exemplarComboBox.addItem(e);

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
        usuariComboBox=new ComboCaixa();
        exemplarComboBox=new ComboCaixa();
    }
}
