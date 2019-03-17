package com.zarembski.dziennik.service;

import com.zarembski.dziennik.api.ApiRequestFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService<T> {

    @Autowired
    ApiRequestFactory<T> apiRequestFactory;
}
