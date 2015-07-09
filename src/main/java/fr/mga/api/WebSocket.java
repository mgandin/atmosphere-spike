package fr.mga.api;

import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.Message;
import org.atmosphere.cpr.DefaultBroadcaster;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author mathieu.gandin
 */
@ManagedService(path = "/async", broadcaster = DefaultBroadcaster.class)
public final class WebSocket {

    @Autowired
    private Payment payment;

    @Message
    public final String onMessage(String uuid) {
        return payment.payed(uuid);
    }


}
