package com.qontrol.keycloak.sms.providers.sender;

import com.qontrol.keycloak.sms.providers.spi.MessageSenderService;
import com.qontrol.keycloak.sms.providers.spi.MessageSenderServiceProviderFactory;

import org.jboss.logging.Logger;
import org.keycloak.Config.Scope;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

public class TelegramMessageServiceProviderFactory implements MessageSenderServiceProviderFactory {

    private Scope config;

    private static final Logger logger = Logger.getLogger(TelegramMessageSenderServiceProvider.class);

    @Override
    public MessageSenderService create(KeycloakSession keycloakSession) {
        return new TelegramMessageSenderServiceProvider(config);
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
        return "telegram";
    }
}
