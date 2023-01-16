
package inf;

import codes.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class mainframe extends javax.swing.JFrame {

    Connection conn= null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    public mainframe() {
        initComponents();
        conn = (Connection) DBconnect.connect();
        tableload();
    }

    public void tableload(){
        try {
            String sql = "SELECT id AS ID ,sname AS NAME,sage AS AGE,agrade AS GRADE FROM student";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        
        
    }
    
    public void tabledata(){
        int r=table1.getSelectedRow();
        
        String id=table1.getValueAt(r,0).toString();
        String name=table1.getValueAt(r, 1).toString();
        String age=table1.getValueAt(r, 2).toString();
        String grade=table1.getValueAt(r, 3).toString();
        
        namebox.setText(name);
        agebox.setText(age);
        gradebox.setSelectedItem(grade);
        idbox.setText(id);
        
    }
    
    
    public void search(){
      
        String srch= searchbox.getText();
        
        try {
            String sql="SELECT * FROM student WHERE sname LIKE '%"+srch+"%' OR id LIKE '%"+srch+"%'  ";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    
    public void update(){
    
        String id=idbox.getText();
        String name=namebox.getText();
        String age=agebox.getText();
        String grade=gradebox.getSelectedItem().toString();
        
        try {
            String sql= "UPDATE student SET sname='"+name+"',sage='"+age+"',agrade='"+grade+"' WHERE id='"+id+"'";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Not Updated");
        }
         tableload();
    }
    
    public void clear(){
        namebox.setText(null);
        agebox.setText(null);
        gradebox.setSelectedItem(null);
        idbox.setText(null);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        namebox = new javax.swing.JTextField();
        agebox = new javax.swing.JTextField();
        gradebox = new javax.swing.JComboBox<>();
        idbox = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        insetbtn = new javax.swing.JButton();
        updatebtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Search"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });
        jPanel3.add(searchbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 18, 168, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 50));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Age");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Grade");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        namebox.setToolTipText("Enter your Name");
        namebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameboxActionPerformed(evt);
            }
        });
        jPanel4.add(namebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 80, -1));

        agebox.setToolTipText("Enter your Age");
        jPanel4.add(agebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 80, -1));

        gradebox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        jPanel4.add(gradebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 80, -1));
        jPanel4.add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 200, 160));

        jPanel5.setBackground(new java.awt.Color(102, 0, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        insetbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        insetbtn.setText("Insert");
        insetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insetbtnActionPerformed(evt);
            }
        });
        jPanel5.add(insetbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        updatebtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        updatebtn.setText("Update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        jPanel5.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        deletebtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jPanel5.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        clearbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        clearbtn.setText("Clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });
        jPanel5.add(clearbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 200, 90));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 350));

        table1.setBackground(new java.awt.Color(255, 255, 153));
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 490, 300));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 330, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        setSize(new java.awt.Dimension(798, 475));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameboxActionPerformed

    private void insetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insetbtnActionPerformed
      String name;
      int age;
      int grade;
              
      name=namebox.getText();
      age=Integer.parseInt(agebox.getText());
      grade=Integer.parseInt(gradebox.getSelectedItem().toString());
      
        try {
            String sql="INSERT INTO student (sname,sage,agrade)VALUES('"+name+"','"+age+"','"+grade+"')";
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Inserted");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
        tableload();
    }//GEN-LAST:event_insetbtnActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        tabledata();
    }//GEN-LAST:event_table1MouseClicked

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
       tabledata();
    }//GEN-LAST:event_table1KeyReleased

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
        search();
    }//GEN-LAST:event_searchboxKeyReleased

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
        update();
    }//GEN-LAST:event_updatebtnActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
       clear();
    }//GEN-LAST:event_clearbtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete?");
        
        
        if(check==0){
           String id = idbox.getText();
           
            try {
                String sql = "DELETE FROM student WHERE id='"+id+"'";
                pst=conn.prepareStatement(sql);
                pst.execute();
                 JOptionPane.showMessageDialog(null,"Deleted");
                
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null,"Not Deleted");
            }
           
        }
        else{
            JOptionPane.showMessageDialog(null,"Error Occored");
        }
        
        tableload();
        clear();
    }//GEN-LAST:event_deletebtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //login lg= new login();
       // lg.setVisible(true);
        //this.dispose();
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agebox;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JComboBox<String> gradebox;
    private javax.swing.JLabel idbox;
    private javax.swing.JButton insetbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField namebox;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTable table1;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
