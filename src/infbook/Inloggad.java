/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

import com.toedter.calendar.JCalendar;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Henrik
 */
public class Inloggad extends javax.swing.JFrame {

    private Connection connection;
    private String status;
    private String angivetAnv;
    private DefaultListModel lista;

    public Inloggad(Connection connection, String status, String angivetAnv) {

        lista = new DefaultListModel();
        this.connection = connection;
        initComponents();
        btnSkapaUnderkategori.setVisible(false);
        this.status = status;
        this.angivetAnv = angivetAnv;

        fyllFlodeMedInlagg();

        btnSkapaSuperKategori.setVisible(false);
        btnSkapaAnvandare.setVisible(false);
        btnHanteraAnvandare.setVisible(false);
        txtArea.setEditable(false);

        if (status.equals("CA") || status.equals("UA") || status.equals("FA")) {
            btnSkapaSuperKategori.setVisible(true);
            btnSkapaAnvandare.setVisible(true);
            btnHanteraAnvandare.setVisible(true);
        }

        String braStatus = KonverteraStatus.konverteraStatus(status);
        lblStatus.setText(braStatus);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        tabFlode = new javax.swing.JTabbedPane();
        pnlForskning = new javax.swing.JPanel();
        pnlInformell = new javax.swing.JPanel();
        pnlUtbildning = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstInlagg = new javax.swing.JList();
        lblFloden = new javax.swing.JLabel();
        btnSkapaInlagg = new javax.swing.JButton();
        btnSkapaUnderkategori = new javax.swing.JButton();
        btnMinProfil = new javax.swing.JButton();
        btnHanteraAnvandare = new javax.swing.JButton();
        lblInloggadSom = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        btnVisaMarkeratInlagg = new javax.swing.JButton();
        btnSkapaSuperKategori = new javax.swing.JButton();
        btnSkapaAnvandare = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnLoggaUt = new javax.swing.JButton();
        sprHog = new javax.swing.JSeparator();
        sprMitten = new javax.swing.JSeparator();
        sprLag = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        kalender = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnVisaMote = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Infbook");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Inloggning.class.getResource("/images/infbookIcon.png")));

        pnlForskning.setMinimumSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout pnlForskningLayout = new javax.swing.GroupLayout(pnlForskning);
        pnlForskning.setLayout(pnlForskningLayout);
        pnlForskningLayout.setHorizontalGroup(
            pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
        );
        pnlForskningLayout.setVerticalGroup(
            pnlForskningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );

        tabFlode.addTab("Forskning", pnlForskning);

        pnlInformell.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout pnlInformellLayout = new javax.swing.GroupLayout(pnlInformell);
        pnlInformell.setLayout(pnlInformellLayout);
        pnlInformellLayout.setHorizontalGroup(
            pnlInformellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
        );
        pnlInformellLayout.setVerticalGroup(
            pnlInformellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );

        tabFlode.addTab("Informell", pnlInformell);

        jScrollPane2.setViewportView(lstInlagg);

        javax.swing.GroupLayout pnlUtbildningLayout = new javax.swing.GroupLayout(pnlUtbildning);
        pnlUtbildning.setLayout(pnlUtbildningLayout);
        pnlUtbildningLayout.setHorizontalGroup(
            pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
        );
        pnlUtbildningLayout.setVerticalGroup(
            pnlUtbildningLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
        );

        tabFlode.addTab("Utbildning", pnlUtbildning);

        lblFloden.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFloden.setText("Samtliga bloggflöden");

        btnSkapaInlagg.setText("Skapa inlägg");
        btnSkapaInlagg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaInlaggActionPerformed(evt);
            }
        });

        btnSkapaUnderkategori.setText("Skapa underkategori");
        btnSkapaUnderkategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaUnderkategoriActionPerformed(evt);
            }
        });

        btnMinProfil.setText("Min profil");
        btnMinProfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinProfilActionPerformed(evt);
            }
        });

        btnHanteraAnvandare.setText("Hantera användare");
        btnHanteraAnvandare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHanteraAnvandareActionPerformed(evt);
            }
        });

        lblInloggadSom.setText("Inloggad som:");

        btnVisaMarkeratInlagg.setText("Visa markerat inlägg");
        btnVisaMarkeratInlagg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaMarkeratInlaggActionPerformed(evt);
            }
        });

        btnSkapaSuperKategori.setText("Skapa överkategori");
        btnSkapaSuperKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaSuperKategoriActionPerformed(evt);
            }
        });

        btnSkapaAnvandare.setText("Skapa användare");
        btnSkapaAnvandare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaAnvandareActionPerformed(evt);
            }
        });

        btnRefresh.setText("↻");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnLoggaUt.setText("Logga ut");
        btnLoggaUt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoggaUtActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/infbookIcon2small.png"))); // NOI18N

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        btnVisaMote.setText("Visa möten");
        btnVisaMote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaMoteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMinProfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSkapaInlagg, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSkapaUnderkategori, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(btnLoggaUt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnHanteraAnvandare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSkapaSuperKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addComponent(btnSkapaAnvandare, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(sprMitten, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sprHog, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kalender, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(sprLag, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVisaMote, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(btnVisaMarkeratInlagg, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(btnRefresh)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(tabFlode, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193))))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblInloggadSom)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(434, 434, 434)
                        .addComponent(jLabel2)
                        .addGap(45, 45, 45)
                        .addComponent(lblFloden)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblInloggadSom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblFloden)
                                .addGap(18, 18, 18))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabFlode)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRefresh)
                            .addComponent(btnVisaMarkeratInlagg))
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sprHog, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSkapaInlagg)
                            .addComponent(btnSkapaUnderkategori))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMinProfil)
                            .addComponent(btnLoggaUt))
                        .addGap(59, 59, 59)
                        .addComponent(sprMitten, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSkapaSuperKategori)
                            .addComponent(btnSkapaAnvandare))
                        .addGap(18, 18, 18)
                        .addComponent(btnHanteraAnvandare)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sprLag, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(kalender, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVisaMote)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSkapaInlaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaInlaggActionPerformed
        new SkapaInlagg(connection, angivetAnv).setVisible(true);
    }//GEN-LAST:event_btnSkapaInlaggActionPerformed

    private void btnSkapaUnderkategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaUnderkategoriActionPerformed
        new SkapaKategori(connection).setVisible(true);
    }//GEN-LAST:event_btnSkapaUnderkategoriActionPerformed

    private void btnMinProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinProfilActionPerformed
        new Profil(connection, angivetAnv).setVisible(true);
    }//GEN-LAST:event_btnMinProfilActionPerformed

    private void btnHanteraAnvandareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHanteraAnvandareActionPerformed
        new HanteraAnvandare(connection,status).setVisible(true);
    }//GEN-LAST:event_btnHanteraAnvandareActionPerformed

    private void btnVisaMarkeratInlaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaMarkeratInlaggActionPerformed
        String valtInlagg = (String) lstInlagg.getSelectedValue();
        String inlaggsID = valtInlagg.substring(0, valtInlagg.indexOf(" "));

        new VisatInlagg(connection, inlaggsID, status, angivetAnv).setVisible(true);


    }//GEN-LAST:event_btnVisaMarkeratInlaggActionPerformed

    private void btnSkapaSuperKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaSuperKategoriActionPerformed
        new SkapaSuperKategori(connection).setVisible(true);
    }//GEN-LAST:event_btnSkapaSuperKategoriActionPerformed

    private void btnSkapaAnvandareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaAnvandareActionPerformed
        new SkapaAnvandare(connection, status).setVisible(true);
    }//GEN-LAST:event_btnSkapaAnvandareActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        lista.removeAllElements();
        fyllFlodeMedInlagg();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnLoggaUtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoggaUtActionPerformed
        setVisible(false);
        new Inloggning(connection).setVisible(true);
    }//GEN-LAST:event_btnLoggaUtActionPerformed

    private void btnVisaMoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaMoteActionPerformed
        txtArea.setText(null);
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd"); //Omformaterar datumet som väljs i DateChoosern så det matchar formatet som datum lagras i databasen.
        String date1 = dFormat.format(kalender.getDate());

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MOTE.INFO ||' - '|| MOTE_ANVANDARE2.TID1 ||'  '|| MOTE.SAL ||' - '|| ANVANDARE.FORNAMN ||' '|| ANVANDARE.EFTERNAMN AS INFORMATION FROM MOTE JOIN MOTE_ANVANDARE2 ON MOTE_ANVANDARE2.MOTE = MOTE.MOTESID JOIN ANVANDARE ON ANVANDARE.PNR = MOTE_ANVANDARE2.ANVANDARE WHERE MOTE_ANVANDARE2.DATUM1 ='" + date1 + "'");
            while (rs.next()) {
                String info = rs.getString("INFORMATION");
                txtArea.append(info + "\n");
                System.out.println(rs.getString("INFORMATION"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Något blev fel");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Det finns inga bokade möten den dagen");
        }


    }//GEN-LAST:event_btnVisaMoteActionPerformed

    private void fyllFlodeMedInlagg() {

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT INLAGGSID ||' - '|| TITEL ||' - '|| FORNAMN ||'  '|| EFTERNAMN AS INFORMATION FROM INLAGG  JOIN ANVANDARE ON ANVANDARE.PNR = INLAGG.ANVANDARE JOIN SUBKATEGORI ON INLAGG.SUBKATEGORI = SUBKATEGORI.SUBKATEGORIID JOIN SUPERKATEGORI ON SUBKATEGORI.SUPERKATEGORI = SUPERKATEGORI.SUPERKATEGORIID JOIN KATEGORI ON SUPERKATEGORI.KATEGORI = KATEGORI.KATEGORIID WHERE KATEGORIID = 1 ORDER BY INLAGGSID DESC");

            while (rs.next()) {
                lista.addElement(rs.getString("INFORMATION"));
                lstInlagg.setModel(lista);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHanteraAnvandare;
    private javax.swing.JButton btnLoggaUt;
    private javax.swing.JButton btnMinProfil;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSkapaAnvandare;
    private javax.swing.JButton btnSkapaInlagg;
    private javax.swing.JButton btnSkapaSuperKategori;
    private javax.swing.JButton btnSkapaUnderkategori;
    private javax.swing.JButton btnVisaMarkeratInlagg;
    private javax.swing.JButton btnVisaMote;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JCalendar kalender;
    private javax.swing.JLabel lblFloden;
    private javax.swing.JLabel lblInloggadSom;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JList lstInlagg;
    private javax.swing.JPanel pnlForskning;
    private javax.swing.JPanel pnlInformell;
    private javax.swing.JPanel pnlUtbildning;
    private javax.swing.JSeparator sprHog;
    private javax.swing.JSeparator sprLag;
    private javax.swing.JSeparator sprMitten;
    private javax.swing.JTabbedPane tabFlode;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
