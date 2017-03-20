package com.std.forum.dto.req;

/**
 * @author: xieyj 
 * @since: 2016年9月17日 下午4:09:39 
 * @history:
 */
public class XN615915Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // key值(选填)
    private String ckey;

    public String getCkey() {
        return ckey;
    }

    public void setCkey(String ckey) {
        this.ckey = ckey;
    }
}
