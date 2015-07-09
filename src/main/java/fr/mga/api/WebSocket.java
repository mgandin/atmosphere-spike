package fr.mga.api;

import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.Message;
import org.atmosphere.cpr.DefaultBroadcaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;

/**
 * @author mathieu.gandin
 */
@ManagedService(path = "/async", broadcaster = DefaultBroadcaster.class)
public final class WebSocket {

    private final Logger logger = LoggerFactory.getLogger(WebSocket.class);

    @Autowired
    private Payment payment;

    @Message
    public final String onMessage(String uuid) {
        return payment.payed(uuid);
    }


}
