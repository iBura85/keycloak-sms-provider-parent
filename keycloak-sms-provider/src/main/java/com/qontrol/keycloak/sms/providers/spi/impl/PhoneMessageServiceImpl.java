package com.qontrol.keycloak.sms.providers.spi.impl;

import com.qontrol.keycloak.sms.providers.constants.TokenCodeType;
import com.qontrol.keycloak.sms.providers.spi.MessageSenderService;
import com.qontrol.keycloak.sms.providers.spi.PhoneMessageService;
import org.jboss.logging.Logger;
import org.keycloak.Config.Scope;
import org.keycloak.models.KeycloakSession;

public class PhoneMessageServiceImpl implements PhoneMessageService {

    private final KeycloakSession session;
    private static final Logger logger = Logger.getLogger(PhoneMessageServiceImpl.class);
    private final int tokenExpiresIn;
    private final int hourMaximum;
    private final String service;



    PhoneMessageServiceImpl(KeycloakSession session, Scope config) {

        this.session = session;

        // получить конфигурацию из Scope
        this.tokenExpiresIn = config.getInt("tokenExpiresIn", 60);

        // получить сервис для отправки сообщений
        this.service = session.listProviderIds(MessageSenderService.class)
                .stream().filter(s -> s.equals(config.get("service")))
                .findFirst().orElse(
                        session.listProviderIds(MessageSenderService.class)
                                .stream().findFirst().orElse("")
                );

        this.hourMaximum = config.getInt("hourMaximum",3);
    }

    @Override
    public int sendTokenCode(String phoneNumber, TokenCodeType type) {
        logger.warn("============ SEND TOKEN!!!: " +  service);
        logger.warn("============ MessageSenderService: " +  service);

        return 0;
    }

    @Override
    public void close() {

    }

}
