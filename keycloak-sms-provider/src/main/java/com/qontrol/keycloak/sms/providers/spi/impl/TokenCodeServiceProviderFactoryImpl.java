package com.qontrol.keycloak.sms.providers.spi.impl;

import com.qontrol.keycloak.sms.providers.spi.TokenCodeService;
import com.qontrol.keycloak.sms.providers.spi.TokenCodeServiceProviderFactory;
import org.keycloak.Config;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

public class TokenCodeServiceProviderFactoryImpl implements TokenCodeServiceProviderFactory {
    @Override
    public TokenCodeService create(KeycloakSession keycloakSession) {
        return null;
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
        return null;
    }
}
