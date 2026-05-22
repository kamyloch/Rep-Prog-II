package prog2.vista;

import prog2.adaptador.Adaptador;
import prog2.model.Usuari;
import prog2.vista.ComponentsPersonalitzats.*;

import javax.swing.*;
import java.awt.*;

/**
 * Finestra de gestió d'usuaris
 */
public class gestorUsuaris extends Finestra {
    private JPanel PanelUsuaris;
    private JButton botoAfegir;
    private JButton botoTornar;
    private JPanel PanelBotons;
    private JList llista;
    private JScrollPane PanelLlista;
    private Finestra finestraomplir;

    /**
     * Constructor que activa la finestra de gestió d'usuaris
     * @param adaptador dades de la BiblioUB
     * @param pare Finestra que crida al gestor
     */
    public gestorUsuaris(Adaptador adaptador, Window pare) {
        super(adaptador, pare);//Preset
        setContentPane(PanelUsuaris);//Afegim el contingut
        setTitle("Usuaris");

        updateLlista();
        botoTornar.addActionListener(e -> tancar());
        botoAfegir.addActionListener(e ->{
            finestraomplir = new OmplirUsuari(adaptador,this);
            finestraomplir.obrir();
            updateLlista(); //Espera que se cierre (No hace falta actualizar con el boton tornar del dialogo)
        });

    }
    /**
     * Actualitza la informació de la llista segons l'adaptador
     */
    public void updateLlista(){
        llista.setListData(adaptador.recuperaUsuaris().toArray());
    }

    /**
     * New de cada component de la UI
     */
    private void createUIComponents() {
        PanelUsuaris = new Panell();
        PanelBotons = new Panell();
        botoAfegir = new Boto();
        botoTornar = new Boto();
        llista = new Llista();
    }
}
