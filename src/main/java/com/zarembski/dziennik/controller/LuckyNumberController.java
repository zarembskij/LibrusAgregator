package com.zarembski.dziennik.controller;

import com.zarembski.dziennik.service.LuckyNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LuckyNumberController {

    @Autowired
    LuckyNumberService luckyNumberService;

    @RequestMapping("/luckynumber")
    public String index() {
        return luckyNumberService.getLuckyNumber();
    }
}
