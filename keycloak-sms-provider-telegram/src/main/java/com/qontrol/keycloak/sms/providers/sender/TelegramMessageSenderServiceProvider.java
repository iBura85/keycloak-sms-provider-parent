package com.qontrol.keycloak.sms.providers.sender;

import com.qontrol.keycloak.sms.providers.constants.TokenCodeType;
import com.qontrol.keycloak.sms.providers.exceptions.MessageSendException;
import com.qontrol.keycloak.sms.providers.spi.MessageSenderService;

import org.jboss.logging.Logger;
import org.keycloak.Config;

public class TelegramMessageSenderServiceProvider implements MessageSenderService {

    private Config.Scope config;

    private static final Logger logger = Logger.getLogger(TelegramMessageSenderServiceProvider.class);

    TelegramMessageSenderServiceProvider(Config.Scope config) {
        this.config = config;
    }

    @Override
    public void sendSmsMessage(TokenCodeType type, String phone, String code, int expires) throws MessageSendException {
        logger.info("sendSmsMessage: Type - " + type + " Phone - " + phone + " Code - " + code);
    }

    @Override
    public void close() {

    }
}
