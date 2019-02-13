package infbook;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Doodle extends javax.swing.JFrame {

    private Connection connection;
    private String angivetAnv;
    private DefaultListModel lista;
    private DefaultListModel lista2;
    private String kallelseID;
    

    public Doodle(Connection connection, String angivetAnv) {
        initComponents();
        this.connection = connection;
        this.angivetAnv = angivetAnv;

        lista = new DefaultListModel();
        lista2 = new DefaultListModel();
        fyllListaAnvandare();
        fyllListaMote();
        txtArea.setLineWrap(true);
        val1.setSelected(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        kalender1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        kalender2 = new com.toedter.calendar.JDateChooser();
        kalender3 = new com.toedter.calendar.JDateChooser();
        tid3 = new javax.swing.JTextField();
        tid2 = new javax.swing.JTextField();
        tid1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAnstallda = new javax.swing.JList();
        btnSkicka = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList100 = new javax.swing.JList();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblDatum1 = new javax.swing.JLabel();
        lblTid1 = new javax.swing.JLabel();
        lblDatum2 = new javax.swing.JLabel();
        lblTid2 = new javax.swing.JLabel();
        lblDatum3 = new javax.swing.JLabel();
        lblTid3 = new javax.swing.JLabel();
        val1 = new javax.swing.JCheckBox();
        val2 = new javax.swing.JCheckBox();
        val3 = new javax.swing.JCheckBox();
        btnSkickaVal = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        antal1 = new javax.swing.JLabel();
        antal3 = new javax.swing.JLabel();
        antal2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Datum");

        jLabel1.setText("Tid");

        jScrollPane1.setViewportView(listAnstallda);

        btnSkicka.setText("Skicka mötesföslag");
        btnSkicka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkickaActionPerformed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane3.setViewportView(txtArea);

        jLabel7.setText("Kort beskrivning av mötet");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                            .addComponent(jSeparator2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(kalender1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                    .addGap(116, 116, 116)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tid1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(kalender3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(kalender2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(117, 117, 117)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tid2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tid3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(65, 65, 65)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(btnSkicka, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kalender1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kalender2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tid2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kalender3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tid3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnSkicka)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addComponent(jSeparator3)
        );

        jTabbedPane1.addTab("Skicka mötelsekallelser", jPanel2);

        jList100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList100MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jList100);

        jLabel3.setText("1");

        jLabel4.setText("2");

        jLabel6.setText("3");

        val1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                val1ActionPerformed(evt);
            }
        });

        val2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                val2ActionPerformed(evt);
            }
        });

        val3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                val3ActionPerformed(evt);
            }
        });

        btnSkickaVal.setText("Skicka val");
        btnSkickaVal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkickaValActionPerformed(evt);
            }
        });

        jLabel8.setText("Personer som har valt:");

        jLabel9.setText("Personer som har valt:");

        jLabel10.setText("Personer som har valt:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDatum3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(lblTid3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDatum2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(lblTid2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(169, 169, 169)
                                .addComponent(lblDatum1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTid1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(val3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(antal3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 15, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(val1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(antal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(15, 15, 15)))
                                .addGap(12, 12, 12))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(val2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(antal2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(27, 27, 27))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(btnSkickaVal, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(313, 313, 313)
                    .addComponent(jLabel5)
                    .addContainerGap(670, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblDatum1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                            .addComponent(lblTid1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(antal1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(val1)))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblTid2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblDatum2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(antal2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(val2)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblTid3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                                                .addGap(8, 8, 8))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblDatum3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(antal3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(val3))))
                        .addGap(31, 31, 31)
                        .addComponent(btnSkickaVal)))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(127, 127, 127)
                    .addComponent(jLabel5)
                    .addContainerGap(256, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Mina mötelsekallelser", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSkickaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkickaActionPerformed
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String datum1 = format.format(kalender1.getDate());
        String datum2 = format.format(kalender2.getDate());
        String datum3 = format.format(kalender3.getDate());
        String tiden1 = tid1.getText();
        String tiden2 = tid2.getText();
        String tiden3 = tid3.getText();
        String pnr = "";
        try {
            Statement stmtTal = connection.createStatement();

            stmtTal.execute("SELECT MAX (KALLELSEID) FROM MOTELSEKALLELSE");
            ResultSet rsTal = stmtTal.getResultSet();
            rsTal.next();
            int tal = rsTal.getInt(1);
            int nyttTal = tal + 1;
            System.out.println(nyttTal);

            PreparedStatement ps5 = connection.prepareStatement("INSERT INTO MOTELSEKALLELSE (KALLELSEID, PNR) VALUES(?,?)");
            ps5.setInt(1, nyttTal);
            ps5.setString(2, angivetAnv);
            ps5.executeUpdate();

            Object[] valda = listAnstallda.getSelectedValues();
            for (Object anvandare : valda) {

                pnr = anvandare.toString().substring(0, anvandare.toString().indexOf(" "));
                PreparedStatement ps4 = connection.prepareStatement("INSERT INTO MOTELSEKALLELSE_TILL_ANVANDARE (ANVANDARE,MOTELSEKALLELSE,DATUM1,TID1,DATUM2,TID2,DATUM3,TID3,BESKRIVNING) values(?,?,?,?,?,?,?,?,?)");
                ps4.setString(1, pnr);
                ps4.setInt(2, nyttTal);
                ps4.setString(3, datum1);
                ps4.setString(4, tiden1);
                ps4.setString(5, datum2);
                ps4.setString(6, tiden2);
                ps4.setString(7, datum3);
                ps4.setString(8, tiden3);
                ps4.setString(9, txtArea.getText());
                ps4.executeUpdate();

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnSkickaActionPerformed

    private void jList100MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList100MouseClicked
        String information = (String) jList100.getSelectedValue();
        kallelseID = information.substring(0, information.indexOf(" "));
        try {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DATUM1 FROM MOTELSEKALLELSE_TILL_ANVANDARE WHERE MOTELSEKALLELSE='" + kallelseID + "'");
            rs.next();
            String datumet = rs.getString("DATUM1");
            lblDatum1.setText(datumet);

            Statement stmt2 = connection.createStatement();
            ResultSet rs2 = stmt2.executeQuery("SELECT DATUM2 FROM MOTELSEKALLELSE_TILL_ANVANDARE WHERE MOTELSEKALLELSE='" + kallelseID + "'");
            rs2.next();
            String datumet2 = rs2.getString("DATUM2");
            lblDatum2.setText(datumet2);

            Statement stmt3 = connection.createStatement();
            ResultSet rs3 = stmt3.executeQuery("SELECT DATUM3 FROM MOTELSEKALLELSE_TILL_ANVANDARE WHERE MOTELSEKALLELSE='" + kallelseID + "'");
            rs3.next();
            String datumet3 = rs3.getString("DATUM3");
            lblDatum3.setText(datumet3);

            Statement stmt4 = connection.createStatement();
            ResultSet rs4 = stmt4.executeQuery("SELECT TID1 FROM MOTELSEKALLELSE_TILL_ANVANDARE WHERE MOTELSEKALLELSE='" + kallelseID + "'");
            rs4.next();
            String tid = rs4.getString("TID1");
            lblTid1.setText(tid);

            Statement stmt5 = connection.createStatement();
            ResultSet rs5 = stmt5.executeQuery("SELECT TID2 FROM MOTELSEKALLELSE_TILL_ANVANDARE WHERE MOTELSEKALLELSE='" + kallelseID + "'");
            rs5.next();
            String tid2 = rs5.getString("TID2");
            lblTid2.setText(tid2);

            Statement stmt6 = connection.createStatement();
            ResultSet rs6 = stmt6.executeQuery("SELECT TID3 FROM MOTELSEKALLELSE_TILL_ANVANDARE WHERE MOTELSEKALLELSE='" + kallelseID + "'");
            rs6.next();
            String tid3 = rs6.getString("TID3");
            lblTid3.setText(tid3);
            
            
            Statement stmt7 = connection.createStatement();
            ResultSet rs7 = stmt7.executeQuery("SELECT COUNT (DISTINCT DATUM || '-' || TID) AS INFORMATION FROM MOTELSEKALLELSE_SVAR WHERE DATUM ='"+datumet+"' AND TID ='"+tid+"' AND KALLELSEID ='"+kallelseID+"'");
            rs7.next();
            String antalet1 = rs7.getString("INFORMATION");
            antal1.setText(antalet1);
            System.out.println(antalet1);
            
             Statement stmt8 = connection.createStatement();
            ResultSet rs8 = stmt8.executeQuery("SELECT COUNT (DISTINCT DATUM || '-' || TID) AS INFORMATION FROM MOTELSEKALLELSE_SVAR WHERE DATUM ='"+datumet2+"' AND TID ='"+tid2+"' AND KALLELSEID ='"+kallelseID+"'");
            rs8.next();
            String antalet2 = rs8.getString("INFORMATION");
            antal2.setText(antalet2);
            System.out.println(antalet2);
            
             Statement stmt9 = connection.createStatement();
            ResultSet rs9 = stmt9.executeQuery("SELECT COUNT (DISTINCT DATUM || '-' || TID) AS INFORMATION FROM MOTELSEKALLELSE_SVAR WHERE DATUM ='"+datumet3+"' AND TID ='"+tid3+"' AND KALLELSEID ='"+kallelseID+"'");
            rs9.next();
            String antalet3 = rs9.getString("INFORMATION");
            antal3.setText(antalet3);
            System.out.println(antalet3);
            
            

        } catch (SQLException e2) {

        }


    }//GEN-LAST:event_jList100MouseClicked

    private void val1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_val1ActionPerformed
        if (val1.isSelected()) {
            val2.setSelected(false);
            val3.setSelected(false);
        }
    }//GEN-LAST:event_val1ActionPerformed

    private void val2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_val2ActionPerformed
        if (val2.isSelected()) {
            val1.setSelected(false);
            val3.setSelected(false);
        }
    }//GEN-LAST:event_val2ActionPerformed

    private void val3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_val3ActionPerformed
        if (val3.isSelected()) {
            val2.setSelected(false);
            val1.setSelected(false);
        }
    }//GEN-LAST:event_val3ActionPerformed

    private void btnSkickaValActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkickaValActionPerformed
        String datum = "";
        String tid = "";
        if (val1.isSelected()) {
            datum = lblDatum1.getText();
            tid = lblTid1.getText();
        } else if (val2.isSelected()) {
            datum = lblDatum2.getText();
            tid = lblTid2.getText();
        } else if (val3.isSelected()) {
            datum = lblDatum3.getText();
            tid = lblTid3.getText();
        }
        
        try{
         PreparedStatement ps5 = connection.prepareStatement("INSERT INTO MOTELSEKALLELSE_SVAR (ANVANDARE, KALLELSEID, DATUM, TID) VALUES(?,?,?,?)");
            ps5.setString(1, angivetAnv);
            ps5.setInt(2,Integer.parseInt(kallelseID));
            ps5.setString(3,datum);
            ps5.setString(4,tid);
            ps5.executeUpdate();
            JOptionPane.showMessageDialog(null,"Ditt svar har registrerats");
        }
        
        catch (SQLException e)
            
        {
            System.out.println(e.getMessage()); 
        }

    }//GEN-LAST:event_btnSkickaValActionPerformed

    private void fyllListaAnvandare() {
        Statement stmt;
        try {
            stmt = connection.createStatement();

            ResultSet rs2 = stmt.executeQuery("SELECT PNR, FORNAMN, EFTERNAMN FROM ANVANDARE");
            rs2.next();

            while (rs2.next()) {

                lista.addElement(rs2.getString("PNR") + " " + rs2.getString("FORNAMN") + " " + rs2.getString("EFTERNAMN"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(SkapaInlagg.class.getName()).log(Level.SEVERE, null, ex);
        }

        listAnstallda.setModel(lista);

    }

    private void fyllListaMote() {
        Statement stmt;
        try {
            stmt = connection.createStatement();

            ResultSet rs2 = stmt.executeQuery("SELECT KALLELSEID ||' - '|| BESKRIVNING AS INFORMATION FROM MOTELSEKALLELSE JOIN MOTELSEKALLELSE_TILL_ANVANDARE ON MOTELSEKALLELSE_TILL_ANVANDARE.MOTELSEKALLELSE = MOTELSEKALLELSE.KALLELSEID WHERE MOTELSEKALLELSE_TILL_ANVANDARE.ANVANDARE ='" + angivetAnv + "'");

            while (rs2.next()) {
                String hej = rs2.getString("INFORMATION");
                lista2.addElement(hej);

            }
        } catch (SQLException ex) {
            Logger.getLogger(SkapaInlagg.class.getName()).log(Level.SEVERE, null, ex);
        }

        jList100.setModel(lista2);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel antal1;
    private javax.swing.JLabel antal2;
    private javax.swing.JLabel antal3;
    private javax.swing.JButton btnSkicka;
    private javax.swing.JButton btnSkickaVal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList100;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JDateChooser kalender1;
    private com.toedter.calendar.JDateChooser kalender2;
    private com.toedter.calendar.JDateChooser kalender3;
    private javax.swing.JLabel lblDatum1;
    private javax.swing.JLabel lblDatum2;
    private javax.swing.JLabel lblDatum3;
    private javax.swing.JLabel lblTid1;
    private javax.swing.JLabel lblTid2;
    private javax.swing.JLabel lblTid3;
    private javax.swing.JList listAnstallda;
    private javax.swing.JTextField tid1;
    private javax.swing.JTextField tid2;
    private javax.swing.JTextField tid3;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JCheckBox val1;
    private javax.swing.JCheckBox val2;
    private javax.swing.JCheckBox val3;
    // End of variables declaration//GEN-END:variables
}
