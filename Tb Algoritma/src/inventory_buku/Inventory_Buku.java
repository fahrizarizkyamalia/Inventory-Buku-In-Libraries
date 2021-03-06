/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_buku;
import java.sql.SQLException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Fahriza Rizky Amalia
 */
public class Inventory_Buku extends javax.swing.JFrame {
private Connection con;
private Statement stat;
private ResultSet res;
private DefaultTableModel tabModel;
    /**
     * Creates new form Inventory_Buku
     */

private void koneksi()
    { try
    {
    Class.forName("com.mysql.jdbc.Driver"); con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory_buku?zeroDateTimeBehavior=convertToNull", "root", "");
    stat=con.createStatement();
    } catch (ClassNotFoundException | SQLException e) {
    JOptionPane.showMessageDialog(null, e);
    }}

    public Inventory_Buku() {
    
        initComponents();
        setTitle("Inventory_Buku");
        koneksi();
        tabel1();
        tabel2();
    }
private void tabel1(){
        DefaultTableModel t= new DefaultTableModel ();
        t.addColumn("Kode Buku");
        t.addColumn("Nama Buku");
        t.addColumn("Tanggal Masuk");
        t.addColumn("Jumlah");
        t.addColumn("Kondisi");
          tbl1.setModel(t); try{ res=stat.executeQuery("select * from inventory_buku_masuk");
          while (res.next()) {
          t.addRow (new Object[]{ res.getString("Kd_Buku"),
          res.getString("Nama_Buku"),
          res.getString("Tanggal_Masuk"),
          res.getString("Jumlah"),
          res.getString("Kondisi")
          });
          }
          } catch (Exception e) {
          JOptionPane.showMessageDialog(rootPane, e);
          }
    }
    
    private void tabel2 (){
    DefaultTableModel t= new DefaultTableModel();
    t.addColumn("Kode Buku");
    t.addColumn("Nama Buku");
    t.addColumn("Tanggal Masuk");
    t.addColumn("Tanggal Keluar");
    t.addColumn("Jumlah");
    t.addColumn("Kondisi");
      tbl2.setModel(t); try{ res=stat.executeQuery("select * from inventory_buku_keluar");
      while (res.next()) {
          t.addRow(new Object[]{ res.getString("Kd_Buku"),
          res.getString("Nama_Buku"),
          res.getString("Tanggal_Masuk"),
          res.getString("Tanggal_Keluar"),
          res.getString("Jumlah"),
          res.getString("Kondisi"),
          });
      }
      }catch (Exception e){
       JOptionPane.showMessageDialog(rootPane, e);
      }
    }

    
    private void kosongkan()
    {
    kode.setText("");
    nama.setText("");
    tglm.setText("");
    tglk.setText("");
    jumlah.setText("");
    kondisi.setSelectedIndex(-1);
    kode.requestFocus();
    }
    
    
    private void kondisi(){
        kondisi.addItem("Baik");
        kondisi.addItem("Rusak Ringan");
        kondisi.addItem("Rusak Berat");
        kondisi.setSelectedIndex(-1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        kode = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        tglm = new javax.swing.JTextField();
        tglk = new javax.swing.JTextField();
        jumlah = new javax.swing.JTextField();
        kondisi = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl2 = new javax.swing.JTable();
        masuk = new javax.swing.JButton();
        hapus1 = new javax.swing.JButton();
        hapus2 = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cari = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("INVENTORY BOOK IN LIBRARIES");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 865, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Input Data Buku");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-20, 30, 840, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Kode Buku");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(34, 67, 59, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nama Buku");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(32, 117, 61, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Tanggal Masuk");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 160, 80, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Tanggal Keluar");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 200, 80, 15);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Jumlah");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(32, 259, 37, 15);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Kondisi");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(32, 300, 37, 15);

