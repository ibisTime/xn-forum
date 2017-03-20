package com.std.forum.dto.req;

/**
 * 分页查询小板块模板
 * @author: asus 
 * @since: 2017年3月20日 下午6:13:58 
 * @history:
 */
public class XN610035Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 名称
    private String name;

    // 状态
    private String parentCode;

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

}
