package infbook;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Henrik
 */
public class LosenordsGenerator {

    private static Random generator = new Random();
    private static String dictionary = "abcdefghijklmnopqrstuvwxyz0123456789"; //symboler som plockas ut
    private static String numbers = "0123456789";

    public static String createPassword() {

        String losenord = "";
        int langd = 10;

        for (int i = 0; i < langd; i++) {

            int index = generator.nextInt(dictionary.length()); //väljer ut bokstäver/siffror
            losenord += dictionary.charAt(index); //bygger upp lösenordet

        }

        return losenord;

    }

    public static String createUsername(Connection connection, String fornamn, String efternamn) {

        String username = "";
        boolean abc = true;
        ArrayList<String> usernames = new ArrayList<String>();

        try {

            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.HOLD_CURSORS_OVER_COMMIT);

            ResultSet rs = stmt.executeQuery("SELECT PNR FROM ANVANDARE");

            while (abc) {

                username = "";

                String fornamnfirst3 = fornamn.substring(0, 3).toLowerCase();
                String efternamnfirst3 = efternamn.substring(0, 3).toLowerCase();

                username += fornamnfirst3;
                username += efternamnfirst3;

                int langd = 3;

                for (int i = 0; i < langd; i++) {

                    int index = generator.nextInt(numbers.length());
                    username += numbers.charAt(index);

                }

                boolean hittad = false;

                while (rs.next()) {

                    usernames.add(rs.getString("PNR"));
                }

                for (String usernamee : usernames) {

                   

                    if (username.equals(usernamee)) {

                        
                        hittad = true;
                        break;

                    }

                }

                if (hittad == false) {
                    abc = false; //loopen stängs

                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return username;

    }

}
