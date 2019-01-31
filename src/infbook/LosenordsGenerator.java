package infbook;


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
    
    
    public static String createPassword(){
    
    String losenord = "";
    int langd = 10;
    
    for(int i = 0; i < langd; i++)
    {
    
    int index = generator.nextInt(dictionary.length()); //väljer ut bokstäver/siffror
    losenord += dictionary.charAt(index); //bygger upp lösenordet
        
    }
    
    return losenord;
    
    }
    
    
}
