/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

/**
 *
 * @author Tomasz
 */
import java.sql.*;
import javax.swing.JOptionPane;

/**
 * @author Tomasz Baslyk
 */
public class Start {

    private static Connection connection; //hej

    public static void main(String[] args) {

        try {
            // Försöker ansluta till databasen
            connection = DriverManager.getConnection("jdbc:firebirdsql://10.22.15.91:3050/c:/db/infbookdb.fdb", "SYSDBA", "masterkey");

            // Fångar fel med databasen och printar ut felmeddelande
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel med databasen!");
            System.out.println("Internt felmeddelande: " + e.getMessage());
        }
        
        new Inloggning(connection).setVisible(true);

    }
}