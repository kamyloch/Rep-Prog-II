package prog2.vista;import prog2.adaptador.Adaptador;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

import static java.util.Objects.*;

/**
 * Clase on es defineixen els components personalitzats que mantenen la estética de la UI
 */
public class ComponentsPersonalitzats {
    private static final Font FONT= new Font("Comfortaa", Font.PLAIN, 30);
    private static final Font FONT_PETITA= new Font("Comfortaa", Font.PLAIN, 20);
    private static final Font FONT_PETITONA= new Font("Comfortaa", Font.PLAIN, 15);
    private static final Color COLOR_FONS = new Color(0Xb5b5b5);
    private static final Color COLOR_FONS_FOSC = new Color(0X7c7c7c);
    private static final Color COLOR_FONS_FOSCOR = new Color(0X545454);
    private static final Color COLOR_BOTO = new Color(0X545454);
    private static final Color COLOR_LLETRA = Color.white;
    private static final Border BORDE_PETIT = BorderFactory.createEmptyBorder(5,10,5,10);
    private static final Border BORDE_GRAN =BorderFactory.createEmptyBorder(10,20,10,20);

    /**
     * JButton personalitzat amb la estética
     */
    public static class Boto extends JButton{
        {
            UIManager.put("ToolTip.font", FONT_PETITONA);
            UIManager.put("ToolTip.background", COLOR_FONS_FOSC);
            UIManager.put("ToolTip.foreground", COLOR_LLETRA);
        }
        public Boto (String tip){
            super();
            if (tip != null)
                setToolTipText(tip);
            init();
        }
        public Boto (){
            super();
            init();
        }
        private void init (){
            setBackground(COLOR_BOTO); //Fondo
            setForeground(COLOR_LLETRA); // Letra
            setFocusPainted(false); //Quita la cosa fea del boton defecto
            setMargin(new Insets(20, 40, 20, 40)); // Aleja la letra del borde
            setFont(FONT);//:)
            setIconTextGap(15);//Aleja la imagen del texto si hay
        }
    }

    /**
     * JDialog personalitzat amb la estética
     */
    public abstract static class Finestra extends JDialog{
        protected Adaptador adaptador;
        private final Window pare;

        /**
         * Constructor de Finestra
         * @param adaptador Dades de la biblioUB
         * @param pare Finestra que obre el diàleg
         */
        public Finestra(Adaptador adaptador, Window pare){
            super(pare, Dialog.ModalityType.APPLICATION_MODAL);
            this.adaptador = adaptador;
            this.pare = pare;
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Para gestionar el pare
            setMinimumSize(new Dimension(700, 500));
            setLocationRelativeTo(null);  //Aparece en el medio
            setBackground(COLOR_FONS);
            //setIconImage(LOGO);
        }

        /**
         * Posa Visible el diàleg
         */
        public void obrir (){
            if (pare != null){
                setVisible(true);
            }
        }

        /**
         * Tanca la finestra amb dispose y sobreposa la finestra pare
         */
        public void tancar (){
            if (pare != null){
                pare.setVisible(true);//aunque siempre es visible, lo sobrepone si esta en el fondo
            }
            dispose();
        }
    }
    public static class Panell extends JPanel{
        public Panell(){
        super();
        setBackground(COLOR_FONS);
        }
    }
    public static class Llista extends JList{
        private static final String[] llistaFantsama = new String[] {"No hi ha elements a la llista"};
        private boolean isEmpty;
        public Llista (){
            setFixedCellHeight(35); //Espai ente Items
            setSelectionBackground(COLOR_FONS_FOSCOR);
            setSelectionForeground(COLOR_LLETRA);
            setBackground(COLOR_FONS_FOSC);
            setForeground(COLOR_LLETRA);
            setFont(FONT_PETITA);
            isEmpty = true;

            //setBorder(BORDE_GRAN);
        }
        @Override
        public void setListData(Object[] lista) {
            if(lista == null || lista.length == 0){
                isEmpty = true;
                super.setListData(llistaFantsama);
            }
            else{
                isEmpty = false;
                super.setListData(lista);
            }
        }
        @Override
        public boolean isSelectionEmpty(){ //por la fantasma
            if (isEmpty)
                return false;
            return super.isSelectionEmpty();
        }
    }

