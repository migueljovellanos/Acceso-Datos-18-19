/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaad1._limpiezadediscos.Vista;

import java.awt.Desktop;
import practicaad1._limpiezadediscos.Vista.TableModels.TableModelArchivos;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import practicaad1._limpiezadediscos.Logica.GestionLimpiezaDiscos;
import practicaad1._limpiezadediscos.Logica.MisExcepciones;

/**
 *
 * @author miguel
 */
public class jDialogBorrarSize extends javax.swing.JDialog {

    private GestionLimpiezaDiscos gestion;
    private List<File> listaArchivos;
    private int Size;

    /**
     * Creates new form jDialogBorrarCategoria
     */
    public jDialogBorrarSize(java.awt.Frame parent, boolean modal, int size, GestionLimpiezaDiscos gestion) throws MisExcepciones.NoExisteDirectorio {
        super(parent, modal);
        initComponents();
        this.gestion = gestion;
        this.listaArchivos = gestion.eliminarFicherosPorTamaño(size);
        this.setLocationRelativeTo(null);
        pintarTabla();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableArchivos = new javax.swing.JTable();
        jButtonBorrarSeleccionados = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonCandelar = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableArchivos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableArchivos);

        jButtonBorrarSeleccionados.setText("Borrar seleccionados");
        jButtonBorrarSeleccionados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarSeleccionadosActionPerformed(evt);
            }
        });

        jLabelTitulo.setText("Archivos :");

        jButtonCandelar.setText("Cancelar");
        jButtonCandelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCandelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonCandelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonBorrarSeleccionados)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBorrarSeleccionados)
                    .addComponent(jButtonCandelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCandelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCandelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCandelarActionPerformed

    private void jButtonBorrarSeleccionadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarSeleccionadosActionPerformed
        int[] filasSeleccionadas = jTableArchivos.getSelectedRows();
        List<File> archivosABorrar = new ArrayList<>();
        for (int i = 0; i < filasSeleccionadas.length; i++) {
            int fila = jTableArchivos.convertRowIndexToModel(filasSeleccionadas[i]);
            archivosABorrar.add(listaArchivos.get(fila));
        }
        int opcion = JOptionPane.showConfirmDialog(this, "¿ Seguro que desea borrar estos ficheros ?");
        if (opcion == 0) {
            gestion.deleteFiles(archivosABorrar);
        }

        try {
            pintarTabla();
        } catch (MisExcepciones.NoExisteDirectorio ex) {
            Logger.getLogger(jDialogBorrarSize.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonBorrarSeleccionadosActionPerformed

    private void pintarTabla() throws MisExcepciones.NoExisteDirectorio {
        this.listaArchivos = gestion.eliminarFicherosPorTamaño(Size);
        TableModelArchivos modelo = new TableModelArchivos(listaArchivos);
        jTableArchivos.setModel(modelo);
        TableRowSorter<TableModel> elQueOrdena = new TableRowSorter<TableModel>(modelo);
        jTableArchivos.setRowSorter(elQueOrdena);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBorrarSeleccionados;
    private javax.swing.JButton jButtonCandelar;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableArchivos;
    // End of variables declaration//GEN-END:variables
}
