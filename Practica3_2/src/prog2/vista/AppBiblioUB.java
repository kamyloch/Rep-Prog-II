package prog2.vista;
import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import prog2.vista.ComponentsPersonalitzats.*;

/**
 * Clase principal que gestiona funionalitats de la Biblio
 */
public class AppBiblioUB extends JFrame {
    private JPanel PanelMenu;
    private JButton botoUsuaris;
    private JButton botoExemplars;
    private JButton botoPrestecs;
    private JButton botoGuarda;
    private JButton botoCarrega;
    private Finestra finestraUsuaris;
    private Finestra finestraExemplars;
    private Finestra finestraPrestecs;
    private Adaptador adaptador;
    private Vidre glass;

    //MenuBar
    private MenuPare barra;


    /**
     * Constructor per defecte de la AppBiblio UB
     * llença l'app i mostra la UI
     */
    public AppBiblioUB (){ //Constructor per defecte
        this.adaptador = new Adaptador();
        go();
    }

    /**
     * Llança l'app amb un adaptador donat (dades)
     * @param ad
     */
    public AppBiblioUB(Adaptador ad) { //Constructor amb adaptador predefinit
        this.adaptador = ad;//Preset
        go();
    }

    /**
     * Private: facilita als contructors llençar l'app
     */
    private void go (){
        if (adaptador == null) return;
        glass = new Vidre();
        setGlassPane(glass);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Per gestionar el pare
        setMinimumSize(new Dimension(700, 500));
        setLocationRelativeTo(null);  //Apareix al centre

        botoUsuaris.addActionListener(e ->{
            finestraUsuaris = new gestorUsuaris(adaptador, this);
            finestraUsuaris.obrir();
        });
        botoExemplars.addActionListener(e -> {
            finestraExemplars = new gestorExemplars(adaptador, this);
            finestraExemplars.obrir();
        });
        botoPrestecs.addActionListener(e -> {
            finestraPrestecs = new gestorPrestecs(adaptador, this);
            finestraPrestecs.obrir();
        });
        botoCarrega.addActionListener(e -> loadDades());
        botoGuarda.addActionListener(e ->  saveDades());

        initMenuBar();
        setJMenuBar(barra);

        setContentPane(PanelMenu); //Afegim el menú
        setTitle("BiblioUB"); //Title
        setVisible(true);
    }

    /**
     * Carrega dades des d'un fitxer
     */
    public void loadDades(){
        String cami = demanaPath(false);
        if (cami != null) {
            try {
                this.adaptador.carregaDades(cami);
                new Missatge(this,"Dades Carregades!",  "Tot a punt!",Missatge.Tipus.LLEST);
            } catch (BiblioException ex) {
                new Missatge(this, ex.getMessage(), "Error",Missatge.Tipus.ERROR);
            }
        }
    }

    /**
     * Guarda l'adaptador (Biblio UB) en un fitxer
     */
    public void saveDades (){
        String cami = demanaPath(true);
        if (cami != null) {
            try {
                this.adaptador.guardaDades(cami);
                new Missatge(this,"Dades guardades amb exit",  "BiblioUB",Missatge.Tipus.FESTA);
            } catch (BiblioException ex) {
                new Missatge(this, ex.getMessage(), "Error", Missatge.Tipus.ERROR);
            }
        }
    }

    /**
     * Demana un camí a l'usuari mitjançant un JFileChooser
     * @param isSave si mostrar (desar/carregar) al demanar el path
     * @return ruta del fitxer
     */
    private String demanaPath(boolean isSave) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(".")); //Se abre desde la carpeta actual

        int resposta; //será 0 si ha rebut path i 1 si no ha rebut path

        if (isSave) //Solo cambia el boton de Save por Open en la ventana que sale, pero son equivalentes, ambas obtienen path
            resposta = fileChooser.showSaveDialog(null);
        else
            resposta = fileChooser.showOpenDialog(null);


        if (resposta == JFileChooser.APPROVE_OPTION) //es lo mismo que 0
            return fileChooser.getSelectedFile().getAbsolutePath();
        else
            return null;
    }
    private void carregarDefault(){
        adaptador = Adaptador.adaptadorDefault();
        new Missatge(this,"Dades per defecte carregades","Biblio prèvia esborrada", Missatge.Tipus.INFO);
    }
    private void clearAdaptador(){
        adaptador = new Adaptador();
        new Missatge(this,"Dades reiniciades", "Biblio buida", Missatge.Tipus.INFO );
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
        PanelMenu = new Panell();
        botoUsuaris = new Boto();
        botoExemplars = new Boto();
        botoPrestecs = new Boto();
        botoCarrega = new Boto("Carrega una Biblio");
        botoGuarda = new Boto("Guarda la Biblio");
    }

    /**
     * Iniciador de la menu bar del menú principal
     */
    private void initMenuBar() {

        barra = new MenuPare();
        //Fitxers
        barra.addFill("Fitxers");
        barra.addNet("Desar",e-> saveDades());
        barra.addNet("Carregar fitxer", e-> loadDades());
        barra.addNet("Carregar dades per defecte", e -> carregarDefault());
        barra.addNet("Esborrar dades", e -> clearAdaptador());
        barra.addNet("Sortir", e-> System.exit(0));

        //Usuaris
        barra.addFill("Usuaris");
        barra.addNet("Mostra", e-> {
            finestraUsuaris=new gestorUsuaris(adaptador,this);
            finestraUsuaris.obrir();
        });
        barra.addNet("Afegeix", e-> new OmplirUsuari(adaptador,this).obrir());

        //Exemplar
        barra.addFill("Exemplar");
        barra.addNet("Mostra", e-> {
            finestraExemplars=new gestorExemplars(adaptador,this);
            finestraExemplars.obrir();
        });
        barra.addNet("Afegeix", e-> new OmplirExemplar(adaptador,this).obrir());

        //Prestec
        barra.addFill("Préstecs");
        barra.addNet("Mostra", e-> {
            finestraPrestecs=new gestorPrestecs(adaptador,this);
            finestraPrestecs.obrir();
        });
        barra.addNet("Afegeix", e-> new OmplirPrestec(adaptador,this).obrir());
    }
}
