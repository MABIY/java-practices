package com.lh.annotationprocessor;

import com.fasterxml.jackson.annotation.JsonView;
import com.lh.annotation.AutoValueDTO;
import com.lh.annotation.Views;

import java.util.List;



@AutoValueDTO
public class Bar extends C<Integer,String> {
    @JsonView(Views.Summary.class)
    String foo;

    @JsonView(Views.Detail.class)
    String name;

    public String getName() {
        return name;
    }

    public Bar setName(String name) {
        this.name = name;
        return this;
    }

    public String getFoo() {
        return foo;
    }

    public void setFoo(String value) {
        this.foo = value;
    }
}

class C<T,F> {
    @JsonView(Views.Summary.class)
    private   T a;

    @JsonView(Views.Summary.class)
    private   F k;
    public T getA() {
        return a;
    }

    public C<T,F> setA(T a) {
        this.a = a;
        return this;
    }

    public F getK() {
        return k;
    }

    public C<T, F> setK(F k) {
        this.k = k;
        return this;
    }
}
