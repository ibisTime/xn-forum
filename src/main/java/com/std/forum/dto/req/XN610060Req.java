package com.std.forum.dto.req;

/** 
 *  每查看帖子一次，增加一次阅读量，不针对用户
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:44:53 
 * @history:
 */
public class XN610060Req {

    // 帖子编号 （必填）
    private String postCode;

    // 阅读者 （必填）
    private String reader;

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }
}
