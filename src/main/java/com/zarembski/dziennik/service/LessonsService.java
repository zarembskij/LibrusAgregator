package com.zarembski.dziennik.service;

import com.zarembski.dziennik.model.lesson.Lessons;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LessonsService extends BaseService{

    public static final String ENDPOINT = "Lessons";

    public String getLessons() {
        Lessons lessons = apiRequestFactory.invoke(ENDPOINT).readEntity(Lessons.class);
        List<String> list = lessons.getLessons().stream().map(l ->
                apiRequestFactory.invokeFullPath(l.getSubject().getUrl()).readEntity(String.class)).collect(Collectors.toList());

        return list.toString();
    }
}