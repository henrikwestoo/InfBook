package infbook;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public static String createUsername(String fornamn, String efternamn) {

        String username = "";

        String fornamnfirst3 = fornamn.substring(0, 3).toLowerCase();
        String efternamnfirst3 = efternamn.substring(0, 3).toLowerCase();

        username += fornamnfirst3;
        username += efternamnfirst3;

        int langd = 3;

        for (int i = 0; i < langd; i++) {

            int index = generator.nextInt(numbers.length());
            username += numbers.charAt(index);

        }

        return username;
    }

}
