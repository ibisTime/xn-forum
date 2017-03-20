package com.std.forum.dto.req;

/**
 * 分页查询大板块模板
 * @author: asus 
 * @since: 2017年3月20日 下午5:18:42 
 * @history:
 */
public class XN610015Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
