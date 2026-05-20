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
    private MenuPare menubarra;
    //Fills
    private MenuFill menuUsuari;
    private MenuFill menuFitxer;
    private MenuFill menuExemplar;
    private MenuFill menuPrestec;
    //Nets
    private MenuNet menuCarregar;
    private MenuNet menuObrir;
    private MenuNet menuSortir;
    private MenuNet menuUserMostra;
    private MenuNet menuUserAfegir;
    private MenuNet menuExemplarMostra;
    private MenuNet menuExemplarAfegir;
    private MenuNet menuPrestecMostra;
    private MenuNet menuPrestecAfegir;



    public AppBiblioUB (){ //Constructor per defecte
        this.adaptador = new Adaptador();
        go();
    }
    public AppBiblioUB(Adaptador ad) { //Constructor amb adaptador predefinit
        this.adaptador = ad;//Preset
        go();
    }
    public void go (){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para gestionar el pare
        setMinimumSize(new Dimension(700, 500));
        setLocationRelativeTo(null);  //Aparece en el medio

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
        setJMenuBar(menubarra);

        setContentPane(PanelMenu); //Afegim el menú
        setTitle("BiblioUB"); //Title
        setVisible(true);
    }
    public void loadDades(){
        String cami = demanaPath(false);
        if (cami != null) {
            try {
                this.adaptador.carregaDades(cami);
            } catch (BiblioException ex) {
                new Missatge(this, ex.getMessage());
            }
        }
    }
    public void saveDades (){
        String cami = demanaPath(false);
        if (cami != null) {
            try {
                this.adaptador.guardaDades(cami);
            } catch (BiblioException ex) {
                new Missatge(this, ex.getMessage());
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
        botoCarrega = new Boto();
        botoGuarda = new Boto();
    }

    private void initMenuBar() {

        menubarra = new MenuPare();

        //Fills
        menuFitxer = new MenuFill("Fitxer");
        menuUsuari = new MenuFill("Usuaris");
        menuExemplar = new MenuFill("Exemplars");
        menuPrestec = new MenuFill("Préstec");
        menubarra.add(menuFitxer);
        menubarra.add(menuUsuari);
        menubarra.add(menuExemplar);
        menubarra.add(menuPrestec);

        //Nets
            //Fitxer
            menuCarregar = new MenuNet("Carregar");
            menuObrir  = new MenuNet("Obrir");
            menuSortir = new MenuNet("Sortir");
            menuFitxer.add(menuCarregar);
            menuFitxer.add(menuObrir);
            menuFitxer.add(menuSortir);

            //Fitxer
            menuUserAfegir = new MenuNet("Carregar");
            menuUserMostra = new MenuNet("Obrir");
            menuSortir = new MenuNet("Sortir");
            menuFitxer.add(menuCarregar);
            menuFitxer.add(menuObrir);
            menuFitxer.add(menuSortir);

            //Usuaris
            menuUserMostra =  new MenuNet("Mostrar");
            menuUserAfegir = new MenuNet("Afegir");



    }
}
