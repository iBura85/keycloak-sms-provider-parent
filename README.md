В файле `keycloak/standalone/configuration/` в секции providers установить провайдер `module:com.qontrol.keycloak.phone`

```xml
<subsystem xmlns="urn:jboss:domain:keycloak-server:1.1">
    <providers>
        <provider>module:com.qontrol.keycloak.sms</provider>
        <provider>module:com.qontrol.keycloak.sms.sender.telegram</provider>
    </providers>
</subsystem>
```

```xml
<spi name="phoneMessageService">
    <provider name="default" enabled="true">
        <properties>
            <property name="service" value="telegram"/>
            <property name="tokenExpiresIn" value="60"/>
        </properties>
    </provider>
</spi>
```

```xml
<spi name="messageSenderService">
    <provider name="telegram" enabled="true">
        <properties>
            <property name="token" value="1330853441:AAGudvxb6LGAosP8BeJNTbS1vIUcR8WKX3g"/>
            <property name="chatId" value="248614760"/>
        </properties>
    </provider>
</spi>
```

Для перезапуска сервера `./rebuild.sh`

`http://localhost:8080/auth/realms/master/sms/authentication-code`