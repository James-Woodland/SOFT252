/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.CardLayout;

/**
 *
 * @author james
 */
public class View extends javax.swing.JFrame {

    /**
     * Creates new form View
     */
    public View() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        PnlLogin = new javax.swing.JPanel();
        BtnPatientAccount = new javax.swing.JButton();
        BtnLoginRequest = new javax.swing.JButton();
        TxtUsername = new javax.swing.JTextField();
        TxtPassword = new javax.swing.JTextField();
        LblLoginUsername = new javax.swing.JLabel();
        LblLoginPassword = new javax.swing.JLabel();
        CmbLoginAccountType = new javax.swing.JComboBox<>();
        LblLoginAccountTYpe = new javax.swing.JLabel();
        PnlRequestPatientAccount = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new java.awt.CardLayout());

        BtnPatientAccount.setText("Request Patient Account");
        BtnPatientAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPatientAccountActionPerformed(evt);
            }
        });

        BtnLoginRequest.setText("Login");

        LblLoginUsername.setText("Username");

        LblLoginPassword.setText("Password");

        CmbLoginAccountType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Patient", "Doctor", "Secretary", "Admin" }));

        LblLoginAccountTYpe.setText("Account Type");

        javax.swing.GroupLayout PnlLoginLayout = new javax.swing.GroupLayout(PnlLogin);
        PnlLogin.setLayout(PnlLoginLayout);
        PnlLoginLayout.setHorizontalGroup(
            PnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlLoginLayout.createSequentialGroup()
                .addGroup(PnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlLoginLayout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(BtnLoginRequest))
                    .addGroup(PnlLoginLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addGroup(PnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LblLoginAccountTYpe)
                            .addGroup(PnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(LblLoginUsername)
                                .addComponent(TxtUsername)
                                .addComponent(TxtPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(BtnPatientAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LblLoginPassword)
                                .addComponent(CmbLoginAccountType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        PnlLoginLayout.setVerticalGroup(
            PnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnlLoginLayout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addComponent(LblLoginUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LblLoginPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblLoginAccountTYpe)
                .addGap(2, 2, 2)
                .addComponent(CmbLoginAccountType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnLoginRequest)
                .addGap(18, 18, 18)
                .addComponent(BtnPatientAccount)
                .addGap(50, 50, 50))
        );

        mainPanel.add(PnlLogin, "PnlLogin");

        javax.swing.GroupLayout PnlRequestPatientAccountLayout = new javax.swing.GroupLayout(PnlRequestPatientAccount);
        PnlRequestPatientAccount.setLayout(PnlRequestPatientAccountLayout);
        PnlRequestPatientAccountLayout.setHorizontalGroup(
            PnlRequestPatientAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
        );
        PnlRequestPatientAccountLayout.setVerticalGroup(
            PnlRequestPatientAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );

        mainPanel.add(PnlRequestPatientAccount, "PnlRequestPatientAccount");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnPatientAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPatientAccountActionPerformed
        CardLayout card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel, "PnlRequestPatientLogin");
    }//GEN-LAST:event_BtnPatientAccountActionPerformed

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLoginRequest;
    private javax.swing.JButton BtnPatientAccount;
    private javax.swing.JComboBox<String> CmbLoginAccountType;
    private javax.swing.JLabel LblLoginAccountTYpe;
    private javax.swing.JLabel LblLoginPassword;
    private javax.swing.JLabel LblLoginUsername;
    private javax.swing.JPanel PnlLogin;
    private javax.swing.JPanel PnlRequestPatientAccount;
    private javax.swing.JTextField TxtPassword;
    private javax.swing.JTextField TxtUsername;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
