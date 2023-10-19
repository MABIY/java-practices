package com.lh.annotationprocessor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.lh.annotation.AutoValueDTO;
import com.lh.annotation.Views;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * @author lh
 * createTime: 2023-03-24
 */

@Data
@Entity
@Accessors(chain = true)
@AutoValueDTO
@EqualsAndHashCode(callSuper = true)
public class UserAccount extends Audited{
    public interface ResetPassword {};
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45)
    @JsonView({Views.New.class})
    @NotNull(groups ={Views.New.class},message = "用户名不能为空")
    private String accountName;

    @Column(length = 100)
    @JsonView({Views.New.class, ResetPassword.class})
    @NotNull(groups ={Views.New.class, ResetPassword.class})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(length = 45)
    @JsonView({Views.New.class,Views.Simple.class})
    @NotNull(groups = {Views.New.class,Views.Simple.class})
    private String name;

    @Column(length = 45)
    @JsonView({Views.New.class,Views.Simple.class})
    @NotNull(groups = {Views.New.class,Views.Simple.class})
    private String phone;

    private boolean enabled =true;

    @Column(length = 45)
    private String email;
}

