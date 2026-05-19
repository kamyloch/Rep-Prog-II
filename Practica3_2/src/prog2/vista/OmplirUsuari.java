package prog2.vista;

import prog2.adaptador.Adaptador;
import prog2.vista.ComponentsPersonalitzats.*;
import javax.swing.*;

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

    public OmplirUsuari(Adaptador adaptador, gestorUsuaris pare) {
        super(adaptador, pare);
        setContentPane(PanellOmplirUs);
        setTitle("Afegir usuari");

        tornarButton.addActionListener(e->pare.obrir());
        tornarButton.addActionListener(e-> tancar());
        afegirButton.addActionListener(e->{
            String nom=nomTextField.getText();
            String adreca=adrecaTextField.getText();
            String email=emailTextField.getText();
            boolean professor=!professorCheckBox.isSelected();

            try{
                adaptador.afegirUsuari(email,nom,adreca,professor);
            }catch(BiblioException exc){}

            pare.updateLlista();
            tancar();
            
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        afegirButton = new Boto();
        tornarButton = new Boto();
        PanellOmplirUs = new Panell();
        panellAT = new Panell();
        panellDades = new Panell();
    }
}
