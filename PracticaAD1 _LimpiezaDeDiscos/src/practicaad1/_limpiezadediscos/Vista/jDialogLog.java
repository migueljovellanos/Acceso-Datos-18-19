/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaad1._limpiezadediscos.Vista;

import practicaad1._limpiezadediscos.Logica.GestionLimpiezaDiscos;

/**
 *
 * @author miguel
 */
public class jDialogLog extends javax.swing.JDialog {

    private GestionLimpiezaDiscos gestion;

    /**
     * Creates new form jDialogLog from frame
     */
    public jDialogLog(java.awt.Frame parent, boolean modal, GestionLimpiezaDiscos gestion) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        this.gestion = gestion;
        pintarTextArea();
        jTextAreaLog.setEditable(false);
    }

    /**
     * Creates new form jDialogLog from dialog
     */
    public jDialogLog(java.awt.Dialog parent, boolean modal, GestionLimpiezaDiscos gestion) {
        super(parent, modal);
        initComponents();
        this.gestion = gestion;
        pintarTextArea();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaLog = new javax.swing.JTextArea();
        jButtonAceptar = new javax.swing.JButton();
        jLabelLog = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextAreaLog.setColumns(20);
        jTextAreaLog.setRows(5);
        jScrollPane1.setViewportView(jTextAreaLog);

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jLabelLog.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelLog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLog.setText("Registro del programa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAceptar))
                    .addComponent(jLabelLog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabelLog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JLabel jLabelLog;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaLog;
    // End of variables declaration//GEN-END:variables

    private void pintarTextArea() {
        String texto = gestion.getLog();
        if (texto.equals("")) {
            jTextAreaLog.setText("No se ha eliminado nada del disco. \nPrograma ejecutado con exito");
        } else {
            jTextAreaLog.setText(texto);
        }
    }
}
