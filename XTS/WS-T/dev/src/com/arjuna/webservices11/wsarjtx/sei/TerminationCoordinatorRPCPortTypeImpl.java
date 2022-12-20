package com.arjuna.webservices11.wsarjtx.sei;

import com.arjuna.schemas.ws._2005._10.wsarjtx.NotificationType;
import com.arjuna.webservices11.wsaddr.AddressingHelper;
import com.arjuna.webservices11.wsarj.ArjunaContext;
import com.arjuna.webservices11.wsarjtx.processors.TerminationCoordinatorRPCProcessor;
import org.jboss.ws.api.addressing.MAP;

import jakarta.annotation.Resource;
import jakarta.jws.*;
import jakarta.jws.soap.SOAPBinding;
import jakarta.xml.ws.WebServiceContext;
import jakarta.xml.ws.handler.MessageContext;

/**
 * This class was generated by Apache CXF 2.2.9-patch-01
 * Thu Aug 26 17:07:44 BST 2010
 * Generated source version: 2.2.9-patch-01
 * 
 */
 
@WebService(targetNamespace = "http://schemas.arjuna.com/ws/2005/10/wsarjtx", name = "TerminationCoordinatorRPCPortType")
@HandlerChain(file="/ws-t-rpc_handlers.xml")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public class TerminationCoordinatorRPCPortTypeImpl {

    @Resource
     private WebServiceContext webServiceCtx;

    @WebResult(name = "Cancelled", targetNamespace = "http://schemas.arjuna.com/ws/2005/10/wsarjtx", partName = "parameters")
    @WebMethod(operationName = "CancelOperation", action = "http://schemas.arjuna.com/ws/2005/10/wsarjtx/Cancel")
    public NotificationType cancelOperation(
        @WebParam(partName = "parameters", name = "Cancel", targetNamespace = "http://schemas.arjuna.com/ws/2005/10/wsarjtx")
        NotificationType parameters
    )
    {
        MessageContext ctx = webServiceCtx.getMessageContext();
        final NotificationType cancel = parameters;
        final MAP inboundMap = AddressingHelper.inboundMap(ctx);
        final ArjunaContext arjunaContext = ArjunaContext.getCurrentContext(ctx);

        TerminationCoordinatorRPCProcessor.getProcessor().cancel(cancel, inboundMap, arjunaContext) ;
        return new NotificationType();
    }

    @WebResult(name = "Closed", targetNamespace = "http://schemas.arjuna.com/ws/2005/10/wsarjtx", partName = "parameters")
    @WebMethod(operationName = "CloseOperation", action = "http://schemas.arjuna.com/ws/2005/10/wsarjtx/Close")
    public NotificationType closeOperation(
        @WebParam(partName = "parameters", name = "Close", targetNamespace = "http://schemas.arjuna.com/ws/2005/10/wsarjtx")
        NotificationType parameters
    )
    {
        MessageContext ctx = webServiceCtx.getMessageContext();
        final NotificationType close = parameters;
        final MAP inboundMap = AddressingHelper.inboundMap(ctx);
        final ArjunaContext arjunaContext = ArjunaContext.getCurrentContext(ctx);

        TerminationCoordinatorRPCProcessor.getProcessor().close(close, inboundMap, arjunaContext); ;
        return new NotificationType();
    }

    @WebResult(name = "Completed", targetNamespace = "http://schemas.arjuna.com/ws/2005/10/wsarjtx", partName = "parameters")
    @WebMethod(operationName = "CompleteOperation", action = "http://schemas.arjuna.com/ws/2005/10/wsarjtx/Complete")
    public NotificationType completeOperation(
        @WebParam(partName = "parameters", name = "Complete", targetNamespace = "http://schemas.arjuna.com/ws/2005/10/wsarjtx")
        NotificationType parameters
    )
    {
        MessageContext ctx = webServiceCtx.getMessageContext();
        final NotificationType complete = parameters;
        final MAP inboundMap = AddressingHelper.inboundMap(ctx);
        final ArjunaContext arjunaContext = ArjunaContext.getCurrentContext(ctx);

        TerminationCoordinatorRPCProcessor.getProcessor().complete(complete, inboundMap, arjunaContext); ;
        return new NotificationType();
    }
}
