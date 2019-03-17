package com.zarembski.dziennik.model.lesson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zarembski.dziennik.model.Subject;
import com.zarembski.dziennik.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Lesson implements Serializable {
    @JsonProperty("Id")
    String id;
    @JsonProperty("Teacher")
    Teacher teacher;
    @JsonProperty("Subject")
    Subject subject;
}