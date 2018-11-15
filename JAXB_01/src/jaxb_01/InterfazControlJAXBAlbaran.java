/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb_01;

import javax.xml.bind.JAXBElement;
import jaxb.albaran.PedidoType;

/**
 *
 * @author Miguel
 */
public interface InterfazControlJAXBAlbaran {
    
    public JAXBElement unmarshalizar();
    
    public boolean marshalizar(JAXBElement element);
    
    public boolean addArticuloPedido(PedidoType pedido,String codigo , String nombreProducto, int cantidad,float precio,String comentario) throws ExcepcionesAlbaran.ErrorFecha;
    
    public boolean modifyDireccionPedido(PedidoType pedido ,String nombre, String calle, String ciudad, String provicia, int codigoPostal);
    
    public float calcularImportePedido(PedidoType pedido);
    
    public boolean deleteArticuloPorNombre(PedidoType pedido , String nombreProducto);
    
}
