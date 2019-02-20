package infbook;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Léonard
 */
public class VisatInlagg extends javax.swing.JFrame {

    private Connection connection;
    private String inlaggsID;
    private String status;
    private String angivetAnv;
    private String subK;
    private String anvandare;
    private File file;
    private InputStream is;
    private int b;
    private String titel;

    public VisatInlagg(Connection connection, String inlaggsID, String status, String angivetAnv) {
        this.connection = connection;
        this.inlaggsID = inlaggsID;
        this.status = status;
        this.angivetAnv = angivetAnv;
        this.titel = titel;

        initComponents();
        this.setResizable(false);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        txtAInlagg.setLineWrap(true);
        txtAInlagg.setEditable(false);
        txtAreaKommentar.setEditable(false);
        btnTaBortInlagg.setVisible(false);
        btnSpara.setVisible(false);
        btnRedigera.setVisible(false);
        lblTitel.setEditable(false);

        txtKommentar.setLineWrap(true);
        txtAreaKommentar.setLineWrap(true);

        kollaOmInlaggetFarTasBort();
        kollaOmInlaggetFarRedigeras();
        jLabel3.setVisible(false);
        txtNR.setVisible(false);//Swingen för att ta bort en kommentar
        lblNR.setVisible(false);
        btnTaBortBekrafta.setVisible(false);
        hmtaFil.setVisible(false);

        try {

            Statement stmt23 = connection.createStatement();
            ResultSet rsFiltyp23 = stmt23.executeQuery("SELECT TYP FROM FILER WHERE INLAGG='" + inlaggsID + "'");
            if(rsFiltyp23.next())
            {
            String typ = rsFiltyp23.getString("TYP");
            if (typ.contains(".jpg")) {
                lblBild2.setIcon(new ImageIcon(getClass().getResource("/images/jpg.png")));
                jLabel3.setVisible(true);
            } else if (typ.contains(".png")) {
                lblBild2.setIcon(new ImageIcon(getClass().getResource("/images/png.png")));
                jLabel3.setVisible(true);
            } else if (typ.contains(".pdf")) {
                lblBild2.setIcon(new ImageIcon(getClass().getResource("/images/pdf.png")));
                jLabel3.setVisible(true);
            } else if (typ.contains(".doc")) {
                lblBild2.setIcon(new ImageIcon(getClass().getResource("/images/docx.png")));
                jLabel3.setVisible(true);
            } else {
                hmtaFil.setVisible(true);
            }
            }
            Statement stmt20 = connection.createStatement();
            ResultSet rs20 = stmt20.executeQuery("SELECT PNR FROM ANVANDARE JOIN INLAGG ON INLAGG.ANVANDARE = ANVANDARE.PNR WHERE INLAGGSID ='" + inlaggsID + "'");
            rs20.next();
            String personen = rs20.getString("PNR");

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT TEXT FROM INLAGG WHERE INLAGGSID ='" + inlaggsID + "'");
            rs.next();
            txtAInlagg.setText(rs.getString("TEXT"));

            Statement stmt2 = connection.createStatement();
            ResultSet rs2 = stmt2.executeQuery("SELECT TITEL FROM INLAGG WHERE INLAGGSID ='" + inlaggsID + "'");
            rs2.next();
            String titel = rs2.getString("TITEL");
            lblTitel.setText(titel);

            Statement stmt7 = connection.createStatement();
            ResultSet rs7 = stmt7.executeQuery("SELECT FIL FROM FILER JOIN INLAGG ON INLAGG.INLAGGSID = FILER.INLAGG WHERE INLAGGSID ='" + inlaggsID + "'");
            if(rs7.next())
            {
            byte[] img = rs7.getBytes("FIL");

            ImageIcon image = new ImageIcon(img);
            Image im = image.getImage();
            Image myImg = im.getScaledInstance(lblBild.getWidth(), lblBild.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newImage = new ImageIcon(myImg);
            lblBild.setIcon(newImage);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        

        fyllKommentarer();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtAInlagg = new javax.swing.JTextArea();
        lblBild = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaKommentar = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnKommentera = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnTaBortInlagg = new javax.swing.JButton();
        btnRedigera = new javax.swing.JButton();
        btnSpara = new javax.swing.JButton();
        lblTitel = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtKommentar = new javax.swing.JTextArea();
        btnTaBortKommentar = new javax.swing.JButton();
        txtNR = new javax.swing.JTextField();
        btnTaBortBekrafta = new javax.swing.JButton();
        lblNR = new javax.swing.JLabel();
        lblNotis = new javax.swing.JLabel();
        lblNotis2 = new javax.swing.JLabel();
        lblBild2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        hmtaFil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtAInlagg.setColumns(20);
        txtAInlagg.setRows(5);
        jScrollPane1.setViewportView(txtAInlagg);

        txtAreaKommentar.setColumns(20);
        txtAreaKommentar.setRows(5);
        jScrollPane2.setViewportView(txtAreaKommentar);

        jLabel1.setText("Skriv kommentar");

        btnKommentera.setText("Kommentera");
        btnKommentera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKommenteraActionPerformed(evt);
            }
        });

        jLabel2.setText("Kommentarer:");

        btnTaBortInlagg.setText("Ta bort inlägg");
        btnTaBortInlagg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortInlaggActionPerformed(evt);
            }
        });

        btnRedigera.setText("Redigera inlägg");
        btnRedigera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedigeraActionPerformed(evt);
            }
        });

        btnSpara.setText("Spara");
        btnSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSparaActionPerformed(evt);
            }
        });

        txtKommentar.setColumns(20);
        txtKommentar.setRows(5);
        jScrollPane3.setViewportView(txtKommentar);

        btnTaBortKommentar.setText("Ta bort kommentar");
        btnTaBortKommentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortKommentarActionPerformed(evt);
            }
        });

        btnTaBortBekrafta.setText("Ta bort");
        btnTaBortBekrafta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortBekraftaActionPerformed(evt);
            }
        });

        lblNR.setText("#");

        lblBild2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBild2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBild2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblBild2MouseExited(evt);
            }
        });

        jLabel3.setText("Tryck för att hämta filen");

        hmtaFil.setText("Hämta bifogad fil");
        hmtaFil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hmtaFilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRedigera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSpara, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(btnTaBortInlagg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBild, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(lblBild2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hmtaFil)))
                    .addComponent(lblTitel))
                .addGap(13, 13, 13)
                .addComponent(lblNR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTaBortBekrafta, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNR, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNotis2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(148, 148, 148)
                            .addComponent(lblNotis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnKommentera, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnTaBortKommentar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lblBild, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRedigera)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSpara)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTaBortInlagg))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnKommentera)
                                    .addComponent(btnTaBortKommentar)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBild2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(hmtaFil))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnTaBortBekrafta)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtNR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblNR))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNotis, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblNotis2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaBortInlaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortInlaggActionPerformed

        try {
            Statement stmt = connection.createStatement();

            try {
                stmt.executeUpdate("DELETE FROM FILER WHERE INLAGG='" + inlaggsID + "'");
            } catch (SQLException e) {
            }
            try {
                stmt.executeUpdate("UPDATE KOMMENTAR SET ANVANDARE = NULL WHERE INLAGG =" + inlaggsID);
                stmt.executeUpdate("DELETE FROM KOMMENTAR WHERE INLAGG ='" + inlaggsID + "'");
            } catch (SQLException e) {
            }
//            try {
//                stmt.executeUpdate("DELETE FROM ANVANDARE_KOMMENTERA_INLAGG WHERE INLAGG='" + inlaggsID + "'");
//            } catch (SQLException e) {
//            }
            stmt.executeUpdate("DELETE FROM INLAGG WHERE INLAGGSID='" + inlaggsID + "'");
            //JOptionPane.showMessageDialog(null, "Inlägget har tagits bort!");
            dispose();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_btnTaBortInlaggActionPerformed

    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed
        String nyText = txtAInlagg.getText();
        try {

            Statement stmt4 = connection.createStatement();
            ResultSet rs4 = stmt4.executeQuery("SELECT PNR FROM ANVANDARE JOIN INLAGG ON INLAGG.ANVANDARE = ANVANDARE.PNR WHERE INLAGG.INLAGGSID ='" + inlaggsID + "'");
            rs4.next();
            anvandare = rs4.getString("PNR");

            Statement stmt5 = connection.createStatement();
            ResultSet rs8 = stmt5.executeQuery("SELECT SUBKATEGORIID FROM SUBKATEGORI JOIN INLAGG ON INLAGG.SUBKATEGORI = SUBKATEGORI.SUBKATEGORIID WHERE INLAGG.INLAGGSID ='" + inlaggsID + "'");
            rs8.next();
            subK = rs8.getString("SUBKATEGORIID");

            PreparedStatement stmt = connection.prepareStatement("UPDATE INLAGG SET INLAGGSID = ?, TEXT = ?, ANVANDARE =?, SUBKATEGORI =?, TITEL =? WHERE INLAGGSID = '" + inlaggsID + "'");
            stmt.setString(1, inlaggsID);
            stmt.setString(2, nyText);
            stmt.setString(3, anvandare);
            stmt.setString(4, subK);
            stmt.setString(5, lblTitel.getText());
            stmt.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Förändringarna har registrerats");
            lblNotis2.setText("Ändringar sparade!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
        }
    }//GEN-LAST:event_btnSparaActionPerformed

    private void btnRedigeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedigeraActionPerformed
        txtAInlagg.setEditable(true);
        btnSpara.setVisible(true);
        lblTitel.setEditable(true);
    }//GEN-LAST:event_btnRedigeraActionPerformed

    private void btnKommenteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKommenteraActionPerformed

        if (Validering.isTextAreaTomt(txtKommentar)) {

            Date d = new Date(); //Visar dagens datum
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd"); //Visar datumet i detta formatet.
            String datum = (s.format(d));

            LocalTime idag = LocalTime.now(); //Hämtar dagens tid

            String tid = idag.toString().substring(0, 5); // Kortar ned till 5 tecken (HH:MM)

            try {

                //Hämta MAX kommentarsID from kommentar
                Statement stmt = connection.createStatement();

                stmt.execute("SELECT MAX(KOMMENTARID) FROM KOMMENTAR");
                ResultSet rs = stmt.getResultSet();

                rs.next();
                int KID = rs.getInt("MAX") + 1; //här

                //Statement stmt2 = connection.createStatement();
                //ResultSet rs2 = stmt2.executeQuery("SELECT ANVANDARE FROM KOMMENTAR WHERE KOMMENTARID ="+KID+"");
                //rs2.next();
                //int anvandare = rs2.getInt("ANVANDARE");
                //String anvandare1 = Integer.toString(anvandare);
                //ta denna plus 1
                // detta blir vårt id för kommentaren
                //Ett ps som stoppar in all data i kommentar
                PreparedStatement ps = connection.prepareStatement("insert into KOMMENTAR(KOMMENTARID,INFO,DATUM,TID,ANVANDARE,INLAGG) values(?,?,?,?,?,?)");
                ps.setInt(1, KID);
                ps.setString(2, txtKommentar.getText());
                ps.setString(3, datum);
                ps.setString(4, tid);
                ps.setString(5, angivetAnv);
                ps.setString(6, inlaggsID);

                ps.executeUpdate();

                Statement stmt101 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY,
                        ResultSet.HOLD_CURSORS_OVER_COMMIT);
                ResultSet rs101 = stmt101.executeQuery("SELECT DISTINCT MOBILNMR FROM ANVANDARE JOIN KOMMENTAR ON KOMMENTAR.ANVANDARE = ANVANDARE.PNR WHERE KOMMENTAR.INLAGG = " + inlaggsID + "");

                Statement stmt103 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY,
                        ResultSet.HOLD_CURSORS_OVER_COMMIT);
                ResultSet rs103 = stmt103.executeQuery("SELECT MOBILNMR FROM ANVANDARE WHERE PNR ='" + angivetAnv+"'");

                rs103.next();

                String mittNR = rs103.getString("MOBILNMR");

                while (rs101.next()) {

                    String mobilnmr = rs101.getString("MOBILNMR");

                    if (mobilnmr.equals(mittNR)) {

                        System.out.println("Meddelandet skickades inte ut till :" + mittNR);

                    } else {

                        System.out.println(mobilnmr);
                        SMSNotiser hej = new SMSNotiser();
                        hej.skickaNotis("En ny kommentar har skrivits på ett inlägg som du har kommenterat på \n\n Med vänliga hälsningar, \n InfBook", mobilnmr);
                    }
                }

                Statement stmt102 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY,
                        ResultSet.HOLD_CURSORS_OVER_COMMIT);
                ResultSet rs102 = stmt102.executeQuery("SELECT DISTINCT EMAIL FROM ANVANDARE JOIN KOMMENTAR ON KOMMENTAR.ANVANDARE = ANVANDARE.PNR WHERE KOMMENTAR.INLAGG = " + inlaggsID + "");

                Statement stmt104 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY,
                        ResultSet.HOLD_CURSORS_OVER_COMMIT);
                ResultSet rs104 = stmt104.executeQuery("SELECT EMAIL FROM ANVANDARE WHERE PNR ='" + angivetAnv+"'");

                rs104.next();

                String minEMAIL = rs104.getString("EMAIL");

                while (rs102.next()) {
                    String email = rs102.getString("EMAIL");

                    if (email.equals(minEMAIL)) {

                        System.out.println("Mailet skickades inte till: " + email);

                    } else {

                        System.out.println(email);
                        SendMail.send(email, "Händelse från InfBook", "Någon har kommenterat på ett inlägg som du har kommenterat på, logga in för att ta reda på vad som har skrivits. \n\n Med vänliga hälsningar,\n InfBook", "mail@infbook.page", "Infbook2019");
                    }
                }

                //användar ps för varje kolumn
                //Variabler: KommentarID, txtArea.getText, dagens datum, dagens tid, anvandarAnv, inlaggsID
                fyllKommentarer();
                txtKommentar.setText("");

                txtNR.setVisible(false);//Swingen för att ta bort en kommentar
                lblNR.setVisible(false);
                btnTaBortBekrafta.setVisible(false);

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

    }//GEN-LAST:event_btnKommenteraActionPerformed

    private void btnTaBortKommentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortKommentarActionPerformed
        fyllKommentarerMedID();

        txtNR.setVisible(true);
        lblNR.setVisible(true);
        btnTaBortBekrafta.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_btnTaBortKommentarActionPerformed

    private void btnTaBortBekraftaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortBekraftaActionPerformed

        if (Validering.isTextFältTomt(txtNR)
                && Validering.isHeltal(txtNR)) {

            String KID = txtNR.getText(); //Angivet kommentarID, det man vill ta bort

            try {

                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT ANVANDARE FROM KOMMENTAR WHERE KOMMENTARID =" + KID); //Hittar vem som kommenterat

                rs.next();

                String kommenterareID = rs.getString("ANVANDARE"); //Variabel för den som kommenterat, IDt

                String posterStatus = getAnvandarStatus(inlaggsID);

                boolean FAbehorighet = false; //En boolean som kontrollerar om du har behörighet att ta bort en kommentar som forskningsadministratör

                if (status.equals("FA") && posterStatus.equals("F") || status.equals("FA") && posterStatus.equals("FA")) {

                    FAbehorighet = true;

                }

                boolean UAbehorighet = false; //En boolean som kontrollerar om du har behörighet att ta bort en kommentar som utbildningsadministratör

                if (status.equals("UA") && posterStatus.equals("U") || status.equals("UA") && posterStatus.equals("UA")) {

                    UAbehorighet = true;
                }

                if (kommenterareID.equals(angivetAnv) || status.equals("CA") || FAbehorighet || UAbehorighet) { //Om den som kommenterat är samma som den som är inloggad

                    Statement stmt1 = connection.createStatement();
                    stmt1.executeUpdate("DELETE FROM KOMMENTAR WHERE KOMMENTARID =" + KID);

                    fyllKommentarerMedID();
                    txtNR.setText("");
                    lblNotis.setText("Kommentaren har tagits bort!");
                    //JOptionPane.showMessageDialog(null, "Kommentaren har tagits bort");

                } else {

                    JOptionPane.showMessageDialog(null, "Du har inte behörighet att ta bort kommentaren");

                }

            } catch (SQLException e) {

                JOptionPane.showMessageDialog(null, e.getMessage());

            }
        }
    }//GEN-LAST:event_btnTaBortBekraftaActionPerformed

    private void lblBild2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBild2MouseClicked
        try {
            Statement stmt = connection.createStatement();
            ResultSet rsFiltyp = stmt.executeQuery("SELECT TYP FROM FILER WHERE INLAGG='" + inlaggsID + "'");

            if (rsFiltyp.next()) {

                String filtyp = rsFiltyp.getString("TYP");

                Statement stmt2 = connection.createStatement();
                ResultSet rsFil = stmt2.executeQuery("SELECT FIL FROM FILER WHERE INLAGG='" + inlaggsID + "'");
                rsFil.next();

                Blob enBlob = rsFil.getBlob("FIL");

                is = enBlob.getBinaryStream();
                b = 0;
                
                String sokvagen = LosenordsGenerator.createPassword();

                String home = System.getProperty("user.home");
                file = new File(home + "/Downloads/"+ sokvagen + filtyp);

                FileOutputStream os = null;
                try {
                    os = new FileOutputStream(file);

                    while ((b = is.read()) != -1) {
                        os.write(b);
                    }
                } catch (IOException ex) {
                    System.out.println("");
                }
                JOptionPane.showMessageDialog(null, "En " + filtyp + " fil har laddats ner i din nedladdningsmapp");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_lblBild2MouseClicked

    private void lblBild2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBild2MouseEntered
        lblBild2.setBackground(Color.CYAN);
    }//GEN-LAST:event_lblBild2MouseEntered

    private void lblBild2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBild2MouseExited
        lblBild2.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_lblBild2MouseExited

    private void hmtaFilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hmtaFilActionPerformed
        try {
            Statement stmt = connection.createStatement();
            ResultSet rsFiltyp = stmt.executeQuery("SELECT TYP FROM FILER WHERE INLAGG='" + inlaggsID + "'");

            if (rsFiltyp.next()) {

                String filtyp = rsFiltyp.getString("TYP");

                Statement stmt2 = connection.createStatement();
                ResultSet rsFil = stmt2.executeQuery("SELECT FIL FROM FILER WHERE INLAGG='" + inlaggsID + "'");
                rsFil.next();

                Blob enBlob = rsFil.getBlob("FIL");

                is = enBlob.getBinaryStream();
                b = 0;
                String sokvagen = LosenordsGenerator.createPassword();
                String home = System.getProperty("user.home");
                file = new File(home + "/Downloads/"+sokvagen + filtyp);

                FileOutputStream os = null;
                try {
                    os = new FileOutputStream(file);

                    while ((b = is.read()) != -1) {
                        os.write(b);
                    }
                } catch (IOException ex) {
                    System.out.println("");
                }
                JOptionPane.showMessageDialog(null, "En " + filtyp + " fil har laddats ner i din nedladdningsmapp");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_hmtaFilActionPerformed

    private void kollaOmInlaggetFarTasBort() { //Kollar om du har behörighet att ta bort ett inlägg
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ANVANDARE FROM INLAGG WHERE INLAGGSID='" + inlaggsID + "'");
            rs.next();
            String inlaggsAnvandare = rs.getString("ANVANDARE");

            //Inläggstatus = Utbildning
            if (getAnvandarStatus(inlaggsID).equals("UA") || getAnvandarStatus(inlaggsID).equals("U")) { //Om inlägget är skapat av en utbildare
                if (status.equals("CA") || status.equals("UA") || inlaggsAnvandare.equals(angivetAnv)) {//och du är inloggad som CA/UA/den som skapade inlägget
                    btnTaBortInlagg.setVisible(true); //kan du ta bort inlägget
                } else {
                    btnTaBortInlagg.setVisible(false);

                }
            } else if (getAnvandarStatus(inlaggsID).equals("FA") || getAnvandarStatus(inlaggsID).equals("F")) { //Om inlägget är skapat av en forskare
                if (status.equals("CA") || status.equals("FA") || inlaggsAnvandare.equals(angivetAnv)) { //och du är inloggad som CA/FA/ den som skapade inlägget
                    btnTaBortInlagg.setVisible(true); //så kan du ta bort inlägget
                } else {
                    btnTaBortInlagg.setVisible(false);

                }
            }

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public String getAnvandarStatus(String inlaggsID) { //Används för att kolla statusen på personen som gjort inlägget, returnerar statusen

        String status = "";

        try {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT STATUS FROM INLAGG JOIN ANVANDARE ON INLAGG.ANVANDARE = ANVANDARE.PNR WHERE INLAGGSID =" + inlaggsID);
            rs.next();

            status = rs.getString("STATUS"); //

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Något gick fel i databasen");
        }

        return status;

    }

    private void kollaOmInlaggetFarRedigeras() { //Kollar om du har behörighet att redigera ett inlägg
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ANVANDARE FROM INLAGG WHERE INLAGGSID='" + inlaggsID + "'");
            rs.next();
            String inlaggsAnvandare = rs.getString("ANVANDARE");

            if (getAnvandarStatus(inlaggsID).equals("UA") || getAnvandarStatus(inlaggsID).equals("U")) { //Om inlägget är skapat av en utbildare
                if (status.equals("CA") || status.equals("UA") || inlaggsAnvandare.equals(angivetAnv)) {//och du är inloggad som CA/UA/den som skapade inlägget
                    btnRedigera.setVisible(true); //kan du redigera inlägget
                } else {
                    btnRedigera.setVisible(false);

                }
            } else if (getAnvandarStatus(inlaggsID).equals("FA") || getAnvandarStatus(inlaggsID).equals("F")) { //Om inlägget är skapat av en forskare
                if (status.equals("CA") || status.equals("FA") || inlaggsAnvandare.equals(angivetAnv)) { //och du är inloggad som CA/FA/ den som skapade inlägget
                    btnRedigera.setVisible(true); //så kan du redigera inlägget
                } else {
                    btnRedigera.setVisible(false);

                }
            }

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    private void fyllKommentarer() { // Fyller kommentarsfältet med kommentarer

        txtAreaKommentar.setText(""); //Tömmer kommentarsfältet för en reset

        try {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT FORNAMN ||' '|| EFTERNAMN ||' '|| DATUM ||' '|| TID ||' \n'|| INFO AS INFORMATION FROM KOMMENTAR JOIN ANVANDARE ON ANVANDARE.PNR = KOMMENTAR.ANVANDARE WHERE INLAGG =" + inlaggsID);

            while (rs.next()) { //Fyller kommentarsfältet med kommentarer
                String kommentar = rs.getString("INFORMATION");
                txtAreaKommentar.append(kommentar + "\n\n");

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Det finns inga kommentarer");
        }
    }

    private void fyllKommentarerMedID() { // Fyller kommentarsfältet med kommentarer

        txtAreaKommentar.setText(""); //Tömmer kommentarsfältet för en reset

        try {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT KOMMENTARID ||'\n'|| FORNAMN ||' '|| EFTERNAMN ||' '|| DATUM ||' '|| TID ||' \n'|| INFO AS INFORMATION FROM KOMMENTAR JOIN ANVANDARE ON ANVANDARE.PNR = KOMMENTAR.ANVANDARE WHERE INLAGG =" + inlaggsID);

            while (rs.next()) { //Fyller kommentarsfältet med kommentarer
                String kommentar = rs.getString("INFORMATION");
                txtAreaKommentar.append("#" + kommentar + "\n\n");

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Det finns inga kommentarer");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKommentera;
    private javax.swing.JButton btnRedigera;
    private javax.swing.JButton btnSpara;
    private javax.swing.JButton btnTaBortBekrafta;
    private javax.swing.JButton btnTaBortInlagg;
    private javax.swing.JButton btnTaBortKommentar;
    private javax.swing.JButton hmtaFil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBild;
    private javax.swing.JLabel lblBild2;
    private javax.swing.JLabel lblNR;
    private javax.swing.JLabel lblNotis;
    private javax.swing.JLabel lblNotis2;
    private javax.swing.JTextField lblTitel;
    private javax.swing.JTextArea txtAInlagg;
    private javax.swing.JTextArea txtAreaKommentar;
    private javax.swing.JTextArea txtKommentar;
    private javax.swing.JTextField txtNR;
    // End of variables declaration//GEN-END:variables
}
