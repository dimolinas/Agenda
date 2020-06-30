package visual;

import datos.Contact;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Iterator;

import static logica.main.diary;

public class listWindow extends JFrame {

    private URL exitUrl = getClass().getResource("../Resources/exit32.png");
    Image logoExit = new ImageIcon(exitUrl).getImage();

    public listWindow() {

        this.setSize(1000, 200);
        this.setLocationRelativeTo(null);
        this.setTitle("Contactos");
        this.setIconImage(new ImageIcon(getClass().getResource("../Resources/logo.png")).getImage());
        this.setVisible(true);
        this.setBackground(Color.white);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        System.out.println("Contactos:");

        Object[][] data = {};
        String[] columnNames = {"Nombre", "Apellido", "Telefono", "Correo", "Empresa o Institución "};
        DefaultTableModel container = new DefaultTableModel(data,columnNames);
        JTable table = new JTable(container);

        for(int i = 0;i<diary.getDiary().size();i++){
            Object[] newRow ={
                    diary.getDiary().get(i).getName(),
                    diary.getDiary().get(i).getSurname(),
                    diary.getDiary().get(i).getPhone(),
                    diary.getDiary().get(i).getEmail(),
                    diary.getDiary().get(i).getInstitution()
            };
            container.addRow(newRow);
        }

        table.setPreferredScrollableViewportSize(new Dimension(500, 80));
        JScrollPane scrollpane = new JScrollPane(table);
        this.getContentPane().add(scrollpane, BorderLayout.CENTER);

        JButton salir = new JButton();
        salir.setSize(50,50);
        salir.setBorder(null);
        salir.setIcon(new ImageIcon(logoExit));
        salir.setFocusPainted(false);
        salir.setBackground(Color.white);
        this.getContentPane().add(salir,BorderLayout.SOUTH);
        salir.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cerrar();
            }
        });
    }

    public void cerrar(){
        this.setVisible(false);
    }
}