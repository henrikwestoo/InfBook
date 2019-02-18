package infbook;

//Imports
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

/*
* Serverklassen som också innehåller en trådklass vars syfte är att lyssna på klienten (se längre ner)
*/
public class Server {

    // Fält
    private static int uniqueId;
    private ArrayList<KlientTrad> klientlista;
    private ServerGUI enServerGUI;
    private SimpleDateFormat sdf;
    private int port;
    private boolean korLoop;

    /*
    * Konstruktor för själva servern
    * Den tar in porten och servergränssnittet som anropsparametrar
    */
    public Server(int port, ServerGUI sg) {
        this.enServerGUI = sg;
        this.port = port;

        // Datumformat som används för alla meddelanden
        sdf = new SimpleDateFormat("HH:mm:ss");

        // Arraylistan för alla klienter
        klientlista = new ArrayList<>();
    }

    /*
     * Metod som startar servern
     * Den instanserar en server socket (vilket kan ses som själva servern) och innehåller en while loop som lyssnar för inkommande klientanslutningar
     */
    public void start() {

        // En boolean som avgör om while loopen längre ner körs
        korLoop = true;

        try {
            // Själva server-socketen
            ServerSocket serverSocket = new ServerSocket(port);

            // Loop som används för att avlyssna anslutningar
            while (korLoop) {

                // Visar meddelande i serverloggen
                visaMeddelandePaServer("Servern avslyssnar anslutningar på porten " + port + ".");

                // Lyssnar för anslutningar och accepterar dem (samt lägger dem i en lokal klientsocket temporärt)
                Socket socket = serverSocket.accept();

                // If-sats som "stänger av" den påbörjade loopen
                if (!korLoop) {
                    break;
                }

                // Skapar en tråd för den accepterade anslutningen
                KlientTrad enTrad = new KlientTrad(socket);

                // Sparar anslutningen i en klientlistan så att man kan hålla koll på aktiva anslutningar
                klientlista.add(enTrad);

                // Startar själva tråden
                enTrad.start();
            }

            // Kod som körs när loopen stängs av
            try {

                // Stänger ner server-socketen
                serverSocket.close();

                // En for loop som stänger av alla klientsockets samt deras input- och outputstreams
                for (int i = 0; i < klientlista.size(); ++i) {

                    KlientTrad tc = klientlista.get(i);
                    try {
                        tc.sInput.close();
                        tc.sOutput.close();
                        tc.socket.close();

                    } catch (IOException e) {
                    }
                }
            } catch (Exception e) {
                visaMeddelandePaServer("Fel vid avstängning: " + e);
            }
        } catch (IOException e) {
            String msg = sdf.format(new Date()) + "Fel med servern: " + e + "\n";
            visaMeddelandePaServer(msg);
        }
    }

    /*
     * Metod som stänger ner servern
     * Den avbryter while loopen i metoden start
     */
    protected void stop() {
        korLoop = false;

        try {
            new Socket("localhost", port);
        } catch (Exception e) {
        }
    }

    /*
     * Metod som används för att visa upp ett meddelande i serverloggen
     * OBS: Det är inte ett samma sak som ett chattmeddelande!
     */
    private void visaMeddelandePaServer(String msg) {

        // Formaterar meddelande med datumformatet
        String time = sdf.format(new Date()) + " " + msg;

        // Skickar ut meddelandet till GUI
        enServerGUI.appendEvent(time + "\n");
    }

    /*
     * Metod som skickar ut ett meddelande till alla anslutna klienter
     * Den tar dessutom bort klienter som det inte går att skicka ut meddelande till från klientlistan 
     */
    private synchronized void sendMeddelande(String message) {
        // Lägger till datumformatet
        String tid = sdf.format(new Date());
        
        // Formaterar meddelandet
        String meddelande = tid + " " + message + "\n";
        
        // Visar meddelandet i server GUI
        enServerGUI.appendRoom(meddelande);

        /*
        * For loop som loopar igenom alla klienter
        * Loopen sker baklänges, då vi vill kunna ta bort klienter som kopplats bort
        */
        for (int i = klientlista.size(); --i >= 0;) {
            KlientTrad ct = klientlista.get(i);
            
            /* 
            *  Försöker skicka meddelandet till en klient
            *  Om meddelande inte kan skickas tas klienten bort från klientlistan
            */
            if (!ct.sendTillbakaMeddelande(meddelande)) {
                klientlista.remove(i);
                visaMeddelandePaServer("Användaren " + ct.anvandarnamn + " verkar ha kopplats av och har därför tagits bort från klientlistan.");
            }
        }
    }

    /*
    * Metod som tar bort klienten från klientlistan när den har loggat ut (stängt ner sitt klientfönster)
    */
    synchronized void taBort(int id) {
        // For loop som letar fram klienten som stängts av
        for (int i = 0; i < klientlista.size(); ++i) {
            KlientTrad ct = klientlista.get(i);
            
            // If-sats som kollar om ID:et matchar
            if (ct.id == id) {
                
                // Tar bort klienten från listan
                klientlista.remove(i);
                return;
            }
        }
    }


    /*
     * Trådklassen
     * Denna klassen instanseras för varje ansluten klient
     */
    class KlientTrad extends Thread {

