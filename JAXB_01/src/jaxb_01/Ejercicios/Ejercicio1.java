/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb_01.Ejercicios;

import javax.xml.bind.JAXBElement;
import jaxb.albaran.PedidoType;

/**
 *
 * @author Miguel
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JAXBElement jaxbElement = null;
        javax.xml.bind.JAXBContext jaxbCtx = null;

        try {
            jaxbCtx = javax.xml.bind.JAXBContext.newInstance("jaxb.albaran");
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            jaxbElement = (JAXBElement) unmarshaller.unmarshal(new java.io.File("albaran.xml")); //NOI18N
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        
        PedidoType pedidoType = (PedidoType) jaxbElement.getValue();
    }

}
