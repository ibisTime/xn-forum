package com.std.forum.dto.req;

/** 
 * 分页查询关键字
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:47:44 
 * @history:
 */
public class XN610100Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 关键词 （必填）
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
