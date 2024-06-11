package com.socialapppro.form;

import lombok.Data;

@Data
public class UserPasswordForm {
    private String id;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
    private String limit;
    private String ename;
    private String pnumber;
}
