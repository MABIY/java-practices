package com.lh.annotationprocessor.value;

import java.lang.Integer;
import java.lang.String;
import lombok.Data;

@Data
public class BarSummary {
  String foo;

  private Integer a;

  private String k;

  public BarSummary create() {
    BarSummary entity = new BarSummary();
    entity.setFoo(foo);
    entity.setA(a);
    entity.setK(k);
    return entity;
  }

  public BarSummary assign(BarSummary entity) {
    entity.setFoo(foo);
    entity.setA(a);
    entity.setK(k);
    return entity;
  }

  public BarSummary patch(BarSummary entity) {
    if (foo != null ) {
      entity.setFoo(foo);
    }
    if (a != null ) {
      entity.setA(a);
    }
    if (k != null ) {
      entity.setK(k);
    }
    return entity;
  }
}
