package com.zarembski.dziennik.service;

import org.springframework.stereotype.Service;

import javax.ws.rs.core.GenericType;

@Service
public class LuckyNumberService extends BaseService {

    public static final String ENDPOINT = "LuckyNumbers";

    public String getLuckyNumber() {
        return apiRequestFactory.invoke(ENDPOINT).readEntity(new GenericType<String>() {});
    }
}
