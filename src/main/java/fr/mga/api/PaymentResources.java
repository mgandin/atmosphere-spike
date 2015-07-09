package fr.mga.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/refresh/3DS")
public class PaymentResources {


    private static final Logger logger = LoggerFactory.getLogger(PaymentResources.class);

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
        logger.info("UUID to pay : {}",uuid);
        payment.pay(uuid);
        return payment.payed(uuid);
    }


}
