/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

import javax.swing.JOptionPane;
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
            JOptionPane.showMessageDialog(null, "Ett eller flera obligatoriska textfält är inte ifyllda.");

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

                JOptionPane.showMessageDialog(null, "En eller flera fält i formuläret får endast fyllas i med heltal");
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

            JOptionPane.showMessageDialog(null, "Endast bokstäver får användas när du fyller i namn");
            resultat = false;

        }

        return resultat;

    }

}
