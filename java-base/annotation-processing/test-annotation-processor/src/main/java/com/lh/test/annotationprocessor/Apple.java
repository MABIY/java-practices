package com.lh.test.annotationprocessor;

import com.fasterxml.jackson.annotation.JsonView;
import com.lh.annotation.AutoValueDTO;
import com.lh.annotation.Views;
import lombok.Data;

/**
 *
 * @author lh
 */
@AutoValueDTO
@Data
public class Apple {

    public interface B{}
    public interface Update extends B{}

    @JsonView(value = Views.NEW.class)
    private int age;

    @JsonView(value = Views.NEW.class)
    private String color;

    @JsonView(value = Views.Value.class)
    private boolean ripe;


    @JsonView(value = Update.class)
    private String update;
}
