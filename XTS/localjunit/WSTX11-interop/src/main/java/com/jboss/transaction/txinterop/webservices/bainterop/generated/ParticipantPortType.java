/*
   Copyright The Narayana Authors
   SPDX-License-Identifier: Apache-2.0
 */


package com.jboss.transaction.txinterop.webservices.bainterop.generated;

import jakarta.jws.Oneway;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.xml.ws.RequestWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.2-hudson-182-RC1
 * Generated source version: 2.0
 * 
 */
@WebService(name = "ParticipantPortType", targetNamespace = "http://fabrikam123.com/wsba")
public interface ParticipantPortType {


    /**
     * 
     */
    @WebMethod(operationName = "Cancel", action = "http://fabrikam123.com/wsba/Cancel")
    @Oneway
    @RequestWrapper(localName = "Cancel", targetNamespace = "http://fabrikam123.com/wsba", className = "com.jboss.transaction.txinterop.webservices.bainterop.generated.TestMessageType")
    public void cancel();

    /**
     * 
     */
    @WebMethod(operationName = "Exit", action = "http://fabrikam123.com/wsba/Exit")
    @Oneway
    @RequestWrapper(localName = "Exit", targetNamespace = "http://fabrikam123.com/wsba", className = "com.jboss.transaction.txinterop.webservices.bainterop.generated.TestMessageType")
    public void exit();

    /**
     * 
     */
    @WebMethod(operationName = "Fail", action = "http://fabrikam123.com/wsba/Fail")
    @Oneway
    @RequestWrapper(localName = "Fail", targetNamespace = "http://fabrikam123.com/wsba", className = "com.jboss.transaction.txinterop.webservices.bainterop.generated.TestMessageType")
    public void fail();

    /**
     * 
     */
    @WebMethod(operationName = "CannotComplete", action = "http://fabrikam123.com/wsba/CannotComplete")
    @Oneway
    @RequestWrapper(localName = "CannotComplete", targetNamespace = "http://fabrikam123.com/wsba", className = "com.jboss.transaction.txinterop.webservices.bainterop.generated.TestMessageType")
    public void cannotComplete();

    /**
     * 
     */
    @WebMethod(operationName = "ParticipantCompleteClose", action = "http://fabrikam123.com/wsba/ParticipantCompleteClose")
    @Oneway
    @RequestWrapper(localName = "ParticipantCompleteClose", targetNamespace = "http://fabrikam123.com/wsba", className = "com.jboss.transaction.txinterop.webservices.bainterop.generated.TestMessageType")
    public void participantCompleteClose();

    /**
     * 
     */
    @WebMethod(operationName = "CoordinatorCompleteClose", action = "http://fabrikam123.com/wsba/CoordinatorCompleteClose")
    @Oneway
    @RequestWrapper(localName = "CoordinatorCompleteClose", targetNamespace = "http://fabrikam123.com/wsba", className = "com.jboss.transaction.txinterop.webservices.bainterop.generated.TestMessageType")
    public void coordinatorCompleteClose();

    /**
     * 
     */
    @WebMethod(operationName = "UnsolicitedComplete", action = "http://fabrikam123.com/wsba/UnsolicitedComplete")
    @Oneway
    @RequestWrapper(localName = "UnsolicitedComplete", targetNamespace = "http://fabrikam123.com/wsba", className = "com.jboss.transaction.txinterop.webservices.bainterop.generated.TestMessageType")
    public void unsolicitedComplete();

    /**
     * 
     */
    @WebMethod(operationName = "Compensate", action = "http://fabrikam123.com/wsba/Compensate")
    @Oneway
    @RequestWrapper(localName = "Compensate", targetNamespace = "http://fabrikam123.com/wsba", className = "com.jboss.transaction.txinterop.webservices.bainterop.generated.TestMessageType")
    public void compensate();

    /**
     * 
     */
    @WebMethod(operationName = "CompensationFail", action = "http://fabrikam123.com/wsba/CompensationFail")
    @Oneway
    @RequestWrapper(localName = "CompensationFail", targetNamespace = "http://fabrikam123.com/wsba", className = "com.jboss.transaction.txinterop.webservices.bainterop.generated.TestMessageType")
    public void compensationFail();

    /**
     * 
     */
    @WebMethod(operationName = "ParticipantCancelCompletedRace", action = "http://fabrikam123.com/wsba/ParticipantCancelCompletedRace")
    @Oneway
    @RequestWrapper(localName = "ParticipantCancelCompletedRace", targetNamespace = "http://fabrikam123.com/wsba", className = "com.jboss.transaction.txinterop.webservices.bainterop.generated.TestMessageType")
    public void participantCancelCompletedRace();

    /**
     * 
     */
    @WebMethod(operationName = "MessageLossAndRecovery", action = "http://fabrikam123.com/wsba/MessageLossAndRecovery")
    @Oneway
    @RequestWrapper(localName = "MessageLossAndRecovery", targetNamespace = "http://fabrikam123.com/wsba", className = "com.jboss.transaction.txinterop.webservices.bainterop.generated.TestMessageType")
    public void messageLossAndRecovery();

    /**
     * 
     */
    @WebMethod(operationName = "MixedOutcome", action = "http://fabrikam123.com/wsba/MixedOutcome")
    @Oneway
    @RequestWrapper(localName = "MixedOutcome", targetNamespace = "http://fabrikam123.com/wsba", className = "com.jboss.transaction.txinterop.webservices.bainterop.generated.TestMessageType")
    public void mixedOutcome();

}