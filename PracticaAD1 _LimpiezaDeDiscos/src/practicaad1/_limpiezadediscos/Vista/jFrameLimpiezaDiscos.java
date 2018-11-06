/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaad1._limpiezadediscos.Vista;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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
        ImageIcon img = new ImageIcon("/home/miguel/Documentos/Acceso-Datos-18-19/PracticaAD1 _LimpiezaDeDiscos/src/practicaad1/_limpiezadediscos/Archivos/icono.png");
        this.setIconImage(img.getImage());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        jDialogSeleccionarUnidad jDialogSeleccionarUnidad = new jDialogSeleccionarUnidad(this, rootPaneCheckingEnabled, gestion);
        jDialogSeleccionarUnidad.setVisible(true);
        if (jDialogSeleccionarUnidad.getGestion() != null) {
            this.gestion = jDialogSeleccionarUnidad.getGestion();
            jLabelRuta.setText(gestion.getUnidadSeleccionada().getAbsolutePath());
        } else {
            cerrar = true;
        }
        pintarEspacioDisco();
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

        jLabelTitulo = new javax.swing.JLabel();
        jButtonSeleccionarUnidad = new javax.swing.JButton();
        jLabelEspacioTotal = new javax.swing.JLabel();
        jLabel = new javax.swing.JLabel();
        jButtonBorrarDocumentos = new javax.swing.JButton();
        jButtonBorrarMusica = new javax.swing.JButton();
        jButtonBorrarVideos = new javax.swing.JButton();
        jButtonBorrarImagenes = new javax.swing.JButton();
        jLabelOpcionesExtra = new javax.swing.JLabel();
        jButtonBorrarDuplicados = new javax.swing.JButton();
        jButtonEliminarFicherosSize = new javax.swing.JButton();
        jButtonLimpiarDisco = new javax.swing.JButton();
        jLabelEspacioLibreTotal = new javax.swing.JLabel();
        jLabelRuta = new javax.swing.JLabel();
        jButtonEscanear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Herramienta limpieza disco");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabelTitulo.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabelTitulo.setText("Herramienta de limpieza de discos");

        jButtonSeleccionarUnidad.setText("Cambiar unidad");
        jButtonSeleccionarUnidad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonSeleccionarUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionarUnidadActionPerformed(evt);
            }
        });

        jLabelEspacioTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelEspacioTotal.setText("Espacio total:");

        jLabel.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jLabel.setText("Ruta: ");

        jButtonBorrarDocumentos.setText("Gestionar documentos");
        jButtonBorrarDocumentos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonBorrarDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarDocumentosActionPerformed(evt);
            }
        });

        jButtonBorrarMusica.setText("Gestionar musica");
        jButtonBorrarMusica.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonBorrarMusica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarMusicaActionPerformed(evt);
            }
        });

        jButtonBorrarVideos.setText("Gestionar videos");
        jButtonBorrarVideos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonBorrarVideos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarVideosActionPerformed(evt);
            }
        });

        jButtonBorrarImagenes.setText("Gestionar imagenes");
        jButtonBorrarImagenes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonBorrarImagenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarImagenesActionPerformed(evt);
            }
        });

        jLabelOpcionesExtra.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelOpcionesExtra.setText("Opciones :");

        jButtonBorrarDuplicados.setText("Borrar duplicados");
        jButtonBorrarDuplicados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonBorrarDuplicados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarDuplicadosActionPerformed(evt);
            }
        });

        jButtonEliminarFicherosSize.setText("Borrar archivos por tamaño");
        jButtonEliminarFicherosSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarFicherosSizeActionPerformed(evt);
            }
        });

        jButtonLimpiarDisco.setText("Borrar directorios vacios");
        jButtonLimpiarDisco.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonLimpiarDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarDiscoActionPerformed(evt);
            }
        });

        jLabelEspacioLibreTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelEspacioLibreTotal.setText("Espacio libre :");

        jButtonEscanear.setText("Escanear unidad");
        jButtonEscanear.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonEscanear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEscanearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelEspacioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEspacioLibreTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelOpcionesExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBorrarDuplicados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEliminarFicherosSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonLimpiarDisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEscanear, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonBorrarMusica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonBorrarImagenes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonBorrarDocumentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonBorrarVideos, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSeleccionarUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSeleccionarUnidad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelRuta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEspacioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEspacioLibreTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelOpcionesExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBorrarImagenes)
                    .addComponent(jButtonEscanear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBorrarDuplicados)
                    .addComponent(jButtonBorrarMusica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEliminarFicherosSize)
                    .addComponent(jButtonBorrarDocumentos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBorrarVideos)
                    .addComponent(jButtonLimpiarDisco))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEliminarFicherosSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarFicherosSizeActionPerformed
        jDialogSeleccionSize dialogoSize = new jDialogSeleccionSize(this, rootPaneCheckingEnabled, gestion);
        dialogoSize.setVisible(true);
        try {
            jDialogBorrarSize dialogo = new jDialogBorrarSize(this, rootPaneCheckingEnabled, gestion);
            dialogo.setVisible(true);
        } catch (MisExcepciones.NoExisteDirectorio ex) {
            Logger.getLogger(jFrameLimpiezaDiscos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEliminarFicherosSizeActionPerformed

    private void jButtonBorrarDuplicadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarDuplicadosActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, "¿ Seguro que desea borrar estos ficheros ?");
        if (opcion == 0) {
            try {
                jDialogBorrarDuplicados dialog = new jDialogBorrarDuplicados(this, rootPaneCheckingEnabled, gestion);
                dialog.setVisible(true);
            } catch (MisExcepciones.NoExisteDirectorio ex) {
                Logger.getLogger(jFrameLimpiezaDiscos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButtonBorrarDuplicadosActionPerformed

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
        int opcion = JOptionPane.showConfirmDialog(this, "¿ Seguro que desea borrar estos ficheros ?");
        if (opcion == 0) {
            gestion.eliminarDirectoriosVaciosRecursivo();
        }
        jDialogLog log = new jDialogLog(this, rootPaneCheckingEnabled, gestion);
        log.setVisible(true);
    }//GEN-LAST:event_jButtonLimpiarDiscoActionPerformed

    private void jButtonEscanearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEscanearActionPerformed
        gestion.listarArchivosRecursivamente(gestion.getUnidadSeleccionada());
    }//GEN-LAST:event_jButtonEscanearActionPerformed

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
            @Override
            public void run() {
                jFrameLimpiezaDiscos frame = new jFrameLimpiezaDiscos();
                if (frame.isCerrar()) {
                    frame.dispose();
                } else {
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
    private javax.swing.JButton jButtonEliminarFicherosSize;
    private javax.swing.JButton jButtonEscanear;
    private javax.swing.JButton jButtonLimpiarDisco;
    private javax.swing.JButton jButtonSeleccionarUnidad;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabelEspacioLibreTotal;
    private javax.swing.JLabel jLabelEspacioTotal;
    private javax.swing.JLabel jLabelOpcionesExtra;
    private javax.swing.JLabel jLabelRuta;
    private javax.swing.JLabel jLabelTitulo;
    // End of variables declaration//GEN-END:variables

    private void pintarEspacioDisco() {
        jLabelEspacioTotal.setText("Espacio total : " + gestion.getTotalSpaceGb() + " GB.");
        jLabelEspacioLibreTotal.setText("Espacio libre : " + gestion.getFreeSpaceGb() + " GB.");
    }
}
