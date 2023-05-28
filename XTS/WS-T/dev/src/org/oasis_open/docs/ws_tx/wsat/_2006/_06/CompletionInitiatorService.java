/*
 * SPDX short identifier: Apache-2.0
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
@WebServiceClient(name = "CompletionInitiatorService", targetNamespace = "http://docs.oasis-open.org/ws-tx/wsat/2006/06", wsdlLocation = "wsdl/wsat-completion-initiator-binding.wsdl")
public class CompletionInitiatorService
    extends Service
{

    private final static URL COMPLETIONINITIATORSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(org.oasis_open.docs.ws_tx.wsat._2006._06.CompletionInitiatorService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = org.oasis_open.docs.ws_tx.wsat._2006._06.CompletionInitiatorService.class.getResource("");
            url = new URL(baseUrl, "wsdl/wsat-completion-initiator-binding.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'wsdl/wsat-completion-initiator-binding.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        COMPLETIONINITIATORSERVICE_WSDL_LOCATION = url;
    }

    public CompletionInitiatorService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CompletionInitiatorService() {
        super(COMPLETIONINITIATORSERVICE_WSDL_LOCATION, new QName("http://docs.oasis-open.org/ws-tx/wsat/2006/06", "CompletionInitiatorService"));
    }

    /**
     * 
     * @return
     *     returns CompletionInitiatorPortType
     */
    @WebEndpoint(name = "CompletionInitiatorPortType")
    public CompletionInitiatorPortType getCompletionInitiatorPortType() {
        return super.getPort(new QName("http://docs.oasis-open.org/ws-tx/wsat/2006/06", "CompletionInitiatorPortType"), CompletionInitiatorPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CompletionInitiatorPortType
     */
    @WebEndpoint(name = "CompletionInitiatorPortType")
    public CompletionInitiatorPortType getCompletionInitiatorPortType(WebServiceFeature... features) {
        return super.getPort(new QName("http://docs.oasis-open.org/ws-tx/wsat/2006/06", "CompletionInitiatorPortType"), CompletionInitiatorPortType.class, features);
    }

}
