package prog2.vista;
import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import prog2.vista.ComponentsPersonalitzats.*;

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

    //MenuBar
    private MenuPare barra;



    public AppBiblioUB (){ //Constructor per defecte
        this.adaptador = new Adaptador();
        go();
    }
    public AppBiblioUB(Adaptador ad) { //Constructor amb adaptador predefinit
        this.adaptador = ad;//Preset
        go();
    }
    public void go (){
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


    private void createUIComponents() {
        // TODO: place custom component creation code here
        PanelMenu = new Panell();
        botoUsuaris = new Boto();
        botoExemplars = new Boto();
        botoPrestecs = new Boto();
        botoCarrega = new Boto("Carrega una Biblio");
        botoGuarda = new Boto("Guarda la Biblio");
    }

    private void initMenuBar() {

        barra = new MenuPare();
        barra.addFill("Fitxers");
        barra.addNet("Desar",e-> saveDades());
        barra.addNet("Carregar", e-> loadDades());
        barra.addNet("Sortir", e-> System.exit(0));
        barra.addFill("Usuaris");
        barra.addNet("Mostra", e-> {
            finestraUsuaris=new gestorUsuaris(adaptador,this);
            finestraUsuaris.obrir();
        });
        barra.addNet("Afegeix", e-> new OmplirUsuari(adaptador,this).obrir());
        barra.addFill("Exemplar");
        barra.addNet("Mostra", e-> {
            finestraExemplars=new gestorExemplars(adaptador,this);
            finestraExemplars.obrir();
        });
        barra.addNet("Afegeix", e-> new OmplirExemplar(adaptador,this).obrir());
        barra.addFill("Préstecs");
        barra.addNet("Mostra", e-> {
            finestraPrestecs=new gestorPrestecs(adaptador,this);
            finestraPrestecs.obrir();
        });
        barra.addNet("Afegeix", e-> new OmplirPrestec(adaptador,this).obrir());








    }
}
