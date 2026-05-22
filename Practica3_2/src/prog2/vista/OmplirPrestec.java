package prog2.vista;
import prog2.adaptador.Adaptador;
import prog2.model.Exemplar;
import prog2.model.Usuari;
import prog2.vista.ComponentsPersonalitzats.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Finestra que permet afegir Préstecs
 */
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

    /**
     * Constructor que llença la finestra segons les dades
     * @param ad Dades de la Biblio UB
     * @param pare Finestra que crida al formulari
     */
    public OmplirPrestec(Adaptador ad, Window pare){
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
                tancar();
            }catch(BiblioException exepcionnnn){
                new Missatge(this,exepcionnnn.getMessage(), "Error",Missatge.Tipus.ERROR);
            }
            });
        updateLlistas();
        setLocationRelativeTo(pare);
        pack();
    }

    public void updateLlistas (){
        usuariComboBox.removeAll();
        exemplarComboBox.removeAll();
        for (String u : adaptador.recuperaUsuaris())
            usuariComboBox.addItem(u);
        for (String e : adaptador.recuperaExemplars())
            exemplarComboBox.addItem(e);

    }

    /**
     * New de cada component de la UI
     */
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
