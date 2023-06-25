/*
   Copyright The Narayana Authors
   SPDX short identifier: Apache-2.0
 */

package org.oasis_open.docs.ws_tx.wsat._2006._06;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.2-hudson-182-RC1
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "CompletionCoordinatorService", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsat/2006/06", wsdlLocation = "wsdl/wsat-completion-coordinator-binding.wsdl")
public class CompletionCoordinatorService
    extends Service
{

    private final static URL COMPLETIONCOORDINATORSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(org.oasis_open.docs.ws_tx.wsat._2006._06.CompletionCoordinatorService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = org.oasis_open.docs.ws_tx.wsat._2006._06.CompletionCoordinatorService.class.getResource("");
            url = new URL(baseUrl, "wsdl/wsat-completion-coordinator-binding.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'wsdl/wsat-completion-coordinator-binding.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        COMPLETIONCOORDINATORSERVICE_WSDL_LOCATION = url;
    }

    public CompletionCoordinatorService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CompletionCoordinatorService() {
        super(COMPLETIONCOORDINATORSERVICE_WSDL_LOCATION, new QName("http://docs.oasis-open.org/ws-tx/wsat/2006/06", "CompletionCoordinatorService"));
    }

    /**
     * 
     * @return
     *     returns CompletionCoordinatorPortType
     */
    @WebEndpoint(name = "CompletionCoordinatorPortType")
    public CompletionCoordinatorPortType getCompletionCoordinatorPortType() {
        return super.getPort(new QName("http://docs.oasis-open.org/ws-tx/wsat/2006/06", "CompletionCoordinatorPortType"), CompletionCoordinatorPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CompletionCoordinatorPortType
     */
    @WebEndpoint(name = "CompletionCoordinatorPortType")
    public CompletionCoordinatorPortType getCompletionCoordinatorPortType(WebServiceFeature... features) {
        return super.getPort(new QName("http://docs.oasis-open.org/ws-tx/wsat/2006/06", "CompletionCoordinatorPortType"), CompletionCoordinatorPortType.class, features);
    }

}
