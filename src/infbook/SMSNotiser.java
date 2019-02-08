/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

import com.teknikindustries.bulksms.SMS;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Léonard
 */
public class SMSNotiser {
    

    public SMSNotiser() {

    }

    public void skickaNotis(String meddelande, String phonenumber) {
        
            
            SMS smstut = new SMS();
            smstut.SendSMS("Leonardbd", "dragonvagen7", meddelande, phonenumber, "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");

    }
}
