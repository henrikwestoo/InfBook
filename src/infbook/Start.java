/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author Tomasz Baslyk
 */
public class Start {

    private static Connection connection;

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Programmet kunde inte läsa in temat för gränssnittet: " + ex.getMessage());
        }
        
        try {
            // Försöker ansluta till databasen
            connection = DriverManager.getConnection("jdbc:firebirdsql://159.253.31.26:3050/C:/db/INFBOOKDB.FDB", "sysdba", "masterkey");
            new Inloggning(connection).setVisible(true);

            // Fångar fel med databasen och printar ut felmeddelande
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel med databasen!");
            System.out.println("Internt felmeddelande: " + e.getMessage());
        }

    }
}
