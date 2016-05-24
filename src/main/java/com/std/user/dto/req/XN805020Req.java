package com.std.user.dto.req;

/**
 * 分页查询角色
 * @author: xieyj 
 * @since: 2016年5月16日 下午9:49:45 
 * @history:
 */
public class XN805020Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 角色名称(选填)
    private String name;

    // 角色等级(选填)
    private String level;

    // 更新人(选填)
    private String updater;

    // 六方(选填)
    private String kind;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

}
