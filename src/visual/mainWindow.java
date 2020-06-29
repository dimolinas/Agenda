package visual;
import javax.swing.*;
import java.awt.*;

public class mainWindow extends JFrame{

    public mainWindow(){

        //Configuración Ventana
        this.setTitle("Agenda");
        this.setSize(600,300);
        this.setIconImage(new ImageIcon(getClass().getResource("../Resources/logo.png")).getImage());
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        mainPanel mainPanel = new mainPanel();
        this.add(mainPanel);
    }
}


