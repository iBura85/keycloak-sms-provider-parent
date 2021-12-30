package com.qontrol.keycloak.sms.providers.spi;

import org.jboss.logging.Logger;
import org.keycloak.provider.Provider;
import org.keycloak.provider.ProviderFactory;
import org.keycloak.provider.Spi;

public class PhoneMessageServiceSpi implements Spi {

    private static final Logger logger = Logger.getLogger(PhoneMessageServiceSpi.class);

    @Override
    public boolean isInternal() {
        logger.warn("isInternal");
        return false;
    }

    @Override
    public String getName() {
        logger.warn("getName");
        return "phoneMessageService";
    }

    @Override
    public Class<? extends Provider> getProviderClass() {
        logger.warn("getProviderClass");
        return PhoneMessageService.class;
    }

    @Override
    public Class<? extends ProviderFactory> getProviderFactoryClass() {
        logger.warn("getProviderFactoryClass");
        return PhoneMessageServiceProviderFactory.class;
    }
}
