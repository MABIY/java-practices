package com.lh.test.annotationprocessor.value;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class PersonNEW {
  @JsonIgnore
  private int age;

  public PersonNEW create() {
    PersonNEW entity = new PersonNEW();
    entity.setAge(age);
    return entity;
  }

  public PersonNEW assign(PersonNEW entity) {
    entity.setAge(age);
    return entity;
  }

  public PersonNEW patch(PersonNEW entity) {
    entity.setAge(age);
    return entity;
  }
}