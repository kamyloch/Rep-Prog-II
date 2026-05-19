package prog2.vista;
import prog2.adaptador.Adaptador;

import javax.swing.*;
import java.io.File;

import prog2.vista.ComponentsPersonalitzats.*;

public class AppBiblioUB extends Finestra {
    private JPanel PanelMenu;
    private JButton botoUsuaris;
    private JButton botoExemplars;
    private JButton botoPrestecs;
    private JButton botoGuarda;
    private JButton botoCarrega;
    private Finestra finestraUsuaris;
    private Finestra finestraExemplars;
    private Finestra finestraPrestecs;

    public AppBiblioUB (){ //Constructor per defecte
        super(new Adaptador(),null);
        go();
    }
    public AppBiblioUB(Adaptador ad) { //Constructor amb adaptador predefinit
        super(ad, null); //Preset
        go();

    }
    public void go (){

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
        botoCarrega.addActionListener(e -> { //MateixCodi de la part 1
            String srcFile = demanaPath(false); // Obtenir el fitxer d'entrada
            if (srcFile != null) {
                // Carregar les dades del fitxer triat
                try {
                    this.adaptador.carregaDades(srcFile);
                    System.err.println("Dades carregades");
                } catch (BiblioException ex) {
                    System.err.println("Error carregant les dades." + ex.getMessage());
                }

            }
        });
        botoGuarda.addActionListener(e -> {
            String dstFile = demanaPath(true); // Obtenir el fitxer de sortida
            if (dstFile != null) {
                // Guardar les dades al fitxer triat
                try {
                    this.adaptador.guardaDades(dstFile);
                    System.err.println("Dades guardades");
                } catch (BiblioException ex) {
                    System.err.println("Error guardant les dades: " + ex.getMessage());
                }
            }
        });

        setContentPane(PanelMenu); //Afegim el menú
        setTitle("BiblioUB"); //Title
        setVisible(true);
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
}
