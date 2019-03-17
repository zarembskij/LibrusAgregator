package com.zarembski.dziennik.controller;

import com.zarembski.dziennik.service.LessonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LessonsController {

    @Autowired
    LessonsService lessonsService;

    @RequestMapping("/lessons")
    public String index() {
        return lessonsService.getLessons();
    }
}
