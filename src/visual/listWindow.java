package visual;

import datos.Contact;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Iterator;

import static logica.main.diary;

public class listWindow extends JFrame {
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
    }
}