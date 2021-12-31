package com.qontrol.keycloak.sms.providers.sender;

import com.qontrol.keycloak.sms.providers.constants.TokenCodeType;
import com.qontrol.keycloak.sms.providers.exceptions.MessageSendException;
import com.qontrol.keycloak.sms.providers.spi.MessageSenderService;

import org.jboss.logging.Logger;
import org.keycloak.Config;

import java.io.IOException;
import java.net.URLEncoder;

public class TelegramMessageSenderServiceProvider implements MessageSenderService {

    private final Config.Scope config;

    private final TelegramBot bot;

    private static final Logger logger = Logger.getLogger(TelegramMessageSenderServiceProvider.class);

    TelegramMessageSenderServiceProvider(Config.Scope config) {
        this.config = config;
        bot = new TelegramBot(config.get("token"));
    }

    @Override
    public void sendSmsMessage(TokenCodeType type, String phone, String code, int expires) {


        String chatId = config.get("chatId");
        String token = config.get("token");

        logger.info("ChatID: " + chatId + " Token "  + token);

        logger.info("sendSmsMessage: Type - " + type + " Phone - " + phone + " Code - " + code);

        String Message = String.format("Ваш код подтверждения (%s): %s", phone, code);

        try {
            bot.sendMessage(config.get("chatId"), Message);
        } catch (IOException | InterruptedException e) {
            logger.error(String.format("Ошибка отправки сообщения telegram: %s", e.getMessage()));
            e.printStackTrace();

        }

    }

    @Override
    public void close() {

    }
}
