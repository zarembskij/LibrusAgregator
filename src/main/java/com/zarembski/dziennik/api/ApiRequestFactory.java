package com.zarembski.dziennik.api;

import org.glassfish.jersey.client.ClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Component
public class ApiRequestFactory {

    @Autowired
    ApiAccessFactory apiAccessFactory;

    public static final String URL = "https://api.librus.pl/2.0/";

    public String invoke(String endpoint) {
        Client client = ClientBuilder.newClient(new ClientConfig());

        return client.target(URL + endpoint)
                .request(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiAccessFactory.getAuthToken())
                .get()
                .readEntity(String.class);
    }
}
