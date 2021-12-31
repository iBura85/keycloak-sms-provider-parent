package com.qontrol.keycloak.sms.providers.rest;

import com.qontrol.keycloak.sms.providers.constants.TokenCodeType;
import com.qontrol.keycloak.sms.providers.exceptions.MessageSendException;
import com.qontrol.keycloak.sms.providers.spi.PhoneMessageService;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.keycloak.models.KeycloakSession;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;

public class TokenCodeResource {

    private static final Logger logger = Logger.getLogger(TokenCodeResource.class);
    protected final KeycloakSession session;
    protected final TokenCodeType tokenCodeType;

    TokenCodeResource(KeycloakSession session, TokenCodeType tokenCodeType) {
        this.session = session;
        this.tokenCodeType = tokenCodeType;
    }

    @GET
    @NoCache
    @Path("")
    @Produces(APPLICATION_JSON)
    public Response getTokenCode(@QueryParam("phone") String phone) throws MessageSendException {

        if (phone == null) throw new BadRequestException("Необходимо указать номер телефона");

        int tokenExpiresIn  = session.getProvider(PhoneMessageService.class).sendTokenCode(phone, tokenCodeType);


        String response = String.format("{\"expires_in\":%s}",  tokenExpiresIn);

        return Response.ok(response, APPLICATION_JSON_TYPE).build();
    }

}
