package prog2.vista;

import javax.swing.*;

import prog2.adaptador.Adaptador;
import prog2.vista.ComponentsPersonalitzats.*;

import java.awt.*;

/**
 * Finestra de gestió d'exemplars
 */
public class gestorExemplars extends Finestra {
    private JButton botoAfegir;
    private JButton botoTornar;
    private JPanel PanelExemplars;
    private JList llista;
    private JScrollPane llistaScroll;
    private JPanel panelBotons;
    private OmplirExemplar afegirFinestra;

    /**
     * Constructor que activa la finestra de gestió d'exemplars
     * @param adaptador dades de la BiblioUB
     * @param pare Finestra que crida al gestor
     */
    public gestorExemplars(Adaptador adaptador, Window pare) {
        super(adaptador, pare);//Preset
        setContentPane(PanelExemplars);//Afegim el contingut
        setTitle("Exemplars");
        updateLlista();

        botoTornar.addActionListener(e -> tancar());
        botoAfegir.addActionListener(e -> {
            afegirFinestra = new OmplirExemplar(adaptador, this);
            afegirFinestra.obrir();
            updateLlista(); //Espera que se cierre (No hace falta actualizar con el boton tornar del dialogo)
        });

    }

    /**
     * Actualitza la informació de la llista segons l'adaptador
     */
    public void updateLlista() {
        llista.setListData(adaptador.recuperaExemplars().toArray());
    }

    /**
     * New de cada component de la UI
     */
    private void createUIComponents() {//ss
        PanelExemplars = new Panell();
        botoAfegir = new Boto();
        botoTornar = new Boto();
        llista = new Llista();
        panelBotons = new Panell();
    }
}