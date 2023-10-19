package com.lh.annotationprocessor.value;

import com.lh.annotation.Views;
import jakarta.validation.constraints.NotNull;
import java.lang.String;
import lombok.Data;

@Data
public class UserAccountSimple {
  @NotNull(
      groups = {
          Views.New.class,
          Views.Simple.class
      }
  )
  private String phone;

  @NotNull(
      groups = {
          Views.New.class,
          Views.Simple.class
      }
  )
  private String name;

  public UserAccountSimple create() {
    UserAccountSimple entity = new UserAccountSimple();
    entity.setPhone(phone);
    entity.setName(name);
    return entity;
  }

  public UserAccountSimple assign(UserAccountSimple entity) {
    entity.setPhone(phone);
    entity.setName(name);
    return entity;
  }

  public UserAccountSimple patch(UserAccountSimple entity) {
    if (phone != null ) {
      entity.setPhone(phone);
    }
    if (name != null ) {
      entity.setName(name);
    }
    return entity;
  }
}
