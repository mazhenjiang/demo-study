package com.demo.study.gateway.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @description: 账户VOl类
 * @author: Aaron Ma
 **/



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VOAccount implements Serializable {

    @JsonProperty("id")
    private String id;
    @JsonProperty("account_name")
    private String accountName;
    @JsonProperty("account_pwd")
    private String accountPwd;
    @NotNull
    @Size(min = 11)
    @JsonProperty("tel")
    private String tel;
    @JsonProperty("verification_code")
    private String verificationCode;
    @JsonProperty("type")
    private String type;
}
