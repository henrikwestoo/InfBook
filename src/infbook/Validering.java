/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Henrik
 */
public class Validering {

    public static boolean isTextFältTomt(JTextField fält) { //Validering för JTextFields för att kolla att man anger ett värde.

        boolean resultat = true;

        if (fält.getText().isEmpty()) { // Liknande ovan

            resultat = false;
            JOptionPane.showMessageDialog(null, "En eller flera obligatoriska fält är inte ifyllda");

        }
        return resultat;
    }

    public static boolean isTextAreaTomt(JTextArea fält) { //Validering för JTextFields för att kolla att man anger ett värde.

        boolean resultat = true;

        if (fält.getText().isEmpty()) { // Liknande ovan

            resultat = false;
            JOptionPane.showMessageDialog(null, "Textrutan är tom");

        }
        return resultat;
    }

    public static boolean isHeltal(JTextField textFält) {  //Kollar om det som står i textfältet består av heltal
        boolean resultat = true;

        String text = textFält.getText();

        if (text.isEmpty()) { //denna används för att godkänna en tom sträng, då man inte alltid behöver fylla i rutan

            return resultat;
        } else {

            try {
                text = textFält.getText();
                int textInt = Integer.parseInt(text); // parseInt metoden i Integerklassen används på strängen som finns i textfältet.
                // får vi ett exception vet vi att strängen inte består av heltal

            } catch (NumberFormatException e) { // och här fångar vi det undantaget och ger användaren ett lämpligt meddelande

                JOptionPane.showMessageDialog(null, "Ett eller flera fält måste fyllas i med heltal");
                resultat = false;
            }

            return resultat;
        }
    }

    public static boolean isString(JTextField fält) { //Validering för att kolla om värdet som matas in i en JTextField verkligen är en String.

        boolean resultat = true;
        String text = fält.getText(); // hämtar värdet i ett textfield
        String regex = "^[a-zA-ZÅÄÖåäö]+$"; //Ett regular expression som innehåller alla tecken vi vill tillåta

        if (text.isEmpty()) {
        } //Kontrollerar ifall strängen är tom. Stringvalideringen behöver inte ske ifall värdet är null
        else if (!text.matches(regex)) { // själva valideringen, kollar ifall det hämtade värdet inte stämmer överens med de tecken som vi tillät

            JOptionPane.showMessageDialog(null, "Ett eller flera fält måste fyllas i med bokstäver");
            resultat = false;

        }

        return resultat;

    }

    public static boolean personnummer(JTextField pnr) {

        boolean resultat = true;
        boolean heltal = true;

        String personnummer = pnr.getText();

        try {

            int intpnr = Integer.parseInt(personnummer);

        } catch (NumberFormatException e) {

            heltal = false;

        }

        int langd = personnummer.length();

        if (!(langd == 10)) {

            resultat = false;
            JOptionPane.showMessageDialog(null, "Personnummret måste skrivas med formatet ÅÅMMDDXXXX");

        }

        if (heltal == false) {

            resultat = false;
            JOptionPane.showMessageDialog(null, "Personnummret måste skrivas med formatet ÅÅMMDDXXXX");

        }

        return resultat;

    }

    public static boolean isJListTomt(JList lista) { //Validering för JLists för att kolla att man anger ett värde.

        boolean resultat = true;

        int index = lista.getSelectedIndex();
        if (index < 0) {

            resultat = false;
            JOptionPane.showMessageDialog(null, "Välj någonting i listan");

        }
        return resultat;
    }

    public static boolean isDateChooserTomt(JDateChooser fält) { //Validering för att kolla om ett datum är angett i samtliga DateChoosers.

        boolean resultat = true;
        Date datum = fält.getDate();

        if (datum == null) {

            resultat = false;
            JOptionPane.showMessageDialog(null, "Ett eller flera obligatoriska textfält är inte ifyllda.");

        }
        return resultat;
    }

    public static boolean usernameFinns(Connection connection, String username) {

        boolean finns = false;

        try {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT PNR FROM ANVANDARE");

            while (rs.next()) {

                if (username.equals(rs.getString("PNR"))) {

                    finns = true;
                    break;

                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if (finns == false) {
            JOptionPane.showMessageDialog(null, "Det angivna användarnamnet är inte giltigt");
        }
        return finns;

    }

}
