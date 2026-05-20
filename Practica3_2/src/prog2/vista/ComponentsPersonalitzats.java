package prog2.vista;import prog2.adaptador.Adaptador;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ComponentsPersonalitzats {
    private static Font FONT= new Font("Comfortaa", Font.PLAIN, 30);
    private static Font FONT_PETITA= new Font("Comfortaa", Font.PLAIN, 20);
    private static Font FONT_PETITONA= new Font("Comfortaa", Font.PLAIN, 15);
    private static Color COLOR_FONS = new Color(0Xb5b5b5);
    private static Color COLOR_FONS_FOSC = new Color(0X7c7c7c);
    private static Color COLOR_BOTO = Color.DARK_GRAY;
    private static Color COLOR_LLETRA = Color.white;
    private static Border BORDE_PETIT = BorderFactory.createEmptyBorder(5,10,5,10);
    private static Border BORDE_GRAN =BorderFactory.createEmptyBorder(10,20,10,20);


    public static class Boto extends JButton{
        public Boto (){
            super();
            setBackground(COLOR_BOTO); //Fondo
            setForeground(COLOR_LLETRA); // Letra
            setFocusPainted(false); //Quita la cosa fea del boton defecto
            setMargin(new Insets(20, 40, 20, 40)); // Aleja la letra del borde
            setFont(FONT);//:)
            setIconTextGap(15);//Aleja la imagen del texto si hay
        }
    }
    public static class Finestra extends JDialog{
        protected Adaptador adaptador;
        private Window pare;


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


        public void obrir (){
            if (pare != null){
                setVisible(true);
            }
        }
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
        private static String[] llistaFantsama = new String[] {"No hi ha elements a la llista"};
        private boolean isEmpty;
        public Llista (){
            setFixedCellHeight(35); //Espai ente Items
            setSelectionBackground(COLOR_FONS_FOSC);
            setSelectionForeground(COLOR_LLETRA);
            setBackground(COLOR_FONS);
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
        private static final Dimension dim = new Dimension(400,150);
        private static final ImageIcon WARNING = new ImageIcon(Check.class.getClassLoader().getResource("prog2/vista/imatges/warning.png"));
        private static final ImageIcon HAPPY = new ImageIcon(Check.class.getClassLoader().getResource("prog2/vista/imatges/happy.png"));

        public Missatge(Window pare, String missatge){
            super(pare, "Error",Dialog.ModalityType.APPLICATION_MODAL);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setResizable(false);
            setMinimumSize(dim);
            Panell contingut  = new Panell();
            Panell panelInf = new Panell(); //Como usare BorderLayout, añado un panel Inf para que el boton quede centrado en este panel pero no llene todoa el panel
            contingut.setLayout(new BorderLayout());


            //Missatge
            Etiqueta txt = new Etiqueta(missatge);
            txt.setFont(FONT_PETITA);
            txt.setIcon(WARNING);
            txt.setBackground(COLOR_FONS_FOSC);

            //Boto
            Boto boto =  new Boto();
            boto.setText("D'acord!");
            boto.setIcon(HAPPY);
            boto.setFont(FONT_PETITA);
            boto.addActionListener(e->dispose());

            //Importa el orden como se añaden al Border layout
            contingut.add(txt,BorderLayout.CENTER);
            contingut.add(panelInf,BorderLayout.SOUTH); //Abajo el panel
            panelInf.add(boto); //En el panel el boton

            getRootPane().setDefaultButton(boto);//Sale con enter
            setContentPane(contingut);

            pack(); //Deja que no se cote la etiqueta
            setLocationRelativeTo(pare);
            setVisible(true);
        }
    }

}
