/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaad1._limpiezadediscos.Vista.TableModels;

import java.io.File;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author miguel
 */
public class TableModelArchivos extends AbstractTableModel {

    private final List<File> listaArchivos;
    private final String[] columnas = {"Nombre", "Ruta", "Peso(mb)"};

    public TableModelArchivos(List<File> archivos) {
        this.listaArchivos = archivos;
    }

    @Override
    public int getRowCount() {
        return listaArchivos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int columna) {
        return columnas[columna];
    }

    @Override
    public Object getValueAt(int rowindex, int columnindex) {
        switch (columnindex) {
            case 0:
                return listaArchivos.get(rowindex).getName();
            case 1:
                return listaArchivos.get(rowindex).getPath();
            case 2:
                return (int) ((listaArchivos.get(rowindex).length() / 1024) / 1024);
        }
        return null;
    }

}
