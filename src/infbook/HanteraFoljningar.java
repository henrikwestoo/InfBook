package infbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class HanteraFoljningar extends javax.swing.JFrame {

    private String angivetAnv;
    private Connection connection;
    private DefaultListModel lista;

    public HanteraFoljningar(Connection connection, String angivetAnv) {
        initComponents();
        this.connection = connection;
        this.angivetAnv = angivetAnv;
        lista = new DefaultListModel();

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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Välj område");

        jScrollPane1.setViewportView(jList2);

        jScrollPane2.setViewportView(jList1);

        cmbKategori.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Välj område", "Forskning", "Utbildning" }));
        cmbKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKategoriActionPerformed(evt);
            }
        });

        jButton1.setText("Följ valda superkategorier");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("(Håll in CTRL för att välja flera alternativ)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKategoriActionPerformed
        Statement stmt;
        try {
            stmt = connection.createStatement();
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
    }//GEN-LAST:event_cmbKategoriActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
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
                System.out.println(angivetAnv);

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbKategori;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
