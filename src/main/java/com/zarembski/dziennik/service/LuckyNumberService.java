package com.zarembski.dziennik.service;

import com.zarembski.dziennik.api.ApiRequestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LuckyNumberService {

    @Autowired
    ApiRequestFactory apiRequestFactory;

    public static final String ENDPOINT = "LuckyNumbers";

    public String getLuckyNumber() {
        return apiRequestFactory.invoke(ENDPOINT);
    }
}
