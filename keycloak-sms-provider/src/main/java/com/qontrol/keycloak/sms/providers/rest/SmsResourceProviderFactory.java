package com.qontrol.keycloak.sms.providers.rest;

import org.keycloak.Config;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.services.resource.RealmResourceProvider;
import org.keycloak.services.resource.RealmResourceProviderFactory;

public class SmsResourceProviderFactory implements RealmResourceProviderFactory {

    // http://sso.rcm/auth/realms/master/sms
    public static final String ID = "sms";

    @Override
    public RealmResourceProvider create(KeycloakSession keycloakSession) {
        return new SmsResourceProvider(keycloakSession);
    }

    @Override
    public void init(Config.Scope scope) {

    }

    @Override
    public void postInit(KeycloakSessionFactory keycloakSessionFactory) {

    }

    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return ID;
    }
}
