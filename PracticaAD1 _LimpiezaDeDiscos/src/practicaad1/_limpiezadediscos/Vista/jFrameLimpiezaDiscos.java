/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaad1._limpiezadediscos.Vista;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import practicaad1._limpiezadediscos.Logica.GestionLimpiezaDiscos;
import practicaad1._limpiezadediscos.Logica.MisExcepciones;

/**
 *
 * @author migue
 */
public class jFrameLimpiezaDiscos extends javax.swing.JFrame {

    JFileChooser chooser = new JFileChooser();
    GestionLimpiezaDiscos gestion;
    static boolean cerrar = false;

    /**
     * Creates new form jFrameLimpiezaDiscos
     */
    public jFrameLimpiezaDiscos() {
        initComponents();
        this.setLocationRelativeTo(null);
        jDialogSeleccionarUnidad jDialogSeleccionarUnidad = new jDialogSeleccionarUnidad(this, rootPaneCheckingEnabled, gestion);
        jDialogSeleccionarUnidad.setVisible(true);
        if (jDialogSeleccionarUnidad.getGestion() != null) {
            this.gestion = jDialogSeleccionarUnidad.getGestion();
            jLabelRuta.setText(gestion.getUnidadSeleccionada().getAbsolutePath());
        } else {
            cerrar = true;
        }

    }

