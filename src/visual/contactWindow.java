package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;

public class contactWindow  extends JFrame {

    public contactWindow(){
        this.setSize(700,310);
        this.setLocationRelativeTo(null);
        this.setTitle("Nuevo Contacto");
        this.setIconImage(new ImageIcon(getClass().getResource("../Resources/new.png")).getImage());
        this.setVisible(false);
        this.setBackground(Color.white);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        try{
            contactPanel contactPanel = new contactPanel();
            this.add(contactPanel);
        }catch (IOException e){
            System.out.println("Error archivo");
        }
    }
}
