package com.lh.annotationprocessor.value;

import java.lang.Integer;
import java.lang.String;
import lombok.Data;

@Data
public class BarDetail {
  String name;

  String foo;

  private Integer a;

  private String k;

  public BarDetail create() {
    BarDetail entity = new BarDetail();
    entity.setName(name);
    entity.setFoo(foo);
    entity.setA(a);
    entity.setK(k);
    return entity;
  }

  public BarDetail assign(BarDetail entity) {
    entity.setName(name);
    entity.setFoo(foo);
    entity.setA(a);
    entity.setK(k);
    return entity;
  }

  public BarDetail patch(BarDetail entity) {
    if (name != null ) {
      entity.setName(name);
    }
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
