package com.qontrol.keycloak.sms.providers.spi.impl;

import com.qontrol.keycloak.sms.providers.spi.PhoneMessageService;
import com.qontrol.keycloak.sms.providers.spi.PhoneMessageServiceProviderFactory;

import org.jboss.logging.Logger;
import org.keycloak.Config.Scope;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

public class PhoneMessageServiceProviderFactoryImpl implements PhoneMessageServiceProviderFactory {
    private Scope config;

    private static final Logger logger = Logger.getLogger(PhoneMessageServiceProviderFactoryImpl.class);

    @Override
    public PhoneMessageService create(KeycloakSession session) {
        return new PhoneMessageServiceImpl(session, config);
    }

    @Override
    public void init(Scope config) {
        this.config = config;
    }

    @Override
    public void postInit(KeycloakSessionFactory keycloakSessionFactory) {

    }

    @Override
    public void close() {

    }

    @Override
    public String getId() {
        return "default";
    }
}
