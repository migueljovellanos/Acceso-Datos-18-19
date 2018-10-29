/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaad1._limpiezadediscos.Vista;

import javax.swing.JFileChooser;
import practicaad1._limpiezadediscos.Logica.GestionLimpiezaDiscos;

/**
 *
 * @author miguel
 */
public class jDialogSeleccionarUnidad extends javax.swing.JDialog {

    JFileChooser chooser = new JFileChooser();
    GestionLimpiezaDiscos gestion;

    /**
    * 
    * @param parent
    * @param modal
    * @param gestion 
    */
    public jDialogSeleccionarUnidad(java.awt.Frame parent, boolean modal, GestionLimpiezaDiscos gestion) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        this.gestion = gestion;
        jButtonContinuar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelSeleccionarUnidad = new javax.swing.JLabel();
        jButtonUnidad = new javax.swing.JButton();
        jLabelRuta = new javax.swing.JLabel();
        jButtonContinuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelSeleccionarUnidad.setText("Debe seleccionar una unidad:");

        jButtonUnidad.setText("Seleccionar unidad.");
        jButtonUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUnidadActionPerformed(evt);
            }
        });

        jButtonContinuar.setText("Continuar");
        jButtonContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonContinuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSeleccionarUnidad)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonUnidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonContinuar))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSeleccionarUnidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonUnidad)
                    .addComponent(jLabelRuta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonContinuar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUnidadActionPerformed
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showOpenDialog(this);
        gestion = new GestionLimpiezaDiscos(chooser.getSelectedFile());
        jLabelRuta.setText(gestion.getUnidadSeleccionada().getAbsolutePath());
        jButtonContinuar.setEnabled(true);

    }//GEN-LAST:event_jButtonUnidadActionPerformed

    private void jButtonContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonContinuarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonContinuarActionPerformed

    public GestionLimpiezaDiscos getGestion() {
        return gestion;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonContinuar;
    private javax.swing.JButton jButtonUnidad;
    private javax.swing.JLabel jLabelRuta;
    private javax.swing.JLabel jLabelSeleccionarUnidad;
    // End of variables declaration//GEN-END:variables
}
