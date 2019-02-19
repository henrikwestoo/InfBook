package infbook;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class HanteraFoljningar extends javax.swing.JFrame {

    private String angivetAnv;
    private Connection connection;
    private DefaultListModel lista;
    private DefaultListModel lista2;
    private DefaultListModel lista3;
    private DefaultListModel lista5;
    private ArrayList<String> allaSuperkategorier;

    public HanteraFoljningar(Connection connection, String angivetAnv) {
        initComponents();
        this.setResizable(false);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        this.connection = connection;
        this.angivetAnv = angivetAnv;
        lista = new DefaultListModel();
        lista2 = new DefaultListModel();
        lista3 = new DefaultListModel();
        lista5 = new DefaultListModel();

        allaSuperkategorier = new ArrayList<>();

        uppdateraSCMB();

        uppdatera3();
        uppdatera12();
        uppdatera5();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPic = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        btnAvfolj = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnFolj = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        cmbKategori = new javax.swing.JComboBox();
        lblNotis1 = new javax.swing.JLabel();
        lblNotis2 = new javax.swing.JLabel();
        lblNotis3 = new javax.swing.JLabel();
        cmbSuperkategori = new javax.swing.JComboBox<String>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnFoljIgen = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(46, 120, 186));

        lblPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/infbookvit.png"))); // NOI18N
        lblPic.setMaximumSize(new java.awt.Dimension(200, 200));
        lblPic.setPreferredSize(new java.awt.Dimension(200, 210));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(400, 400, 400))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setViewportView(jList2);

        btnAvfolj.setText("Avfölj valda överkategorier");
        btnAvfolj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvfoljActionPerformed(evt);
            }
        });

        jButton1.setText("Avfölj subkategori");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnFolj.setText("Följ valda överkategorier");
        btnFolj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoljActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jList1);

        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Välj område", "Forskning", "Utbildning", "Informell" }));
        cmbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKategoriActionPerformed(evt);
            }
        });

        cmbSuperkategori.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Välj överkategori" }));
        cmbSuperkategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSuperkategoriActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(jList5);

        jScrollPane3.setViewportView(jList3);

        jLabel3.setText("Överkategorier du följer inom området");

        jLabel4.setText("Avföljda subkategorier");

        btnFoljIgen.setText("Följ igen");
        btnFoljIgen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoljIgenActionPerformed(evt);
            }
        });

        jLabel2.setText("Se subkategorierna du följer");

        jLabel1.setText("Följ överkategorier");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(lblNotis1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnFolj, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                            .addGap(8, 8, 8)))
                    .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(lblNotis3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(lblNotis2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(btnAvfolj, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(cmbSuperkategori, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFoljIgen, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbSuperkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane2)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFolj)
                    .addComponent(btnAvfolj)
                    .addComponent(jButton1)
                    .addComponent(btnFoljIgen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNotis1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNotis2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNotis3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKategoriActionPerformed

        uppdatera12();

    }//GEN-LAST:event_cmbKategoriActionPerformed

    private void btnFoljActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoljActionPerformed

        if (Validering.isJListTomt(jList1)) {
            Object[] valt = jList1.getSelectedValues();

            for (Object ettVal : valt) {
                String enSuperkategori = ettVal.toString();
                System.out.println(enSuperkategori);

                try {
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT SUPERKATEGORIID FROM SUPERKATEGORI WHERE SKNAMN='" + enSuperkategori + "'");
                    rs.next();
                    int id = rs.getInt("SUPERKATEGORIID");
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO ANVANDARE_SUPERKATEGORI (ANVANDARE,SUPERKATEGORIID) VALUES (?,?)");
                    ps.setString(1, angivetAnv);
                    ps.setInt(2, id);
                    ps.executeUpdate();

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                uppdatera12();
                uppdatera3();
                uppdatera5();
                uppdateraSCMB();

            }
        }


    }//GEN-LAST:event_btnFoljActionPerformed

    private void btnAvfoljActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvfoljActionPerformed

        if (Validering.isJListTomt(jList2)) {

            Object[] valt = jList2.getSelectedValues();

            for (Object ettVal : valt) {
                String enSuperkategori = ettVal.toString();
                System.out.println(enSuperkategori);

                try {
                    Statement stmt = connection.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT SUPERKATEGORIID FROM SUPERKATEGORI WHERE SKNAMN='" + enSuperkategori + "'");
                    rs.next();
                    int id = rs.getInt("SUPERKATEGORIID");

                    Statement stmt2 = connection.createStatement();
                    stmt2.executeUpdate("DELETE FROM ANVANDARE_SUPERKATEGORI WHERE SUPERKATEGORIID=" + id + " AND ANVANDARE='" + angivetAnv + "'");
                    //JOptionPane.showMessageDialog(null, "Du har avföljt dina val");
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
                uppdatera12();
                uppdateraSCMB();

            }
        }
    }//GEN-LAST:event_btnAvfoljActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (Validering.isJListTomt(jList3)) {
            String subK = (String) jList3.getSelectedValue();
            System.out.println(subK);
            try {
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT SUBKATEGORIID FROM SUBKATEGORI WHERE SKNAMN='" + subK + "'");
                rs.next();

                int id = rs.getInt("SUBKATEGORIID");

                PreparedStatement ps = connection.prepareStatement("INSERT INTO ANVANDARE_SUBKATEGORI (ANVANDARE,SUBKATEGORI) VALUES (?,?)");
                ps.setString(1, angivetAnv);
                ps.setInt(2, id);
                ps.executeUpdate();
                // JOptionPane.showMessageDialog(null, "Subkategorin är nu avföljd");

            } catch (SQLException e) {
                System.out.println(e.getMessage());

            }

            uppdatera5();
            uppdatera3();

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbSuperkategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSuperkategoriActionPerformed
        uppdatera3();


    }//GEN-LAST:event_cmbSuperkategoriActionPerformed

    private void btnFoljIgenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoljIgenActionPerformed

        if (Validering.isJListTomt(jList5)) {
            String subKNamn = (String) jList5.getSelectedValue();
            try {

                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT SUBKATEGORIID FROM ANVANDARE_SUBKATEGORI JOIN SUBKATEGORI ON ANVANDARE_SUBKATEGORI.SUBKATEGORI = SUBKATEGORI.SUBKATEGORIID WHERE SKNAMN ='" + subKNamn + "'");

                rs.next();

                String subKID = rs.getString("SUBKATEGORIID"); //denna

                Statement stmt2 = connection.createStatement();
                stmt2.executeUpdate("DELETE FROM ANVANDARE_SUBKATEGORI WHERE ANVANDARE =" + angivetAnv + " AND SUBKATEGORI =" + subKID);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

            uppdatera3();
            uppdatera5();

        }
    }//GEN-LAST:event_btnFoljIgenActionPerformed

    private void refresh() {

        lista.removeAllElements();
        lista2.removeAllElements();
        jList1.setModel(lista);
        jList2.setModel(lista2);

    }

    private void uppdatera3() {

        try {
        
        lista3.removeAllElements();
        Object valdSakObject = cmbSuperkategori.getSelectedItem();
        String superKategoriNamn = valdSakObject.toString();

        System.out.println(superKategoriNamn);

        
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SUPERKATEGORIID FROM SUPERKATEGORI WHERE SKNAMN ='" + superKategoriNamn + "'");

            rs.next();

            String superKategoriID = rs.getString("SUPERKATEGORIID");

            ResultSet rs2 = stmt.executeQuery("SELECT SKNAMN FROM SUBKATEGORI WHERE SUPERKATEGORI =" + superKategoriID);

            while (rs2.next()) {

                lista3.addElement(rs2.getString("SKNAMN"));
                System.out.println("första listan: " + rs2.getString("SKNAMN"));
            }

            Statement stmt2 = connection.createStatement();
            ResultSet rs3 = stmt2.executeQuery("SELECT SKNAMN FROM SUBKATEGORI JOIN ANVANDARE_SUBKATEGORI ON SUBKATEGORI.SUBKATEGORIID=ANVANDARE_SUBKATEGORI.SUBKATEGORI WHERE ANVANDARE =" + angivetAnv + " AND SUPERKATEGORI=" + superKategoriID);

            while (rs3.next()) {

                lista3.removeElement(rs3.getString("SKNAMN"));
                System.out.println("andra listan: " + rs3.getString("SKNAMN"));

            }
            jList3.setModel(lista3);

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }
        
        catch(NullPointerException ex){}

    }

    private void uppdatera12() {

        try {

            lista.removeAllElements();
            lista2.removeAllElements();

            Statement stmt = connection.createStatement();
            Object valdSakObject = cmbKategori.getSelectedItem();
            String kategoriNamn = valdSakObject.toString();

            ResultSet rs2 = stmt.executeQuery("SELECT KATEGORIID FROM KATEGORI WHERE KATEGORINAMN ='" + kategoriNamn + "'");
            rs2.next();
            int kategoriId = rs2.getInt("KATEGORIID");

            ResultSet rs = stmt.executeQuery("SELECT SKNAMN FROM SUPERKATEGORI WHERE SUPERKATEGORI.KATEGORI = " + kategoriId);

            while (rs.next()) {

                lista.addElement(rs.getString("SKNAMN"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        jList1.setModel(lista);

        try {
            Statement stmt = connection.createStatement();
            Object valdSakObject = cmbKategori.getSelectedItem();
            String superKategoriNamn = valdSakObject.toString();

            ResultSet rs2 = stmt.executeQuery("SELECT KATEGORIID FROM KATEGORI WHERE KATEGORINAMN ='" + superKategoriNamn + "'");
            rs2.next();
            int superKategoriId = rs2.getInt("KATEGORIID");

            ResultSet rs = stmt.executeQuery("SELECT SKNAMN FROM SUPERKATEGORI JOIN ANVANDARE_SUPERKATEGORI ON SUPERKATEGORI.SUPERKATEGORIID=ANVANDARE_SUPERKATEGORI.SUPERKATEGORIID JOIN ANVANDARE ON ANVANDARE.PNR=ANVANDARE_SUPERKATEGORI.ANVANDARE WHERE SUPERKATEGORI.KATEGORI =" + superKategoriId + " AND ANVANDARE.PNR='" + angivetAnv + "'");

            while (rs.next()) {

                lista2.addElement(rs.getString("SKNAMN"));

            }

            jList2.setModel(lista2);
        } catch (SQLException ex) {

        }

    }

    private void uppdatera5() {

        lista5.removeAllElements();

        try {

            Statement stmt2 = connection.createStatement();
            ResultSet rs2 = stmt2.executeQuery("SELECT SKNAMN FROM SUBKATEGORI JOIN ANVANDARE_SUBKATEGORI ON ANVANDARE_SUBKATEGORI.SUBKATEGORI=SUBKATEGORI.SUBKATEGORIID WHERE ANVANDARE=" + angivetAnv);

            while (rs2.next()) {

                lista5.addElement(rs2.getString("SKNAMN"));
                System.out.println(rs2.getString("SKNAMN"));

            }

            jList5.setModel(lista5);

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }

    }

    private void uppdateraSCMB() {

        allaSuperkategorier.clear();

        try {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SKNAMN FROM SUPERKATEGORI JOIN ANVANDARE_SUPERKATEGORI ON ANVANDARE_SUPERKATEGORI.SUPERKATEGORIID=SUPERKATEGORI.SUPERKATEGORIID WHERE ANVANDARE =" + angivetAnv);

            while (rs.next()) {

                allaSuperkategorier.add(rs.getString("SKNAMN"));

            }

        } catch (SQLException e) {
        }

        cmbSuperkategori.setModel(new DefaultComboBoxModel(allaSuperkategorier.toArray()));

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvfolj;
    private javax.swing.JButton btnFolj;
    private javax.swing.JButton btnFoljIgen;
    private javax.swing.JComboBox cmbKategori;
    private javax.swing.JComboBox<String> cmbSuperkategori;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JList jList5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblNotis1;
    private javax.swing.JLabel lblNotis2;
    private javax.swing.JLabel lblNotis3;
    private javax.swing.JLabel lblPic;
    // End of variables declaration//GEN-END:variables
}
