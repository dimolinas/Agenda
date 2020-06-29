package visual;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class contactWindow  extends JFrame {

    public contactWindow(){
        this.setSize(700,310);
        this.setLocationRelativeTo(null);
        this.setTitle("Nuevo Contacto");
        this.setIconImage(new ImageIcon(getClass().getResource("../Resources/new.png")).getImage());
        this.setVisible(true);
        this.setBackground(Color.white);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        try{
            contactPanel contactPanel = new contactPanel();
            this.getContentPane().add(contactPanel);
        }catch (IOException e){
            System.out.println("Error archivo");
        }
    }
}
