package com.qontrol.keycloak.sms.providers.spi.impl;

import com.qontrol.keycloak.sms.providers.constants.TokenCodeType;
import com.qontrol.keycloak.sms.providers.exceptions.MessageSendException;
import com.qontrol.keycloak.sms.providers.spi.MessageSenderService;
import com.qontrol.keycloak.sms.providers.spi.PhoneMessageService;
import org.jboss.logging.Logger;
import org.keycloak.Config.Scope;
import org.keycloak.models.KeycloakSession;

import javax.ws.rs.ServiceUnavailableException;

public class PhoneMessageServiceImpl implements PhoneMessageService {

    private final KeycloakSession session;
    private static final Logger logger = Logger.getLogger(PhoneMessageServiceImpl.class);
    private final int tokenExpiresIn;
    private final int hourMaximum;
    private final String service;



    PhoneMessageServiceImpl(KeycloakSession session, Scope config) {

        logger.warn("~~~~~~~~~~~~~~ CONSTRUCTOR ~~~~~~~~~~~~~~~~~~~~~~");

        this.session = session;

        // получить конфигурацию из Scope
        this.tokenExpiresIn = config.getInt("tokenExpiresIn", 60);

        this.service = session.listProviderIds(MessageSenderService.class)
                .stream().filter(s -> s.equals(config.get("service")))
                .findFirst().orElse(
                        session.listProviderIds(MessageSenderService.class)
                                .stream().findFirst().orElse("")
                );

        this.hourMaximum = config.getInt("hourMaximum",3);
    }

    @Override
    public int sendTokenCode(String phone, TokenCodeType type)  {

        logger.warn("~~~ tokenExpiresIn" +  tokenExpiresIn);

        String code = "1234";


        logger.warn("~~~ service" +  service);

        try {
            session.getProvider(MessageSenderService.class, service).sendSmsMessage(type, phone, code, 123324);
        } catch (MessageSendException e) {
            logger.error(String.format("Message sending to %s failed with %s: %s",
                    phone, e.getErrorCode(), e.getErrorMessage()));
            throw new ServiceUnavailableException("Internal server error");

        }

        return 0;
    }

    @Override
    public void close() {

    }

}