        kode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodeActionPerformed(evt);
            }
        });
        getContentPane().add(kode);
        kode.setBounds(143, 65, 130, 20);

        nama.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        getContentPane().add(nama);
        nama.setBounds(140, 110, 130, 30);

        tglm.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        getContentPane().add(tglm);
        tglm.setBounds(140, 160, 130, 30);

        tglk.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        getContentPane().add(tglk);
        tglk.setBounds(140, 200, 130, 30);

        jumlah.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        getContentPane().add(jumlah);
        jumlah.setBounds(140, 250, 130, 30);

        kondisi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baik", "Rusak Ringan", "Rusak Berat" }));
        getContentPane().add(kondisi);
        kondisi.setBounds(143, 298, 130, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Buku Masuk");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(291, 67, 74, 15);

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(291, 91, 510, 204);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Buku Keluar");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(291, 332, 73, 15);

        tbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(291, 356, 510, 205);

        masuk.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        masuk.setText("Buku Masuk");
        masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masukActionPerformed(evt);
            }
        });
        getContentPane().add(masuk);
        masuk.setBounds(440, 60, 120, 23);

        hapus1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        hapus1.setText("Hapus");
        hapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus1ActionPerformed(evt);
            }
        });
        getContentPane().add(hapus1);
        hapus1.setBounds(590, 60, 71, 23);

        hapus2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        hapus2.setText("Hapus");
        hapus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus2ActionPerformed(evt);
            }
        });
        getContentPane().add(hapus2);
        hapus2.setBounds(610, 320, 80, 23);

        keluar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        keluar.setText("Buku Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        getContentPane().add(keluar);
        keluar.setBounds(440, 320, 120, 23);

        edit.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        edit.setText("Update");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        getContentPane().add(edit);
        edit.setBounds(130, 340, 100, 23);

        jButton2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton2.setText("Refresh");
        getContentPane().add(jButton2);
        jButton2.setBounds(130, 390, 100, 23);

        cari.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        cari.setText("Search");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        getContentPane().add(cari);
        cari.setBounds(130, 440, 100, 23);

        clear.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear);
        clear.setBounds(130, 480, 100, 23);

        exit.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(130, 530, 100, 23);

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon("G:\\maxresdefault.jpg")); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(-60, -10, 870, 610);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodeActionPerformed
       try {
           res=stat.executeQuery("select ' from inventory_buku_masuk where "+ "Kd_Buku '" +kode.getText() +"'"); while (res.next()){
               nama.setText(res.getString("Nama_Buku"));
               tglm .setText(res.getString("Tanggal_Masuk"));
               jumlah.setText(res.getString("Jumlah"));
               kondisi.setSelectedItem(res.getString("Kondisi"));
           }
       } 
       catch (Exception e) {
           JOptionPane.showMessageDialog(rootPane, e);
       }// TODO add your handling code here:
    }//GEN-LAST:event_kodeActionPerformed

    private void masukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masukActionPerformed
  try {
      stat.executeUpdate("insert into inventory_buku_masuk values ("
        + "'" + kode.getText()+"',"
        + "'" + nama.getText()+"',"
        + "'" + tglm.getText()+"',"
        + "'" + jumlah.getText()+"',"
        + "'" + kondisi.getSelectedItem()+ "')");
     
      kosongkan();
      JOptionPane.showMessageDialog(null, "Berhasil Menyimpan Data");
      } catch (Exception e){
      JOptionPane.showMessageDialog(null, "Perintah Salah : "+e);
      }     // TODO add your handling code here:
    }//GEN-LAST:event_masukActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
   try {
       stat.executeUpdate("insert into inventory_buku_keluar value ("
     + "'" + kode.getText()+"',"
     + "'" + nama.getText()+"',"
     + "'" + tglm.getText()+"',"
     + "'" + tglk.getText()+"',"
     + "'" + jumlah.getText()+"',"
     + "'" + kondisi.getSelectedItem()+ "')");
       
      this.tabel1();
      this.tabel2();
      kosongkan();
      JOptionPane.showMessageDialog(null, "Data Berhasil Dikeluarkan");
   } catch (Exception e) {
       JOptionPane.showMessageDialog(null, "Perintah Salah :"+e);
   }    // TODO add your handling code here:
    }//GEN-LAST:event_keluarActionPerformed

    private void hapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus1ActionPerformed
      int ok=JOptionPane.showConfirmDialog(null,"Apakah Anda Yakin Untuk Menghapus Data Ini???","Confirmation", JOptionPane.YES_NO_OPTION);
    try {
    stat.executeUpdate("delete from inventory_buku_masuk where "
    + "Kd_Buku='"+kode.getText()
    +"'" );
    
    kosongkan();
     JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Perintah Salah : "+e);
    }

       
    }//GEN-LAST:event_hapus1ActionPerformed

    private void hapus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus2ActionPerformed
         int ok=JOptionPane.showConfirmDialog(null,"Apakah Anda Yakin Untuk Menghapus Data Ini???","Confirmation", JOptionPane.YES_NO_OPTION);
    try {
    stat.executeUpdate("delete from inventory_buku_keluar where "
    + "Kd_Buku='"+kode.getText()
    +"'" );
    
    kosongkan();
     JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Perintah Salah : "+e);
    }
        // TODO add your handling code here:

    }//GEN-LAST:event_hapus2ActionPerformed

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
    int i = tbl1.getSelectedRow();
    if(i==-1){
    return;
    }
    String code = (String) tbl1.getValueAt(i,0);
    String code1 = (String) tbl1.getValueAt(i,1);
    String code2 = (String) tbl1.getValueAt(i,2);
    String code3 = (String) tbl1.getValueAt(i,3);
    String code4 = (String) tbl1.getValueAt(i,4);
    kode.setText(code);
    nama.setText(code1);
    tglm.setText(code2);
    jumlah.setText(code3);
    kondisi.setSelectedItem(code4);
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl1MouseClicked

    private void tbl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl2MouseClicked
    int i = tbl2.getSelectedRow();
    if(i==-1){
    return;
    }
    String code = (String) tbl2.getValueAt(i,0);
    String code1 = (String) tbl2.getValueAt(i,1);
    String code2 = (String) tbl2.getValueAt(i,2);
    String code3 = (String) tbl2.getValueAt(i,3);
    String code4 = (String) tbl2.getValueAt(i,4);
    String code5 = (String) tbl2.getValueAt(i,5);
    kode.setText(code);
    nama.setText(code1);
    tglm.setText(code2);
    tglk.setText(code3);
    jumlah.setText(code4);
    kondisi.setSelectedItem(code5);
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl2MouseClicked

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
     try {
         res=stat.executeQuery("select * from inventory_buku_masuk where "+ "Kd_Buku='" +kode.getText()
                 +"'" ); while (res.next()){
                 nama.setText(res.getString("Nama_Buku"));
                 tglm.setText(res.getString("Tanggal_Masuk"));
                 jumlah.setText(res.getString("Jumlah"));
                 kondisi.setSelectedItem(res.getString("Kondisi"));
                 }
            }
     catch (Exception e) {
         JOptionPane.showMessageDialog(rootPane, e);
     }// TODO add your handling code here:
    }//GEN-LAST:event_cariActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
