package com.std.forum.dto.res;

public class XN610320Res {

    XN610320Res() {
    }

    public XN610320Res(String code, String takeAddress) {
        this.code = code;
        this.takeAddress = takeAddress;
    }

    // 编号
    private String code;

    // 取货地址
    private String takeAddress;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTakeAddress() {
        return takeAddress;
    }

    public void setTakeAddress(String takeAddress) {
        this.takeAddress = takeAddress;
    }
}
