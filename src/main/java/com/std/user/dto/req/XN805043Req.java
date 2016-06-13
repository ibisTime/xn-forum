package com.std.user.dto.req;

public class XN805043Req {
    // 登陆名（必填）
    private String loginName;

    // 登陆密码（必填）
    private String loginPwd;

    // 类型（选填）
    private String kind;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}
