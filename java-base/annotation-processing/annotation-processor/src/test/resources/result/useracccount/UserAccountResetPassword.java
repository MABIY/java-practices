package com.lh.annotationprocessor.value;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lh.annotation.Views;
import com.lh.annotationprocessor.UserAccount;
import jakarta.validation.constraints.NotNull;
import java.lang.String;
import lombok.Data;

@Data
public class UserAccountResetPassword {
  @NotNull(
      groups = {
          Views.New.class,
          UserAccount.ResetPassword.class
      }
  )
  @JsonProperty(
      access = JsonProperty.Access.WRITE_ONLY
  )
  private String password;

  public UserAccountResetPassword create() {
    UserAccountResetPassword entity = new UserAccountResetPassword();
    entity.setPassword(password);
    return entity;
  }

  public UserAccountResetPassword assign(UserAccountResetPassword entity) {
    entity.setPassword(password);
    return entity;
  }

  public UserAccountResetPassword patch(UserAccountResetPassword entity) {
    if (password != null ) {
      entity.setPassword(password);
    }
    return entity;
  }
}
