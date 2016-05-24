package com.std.user.dto.req;

public class XN805001Req {
    // 菜单名称(选填)
    private String name;

    // 类型(选填)
    private String type;

    // 父菜单编号(选填)
    private String parentCode;

    // 更新人(选填)
    private String updater;

    // 六方(选填)
    private String kind;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}
