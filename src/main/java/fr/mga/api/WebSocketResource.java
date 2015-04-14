package fr.mga.api;

import org.atmosphere.annotation.Broadcast;
import org.atmosphere.annotation.Suspend;
import org.atmosphere.config.service.AtmosphereService;
import org.atmosphere.cpr.*;
import org.atmosphere.jersey.Broadcastable;
import org.atmosphere.jersey.JerseyBroadcaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;

@Path("/refresh/3DS")
@AtmosphereService (broadcaster = JerseyBroadcaster.class)
public class WebSocketResource {


    private final Logger logger = LoggerFactory.getLogger(WebSocketResource.class);

    @Autowired
    private Payment payment;


    @GET
    @Path("/start")
    public String start() {
        String uuid = payment.start();
        logger.info("UUID : {}",uuid);
        return uuid;
    }

    @GET
    @Path("/pay/{uuid}")
    public String pay(@PathParam("uuid")String uuid) {
        payment.pay(uuid);
        return payment.payed(uuid);
    }

    @Suspend(contentType = "application/json", listeners = {AtmosphereResourceEventListenerAdapter.OnDisconnect.class})
    @GET
    @Path("/{uuid}")
    public String suspend(@PathParam("uuid")String uuid) {
        return payment.payed(uuid);
    }


}
