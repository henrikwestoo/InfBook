package infbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class HanteraFoljningar extends javax.swing.JFrame {

    private String angivetAnv;
    private Connection connection;
    private DefaultListModel lista;
    private DefaultListModel lista2;

    public HanteraFoljningar(Connection connection, String angivetAnv) {
        initComponents();
        this.connection = connection;
        this.angivetAnv = angivetAnv;
        lista = new DefaultListModel();
        lista2 = new DefaultListModel();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        cmbKategori = new javax.swing.JComboBox();
        btnFolj = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnAvfolj = new javax.swing.JButton();
        txtSub = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblNotis1 = new javax.swing.JLabel();
        lblNotis2 = new javax.swing.JLabel();
        lblNotis3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Välj område");

        jScrollPane1.setViewportView(jList2);

        jScrollPane2.setViewportView(jList1);

        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Välj område", "Forskning", "Utbildning" }));
        cmbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKategoriActionPerformed(evt);
            }
        });

        btnFolj.setText("Följ valda superkategorier");
        btnFolj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFoljActionPerformed(evt);
            }
        });

        jLabel2.setText("(Håll in CTRL för att välja flera alternativ)");

        btnAvfolj.setText("Avfölj valda superkategorier");
        btnAvfolj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvfoljActionPerformed(evt);
            }
        });

        jButton1.setText("Avfölj angiven subkategori");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNotis1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnFolj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                            .addComponent(txtSub))
                                        .addGap(24, 24, 24))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblNotis3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnAvfolj))
                                        .addGap(61, 61, 61))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(lblNotis2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel1)
                .addGap(33, 599, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFolj)
                    .addComponent(btnAvfolj)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNotis1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNotis2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNotis3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKategoriActionPerformed

        try {
            Statement stmt = connection.createStatement();
            Object valdSakObject = cmbKategori.getSelectedItem();
            String superKategoriNamn = valdSakObject.toString();

            ResultSet rs2 = stmt.executeQuery("SELECT KATEGORIID FROM KATEGORI WHERE KATEGORINAMN ='" + superKategoriNamn + "'");
            rs2.next();
            int superkategoriId = rs2.getInt("KATEGORIID");

            ResultSet rs = stmt.executeQuery("SELECT SKNAMN FROM SUPERKATEGORI WHERE SUPERKATEGORI.KATEGORI = " + superkategoriId);

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
    }//GEN-LAST:event_cmbKategoriActionPerformed

    private void btnFoljActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFoljActionPerformed
       if(Validering.isJListTomt(jList1))
       {
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
                lblNotis1.setText("Kategorier följda");
                lblNotis2.setText("");
                lblNotis3.setText("");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
       }


    }//GEN-LAST:event_btnFoljActionPerformed

    private void btnAvfoljActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvfoljActionPerformed
        if(Validering.isJListTomt(jList2))
        {
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
                lblNotis3.setText("Superkategori avföljd");
                lblNotis2.setText("");
                lblNotis1.setText("");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
        }
    }//GEN-LAST:event_btnAvfoljActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(Validering.isTextFältTomt(txtSub))
       {
        String subK = txtSub.getText();
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
            lblNotis2.setText("Subkategorin är nu avföljd");
            lblNotis1.setText("");
            lblNotis3.setText("");
        } catch (SQLException e) {
              System.out.println(e.getMessage());

        }
       }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvfolj;
    private javax.swing.JButton btnFolj;
    private javax.swing.JComboBox cmbKategori;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblNotis1;
    private javax.swing.JLabel lblNotis2;
    private javax.swing.JLabel lblNotis3;
    private javax.swing.JTextField txtSub;
    // End of variables declaration//GEN-END:variables
}
