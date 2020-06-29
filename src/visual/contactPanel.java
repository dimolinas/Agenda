package visual;

import com.sun.tools.javac.Main;
import datos.Contact;
import logica.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;

import static logica.main.diary;
import static logica.main.main;

public class contactPanel extends JPanel {

    private URL logoUrl = getClass().getResource("../Resources/logoNewA.png");
    Image logoImg = new ImageIcon(logoUrl).getImage();

    private URL agreeUrl = getClass().getResource("../Resources/okA.png");
    Image logoAgree = new ImageIcon(agreeUrl).getImage();

    private URL cancelUrl = getClass().getResource("../Resources/cancelA.png");
    Image logoCancel = new ImageIcon(cancelUrl).getImage();

    public contactPanel() throws IOException {

        this.setLayout(null);
        this.setBackground(Color.white);

        //Eiqueta del titulo
        JLabel title = new JLabel();
        title.setText("Nuevo Contacto");
        title.setBounds(330,10,240,80);
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        title.setFont(new Font("Summer Tropical Personal Use",Font.PLAIN,40));
        this.add(title);

        JLabel name = new JLabel();
        name.setText("Nombres");
        name.setBounds(230,80,100,50);
        name.setHorizontalTextPosition(SwingConstants.CENTER);
        this.add(name);

        JTextField nameText = new JTextField();
        nameText.setBounds(230,120,200,25);
        this.add(nameText);

        JLabel surname = new JLabel();
        surname.setText("Apellidos");
        surname.setBounds(450,80,100,50);
        this.add(surname);

        JTextField surnameText = new JTextField();
        surnameText.setBounds(450,120,200,25);
        this.add(surnameText);

        JLabel company = new JLabel();
        company.setText("Empresa");
        company.setBounds(80,145,100,50);
        this.add(company);

        JTextField companyText = new JTextField();
        companyText.setBounds(230,160,300,25);
        this.add(companyText);

        JLabel mail = new JLabel();
        mail.setText("E-mail");
        mail.setBounds(80,180,100,50);
        this.add(mail);

        JTextField mailText = new JTextField();
        mailText.setBounds(230,200,300,25);
        this.add(mailText);

        JLabel phone = new JLabel();
        phone.setText("Phone");
        phone.setBounds(80,215,100,50);
        this.add(phone);

        JTextField phoneText = new JTextField();
        phoneText.setBounds(230,240,300,25);
        this.add(phoneText);

        JButton agree = new JButton();
        agree.setBounds(590,170,30,30);;
        agree.setOpaque(false);
        agree.setIcon(new ImageIcon(logoAgree));
        agree.setBorder(null);
        agree.setFocusPainted(false);
        agree.setBackground(Color.white);
        this.add(agree);
         agree.addActionListener(new AbstractAction() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 boolean control = true;

                 String nombre = nameText.getText();
                 String apellido = surnameText.getText();
                 String empresa = companyText.getText();
                 String email = mailText.getText();
                 long telefono = 0;

                 if(nombre.length()<1){
                     control = false;
                     JOptionPane.showMessageDialog(null,"Nombre Erroneo","Error",JOptionPane.ERROR_MESSAGE);
                 }

                 if(nombre.length()<1){
                     control = false;
                     JOptionPane.showMessageDialog(null,"Apellido Erroneo","Error",JOptionPane.ERROR_MESSAGE);
                 }

                 if(email.indexOf("@") == -1 ){
                     control = false;
                     JOptionPane.showMessageDialog(null,"Falta @","Error",JOptionPane.ERROR_MESSAGE);
                 }

                 if(email.length() < 4){
                     control = false;
                     JOptionPane.showMessageDialog(null,"E-mail erroneo","Error",JOptionPane.ERROR_MESSAGE);
                 }

                 try{
                     telefono = Long.parseLong(phoneText.getText());
                 }catch (Exception w){
                     JOptionPane.showMessageDialog(null,"Telefono Erroneo","Error",JOptionPane.ERROR_MESSAGE);
                     control = false;
                 }

                 diary.getDiary().forEach(i-> System.out.println(i.toString()));
                 if(control){
                     diary.getDiary().add(new Contact(nombre,apellido,empresa,email,telefono));
                     try{
                         main.guardar();
                     }catch (IOException r){
                         System.out.println("Error archivo");
                     }
                     JOptionPane.showMessageDialog(null,"Contacto Agregado");
                     System.exit(0);
                 }
             }
         });

        JButton cancel = new JButton();
        cancel.setBounds(590,210,30,30);
        cancel.setOpaque(false);
        cancel.setIcon(new ImageIcon(logoCancel));
        cancel.setBorder(null);
        cancel.setFocusPainted(false);
        cancel.setBackground(Color.white);
        this.add(cancel);
        cancel.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g){
        g.drawImage(logoImg,5,-10,200,200,this);
        this.setOpaque(false);
        super.paint(g);
    }
}
