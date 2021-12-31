package com.qontrol.keycloak.sms.providers.sender;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class TelegramBot {

    private final String token;

    TelegramBot(String t) {
        token = t;
    }

    public void sendMessage(String chatId, String text) throws IOException, InterruptedException {



        String u = String.format("https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s", token, chatId, URLEncoder.encode(text, StandardCharsets.UTF_8));

        // create a client
        var client = HttpClient.newHttpClient();

        // create a request
        var request = HttpRequest.newBuilder(
                URI.create(u)
        ).build();

        // use the client to send the request
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        response.statusCode();
    }
}
