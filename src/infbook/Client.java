package infbook;

import java.net.*;
import java.io.*;

/*
 * Klientklassen som dessutom innehåller en trådklass vars syfte är att lyssna på servern (se längre ner)
 */
public class Client {

    // Fält
    private ObjectInputStream sInput;
    private ObjectOutputStream sOutput;
    private Socket socket;
    private Inloggad cg;
    private String server, username;
    private int port;


    /*
     * Konstruktorn för klientklassen
     * Den tar in anropsparametrarna server (IP:en), port, användarnamn och GUI-klass
     */
    Client(String server, int port, String username, Inloggad cg) {
        this.server = server;
        this.port = port;
        this.username = username;
        this.cg = cg;
    }

    /*
     * Metod som startar klienten
     * Den instanserar en klientsocket som försöker ansluta till den angivna servern
     * Därefter försöker den skapa input- och outputstreams för kommunikationen samt en tråd som lyssnar på servern
     */
    public boolean start() {

        // Försöker ansluta till servern genom att instansera en klientsocket
        try {
            socket = new Socket(server, port);
        } catch (Exception ec) {
            sendMeddelandeTillKlient("Klienten kunde inte ansluta till servern");
            return false;
        }

        try {
            // Försöker skapa en objectinputstream
            sInput = new ObjectInputStream(socket.getInputStream());

            // Försöker skapa en objectoutputstream
            sOutput = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException eIO) {
            sendMeddelandeTillKlient("Ett fel uppstod");
            return false;
        }

        // Skapar en ny tråd vars syfte är att lyssna på servern
        new LyssnaPaServerTrad().start();

        /*
         * Försöker skicka ut användarnamnet till servern
         * Det här är den enda gången något skickas till servern direkt genom en sträng. I alla andra fall skickar vi det i form av objekt.
         */
        try {
            sOutput.writeObject(username);
            
            sendMeddelandeTillKlient("Klienten är nu ansluten till chattservern");
        } catch (IOException eIO) {
            sendMeddelandeTillKlient("Ett fel uppstod när ditt användarnamnet skulle skickas till servern");
            disconnect();
            return false;
        }
        return true;
    }

    /*
     * Metod som visar upp ett meddelande (oftast felmeddelande) i chattfönstret
     */
    private void sendMeddelandeTillKlient(String meddelande) {

        cg.append(meddelande + "\n");
    }

    /*
     * Metod som skickar ett meddelande till servern
     * Strängen som ska skickas görs först om till ett objekt
     */
    void sendMessage(ChatMessage msg) {
        try {
            sOutput.writeObject(msg);
        } catch (IOException e) {
            sendMeddelandeTillKlient("Ditt meddelande kunde inte skickas");
        }
    }

    /*
     * Metod som kopplar ifrån klienten från servern
     * Denna metod körs främst när något går fel och ett undantag fångas
     */
    private void disconnect() {

        // Försöker stänga ner inputstreamen
        try {
            if (sInput != null) {
                sInput.close();
            }
        } catch (Exception e) {
        }

        // Försöker stänga ner outputstreamen
        try {
            if (sOutput != null) {
                sOutput.close();
            }
        } catch (Exception e) {
        }

        // Försöker stänga ner klientsocketen
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (Exception e) {
        }

        // Informerar användargränssnittet att anslutning har avbrutits
        if (cg != null) {
            cg.connectionFailed();
        }

    }

    /*
     * En trådklass som avlyssnar servern och skickar ut det till chattfönstret
     */
    class LyssnaPaServerTrad extends Thread {

        /*
         * Trådens run-metod
         * Den innehåller en while loop som avläser det servern skickar ut
         * OBS: Eftersom detta är en trådklass körs run när man kallar på trådmetoden start
         */
        public void run() {

            // En while loop som körs kontinuerligt tills något går fel
            while (true) {
                try {

                    // Deklarar en lokalvariabel som används för att hämta strängar från servern
                    String meddelande;
                    try {

                        // Hämtar objektet från servern och gör om det till en sträng
                        meddelande = (String) sInput.readObject();

                        // Skickar vidare strängen till GUI
                        cg.append(meddelande);

                    } catch (ClassNotFoundException ex) {
                        break;
                    }
                } catch (IOException e) {
                    sendMeddelandeTillKlient("Servern har stängts ner");
                    cg.connectionFailed();

                    break;
                }
            }
        }
    }
}
