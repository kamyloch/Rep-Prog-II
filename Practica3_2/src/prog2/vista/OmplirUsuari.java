package prog2.vista;

import prog2.adaptador.Adaptador;
import prog2.vista.ComponentsPersonalitzats.*;
import javax.swing.*;
import java.awt.*;

public class OmplirUsuari extends Finestra {

    private JTextField nomTextField;
    private JButton afegirButton;
    private JButton tornarButton;
    private JTextField adrecaTextField;
    private JPanel PanellOmplirUs;
    private JPanel panellDades;
    private JPanel panellAT;
    private JTextField emailTextField;
    private JCheckBox professorCheckBox;
    private JLabel nomLabel;
    private JLabel adrecaLabel;
    private JLabel emailLabel;

    public OmplirUsuari(Adaptador adaptador, Window pare) {
        super(adaptador, pare);
        setContentPane(PanellOmplirUs);
        setTitle("Afegir usuari");

        tornarButton.addActionListener(e-> tancar());
        afegirButton.addActionListener(e->{
            String nom=nomTextField.getText();
            String adreca=adrecaTextField.getText();
            String email=emailTextField.getText();
            boolean professor=!professorCheckBox.isSelected();

            try{
                adaptador.afegirUsuari(email,nom,adreca,professor);
                tancar();
            }catch(BiblioException exc){
                new Missatge(this,exc.getMessage(), "Error",Missatge.Tipus.ERROR);
            }
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        //Botones
        afegirButton = new Boto();
        tornarButton = new Boto();
        //Paneles
        PanellOmplirUs = new Panell();
        panellAT = new Panell();
        panellDades = new Panell();
        //CheckBox
        professorCheckBox = new Check();
        //Area de text
        nomTextField = new CampText();
        adrecaTextField = new CampText();
        emailTextField = new CampText();

        //Labels
        nomLabel = new Etiqueta();
        emailLabel = new Etiqueta();
        adrecaLabel = new Etiqueta();
    }
}
