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
<spi name="messageSenderService">
<provider name="Telegram" enabled="true">
    <properties>
<!--        <property name="accountSid" value="YOUR_ACCOUNT_SID_HERE"/>-->
<!--        <property name="authToken" value="YOUR_AUTH_TOKEN_HERE"/>-->
<!--        <property name="twilioPhoneNumber" value="YOUR_PURCHASED_TWILIO_NUMBER"/>-->
    </properties>
</provider>
</spi>
```

Для перезапуска сервера `./rebuild.sh`

`http://localhost:8080/auth/realms/master/sms/authentication-code`