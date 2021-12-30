KEYCLOAK_BIN=/home/bia/soft/keycloak/bin
JAR=/home/bia/projects/IdeaProjects/keycloak-sms-provider/build/keycloak-sms-provider.jar

TELEGRAM_JAR=/home/bia/projects/IdeaProjects/keycloak-sms-provider/build/keycloak-sms-provider-telegram.jar

mvn package

$KEYCLOAK_BIN/jboss-cli.sh --command="module remove --name=com.qontrol.keycloak.sms"
$KEYCLOAK_BIN/jboss-cli.sh --command="module add --name=com.qontrol.keycloak.sms --resources=${JAR} --dependencies=org.keycloak.keycloak-core,org.keycloak.keycloak-services,org.keycloak.keycloak-model-jpa,org.keycloak.keycloak-server-spi,org.keycloak.keycloak-server-spi-private,javax.ws.rs.api,javax.persistence.api,org.hibernate,org.javassist,org.liquibase,org.jboss.logging"


$KEYCLOAK_BIN/jboss-cli.sh --command="module remove --name=com.qontrol.keycloak.sms.sender.telegram"
$KEYCLOAK_BIN/jboss-cli.sh --command="module add --name=com.qontrol.keycloak.sms.sender.telegram--resources=${TELEGRAM_JAR} --dependencies=org.keycloak.keycloak-core,org.keycloak.keycloak-server-spi,org.jboss.logging,com.qontrol.keycloak.sms"

$KEYCLOAK_BIN/standalone.sh



