package swingCheckBoxDemo;

import javax.swing.JFrame;

public class JResortCalc extends javax.swing.JFrame {

    final int BASE_PRICE = 200;
    final int WEEKEND_PREMIUM = 100;
    final int BREAKFAST_PREMIUM = 20;
    final int GOLF_PREMIUM = 75;
    int totalPrice = BASE_PRICE;
    
    public JResortCalc() {
        initComponents();
        totPrice.setText("$" + BASE_PRICE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        resortLabel = new javax.swing.JLabel();
        optionExplainLabel = new javax.swing.JLabel();
        optionExplainLabel2 = new javax.swing.JLabel();
        weekendBox = new javax.swing.JCheckBox();
        breakfastBox = new javax.swing.JCheckBox();
        golfBox = new javax.swing.JCheckBox();
        priceLabel = new javax.swing.JLabel();
        totPrice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        resortLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        resortLabel.setText("Resort Price Calculator");

        optionExplainLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        optionExplainLabel.setText("Base price for a room is $200");

        optionExplainLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        optionExplainLabel2.setText("Check the options you want.");

        weekendBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        weekendBox.setText("Weekend premium $100");
        weekendBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weekendBoxActionPerformed(evt);
            }
        });

        breakfastBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        breakfastBox.setText("Breakfast $20");
        breakfastBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                breakfastBoxActionPerformed(evt);
            }
        });

        golfBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        golfBox.setText("Golf $75");
        golfBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                golfBoxActionPerformed(evt);
            }
        });

        priceLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        priceLabel.setText("The price for your stay is");

        totPrice.setEditable(false);
        totPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totPrice.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resortLabel)
                    .addComponent(optionExplainLabel)
                    .addComponent(optionExplainLabel2))
                .addGap(95, 95, 95))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(golfBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(priceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(weekendBox)
                        .addGap(71, 71, 71)
                        .addComponent(breakfastBox)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(resortLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionExplainLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionExplainLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(weekendBox)
                    .addComponent(breakfastBox))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(golfBox)
                    .addComponent(priceLabel)
                    .addComponent(totPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void weekendBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weekendBoxActionPerformed
        if (weekendBox.isSelected())
            totalPrice += WEEKEND_PREMIUM;
        else
            totalPrice -= WEEKEND_PREMIUM;
        
        totPrice.setText("$" + totalPrice);
    }//GEN-LAST:event_weekendBoxActionPerformed

    private void breakfastBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_breakfastBoxActionPerformed
        if (breakfastBox.isSelected())
            totalPrice += BREAKFAST_PREMIUM;
        else
            totalPrice -= BREAKFAST_PREMIUM;
        
        totPrice.setText("$" + totalPrice);
    }//GEN-LAST:event_breakfastBoxActionPerformed

    private void golfBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_golfBoxActionPerformed
        if (golfBox.isSelected())
            totalPrice += GOLF_PREMIUM;
        else
            totalPrice -= GOLF_PREMIUM;
        
        totPrice.setText("$" + totalPrice);
    }//GEN-LAST:event_golfBoxActionPerformed

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
            java.util.logging.Logger.getLogger(JResortCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JResortCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JResortCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JResortCalc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JResortCalc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox breakfastBox;
    private javax.swing.JCheckBox golfBox;
    private javax.swing.JLabel optionExplainLabel;
    private javax.swing.JLabel optionExplainLabel2;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel resortLabel;
    private javax.swing.JTextField totPrice;
    private javax.swing.JCheckBox weekendBox;
    // End of variables declaration//GEN-END:variables
}
