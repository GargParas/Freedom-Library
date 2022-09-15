package library.management;
import java.awt.Window;
import java.sql.*;
import javax.swing.JOptionPane;
public class LOGIN extends javax.swing.JFrame {
        Connection con;
        Statement st;
        ResultSet rs;

    public LOGIN() {
        initComponents();
        this.setTitle("LOGIN");
        setSize(600, 375);
        setLocation(500, 200);
        setResizable(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USERNAME");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 90, 170, 30);

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PASSWORD");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 160, 170, 35);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(260, 170, 250, 22);

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Felix Titling", 1, 14)); // NOI18N
        jButton1.setText("LOGIN");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.darkGray, java.awt.Color.black));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(270, 260, 70, 70);

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField3);
        jTextField3.setBounds(260, 100, 250, 22);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/library/management/books-background-library-png-background-800_375.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 610, 360);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String user = jTextField3.getText();
        String pass = jPasswordField1.getText();
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lib","root","PARAM");
            st=con.createStatement();
            rs = st.executeQuery("select * from login");
            boolean flag = false;
            while(rs.next())
            {
                if(user.equals(rs.getString(1)) && pass.equals(rs.getString(2)))
                {
                    HOME_PAGE HP = new HOME_PAGE();
                    HP.setVisible(true);
                    this.setVisible(false);
                    flag = true;   
                }  
            }    
            if(!flag)
            {
               JOptionPane.showMessageDialog(this,"WRONG INPUT",null,JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOGIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
