package com.lh.annotationprocessor.value;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lh.annotation.Views;
import com.lh.annotationprocessor.UserAccount;
import jakarta.validation.constraints.NotNull;
import java.lang.Long;
import java.lang.String;
import lombok.Data;

@Data
public class UserAccountNew {
  @NotNull(
      groups = {
          Views.New.class,
          Views.Simple.class
      }
  )
  private String phone;

  protected Long createdBy;

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

  @NotNull(
      groups = {
          Views.New.class,
          Views.Simple.class
      }
  )
  private String name;

  @NotNull(
      groups = Views.New.class,
      message = "用户名不能为空"
  )
  private String accountName;

  public UserAccountNew create() {
    UserAccountNew entity = new UserAccountNew();
    entity.setPhone(phone);
    entity.setCreatedBy(createdBy);
    entity.setPassword(password);
    entity.setName(name);
    entity.setAccountName(accountName);
    return entity;
  }

  public UserAccountNew assign(UserAccountNew entity) {
    entity.setPhone(phone);
    entity.setCreatedBy(createdBy);
    entity.setPassword(password);
    entity.setName(name);
    entity.setAccountName(accountName);
    return entity;
  }

  public UserAccountNew patch(UserAccountNew entity) {
    if (phone != null ) {
      entity.setPhone(phone);
    }
    if (createdBy != null ) {
      entity.setCreatedBy(createdBy);
    }
    if (password != null ) {
      entity.setPassword(password);
    }
    if (name != null ) {
      entity.setName(name);
    }
    if (accountName != null ) {
      entity.setAccountName(accountName);
    }
    return entity;
  }
}
