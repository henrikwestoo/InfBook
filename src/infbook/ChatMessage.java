package infbook;

import java.io.*;
/*
 * Den här klassen definerar de typen av meddelanden som skickas mellan klient och server
 * Meddelandena skickas i form av objekt som senare konverteras till strängar
 * De olika meddelandetyperna avgör vad meddelandet faktiskt innebär
 */

public class ChatMessage implements Serializable {

    // De olika typerna:
    // WHOISIN används för att skicka klienten en lista på alla anslutna till chatten
    // MESSAGE skickar ett vanligt chattmeddelande
    // LOGOUT kopplar bort klienten från servern
    // Fält
    protected static final long serialVersionUID = 1112122200L;
    static final int WHOISIN = 0, MESSAGE = 1, LOGOUT = 2;
    private int type;
    private String message;

    // Konstruktor
    ChatMessage(int type, String message) {
        this.type = type;
        this.message = message;
    }

    // Getters nedanför
    
    int getType() {
        return type;
    }

    String getMessage() {
        return message;
    }
}
