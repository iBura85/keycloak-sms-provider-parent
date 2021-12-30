package com.qontrol.keycloak.sms.providers.rest;

import org.keycloak.models.KeycloakSession;
import org.keycloak.services.resource.RealmResourceProvider;

import javax.ws.rs.*;

public class SmsResourceProvider implements RealmResourceProvider {

    private KeycloakSession session;

    public SmsResourceProvider(KeycloakSession session) {
        this.session = session;
    }

    @Override
    public Object getResource() {
        return new SmsResource(this.session);
    }

    @GET
    @Produces("text/plain; charset=utf-8")
    public String get() {
        String name = session.getContext().getRealm().getDisplayName();
        if (name == null) {
            name = session.getContext().getRealm().getName();
        }
        return "Hello world " + name;
    }


    @Override
    public void close() {

    }
}
