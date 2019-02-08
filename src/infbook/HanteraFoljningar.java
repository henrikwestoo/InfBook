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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnFolj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAvfolj)
                        .addGap(61, 61, 61))))
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFolj)
                    .addComponent(btnAvfolj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(27, Short.MAX_VALUE))
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

        }


    }//GEN-LAST:event_btnFoljActionPerformed

    private void btnAvfoljActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvfoljActionPerformed
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
                JOptionPane.showMessageDialog(null, "Du har avföljt dina val");

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }//GEN-LAST:event_btnAvfoljActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvfolj;
    private javax.swing.JButton btnFolj;
    private javax.swing.JComboBox cmbKategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