        // Fält
        Socket socket;
        ObjectInputStream sInput;
        ObjectOutputStream sOutput;
        int id;
        String anvandarnamn;
        ChatMessage cm;
        String date;

        // Konstruktor för tråden
        KlientTrad(Socket socket) {
            
            // Gör så att varje tråd får ett unikt ID
            id = ++uniqueId;
            
            this.socket = socket;
            
            try {
                // Skapar en objectoutputstream
                sOutput = new ObjectOutputStream(socket.getOutputStream());
                
                // Skapar en objectinputstream
                sInput = new ObjectInputStream(socket.getInputStream());
                
                // Hämtar användarnamnet och printar i serverloggen att användaren har anslutit
                anvandarnamn = (String) sInput.readObject();
                visaMeddelandePaServer(anvandarnamn + " anslöt nyss till servern.");
                
            } catch (IOException e) {
                visaMeddelandePaServer("Kunde inte skapa output- eller inputstream: " + e);
                return;
            }
            catch (ClassNotFoundException e) {
                visaMeddelandePaServer("Kunde inte hämta användarnamnet: " + e);
            }
            
            // Hämtar datum och konverterar till sträng
            date = new Date().toString() + "\n";
        }

        /*
        * Trådens run-metod
        * Den innehåller en while loop som avläser det klienten gör
        * OBS: Eftersom detta är en trådklass körs run när man kallar på trådmetoden start
        */
        public void run() {
            // Boolean som avgör om loopen nedan körs
            boolean korTrad = true;
            
            // Själva loopen som avlyssnar klienten
            while (korTrad) {
                try {
                    /* Läser av data som klienten skickar
                    *  Datan överförs i form av ett objekt, men vi vet att den alltid är en sträng
                    */
                    cm = (ChatMessage) sInput.readObject();
                    
                    // Fångar eventuella undantag och stänger loopen
                } catch (IOException e) {
                    visaMeddelandePaServer("Kunde inte avläsa datan från klienten " + anvandarnamn + ": " + e);
                    break;
                } catch (ClassNotFoundException e2) {
                    break;
                }
                
                // Hämtar strängen (meddelandet)
                String message = cm.getMessage();

                /*
                * En switch-sats som kollar vilken typ av meddelande som har kommit in och hanterar det
                */
                switch (cm.getType()) {

                    // Om meddelandet är ett vanligt meddelande skickas det ut till alla anslutna klienter
                    case ChatMessage.MESSAGE:
                        sendMeddelande(anvandarnamn + ": " + message);
                        break;
                    
                    // Om meddelandet är ett LOGOUT-meddelandet (klienten stänger ner sitt fönster) meddelas servern och loopen stängs av
                    case ChatMessage.LOGOUT:
                        visaMeddelandePaServer(anvandarnamn + " kopplades bort.");
                        korTrad = false;
                        break;
                        
                    // Om meddelandet är ett WHOISIN-meddelande (klienten vill få reda på alla andra anslutna klienter) skickas det tillbaka en klientlista via outputstreamen
                    case ChatMessage.WHOISIN:
                        sendTillbakaMeddelande("Anslutna användare " + sdf.format(new Date()) + ":" + "\n");
                        
                        // For loop som hämtar alla klienter i klientlistan
                        for (int i = 0; i < klientlista.size(); ++i) {
                            KlientTrad ct = klientlista.get(i);
                            
                            // Skickar ut data om varje ansluten klient
                            sendTillbakaMeddelande((i + 1) + ") " + ct.anvandarnamn + "\n");
                        }
                        break;
                }
            }
            /*
            * Tar bort den aktuella klienten från klientlistann
            * Detta körs då enbart när loopen har stängs av
            */
            taBort(id);
            close();
        }

        /*
        * Metod som försöker stänga ner allt relaterat till klienttråden
        */
        private void close() {
            
            // Försöker stänga av outputstreamen
            try {
                if (sOutput != null) {
                    sOutput.close();
                }
            } catch (Exception e) {
                visaMeddelandePaServer("Det gick inte att stänga ner outputstreamen för klienten " + anvandarnamn);
            }
            // Försöker stänga av inputstreamen
            try {
                if (sInput != null) {
                    sInput.close();
                }
            } catch (Exception e) {
                visaMeddelandePaServer("Det gick inte att stänga ner inputputstreamen för klienten " + anvandarnamn);
            }
            
            // Försöker stänga av själva klientsocketen
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
                visaMeddelandePaServer("Det gick inte att stänga ner socketen för klienten " + anvandarnamn);
            }
        }

        /*
         * Metod som skickar tillbaka något till klienten via dess inputstream
         */
        private boolean sendTillbakaMeddelande(String meddelande) {
            
            // Kontrollerar först att klienten fortfarande är ansluten
            if (!socket.isConnected()) {
                close();
                return false;
            }
            
            // Försöker skickar meddelandet
            try {
                sOutput.writeObject(meddelande);
            }
            
            // Fångar fel och meddelar servern
            catch (IOException e) {
                visaMeddelandePaServer("Ett fel uppstod när data till klienten " + anvandarnamn + " försökte skickas ut");
                visaMeddelandePaServer(e.toString());
            }
            return true;
        }
    }
}
