/*
   Copyright The Narayana Authors
   SPDX-License-Identifier: Apache-2.0
 */

package org.oasis_open.docs.ws_tx.wsba._2006._06;

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
@WebService(name = "BusinessAgreementWithParticipantCompletionParticipantPortType", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsba/2006/06")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BusinessAgreementWithParticipantCompletionParticipantPortType {


    /**
     * 
     * @param parameters
     */
    @WebMethod(operationName = "CloseOperation", action = "http://docs.oasis-open.org/ws-tx/wsba/2006/06/Close")
    @Oneway
    public void closeOperation(
        @WebParam(name = "Close", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsba/2006/06", partName = "parameters")
        NotificationType parameters);

    /**
     * 
     * @param parameters
     */
    @WebMethod(operationName = "CancelOperation", action = "http://docs.oasis-open.org/ws-tx/wsba/2006/06/Cancel")
    @Oneway
    public void cancelOperation(
        @WebParam(name = "Cancel", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsba/2006/06", partName = "parameters")
        NotificationType parameters);

    /**
     * 
     * @param parameters
     */
    @WebMethod(operationName = "CompensateOperation", action = "http://docs.oasis-open.org/ws-tx/wsba/2006/06/Compensate")
    @Oneway
    public void compensateOperation(
        @WebParam(name = "Compensate", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsba/2006/06", partName = "parameters")
        NotificationType parameters);

    /**
     * 
     * @param parameters
     */
    @WebMethod(operationName = "FailedOperation", action = "http://docs.oasis-open.org/ws-tx/wsba/2006/06/Failed")
    @Oneway
    public void failedOperation(
        @WebParam(name = "Failed", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsba/2006/06", partName = "parameters")
        NotificationType parameters);

    /**
     * 
     * @param parameters
     */
    @WebMethod(operationName = "ExitedOperation", action = "http://docs.oasis-open.org/ws-tx/wsba/2006/06/Exited")
    @Oneway
    public void exitedOperation(
        @WebParam(name = "Exited", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsba/2006/06", partName = "parameters")
        NotificationType parameters);

    /**
     * 
     * @param parameters
     */
    @WebMethod(operationName = "NotCompleted", action = "http://docs.oasis-open.org/ws-tx/wsba/2006/06/NotCompleted")
    @Oneway
    public void notCompleted(
        @WebParam(name = "NotCompleted", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsba/2006/06", partName = "parameters")
        NotificationType parameters);

    /**
     * 
     * @param parameters
     */
    @WebMethod(operationName = "GetStatusOperation", action = "http://docs.oasis-open.org/ws-tx/wsba/2006/06/GetStatus")
    @Oneway
    public void getStatusOperation(
        @WebParam(name = "GetStatus", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsba/2006/06", partName = "parameters")
        NotificationType parameters);

    /**
     * 
     * @param parameters
     */
    @WebMethod(operationName = "StatusOperation", action = "http://docs.oasis-open.org/ws-tx/wsba/2006/06/Status")
    @Oneway
    public void statusOperation(
        @WebParam(name = "Status", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsba/2006/06", partName = "parameters")
        StatusType parameters);

    /**
     *
     * @param fault
     */
    @WebMethod(operationName = "SoapFault", action = "http://docs.oasis-open.org/ws-tx/wscoor/2006/06/fault")
    @Oneway
    public void soapFault(
        @WebParam(name = "Fault", targetNamespace = "http://schemas.xmlsoap.org/soap/envelope/", partName = "parameters")
        Fault fault);
}
