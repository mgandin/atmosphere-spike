package fr.mga.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Payment {

    private static final boolean hasPayed = false;

    private final static Map<String,Boolean> pay = new HashMap<>();

    public String start() {
        String uuid = UUID.randomUUID().toString();
        pay.put(uuid, hasPayed);
        return uuid;
    }

    public void pay(String uuid) {
        pay.put(uuid, true);
    }

    public String payed(String uuid) {

        if(pay.containsKey(uuid))
            return pay.get(uuid) ? "PAYED" : "WAITING ..." + uuid;
        else
            return "WAITING ...";
    }
}
