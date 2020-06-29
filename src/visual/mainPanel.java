package visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;

public class mainPanel extends JPanel {

    //Logo Contacts
    private URL contacts = getClass().getResource("../Resources/new.png");
    Image logoContacts = new ImageIcon(contacts).getImage();
    //logo newContact
    private URL newContact = getClass().getResource("../Resources/logoContacts.png");
    Image logoNew = new ImageIcon(newContact).getImage();
    //logo exit
    private URL exitUrl = getClass().getResource("../Resources/exit32.png");
    Image logoExit = new ImageIcon(exitUrl).getImage();

    public mainPanel(){

        this.setLayout(null);
        this.setVisible(true);

        //Title
        JLabel title = new JLabel();
        title.setText("Agenda");
        title.setBounds(225,30,150,80);
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        title.setFont(new Font("Summer Tropical Personal Use",Font.PLAIN,50));
        this.add(title);

        //New Contact
        JButton newContact = new JButton();
        newContact.setBounds(220,140,200,40);
        newContact.setText("Nuevo Contacto");
        newContact.setBorder(null);
        newContact.setFocusPainted(false);
        newContact.setBackground(Color.WHITE);
        this.add(newContact);
        newContact.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contactWindow contactWindow = new contactWindow();
            }
        });

        //Contacts
        JButton contact = new JButton();
        contact.setBounds(220,190,200,40);
        contact.setText("Contactos");
        contact.setBorder(null);
        contact.setFocusPainted(false);
        contact.setBackground(Color.white);
        this.add(contact);
        contact.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listWindow listWindow = new listWindow();
            }
        });

        JButton exit = new JButton();
        exit.setBounds(540,220,32,32);
        exit.setIcon(new ImageIcon(logoExit));
        exit.setBorder(null);
        exit.setHorizontalAlignment(SwingConstants.CENTER);
        exit.setVerticalAlignment(SwingConstants.CENTER);
        exit.setFocusPainted(false);
        exit.setBackground(Color.white);
        this.add(exit);
        exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
    public void paint(Graphics g){
        g.drawImage(logoContacts,180,145,30,30,this);
        g.drawImage(logoNew,180,195,30,30,this);
        this.setOpaque(false);
        super.paint(g);
    }
}
