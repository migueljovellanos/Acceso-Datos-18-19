/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb_01.Ejercicios;

import java.util.logging.Level;
import java.util.logging.Logger;
import jaxb.albaran.PedidoType;
import jaxb_01.ExcepcionesAlbaran;
import jaxb_01.GestionAlbaran;

/**
 *
 * @author Miguel
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestionAlbaran gestion = new GestionAlbaran();
        PedidoType pedidoType = (PedidoType) gestion.unmarshalizar().getValue();
        System.out.println(String.valueOf(gestion.calcularImportePedido(pedidoType)));
        try {
            gestion.addArticuloPedido(pedidoType, "BBB", "cascos", 5, 10, "");
        } catch (ExcepcionesAlbaran.ErrorFecha ex) {
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(String.valueOf(gestion.calcularImportePedido(pedidoType)));
        gestion.deleteArticuloPorNombre(pedidoType, "cascos");
        System.out.println(String.valueOf(gestion.calcularImportePedido(pedidoType)));
        
    }

}
