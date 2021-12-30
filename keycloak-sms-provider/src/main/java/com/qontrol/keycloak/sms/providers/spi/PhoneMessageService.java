package com.qontrol.keycloak.sms.providers.spi;

import com.qontrol.keycloak.sms.providers.constants.TokenCodeType;
import org.keycloak.provider.Provider;

public interface PhoneMessageService extends Provider {

    //TODO on key longin support
    //boolean Verification(String phoneNumber, String token);

    int sendTokenCode(String phoneNumber, TokenCodeType type);
}