int ok=JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Untuk Update Data Ini???","Confirmation",JOptionPane.YES_NO_OPTION);
try {
    String sql="update inventory_buku_masuk set Kd_Buku=?,Nama_Buku=?,Tanggal_Masuk=?,Jumlah=?,Kondisi=?, where Kd_Buku='"+kode.getText()+"'";
    PreparedStatement st=con.prepareStatement(sql);
    if(ok==0)
    {
    try {
    st.setString(1, kode.getText());
    st.setString(2, nama.getText());
    st.setString(3, tglm.getText());
    st.setString(4, jumlah.getText());
    st.setString(5,(String) kondisi.getSelectedItem());
    st.executeUpdate();
    JOptionPane.showMessageDialog(null, "Update Data Berhasil");
    } catch (Exception e)
    {
    JOptionPane.showMessageDialog(null,"Update Data Gagal");
    }
    }
    } catch (Exception e){}
         // TODO add your handling code here:
    }//GEN-LAST:event_editActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
kosongkan();
// TODO add your handling code here:
    }//GEN-LAST:event_clearActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
JOptionPane.showMessageDialog(null,"Anda Keluar");
System.exit(0);
// TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

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
            java.util.logging.Logger.getLogger(Inventory_Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory_Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory_Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory_Buku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventory_Buku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cari;
    private javax.swing.JButton clear;
    private javax.swing.JButton edit;
    private javax.swing.JButton exit;
    private javax.swing.JButton hapus1;
    private javax.swing.JButton hapus2;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jumlah;
    private javax.swing.JButton keluar;
    private javax.swing.JTextField kode;
    private javax.swing.JComboBox<String> kondisi;
    private javax.swing.JButton masuk;
    private javax.swing.JTextField nama;
    private javax.swing.JTable tbl1;
    private javax.swing.JTable tbl2;
    private javax.swing.JTextField tglk;
    private javax.swing.JTextField tglm;
    // End of variables declaration//GEN-END:variables

    
}
