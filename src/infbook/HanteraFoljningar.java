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

    public HanteraFoljningar(Connection connection, String angivetAnv) {
        initComponents();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
        this.connection = connection;
        this.angivetAnv = angivetAnv;
        lista = new DefaultListModel();
        lista2 = new DefaultListModel();
        lista3 = new DefaultListModel();
        
        ArrayList <String> allaSuperkategorier = new ArrayList();
       
        try{
        
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT SKNAMN FROM SUPERKATEGORI");
        
        while(rs.next()){
        
        allaSuperkategorier.add(rs.getString("SKNAMN"));
        
        }
        
        
        }
        catch(SQLException e){}
        
        
         
           cmbSuperkategori.setModel(new DefaultComboBoxModel(allaSuperkategorier.toArray()));
        
        
        

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
        jLabel2 = new javax.swing.JLabel();
        btnFolj = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        cmbKategori = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        lblNotis1 = new javax.swing.JLabel();
        lblNotis2 = new javax.swing.JLabel();
        lblNotis3 = new javax.swing.JLabel();
        cmbSuperkategori = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        txtSub = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(46, 120, 186));

        lblPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/infbookthin.png"))); // NOI18N
        lblPic.setMaximumSize(new java.awt.Dimension(200, 200));
        lblPic.setPreferredSize(new java.awt.Dimension(200, 210));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(296, 296, 296))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPic, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setViewportView(jList2);

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

        jLabel2.setText("(Håll in CTRL för att välja flera alternativ)");

        btnFolj.setText("Följ valda superkategorier");
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

        jLabel1.setText("Välj område");

        cmbSuperkategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj superkategori" }));
        cmbSuperkategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSuperkategoriActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(jList3);

        txtSub.setText("jTextField1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(338, 338, 338))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(261, 261, 261)
                                .addComponent(btnAvfolj)))
                        .addGap(179, 179, 179))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(lblNotis1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnFolj, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                        .addGap(8, 8, 8)))
                                .addGap(77, 77, 77)
                                .addComponent(lblNotis3, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNotis2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(338, 338, 338)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbSuperkategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel2)
                                .addGap(160, 160, 160)
                                .addComponent(txtSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbSuperkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnFolj)
                            .addComponent(jButton1)
                            .addComponent(btnAvfolj))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNotis1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNotis2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNotis3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2)
                        .addContainerGap(77, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKategoriActionPerformed

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
        if (Validering.isTextFältTomt(txtSub)) {
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
                lblNotis2.setText("Subkategorin är nu avföljd");
                lblNotis1.setText("");
                lblNotis3.setText("");
            } catch (SQLException e) {
                System.out.println(e.getMessage());

            }
        }
        

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbSuperkategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSuperkategoriActionPerformed

            lista3.removeAllElements();
            Object valdSakObject = cmbSuperkategori.getSelectedItem();
            String superKategoriNamn = valdSakObject.toString();
            
            System.out.println(superKategoriNamn);
            
            
            try{
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT SUPERKATEGORIID FROM SUPERKATEGORI WHERE SKNAMN ='"+superKategoriNamn+"'");
            
            rs.next();
            
            
            String superKategoriID = rs.getString("SUPERKATEGORIID");
            
            ResultSet rs2 = stmt.executeQuery("SELECT SKNAMN FROM SUBKATEGORI WHERE SUPERKATEGORI ="+superKategoriID);
            
            while(rs2.next()){
            
            lista3.addElement(rs2.getString("SKNAMN"));
            
            }
            
            jList3.setModel(lista3);
            
            
            }

    catch(SQLException e){
        
        JOptionPane.showMessageDialog(null, e.getMessage());

}
    }//GEN-LAST:event_cmbSuperkategoriActionPerformed

    private void refresh(){
    
       lista.removeAllElements();
       lista2.removeAllElements();
       jList1.setModel(lista);
       jList2.setModel(lista2);
    
    
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvfolj;
    private javax.swing.JButton btnFolj;
    private javax.swing.JComboBox cmbKategori;
    private javax.swing.JComboBox<String> cmbSuperkategori;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblNotis1;
    private javax.swing.JLabel lblNotis2;
    private javax.swing.JLabel lblNotis3;
    private javax.swing.JLabel lblPic;
    private javax.swing.JTextField txtSub;
    // End of variables declaration//GEN-END:variables
}
