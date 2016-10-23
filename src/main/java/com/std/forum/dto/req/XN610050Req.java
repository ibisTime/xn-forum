package com.std.forum.dto.req;

public class XN610050Req {

    // 帖子编号（必填）
    private String code;

    // 板块编号（必填）
    private String plateCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(String plateCode) {
        this.plateCode = plateCode;
    }
}
