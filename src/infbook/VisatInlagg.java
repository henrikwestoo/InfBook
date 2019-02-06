package infbook;

import java.awt.Image;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public VisatInlagg(Connection connection, String inlaggsID, String status, String angivetAnv) {
        this.connection = connection;
        this.inlaggsID = inlaggsID;
        this.status = status;
        this.angivetAnv = angivetAnv;

        initComponents();
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        txtAreaKommentar.setEditable(false);
        btnTaBortInlagg.setVisible(false);
        btnSpara.setVisible(false);
        btnRedigera.setVisible(false);
        lblTitel.setEditable(false);

        kollaOmInlaggetFarTasBort();

        try {
            Statement stmt20 = connection.createStatement();
            ResultSet rs20 = stmt20.executeQuery("SELECT PNR FROM ANVANDARE JOIN INLAGG ON INLAGG.ANVANDARE = ANVANDARE.PNR WHERE INLAGGSID ='" + inlaggsID + "'");
            rs20.next();
            String personen = rs20.getString("PNR");

            if (personen.equals(angivetAnv)) {

                btnRedigera.setVisible(true);
            }

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT TEXT FROM INLAGG WHERE INLAGGSID ='" + inlaggsID + "'");
            rs.next();
            textArea.setText(rs.getString("TEXT"));

            Statement stmt2 = connection.createStatement();
            ResultSet rs2 = stmt2.executeQuery("SELECT TITEL FROM INLAGG WHERE INLAGGSID ='" + inlaggsID + "'");
            rs2.next();
            String titel = rs2.getString("TITEL");
            lblTitel.setText(titel);

            Statement stmt7 = connection.createStatement();
            ResultSet rs7 = stmt7.executeQuery("SELECT FIL FROM FILER JOIN INLAGG ON INLAGG.INLAGGSID = FILER.INLAGG WHERE INLAGGSID ='" + inlaggsID + "'");
            rs7.next();
            byte[] img = rs7.getBytes("FIL");

            ImageIcon image = new ImageIcon(img);
            Image im = image.getImage();
            Image myImg = im.getScaledInstance(lblBild.getWidth(), lblBild.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon newImage = new ImageIcon(myImg);
            lblBild.setIcon(newImage);

        } catch (SQLException e) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        lblBild = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaKommentar = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lblannanFil = new javax.swing.JLabel();
        btnKommentera = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnTaBortInlagg = new javax.swing.JButton();
        btnRedigera = new javax.swing.JButton();
        btnSpara = new javax.swing.JButton();
        lblTitel = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        txtAreaKommentar.setColumns(20);
        txtAreaKommentar.setRows(5);
        jScrollPane2.setViewportView(txtAreaKommentar);

        jLabel1.setText("Skriv kommentar");

        btnKommentera.setText("Kommentera");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnKommentera, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTaBortInlagg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblBild, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(lblannanFil, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSpara))
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRedigera)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRedigera)
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBild, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnTaBortInlagg))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSpara)
                            .addComponent(lblannanFil, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKommentera))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                stmt.executeUpdate("DELETE FROM KOMMENTAR JOIN ANVANDARE_KOMMENTERA_INLAGG ON KOMMENTAR.KOMMENTARID=ANVANDARE_KOMMENTERA_INLAGG.KOMMENTAR WHERE ANVANDARE_KOMMENTERA_INLAGG.INLAGG ='" + inlaggsID + "'");
            } catch (SQLException e) {
            }
            try {
                stmt.executeUpdate("DELETE FROM ANVANDARE_KOMMENTERA_INLAGG WHERE INLAGG='" + inlaggsID + "'");
            } catch (SQLException e) {
            }
            stmt.executeUpdate("DELETE FROM INLAGG WHERE INLAGGSID='" + inlaggsID + "'");
            JOptionPane.showMessageDialog(null, "Inlägget har tagits bort!");
            dispose();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_btnTaBortInlaggActionPerformed

    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed
        String nyText = textArea.getText();
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
            JOptionPane.showMessageDialog(null, "Förändringarna har registrerats");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "hej");
        }
    }//GEN-LAST:event_btnSparaActionPerformed

    private void btnRedigeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedigeraActionPerformed
        textArea.setEditable(true);
        btnSpara.setVisible(true);
        lblTitel.setEditable(true);
    }//GEN-LAST:event_btnRedigeraActionPerformed

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
            }

            else if (getAnvandarStatus(inlaggsID).equals("FA") || getAnvandarStatus(inlaggsID).equals("F")) { //Om inlägget är skapat av en forskare
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKommentera;
    private javax.swing.JButton btnRedigera;
    private javax.swing.JButton btnSpara;
    private javax.swing.JButton btnTaBortInlagg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblBild;
    private javax.swing.JTextField lblTitel;
    private javax.swing.JLabel lblannanFil;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextArea txtAreaKommentar;
    // End of variables declaration//GEN-END:variables
}
