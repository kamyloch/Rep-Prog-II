package prog2.vista;

/*import org.kordamp.ikonli.swing.FontIcon;
import org.kordamp.ikonli.remixicon.RemixIcon;

// ...
JButton button = new JButton(" GitHub");
FontIcon githubIcon = FontIcon.of(RemixIcon.GITHUB_FILL);
githubIcon.setIconSize(20); // Ajusta el tamaño
button.setIcon(githubIcon);*/ // El chat me dio esto para ponerle Iconos bonitos a los botones... Se ve facil asi que me gustaria probarlo


import javax.swing.*;
import java.awt.*;

public class ComponentsPersonalitzats {
    private static Font FONT= new Font("Comfortaa", Font.PLAIN, 30);
    private static Color COLOR_FONS = new Color(0Xb5b5b5);


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
        public Finestra(){
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Mata solo la pestaña actual
            setMinimumSize(new Dimension(700, 500));
            setLocationRelativeTo(null);  //Aparece en el medio
            setVisible(true);
            setBackground(COLOR_FONS);
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
                for (java.awt.event.MouseListener ml : glass.getMouseListeners()) glass.removeMouseListener(ml);
            }
        }
    }
    public static class Panell extends JPanel{
        public Panell(){
        super();
        setBackground(COLOR_FONS);
        }
    }
}
