/*
 * SPDX short identifier: Apache-2.0
 */

package org.jboss.jbossts.xts.soapfault;

import org.xmlsoap.schemas.soap.envelope.Fault;

import jakarta.jws.Oneway;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.2-hudson-182-RC1
 * Generated source version: 2.1
 * 
 */
@WebService(name = "SoapFaultPortType", targetNamespace = "http://jbossts.jboss.org/xts/soapfault")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface SoapFaultPortType {


    /**
     * 
     * @param fault
     */
    @WebMethod(operationName = "SoapFault")
    @Oneway
    public void soapFault(
        @WebParam(name = "Fault", targetNamespace = "http://schemas.xmlsoap.org/soap/envelope/", partName = "fault")
        Fault fault);

}
