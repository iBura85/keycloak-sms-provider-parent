FROM quay.io/keycloak/keycloak:latest

WORKDIR /tmp

COPY build/keycloak-sms-provider.jar .
COPY build/keycloak-sms-provider-telegram.jar .

COPY cli/module-add.cli cli/

RUN $JBOSS_HOME/bin/jboss-cli.sh --file=cli/module-add.cli
#RUN rm -rf $JBOSS_HOME/standalone/configuration/standalone_xml_history/current