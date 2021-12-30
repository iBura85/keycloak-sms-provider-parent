package com.qontrol.keycloak.sms.providers.spi;

import com.qontrol.keycloak.sms.providers.constants.TokenCodeType;
import com.qontrol.keycloak.sms.providers.exceptions.MessageSendException;
import org.keycloak.provider.Provider;

/**
 * SMS, Voice, APP
 */
public interface MessageSenderService extends Provider {

    //void sendVoiceMessage((TokenCodeType type, String realmName, String realmDisplayName, String phoneNumber, String code , int expires) throws MessageSendException;


    void sendSmsMessage(TokenCodeType type, String phone, String code , int expires) throws MessageSendException;
}