    public static boolean isCerrar() {
        return cerrar;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonLimpiarDisco = new javax.swing.JButton();
        jLabelOpcionesExtra = new javax.swing.JLabel();
        jButtonBorrarImagenes = new javax.swing.JButton();
        jButtonBorrarVideos = new javax.swing.JButton();
        jButtonBorrarDocumentos = new javax.swing.JButton();
        jButtonBorrarMusica = new javax.swing.JButton();
        jLabelRuta = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        jButtonSeleccionarUnidad = new javax.swing.JButton();
        jButtonBorrarDuplicados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Herramienta limpieza disco");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabelTitulo.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabelTitulo.setText("Herramienta de limpieza de discos");

        jButtonLimpiarDisco.setText("Ejecutar limpieza disco.");
        jButtonLimpiarDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarDiscoActionPerformed(evt);
            }
        });

        jLabelOpcionesExtra.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelOpcionesExtra.setText("Opciones extra:");

        jButtonBorrarImagenes.setText("Borrar imagenes");
        jButtonBorrarImagenes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonBorrarImagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarImagenesActionPerformed(evt);
            }
        });

        jButtonBorrarVideos.setText("Borrar videos");
        jButtonBorrarVideos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonBorrarVideos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarVideosActionPerformed(evt);
            }
        });

        jButtonBorrarDocumentos.setText("Borrar documentos");
        jButtonBorrarDocumentos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonBorrarDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarDocumentosActionPerformed(evt);
            }
        });

        jButtonBorrarMusica.setText("Borrar musica");
        jButtonBorrarMusica.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonBorrarMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarMusicaActionPerformed(evt);
            }
        });

        jLabelRuta.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jLabel.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel.setText("Ruta: ");

        jButtonSeleccionarUnidad.setText("Cambiar unidad");
        jButtonSeleccionarUnidad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonSeleccionarUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionarUnidadActionPerformed(evt);
            }
        });

        jButtonBorrarDuplicados.setText("Borrar duplicados");
        jButtonBorrarDuplicados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonBorrarDuplicados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarDuplicadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonSeleccionarUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonLimpiarDisco)
                            .addComponent(jLabelOpcionesExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButtonBorrarImagenes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonBorrarVideos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonBorrarMusica, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonBorrarDocumentos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(113, 113, 113)
                                .addComponent(jButtonBorrarDuplicados)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSeleccionarUnidad)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonLimpiarDisco)
                .addGap(18, 18, 18)
                .addComponent(jLabelOpcionesExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBorrarImagenes)
                    .addComponent(jButtonBorrarDuplicados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBorrarVideos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBorrarMusica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBorrarDocumentos))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSeleccionarUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleccionarUnidadActionPerformed
        jDialogSeleccionarUnidad jDialogSeleccionarUnidad = new jDialogSeleccionarUnidad(this, rootPaneCheckingEnabled, gestion);
        jDialogSeleccionarUnidad.setVisible(true);
        if (jDialogSeleccionarUnidad.getGestion() != null) {
            this.gestion = jDialogSeleccionarUnidad.getGestion();
            jLabelRuta.setText(gestion.getUnidadSeleccionada().getAbsolutePath());
        }
    }//GEN-LAST:event_jButtonSeleccionarUnidadActionPerformed

    private void jButtonBorrarMusicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarMusicaActionPerformed
        try {
            jDialogBorrarCategoria dialog = new jDialogBorrarCategoria(this, rootPaneCheckingEnabled, "Audios", gestion);
            dialog.setVisible(true);
        } catch (MisExcepciones.NoExisteDirectorio ex) {
            Logger.getLogger(jFrameLimpiezaDiscos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonBorrarMusicaActionPerformed

    private void jButtonBorrarDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarDocumentosActionPerformed
        try {
            jDialogBorrarCategoria dialog = new jDialogBorrarCategoria(this, rootPaneCheckingEnabled, "Documentos", gestion);
            dialog.setVisible(true);
        } catch (MisExcepciones.NoExisteDirectorio ex) {
            Logger.getLogger(jFrameLimpiezaDiscos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonBorrarDocumentosActionPerformed

    private void jButtonBorrarVideosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarVideosActionPerformed
        try {
            jDialogBorrarCategoria dialog = new jDialogBorrarCategoria(this, rootPaneCheckingEnabled, "Videos", gestion);
            dialog.setVisible(true);
        } catch (MisExcepciones.NoExisteDirectorio ex) {
            Logger.getLogger(jFrameLimpiezaDiscos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonBorrarVideosActionPerformed

    private void jButtonBorrarImagenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarImagenesActionPerformed
        try {
            jDialogBorrarCategoria dialog = new jDialogBorrarCategoria(this, rootPaneCheckingEnabled, "Imagenes", gestion);
            dialog.setVisible(true);
        } catch (MisExcepciones.NoExisteDirectorio ex) {
            Logger.getLogger(jFrameLimpiezaDiscos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonBorrarImagenesActionPerformed

    private void jButtonLimpiarDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarDiscoActionPerformed
        gestion.eliminarDirectoriosVaciosRecursivo();
        jDialogLog log = new jDialogLog(this, rootPaneCheckingEnabled, gestion);
        log.setVisible(true);
    }//GEN-LAST:event_jButtonLimpiarDiscoActionPerformed

    private void jButtonBorrarDuplicadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarDuplicadosActionPerformed
        
        try {
            jDialogBorrarDuplicados dialog = new jDialogBorrarDuplicados(this, rootPaneCheckingEnabled, gestion);
            dialog.setVisible(true);
        } catch (MisExcepciones.NoExisteDirectorio ex) {
            Logger.getLogger(jFrameLimpiezaDiscos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonBorrarDuplicadosActionPerformed

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
            java.util.logging.Logger.getLogger(jFrameLimpiezaDiscos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrameLimpiezaDiscos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrameLimpiezaDiscos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrameLimpiezaDiscos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jFrameLimpiezaDiscos frame = new jFrameLimpiezaDiscos();
                if (frame.isCerrar()){
                    frame.dispose();
                }else{
                    frame.setVisible(true);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBorrarDocumentos;
    private javax.swing.JButton jButtonBorrarDuplicados;
    private javax.swing.JButton jButtonBorrarImagenes;
    private javax.swing.JButton jButtonBorrarMusica;
    private javax.swing.JButton jButtonBorrarVideos;
    private javax.swing.JButton jButtonLimpiarDisco;
    private javax.swing.JButton jButtonSeleccionarUnidad;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabelOpcionesExtra;
    private javax.swing.JLabel jLabelRuta;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
