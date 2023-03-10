/*  
 *  Author: Brian Moye
 *  Purpose:
 *  Create a GUI program that allows a user to:
 *      Enter the number of guests, if the input isn't numeric set to 0.
 *      Choose a variety of meal options:
 *          One entree from four choices
 *          Two sides from four choices
 *          One dessert from three choices
 *          $35 per person for each event
 *      Display a list of the current choices, if more than two sides are 
 *          selected reset the side dish selection for the user to start over.
 */ 

package JCarlysCatering;

import java.awt.event.*;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class JCarlysMenu extends javax.swing.JFrame implements ItemListener {

    final double PRICE_PER_GUEST = 35.00;
    
    String entreeSelection = "", sideSelection = "", dessertSelection = "";
    int sidesCount = 0; //Variable to keep track of how many side dishes are selected.
    
    public JCarlysMenu() {
        initComponents();
        initListeners();
        
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

        groupEntrees = new javax.swing.ButtonGroup();
        groupDesserts = new javax.swing.ButtonGroup();
        labelTitle = new javax.swing.JLabel();
        labelPrice = new javax.swing.JLabel();
        labelSelectedItems = new javax.swing.JLabel();
        labelEntrees = new javax.swing.JLabel();
        labelSideDishes = new javax.swing.JLabel();
        labelDesserts = new javax.swing.JLabel();
        labelNumGuests = new javax.swing.JLabel();
        labelTotalPrice = new javax.swing.JLabel();
        btnPrimeRib = new javax.swing.JRadioButton();
        btnLobster = new javax.swing.JRadioButton();
        btnCatfish = new javax.swing.JRadioButton();
        btnLasagna = new javax.swing.JRadioButton();
        boxMashedPotatoes = new javax.swing.JCheckBox();
        boxGreenBeans = new javax.swing.JCheckBox();
        boxMacCheese = new javax.swing.JCheckBox();
        boxCaesarSalad = new javax.swing.JCheckBox();
        btnPumpkinPie = new javax.swing.JRadioButton();
        btnReesesCake = new javax.swing.JRadioButton();
        btnStrawberryCheesecake = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaSelections = new javax.swing.JTextArea();
        btnSubmit = new javax.swing.JButton();
        textFieldGuests = new javax.swing.JTextField();
        textFieldTotalPrice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Carly's Catering Menu");

        labelTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTitle.setText("Carly's Catering Menu");

        labelPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelPrice.setText("Dinner Selection - $35 per person");

        labelSelectedItems.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelSelectedItems.setText("Selected Dinner Items");

        labelEntrees.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelEntrees.setText("Entrees");

        labelSideDishes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelSideDishes.setText("Side Dishes (2)");

        labelDesserts.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelDesserts.setText("Desserts");

        labelNumGuests.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelNumGuests.setText("Enter number of guests:");

        labelTotalPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelTotalPrice.setText("Total Price:");

        groupEntrees.add(btnPrimeRib);
        btnPrimeRib.setText("Prime Rib");

        groupEntrees.add(btnLobster);
        btnLobster.setText("Lobster");

        groupEntrees.add(btnCatfish);
        btnCatfish.setText("Catfish");

        groupEntrees.add(btnLasagna);
        btnLasagna.setText("Lasagna");

        boxMashedPotatoes.setText("Mashed Potatoes");

        boxGreenBeans.setText("Green Beans");

        boxMacCheese.setText("Mac-N-Cheese");

        boxCaesarSalad.setText("Caesar Salad");

        groupDesserts.add(btnPumpkinPie);
        btnPumpkinPie.setText("Pumpkin Pie");

        groupDesserts.add(btnReesesCake);
        btnReesesCake.setText("Reese's Cake");

        groupDesserts.add(btnStrawberryCheesecake);
        btnStrawberryCheesecake.setText("Strawberry Cheesecake");

        textAreaSelections.setEditable(false);
        textAreaSelections.setColumns(20);
        textAreaSelections.setRows(5);
        jScrollPane1.setViewportView(textAreaSelections);

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        textFieldGuests.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textFieldGuests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldGuestsActionPerformed(evt);
            }
        });

        textFieldTotalPrice.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNumGuests)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(labelPrice))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelTotalPrice)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelEntrees)
                                    .addComponent(btnPrimeRib)
                                    .addComponent(btnCatfish)
                                    .addComponent(btnLasagna)
                                    .addComponent(btnLobster))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boxMashedPotatoes)
                                    .addComponent(labelSideDishes)
                                    .addComponent(boxGreenBeans)
                                    .addComponent(boxCaesarSalad)
                                    .addComponent(boxMacCheese))))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStrawberryCheesecake)
                            .addComponent(btnReesesCake)
                            .addComponent(btnPumpkinPie)
                            .addComponent(labelDesserts))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(labelSelectedItems)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(labelTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPrice)
                    .addComponent(labelSelectedItems)
                    .addComponent(labelNumGuests)
                    .addComponent(textFieldGuests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelEntrees)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPrimeRib)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLobster)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCatfish)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLasagna))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelSideDishes)
                                    .addComponent(labelDesserts))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnPumpkinPie)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnReesesCake)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnStrawberryCheesecake))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(boxMashedPotatoes)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(boxGreenBeans)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(boxMacCheese)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxCaesarSalad)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelTotalPrice)
                                    .addComponent(textFieldTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        DecimalFormat currency = new DecimalFormat("$###,###,###,##0.00");
        double price = 0;
        
        try {
            price = Integer.parseInt(textFieldGuests.getText()) * PRICE_PER_GUEST;
        } catch (Exception all) {
            price = 0;
        }
        textFieldTotalPrice.setText(currency.format(price));
        //dispose(); // Close the frame
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void textFieldGuestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldGuestsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldGuestsActionPerformed

    private void initListeners() {
        btnPrimeRib.addItemListener(this);
        btnLobster.addItemListener(this);
        btnCatfish.addItemListener(this);
        btnLasagna.addItemListener(this);
        boxMashedPotatoes.addItemListener(this);
        boxGreenBeans.addItemListener(this);
        boxMacCheese.addItemListener(this);
        boxCaesarSalad.addItemListener(this);
        btnPumpkinPie.addItemListener(this);
        btnReesesCake.addItemListener(this);
        btnStrawberryCheesecake.addItemListener(this);
    }
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
            java.util.logging.Logger.getLogger(JCarlysMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JCarlysMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JCarlysMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JCarlysMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JCarlysMenu().setVisible(true);
            }
        });
    }
    
    @Override
    public void itemStateChanged(ItemEvent evt) {
        Object source = evt.getSource();
        
        // Entrees
        if (source == btnPrimeRib) {
            entreeSelection = btnPrimeRib.getText();
        }
        else if (source == btnLobster) {
            entreeSelection = btnLobster.getText();
        }
        else if (source == btnCatfish) {
            entreeSelection = btnCatfish.getText();
        }
        else if (source == btnLasagna) {
            entreeSelection = btnLasagna.getText();
        }
        
        // Side dishes
        if (source == boxMashedPotatoes || source == boxGreenBeans 
                || source == boxMacCheese || source == boxCaesarSalad) {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                sidesCount++;
            }
            else {
                sidesCount--;
            }
            
            sideSelection = "";
            if (sidesCount <= 2) {
                if (boxMashedPotatoes.isSelected()) {
                    sideSelection += boxMashedPotatoes.getText() + "\n";
                }
                if (boxGreenBeans.isSelected()) {
                    sideSelection += boxGreenBeans.getText() + "\n";
                }
                if (boxMacCheese.isSelected()) {
                    sideSelection += boxMacCheese.getText() + "\n";
                }
                if (boxCaesarSalad.isSelected()) {
                    sideSelection += boxCaesarSalad.getText() + "\n";
                }
            }
            else {
                JOptionPane.showMessageDialog(null, 
                        "Sorry, you may only choose up to two side dishes.",
                        "Side Dish Error", JOptionPane.ERROR_MESSAGE);
                boxMashedPotatoes.setSelected(false);
                boxGreenBeans.setSelected(false);
                boxMacCheese.setSelected(false);
                boxCaesarSalad.setSelected(false);
            }
        }
        
        // Desserts
        if (source == btnPumpkinPie) {
            dessertSelection = btnPumpkinPie.getText();
        }
        else if (source == btnReesesCake) {
            dessertSelection = btnReesesCake.getText();
        }
        else if (source == btnStrawberryCheesecake) {
            dessertSelection = btnStrawberryCheesecake.getText();
        }
        textAreaSelections.setText("Entree:\n" + entreeSelection 
            + "\n\nSide(s):\n" + sideSelection + "\nDessert:\n" 
            + dessertSelection);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boxCaesarSalad;
    private javax.swing.JCheckBox boxGreenBeans;
    private javax.swing.JCheckBox boxMacCheese;
    private javax.swing.JCheckBox boxMashedPotatoes;
    private javax.swing.JRadioButton btnCatfish;
    private javax.swing.JRadioButton btnLasagna;
    private javax.swing.JRadioButton btnLobster;
    private javax.swing.JRadioButton btnPrimeRib;
    private javax.swing.JRadioButton btnPumpkinPie;
    private javax.swing.JRadioButton btnReesesCake;
    private javax.swing.JRadioButton btnStrawberryCheesecake;
    private javax.swing.JButton btnSubmit;
    private javax.swing.ButtonGroup groupDesserts;
    private javax.swing.ButtonGroup groupEntrees;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDesserts;
    private javax.swing.JLabel labelEntrees;
    private javax.swing.JLabel labelNumGuests;
    private javax.swing.JLabel labelPrice;
    private javax.swing.JLabel labelSelectedItems;
    private javax.swing.JLabel labelSideDishes;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JLabel labelTotalPrice;
    private javax.swing.JTextArea textAreaSelections;
    private javax.swing.JTextField textFieldGuests;
    private javax.swing.JTextField textFieldTotalPrice;
    // End of variables declaration//GEN-END:variables
}
