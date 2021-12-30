package com.qontrol.keycloak.sms.providers.rest;

import com.qontrol.keycloak.sms.providers.constants.TokenCodeType;
import org.keycloak.models.KeycloakSession;

import javax.ws.rs.Path;

public class SmsResource {
    private final KeycloakSession session;

    public SmsResource(KeycloakSession session) {
        this.session = session;
    }

    @Path("authentication-code")
    public TokenCodeResource getAuthenticationCodeResource() {
        return new TokenCodeResource(session, TokenCodeType.OTP);
    }
}
