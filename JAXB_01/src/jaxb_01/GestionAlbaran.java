/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb_01;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import jaxb.albaran.Articulos;
import jaxb.albaran.Direccion;
import jaxb.albaran.PedidoType;

/**
 *
 * @author Miguel
 */
public class GestionAlbaran implements InterfazControlJAXBAlbaran {

    javax.xml.bind.JAXBContext jaxbCtx = null;

    public GestionAlbaran() {
    }

    @Override
    public JAXBElement unmarshalizar() {
        JAXBElement jaxbElement = null;
        try {
            jaxbCtx = javax.xml.bind.JAXBContext.newInstance("jaxb.albaran");
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            jaxbElement = (JAXBElement) unmarshaller.unmarshal(new java.io.File("albaran.xml"));
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex);
        }
        return jaxbElement;
    }

    @Override
    public boolean marshalizar(JAXBElement element) {
        try {
            Marshaller m = jaxbCtx.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.marshal(element, System.out);
            return true;
        } catch (PropertyException ex) {
            Logger.getLogger(GestionAlbaran.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(GestionAlbaran.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private Articulos.Articulo crearArticulo(String codigo, String nombreProducto, int cantidad, float precio, String comentario) {
        Articulos.Articulo articuloNuevo = new Articulos.Articulo();
        articuloNuevo.setCodigo(codigo);
        articuloNuevo.setNombreProducto(nombreProducto);
        articuloNuevo.setCantidad(cantidad);
        articuloNuevo.setPrecio(BigDecimal.valueOf(precio));
        articuloNuevo.setComentario(comentario);
        return articuloNuevo;
    }

    @Override
    public boolean deleteArticuloPorNombre(PedidoType pedido, String nombreProducto) {
        List<Articulos.Articulo> listaArticulos = pedido.getArticulos().getArticulo();
        Iterator<Articulos.Articulo> it = listaArticulos.iterator();
        while (it.hasNext()) {
            Articulos.Articulo articulo = it.next();
            if (articulo.getNombreProducto().equals(nombreProducto)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean modifyDireccionPedido(PedidoType pedido, String nombre, String calle, String ciudad, String provicia, int codigoPostal) {
        Direccion direccion = pedido.getFacturarA();
        if (direccion != null) {
            direccion.setNombre(nombre);
            direccion.setCalle(calle);
            direccion.setCiudad(ciudad);
            direccion.setProvincia(provicia);
            direccion.setCodigoPostal(BigDecimal.valueOf(codigoPostal));
            return true;
        }
        return false;
    }

    @Override
    public float calcularImportePedido(PedidoType pedido) {
        List<Articulos.Articulo> listaArticulos = pedido.getArticulos().getArticulo();
        float total = 0;
        for (Articulos.Articulo articulo : listaArticulos) {
            total = total + (articulo.getCantidad() * articulo.getPrecio().floatValue());
        }
        return total;
    }

    @Override
    public boolean addArticuloPedido(PedidoType pedido, String codigo, String nombreProducto, int cantidad, float precio, String comentario) throws ExcepcionesAlbaran.ErrorFecha {
        if (comprobarFecha(pedido)) {
            Articulos.Articulo articuloToAdd = crearArticulo(codigo, nombreProducto, cantidad, precio, comentario);
            List<Articulos.Articulo> listaArticulos = pedido.getArticulos().getArticulo();
            for (Articulos.Articulo articulo : listaArticulos) {
                if (articulo.getCodigo().equals(articuloToAdd.getCodigo())) {
                    return false;
                }
            }
            listaArticulos.add(articuloToAdd);
            return true;
        } else {
            throw new ExcepcionesAlbaran.ErrorFecha();
        }
    }

    private boolean comprobarFecha(PedidoType pedido) {
        if (pedido.getFechaPedido() != null) {
            int day = pedido.getFechaPedido().getDay();
            int year = pedido.getFechaPedido().getYear();
            int month = pedido.getFechaPedido().getMonth();
            if ((0 < day && day < 32) && (0 < month && month < 13) && (1989 < day && day < 2031)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
