package prog2.vista;

import prog2.adaptador.Adaptador;
import prog2.vista.ComponentsPersonalitzats.*;

import javax.swing.*;
import java.awt.*;

/**
 * Finestra de gestió de préstecs
 */
public class gestorPrestecs extends Finestra{
    private JPanel panelGrande;
    private JButton botoAfegir;
    private JButton botoRetornarPrestec;
    private JButton botoTornar;
    private JList llista;
    private JCheckBox noRetornatsCheckBox;
    private JPanel panelInferior;
    private JPanel panelSuperior;

    //Finestras fills
    private OmplirPrestec finestraAfegir;

    /**
     * Constructor que activa la finestra de gestió de prestecs
     * @param adaptador dades de la BiblioUB
     * @param pare Finestra que crida al gestor
     */
    public gestorPrestecs(Adaptador adaptador, Window pare) {
        super(adaptador, pare);//Preset
        setContentPane(panelGrande);//Afegim el contingut
        setTitle("Préstecs");//s
        updateLlista();

        noRetornatsCheckBox.addActionListener(e -> updateLlista());
        botoAfegir.addActionListener( e->{
            finestraAfegir=new OmplirPrestec(adaptador,this);
            finestraAfegir.obrir();
            updateLlista(); //Espera que se cierre (No hace falta actualizar con el boton tornar del dialogo)
        });
        botoTornar.addActionListener(e -> tancar());
        botoRetornarPrestec.addActionListener(e ->retornar());

    }

    /**
     * Retorna el prestec seleccionat a la llista
     */
    private void retornar(){
        {
            try{
                if(llista.isSelectionEmpty())
                    throw new Exception("Si us plau, tria una opció de la llista");
                int seleccio = llista.getSelectedIndex();
                if (noRetornatsCheckBox.isSelected())
                    adaptador.retornarPrestec(seleccio);
                else
                    adaptador.retornarPrestecTots(seleccio);

                new Missatge(this,"Has retornat el préstec","Moltes gràcies!", Missatge.Tipus.FESTA);
                updateLlista();
            }catch (Exception exew){
                new Missatge(this, exew.getMessage(), "Error",Missatge.Tipus.ERROR);
            }
        }
    }

    /**
     * Actualitza la informació de la llista segons l'adaptador
     */
    public void updateLlista(){
        if (noRetornatsCheckBox.isSelected())
            llista.setListData(adaptador.recuperaPrestecsNoRetornats().toArray());
        else
            llista.setListData(adaptador.recuperaPrestecs().toArray());
    }

    /**
     * New de cada component de la UI
     */
    private void createUIComponents() {
        // TODO: place custom component creation code here
        //Botos
        botoAfegir = new Boto();
        botoTornar = new Boto();
        botoRetornarPrestec = new Boto();

        //Llista
        llista = new Llista();

        //Check
        noRetornatsCheckBox = new Check();

        //Paneles
        panelGrande = new Panell();
        panelInferior  = new Panell();
        panelSuperior = new Panell();
    }
}
