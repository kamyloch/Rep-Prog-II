package prog2.vista;

/*import org.kordamp.ikonli.swing.FontIcon;
import org.kordamp.ikonli.remixicon.RemixIcon;

// ...
JButton button = new JButton(" GitHub");
FontIcon githubIcon = FontIcon.of(RemixIcon.GITHUB_FILL);
githubIcon.setIconSize(20); // Ajusta el tamaño
button.setIcon(githubIcon);*/ // El chat me dio esto para ponerle Iconos bonitos a los botones... Se ve facil asi que me gustaria probarlo


import prog2.adaptador.Adaptador;

import javax.swing.*;/9
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ComponentsPersonalitzats {
    private static Font FONT= new Font("Comfortaa", Font.PLAIN, 30);
    private static Font FONT_PETITA= new Font("Comfortaa", Font.PLAIN, 20);
    private static Color COLOR_FONS = new Color(0Xb5b5b5);
    //private static Image LOGO = new ImageIcon("prog2/vista/imatges/logo.png").getImage();

    public static class Boto extends JButton{
        public Boto (){
            super();
            setBackground(Color.DARK_GRAY); //Fondo
            setForeground(Color.WHITE); // Letra
            setFocusPainted(false); //Quita la cosa fea del boton defecto
            setMargin(new Insets(20, 40, 20, 40)); // Aleja la letra del borde
            setFont(FONT);//:)
            setIconTextGap(15);//Aleja la imagen del texto si hay
        }
    }
    public static class Finestra extends JFrame{
        protected Adaptador adaptador;
        private Finestra pare;
        public Finestra(Adaptador adaptador, Finestra pare){
            this.adaptador = adaptador;
            this.pare = pare;
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Para gestionar el pare
            setMinimumSize(new Dimension(700, 500));
            setLocationRelativeTo(null);  //Aparece en el medio
            setBackground(COLOR_FONS);
            //setIconImage(LOGO);
            if(pare != null)
                addWindowListener(new WindowAdapter() { //desbloqueja el pare si es tanca amb X
                    public void windowClosed(WindowEvent e) {
                        pare.setBloquejar(false);
                    }
                });
            else
                setDefaultCloseOperation(EXIT_ON_CLOSE); //Si no hay padre todo muere
        }
        public void setBloquejar(boolean bloquear) { //Gemini
            JPanel glass = (JPanel) getGlassPane();
            if (bloquear) {
                glass.setVisible(true);
                glass.addMouseListener(new java.awt.event.MouseAdapter() {});
                glass.addKeyListener(new java.awt.event.KeyAdapter() {});
                glass.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

                glass.setBackground(new Color(0, 0, 0, 50));
                glass.setOpaque(true);

            } else {
                glass.setVisible(false);
                glass.setOpaque(false);
                for (java.awt.event.MouseListener ml : glass.getMouseListeners()) glass.removeMouseListener(ml); //Neteja els escoltadors fantasma
            }
        }

        public void obrir (){
            if (pare != null){
                pare.setBloquejar(true);
            }
            setVisible(true);
        }
        public void tancar (){
            if (pare != null){
                pare.setBloquejar(false);
                setVisible(false);
            }
            else //Si no hi ha pare, tot mor
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
        public Llista (){
            setFixedCellHeight(35); //Espai ente Items
            setSelectionBackground(COLOR_FONS);
            setSelectionForeground(Color.WHITE);
            setBackground(COLOR_FONS);
            setForeground(Color.WHITE);
            setFont(FONT_PETITA);
            setMaximumSize(new Dimension(400,800));

        }
    }

}
