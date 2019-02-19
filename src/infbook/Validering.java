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
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
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
    
    public static boolean validTimeFormat(JTextField fält)
    {
        boolean resultat = true;
        String text = fält.getText();
        String regexnmr = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
        
        if(!text.matches(regexnmr))
        {
            JOptionPane.showMessageDialog(null, "Tiden ska skrivas i formatet HH:mm");
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

    public static boolean isTelefonNummer(JTextField fält) {

        boolean resultat = true;

        String nummer = fält.getText();
        String nummer1 = nummer.substring(0, 2);
        
        int nummerlangd = nummer.length();
        System.out.println(nummerlangd);
        
        if (nummerlangd < 11 || !(nummer1.equals("46"))) {
            resultat = false;
            JOptionPane.showMessageDialog(null, "Telefonnummret måste börja med '46' och vara minst 11 siffror långt");
        }
        
        return resultat;

    }

    public static boolean isValidEmailAddress(JTextField fält) {
        boolean result = true;
        try {
            String email = fält.getText();
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
            JOptionPane.showMessageDialog(null, "Ange en giltig E-mail adress");
        }

        return result;
    }

    public static String makeFirstLetterUpperCase(String text) { //Används för att göra den första bokstaven i en String till en versal.
//Kodraden nedan plockar ut den första bokstaven ur värdet som angivits
//Vi använder metoden .toUpperCase() för att göra den bokstaven till en versal
//Vi lägger ihop bokstaven med resten av strängen, dvs hela strängen förutom första bokstaven (text.substring(1);
        String nyText = text.substring(0, 1).toUpperCase() + text.substring(1);
        return nyText;
    }
    
 
    
}
