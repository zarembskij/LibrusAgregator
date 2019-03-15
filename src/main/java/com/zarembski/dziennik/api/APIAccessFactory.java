package com.zarembski.dziennik.api;

import lombok.RequiredArgsConstructor;
import org.glassfish.jersey.client.ClientConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Component
@RequiredArgsConstructor
@PropertySource("classpath:config.properties")
public class APIAccessFactory {

    private final String host = "https://api.librus.pl/OAuth/Token";
    private final String token = "Mjg6ODRmZGQzYTg3YjAzZDNlYTZmZmU3NzdiNThiMzMyYjE=";

    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    Logger logger = LoggerFactory.getLogger(APIAccessFactory.class);

    private LibrusAuthToken librusAuthToken;

    private void refreshToken() {
        Client client = ClientBuilder.newClient(new ClientConfig());

        librusAuthToken = client.target(host)
                .request(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Basic " + token)
                .post(Entity.form(getRequestBody()))
                .readEntity(LibrusAuthToken.class);
        client.close();
    }

    private String refreshAuthTokenAndGet() {
        refreshToken();
        return librusAuthToken.accessToken;
    }

    private Form getRequestBody() {
        return new Form()
                .param("username", username)
                .param("password", password)
                .param("librus_long_term_token", "1")
                .param("grant_type", "password");
    }

    public String getAuthToken() {
        logger.info("Get " + (librusAuthToken == null ? "new" : "existing") + " AUTH token");
        return librusAuthToken == null ? refreshAuthTokenAndGet() : librusAuthToken.accessToken;
    }
}
