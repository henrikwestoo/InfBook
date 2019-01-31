/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

/**
 *
 * @author Henrik
 */
public class KonverteraStatus { //Konverterar en förkortad status till en mer användarvänlig (CA -> Centraladmin)
    
    public static String konverteraStatus(String forkortning){
        
        String formatteradStatus = "";
        
       if(forkortning.equals("CA")){
        
        formatteradStatus = "Centraladministratör";
        
        }
        
        else if(forkortning == "UA"){
        
        formatteradStatus = "Utbildningsadministratör";
            
        }
        
        else if(forkortning == "FA"){
        
        formatteradStatus = "Forskningsadministratör";
        
        }
        
        else if(forkortning == "A"){
        
        formatteradStatus = "Amanuens";
        
        }
        else if(forkortning == "F"){
        
        formatteradStatus = "Forskningsanvändare";
        
        }
        else if(forkortning == "U"){
        
        formatteradStatus = "Utbildningsanvändare";
        
        }
        
        System.out.println(formatteradStatus);
        return formatteradStatus;
    
    
    }
    
    
}
