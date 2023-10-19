package com.lh.annotationprocessor.value;

import java.lang.Long;
import lombok.Data;

@Data
public class UserAccountValue {
  protected Long createdBy;

  public UserAccountValue create() {
    UserAccountValue entity = new UserAccountValue();
    entity.setCreatedBy(createdBy);
    return entity;
  }

  public UserAccountValue assign(UserAccountValue entity) {
    entity.setCreatedBy(createdBy);
    return entity;
  }

  public UserAccountValue patch(UserAccountValue entity) {
    if (createdBy != null ) {
      entity.setCreatedBy(createdBy);
    }
    return entity;
  }
}
