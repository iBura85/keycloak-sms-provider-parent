package com.qontrol.keycloak.sms.providers.spi;

import com.qontrol.keycloak.sms.providers.constants.TokenCodeType;
import com.qontrol.keycloak.sms.providers.exceptions.MessageSendException;
import org.keycloak.provider.Provider;

public interface PhoneMessageService extends Provider {
    int sendTokenCode(String phoneNumber, TokenCodeType type) throws MessageSendException;
}
