/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

import com.teknikindustries.bulksms.SMS;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Tomasz
 */
public class SkapaAnvandare extends javax.swing.JFrame {

    private DefaultListModel lista;
    private Connection connection;
    private String s = null;
    private File selectedFile;
    private JFileChooser file;
    private String path;
    private String status;

    /**
     * Creates new form SkapaAnvandare
     */
    public SkapaAnvandare(Connection connection, String status) {
        this.connection = connection; //Arrayerna nedan kommer fylla comboboxen och är olika beroende på vem man är inloggad som
        String[] alternativCA = new String[]{"Centraladministratör", "Forskningsadministratör", "Utbildningsadministratör", "Forskningsanvändare", "Utbildningsanvändare", "Amanuens"};
        String[] alternativUA = new String[]{"Utbildningsanvändare", "Amanuens"};
        String[] alternativFA = new String[]{"Forskningsanvändare", "Amanuens"};

        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

        if (status.equals("UA")) {

            cmbStatus.setModel(new DefaultComboBoxModel(alternativUA)); //Om man är ua väljs denna array för att fylla boxen

        } else if (status.equals("FA")) {

            cmbStatus.setModel(new DefaultComboBoxModel(alternativFA)); // etc etc

        } else if (status.equals("CA")) {

            cmbStatus.setModel(new DefaultComboBoxModel(alternativCA)); // etc etc

        }

        lista = new DefaultListModel();
        lblBild.setBounds(10, 10, 60, 60);
        this.status = status;

        btnBifogaFil.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                file = new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();
                    System.out.println(path);
                    lblBild.setIcon(ResizeImage(path));

                    s = path;
                }

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblNotis = new javax.swing.JLabel();
        btnSkapaAnvandare = new javax.swing.JButton();
        lblBild = new javax.swing.JLabel();
        btnBifogaFil = new javax.swing.JButton();
        cmbStatus = new javax.swing.JComboBox();
        lblAnvstatus = new javax.swing.JLabel();
        txtTlfnr = new javax.swing.JTextField();
        lblTlfnr = new javax.swing.JLabel();
        txtPnr = new javax.swing.JTextField();
        lblPnr = new javax.swing.JLabel();
        txtFornamn = new javax.swing.JTextField();
        lblFornamn = new javax.swing.JLabel();
        lblEfternamn = new javax.swing.JLabel();
        lblNyAnvandare = new javax.swing.JLabel();
        txtEfternamn = new javax.swing.JTextField();
        lblRumsnr = new javax.swing.JLabel();
        txtRumsnr = new javax.swing.JTextField();
        lblEpost = new javax.swing.JLabel();
        txtEpost = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Personnummer");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnSkapaAnvandare.setText("Skapa Användare");
        btnSkapaAnvandare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaAnvandareActionPerformed(evt);
            }
        });

        lblBild.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnBifogaFil.setText("Bifoga profilbild");

        cmbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusActionPerformed(evt);
            }
        });

        lblAnvstatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblAnvstatus.setText("Användarstatus");

        lblTlfnr.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTlfnr.setText("Telefonnummer");

        lblPnr.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPnr.setText("Personnummer");

        lblFornamn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblFornamn.setText("Förnamn");

        lblEfternamn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEfternamn.setText("Efternamn");

        lblNyAnvandare.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNyAnvandare.setText("Skapa ny användare");

        lblRumsnr.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblRumsnr.setText("Rumsnummer");

        lblEpost.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEpost.setText("E-post");

        txtEpost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEpostActionPerformed(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/infbook.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAnvstatus)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPnr, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(43, 43, 43))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtTlfnr, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblTlfnr, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblPnr, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblFornamn, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cmbStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnBifogaFil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnSkapaAnvandare, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtEfternamn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRumsnr, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEpost, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblBild, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblEpost)
                                    .addComponent(lblRumsnr)
                                    .addComponent(lblEfternamn)))
                            .addComponent(lblNotis, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNyAnvandare)
                        .addGap(13, 13, 13)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNyAnvandare))
                    .addComponent(jLabel7))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEfternamn)
                    .addComponent(lblFornamn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEfternamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPnr)
                    .addComponent(lblRumsnr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRumsnr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPnr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEpost)
                    .addComponent(lblTlfnr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTlfnr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(lblAnvstatus)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnBifogaFil)
                        .addGap(49, 49, 49)
                        .addComponent(btnSkapaAnvandare))
                    .addComponent(lblBild, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblNotis, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public ImageIcon ResizeImage(String ImagePath) {

        ImageIcon myImage = new ImageIcon(ImagePath);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(lblBild.getWidth(), lblBild.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }


    private void btnSkapaAnvandareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaAnvandareActionPerformed

        if (Validering.isTextFältTomt(txtFornamn) && Validering.isTextFältTomt(txtEfternamn) && Validering.isTextFältTomt(txtPnr) && Validering.isTextFältTomt(txtRumsnr) && Validering.isTextFältTomt(txtTlfnr) && Validering.isTextFältTomt(txtEpost)) {

            String PNR = txtPnr.getText();
            String Rumsnmr = txtRumsnr.getText();
            String mobilnmr = txtTlfnr.getText();
            String email = txtEpost.getText();
            String fornamn = txtFornamn.getText();
            String efternamn = txtEfternamn.getText();
            String status = "";
            String losenord = LosenordsGenerator.createPassword();

            if (cmbStatus.getSelectedItem().toString().equals("Centraladministratör")) {
                status = "CA";
            }
            if (cmbStatus.getSelectedItem().toString().equals("Utbildningsadministratör")) {
                status = "UA";
            }
            if (cmbStatus.getSelectedItem().toString().equals("Forskningsadministratör")) {
                status = "FA";
            }
            if (cmbStatus.getSelectedItem().toString().equals("Amanuens")) {
                status = "A";
            }
            if (cmbStatus.getSelectedItem().toString().equals("Forskningsanvändare")) {
                status = "F";
            }
            if (cmbStatus.getSelectedItem().toString().equals("Utbildningsanvändare")) {
                status = "U";
            }

            try {
                PreparedStatement ps = connection.prepareStatement("insert into ANVANDARE(PNR, LOSENORD, RUMSNMR, MOBILNMR, EMAIL, PROFILBILD, FORNAMN, EFTERNAMN, STATUS) values(?,?,?,?,?,?,?,?,?)");
                InputStream is = new FileInputStream(new File(s));
                selectedFile = file.getSelectedFile();
                path = selectedFile.getAbsolutePath();

                Statement stmt = connection.createStatement();
                ps.setString(1, PNR);
                ps.setString(2, losenord);
                ps.setString(3, Rumsnmr);
                ps.setString(4, mobilnmr);
                ps.setString(5, email);
                ps.setBlob(6, is);
                ps.setString(7, fornamn);
                ps.setString(8, efternamn);
                ps.setString(9, status);
                ps.executeUpdate();
                SMSNotiser hej = new SMSNotiser();
                hej.skickaNotis("Ditt InfBook konto har skapats.\nDu kan logga in med ditt personnummer och lösenordet: " + losenord + ". \n\n Med vänliga hälsningar, \n InfBook", mobilnmr);
                try {
                    SendMail.send(email, "Ditt konto har skapats", "Ditt InfBook konto har skapats.\nDu kan logga in med ditt personnummer och lösenordet: " + losenord + ". \nLogga in för att byta ditt lösenord. \n\n Med vänliga hälsningar, \n InfBook", "mail@infbook.page", "Infbook2019");
                } catch (RuntimeException e) {
                    JOptionPane.showMessageDialog(null, "Den angivna epostadressen är inte giltig");
                }

                //ResultSet rs3 = stmt.executeQuery("SELECT FIRST 1  * FROM FILER ORDER BY FILID DESC");
                //rs.next();
                //int hogstaVarde2 = rs3.getInt("FILID");
                // int nyaVardet2 = hogstaVarde + 1;
                // byte[] text = str.
                //JOptionPane.showMessageDialog(null, "En användare har skapats!");
                lblNotis.setText("Användare skapad!");
                // this.dispose();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SkapaAnvandare.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(SkapaAnvandare.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSkapaAnvandareActionPerformed

    private void txtEpostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEpostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEpostActionPerformed

    private void cmbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBifogaFil;
    private javax.swing.JButton btnSkapaAnvandare;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAnvstatus;
    private javax.swing.JLabel lblBild;
    private javax.swing.JLabel lblEfternamn;
    private javax.swing.JLabel lblEpost;
    private javax.swing.JLabel lblFornamn;
    private javax.swing.JLabel lblNotis;
    private javax.swing.JLabel lblNyAnvandare;
    private javax.swing.JLabel lblPnr;
    private javax.swing.JLabel lblRumsnr;
    private javax.swing.JLabel lblTlfnr;
    private javax.swing.JTextField txtEfternamn;
    private javax.swing.JTextField txtEpost;
    private javax.swing.JTextField txtFornamn;
    private javax.swing.JTextField txtPnr;
    private javax.swing.JTextField txtRumsnr;
    private javax.swing.JTextField txtTlfnr;
    // End of variables declaration//GEN-END:variables
}
