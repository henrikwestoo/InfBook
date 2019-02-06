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

    private static Connection connection; //hejhejhej

    public static void main(String[] args) {

        try {
            // Försöker ansluta till databasen
            connection = DriverManager.getConnection("jdbc:firebirdsql://infbook.myscriptcase.com:3050//home/infbookm/INFBOOKDB.FDB", "infbookm", "masterkey");
            new Inloggning(connection).setVisible(true);

            // Fångar fel med databasen och printar ut felmeddelande
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel med databasen!");
            System.out.println("Internt felmeddelande: " + e.getMessage());
        }

    }
}