    public static class Check extends JCheckBox{
        private static final ImageIcon CHECK_ON = new ImageIcon(Check.class.getClassLoader().getResource("prog2/vista/imatges/check_on.png"));
        private static final ImageIcon CHECK_OFF = new ImageIcon(Check.class.getClassLoader().getResource("prog2/vista/imatges/check_off.png"));
        public Check(){
            setFont(FONT);
            setBackground(COLOR_FONS_FOSC);
            setForeground(COLOR_LLETRA);
            setBorder(BORDE_PETIT);
            setFocusPainted(false);//Seleccion por defecto

            setSelectedIcon(CHECK_ON);
            setIcon(CHECK_OFF);

        }
    }
    public static class CampText extends JTextField{
        public CampText(){
            super();
            setBackground(COLOR_FONS_FOSC);
            setBorder(BORDE_PETIT);
            setFont(FONT);
            setForeground(COLOR_LLETRA);
        }
    }
    public static class Etiqueta extends JLabel{
        public Etiqueta (){
            super();
            setBackground(COLOR_FONS_FOSC);
            setForeground(COLOR_LLETRA);
            setFont(FONT);
            setBorder(BORDE_GRAN);
        }
        public Etiqueta (String s){
            super(s);
            setBackground(COLOR_FONS_FOSC);
            setForeground(COLOR_LLETRA);
            setFont(FONT);
            setBorder(BORDE_GRAN);
        }
    }

    public static class ComboCaixa extends JComboBox{
        public ComboCaixa(){
            super();
            setBackground(COLOR_FONS_FOSC);
            setForeground(COLOR_LLETRA);
            setFont(FONT_PETITONA);
            setBorder(BORDE_GRAN);
        }
    }

    public static class Missatge extends JDialog{
        //Alternativa a hacer esto:
        //JOptionPane.showMessageDialog(pare,txt ,"Error",JOptionPane.ERROR_MESSAGE); //<- NATIVA DE JAVA
        private static final Dimension dim = new Dimension(400,200);
        private static final ImageIcon WARNING_PNG = new ImageIcon(Check.class.getClassLoader().getResource("prog2/vista/imatges/warning.png"));
        private static final ImageIcon HAPPY_PNG = new ImageIcon(Check.class.getClassLoader().getResource("prog2/vista/imatges/happy.png"));
        private static final ImageIcon INFO_PNG = new ImageIcon(Check.class.getClassLoader().getResource("prog2/vista/imatges/info.png"));
        private static final ImageIcon FESTA_PNG = new ImageIcon(Check.class.getClassLoader().getResource("prog2/vista/imatges/party.png"));
        private static final ImageIcon CHECK_PNG = new ImageIcon(Check.class.getClassLoader().getResource("prog2/vista/imatges/check.png"));

        public enum Tipus {ERROR, INFO,LLEST,FESTA}
        public Missatge(Window pare, String missatge, String titol, Tipus tipo){
            super(pare, titol,Dialog.ModalityType.APPLICATION_MODAL);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setResizable(false);
            setMinimumSize(dim);
            Panell contingut  = new Panell();
            Panell panelInf = new Panell(); //Como usare BorderLayout, añado un panel Inf para que el boton quede centrado en este panel pero no llene todoa el panel
            Panell panelSup  = new Panell();
            panelInf.setBackground(COLOR_FONS_FOSC);
            panelSup.setBackground(COLOR_FONS_FOSC);
            contingut.setLayout(new BorderLayout());


            //Missatge

            Etiqueta txt = new Etiqueta(missatge);
            txt.setFont(FONT_PETITA);
            switch (tipo){
                case ERROR-> txt.setIcon(WARNING_PNG);
                case INFO-> txt.setIcon(INFO_PNG);
                case FESTA -> txt.setIcon(FESTA_PNG);
                case LLEST -> txt.setIcon(CHECK_PNG);
            }

            //Boto
            Boto boto =  new Boto();
            boto.setText("D'acord!");
            boto.setIcon(HAPPY_PNG);
            boto.setFont(FONT_PETITA);
            boto.addActionListener(e->dispose());

            //Importa el orden como se añaden al Border layout
            contingut.add(panelSup,BorderLayout.CENTER);
            contingut.add(panelInf,BorderLayout.SOUTH); //Abajo el panel
            panelInf.add(boto); //En el panel el boton
            panelSup.add(txt);

            getRootPane().setDefaultButton(boto);//Sale con enter
            setContentPane(contingut);

            pack(); //Deja que no se cote la etiqueta
            setLocationRelativeTo(pare);
            setVisible(true);
        }
    }
    public static class MenuPare extends JMenuBar {
        private MenuFill last_Fill;
        public MenuPare (){
            last_Fill = null;
            setBackground(COLOR_FONS_FOSC);
        }
        public void addFill(String nom){
            last_Fill = new MenuFill(nom);
            add(last_Fill);
        }
        public void addNet(String nom, ActionListener e){
            if (last_Fill == null) return;
            MenuNet nou = new MenuNet(nom);
            nou.addActionListener(e);
            last_Fill.add(nou);
        }

    }
    public static class MenuFill extends JMenu{
        public MenuFill(String nom){
            super(nom);
            setForeground(COLOR_LLETRA);
            setFont(FONT_PETITONA);
            setBackground(COLOR_FONS_FOSC);
        }
    }
    public static class MenuNet extends JMenuItem{
        public MenuNet(String nom){
            super(nom);
            setForeground(COLOR_FONS_FOSC);
            setFont(FONT_PETITONA);
            setBackground(COLOR_LLETRA);
        }
    }
}
