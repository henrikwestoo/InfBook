package infbook;

import java.awt.Image;
import java.sql.Connection;
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

        kollaOmInlaggetFarTasBort();

        try {
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
            ResultSet rs7 = stmt7.executeQuery("SELECT FILER.FIL FROM FILER JOIN INLAGG_FILER ON FILER.FILID = INLAGG_FILER.FIL JOIN INLAGG ON INLAGG.INLAGGSID = INLAGG_FILER.INLAGG WHERE INLAGG.INLAGGSID ='" + inlaggsID + "'");
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

        lblTitel = new javax.swing.JLabel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitel.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N

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
                                .addComponent(lblannanFil, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addComponent(lblTitel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblannanFil, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBild, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnTaBortInlagg)))
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
            }
            catch (SQLException e) {
            }
            try {
                stmt.executeUpdate("DELETE FROM KOMMENTAR JOIN ANVANDARE_KOMMENTERA_INLAGG ON KOMMENTAR.KOMMENTARID=ANVANDARE_KOMMENTERA_INLAGG.KOMMENTAR WHERE ANVANDARE_KOMMENTERA_INLAGG.INLAGG ='" + inlaggsID + "'");
            }
            catch (SQLException e) {
            }
            try {
                stmt.executeUpdate("DELETE FROM ANVANDARE_KOMMENTERA_INLAGG WHERE INLAGG='" + inlaggsID + "'");
            }
            catch (SQLException e) {
            }
            stmt.executeUpdate("DELETE FROM INLAGG WHERE INLAGGSID='" + inlaggsID + "'");
            JOptionPane.showMessageDialog(null, "Inlägget har tagits bort!");
            dispose();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_btnTaBortInlaggActionPerformed

    private void kollaOmInlaggetFarTasBort() {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ANVANDARE FROM INLAGG WHERE INLAGGSID='" + inlaggsID + "'");
            rs.next();
            String inlaggsAnvandare = rs.getString("ANVANDARE");

            if (status.equals("CA") || status.equals("UA") || status.equals("FA") || inlaggsAnvandare.equals(angivetAnv)) {
                btnTaBortInlagg.setVisible(true);
            } else {
                btnTaBortInlagg.setVisible(false);
            }

        } catch (SQLException e) {
            e.getMessage();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKommentera;
    private javax.swing.JButton btnTaBortInlagg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblBild;
    private javax.swing.JLabel lblTitel;
    private javax.swing.JLabel lblannanFil;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextArea txtAreaKommentar;
    // End of variables declaration//GEN-END:variables
}
