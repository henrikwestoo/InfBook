/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infbook;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author alexa
 */
public class SkapaMoten extends javax.swing.JFrame {

    private Connection connection;
    private DefaultListModel lista;
    private String angivetAnv;
    private String datumet;
    private String tiden;

    public SkapaMoten(Connection connection, String angivetAnv, String datumet, String tiden) {
        initComponents();
        this.setResizable(false);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        this.connection = connection;
        lista = new DefaultListModel();
        fyllComboBoxAnvandare();
        this.angivetAnv = angivetAnv;
        this.datumet = datumet;
        this.tiden = tiden;
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(datumet);
            dagValjare.setDate(date);
            txtTid.setText(tiden);
        } catch (ParseException e) {

        } catch (NullPointerException es) {

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblNotis = new javax.swing.JLabel();
        btnSkapaMotet = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listAnstallda = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInfoMote = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dagValjare = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSal = new javax.swing.JTextField();
        txtTid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnSkapaMotet.setText("Skapa mötet");
        btnSkapaMotet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkapaMotetActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listAnstallda);

        txtInfoMote.setColumns(20);
        txtInfoMote.setRows(5);
        jScrollPane1.setViewportView(txtInfoMote);

        jLabel3.setText("Välj vilka som ska delta på mötet");

        jLabel2.setText("Skriv information om mötet");

        jLabel1.setText("Välj datum");

        jLabel4.setText("Ange sal");

        jLabel5.setText("Ange tid");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/infbook.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(btnSkapaMotet)
                        .addGap(18, 18, 18)
                        .addComponent(lblNotis, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(185, 185, 185))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(dagValjare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(43, 43, 43))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtSal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtTid, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2))
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dagValjare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblNotis, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSkapaMotet))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fyllComboBoxAnvandare() {
        Statement stmt;
        try {
            stmt = connection.createStatement();

            ResultSet rs2 = stmt.executeQuery("SELECT PNR, FORNAMN, EFTERNAMN FROM ANVANDARE");
            rs2.next();
            String pnr = rs2.getString("PNR") + " " + rs2.getString("FORNAMN") + " " + rs2.getString("EFTERNAMN");

            while (rs2.next()) {

                lista.addElement(rs2.getString("PNR") + " " + rs2.getString("FORNAMN") + " " + rs2.getString("EFTERNAMN"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(SkapaInlagg.class.getName()).log(Level.SEVERE, null, ex);
        }

        listAnstallda.setModel(lista);

    }


    private void btnSkapaMotetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkapaMotetActionPerformed
        if (Validering.isTextFältTomt(txtSal)
                && Validering.isTextFältTomt(txtTid)
                && Validering.isTextAreaTomt(txtInfoMote)
                && Validering.isJListTomt(listAnstallda)
                && Validering.isDateChooserTomt(dagValjare)) {
            try {

                Statement stmt2 = connection.createStatement();

                ResultSet rs2 = stmt2.executeQuery("SELECT FIRST 1  * FROM MOTE ORDER BY MOTESID DESC");
                rs2.next();
                int hogstaVarde = rs2.getInt("MOTESID");
                int nyaVardet = hogstaVarde + 1;

                SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd"); //Omformaterar datumet som väljs i DateChoosern så det matchar formatet som datum lagras i databasen.
                String date1 = dFormat.format(dagValjare.getDate());

                String info = txtInfoMote.getText();

                PreparedStatement ps2 = connection.prepareStatement("insert into MOTE(MOTESID,INFO,SAL,TID,DATUM,ANVANDARE) values(?,?,?,?,?,?)");
                ps2.setInt(1, nyaVardet);
                ps2.setString(2, info);
                ps2.setString(3, txtSal.getText());
                ps2.setString(4, txtTid.getText());
                ps2.setString(5, date1);
                ps2.setString(6, angivetAnv);

                ps2.executeUpdate();
                lblNotis.setText("Mötet skapat");
                // JOptionPane.showMessageDialog(null, "Mötet har skapats");
                Object[] valda = listAnstallda.getSelectedValues();
                for (Object anvandare : valda) {
                    PreparedStatement ps4 = connection.prepareStatement("insert into MOTE_ANVANDARE2(ANVANDARE,MOTE) values(?,?)");

                    String pnr = anvandare.toString().substring(0, anvandare.toString().indexOf(" "));

                    ps4.setString(1, pnr);
                    ps4.setInt(2, nyaVardet);
                    ps4.executeUpdate();
                }
                Statement stmt101 = connection.createStatement();
                ResultSet rs101 = stmt101.executeQuery("SELECT MOBILNMR FROM ANVANDARE JOIN MOTE_ANVANDARE2 ON MOTE_ANVANDARE2.ANVANDARE = ANVANDARE.PNR WHERE MOTE_ANVANDARE2.MOTE =" + nyaVardet + "");

                while (rs101.next()) {
                    String mobilnmr = rs101.getString("MOBILNMR");
                    System.out.println(mobilnmr);
                    SMSNotiser hej = new SMSNotiser();
                    hej.skickaNotis("Du har kallats till ett möte " + date1 + " klockan " + txtTid.getText() + " i sal " + txtSal.getText() + "\n\n Med vänliga hälsningar, \n InfBook", mobilnmr);
                }

                Statement stmt102 = connection.createStatement();
                ResultSet rs102 = stmt102.executeQuery("SELECT EMAIL FROM ANVANDARE JOIN MOTE_ANVANDARE2 ON MOTE_ANVANDARE2.ANVANDARE = ANVANDARE.PNR WHERE MOTE_ANVANDARE2.MOTE =" + nyaVardet + "");
                while (rs102.next()) {
                    String email = rs102.getString("EMAIL");
                    System.out.println(email);
                    SendMail.send(email, "Du har kallats till ett möte", "Du har kallats till ett möte " + date1 + " klockan " + txtTid.getText() + " i sal " + txtSal.getText() + "\n\n Med vänliga hälsningar, \n InfBook", "mail@infbook.page", "Infbook2019");
                }

            } catch (SQLException ex) {
                Logger.getLogger(SkapaInlagg.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSkapaMotetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSkapaMotet;
    private com.toedter.calendar.JDateChooser dagValjare;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNotis;
    private javax.swing.JList<String> listAnstallda;
    private javax.swing.JTextArea txtInfoMote;
    private javax.swing.JTextField txtSal;
    private javax.swing.JTextField txtTid;
    // End of variables declaration//GEN-END:variables
}
