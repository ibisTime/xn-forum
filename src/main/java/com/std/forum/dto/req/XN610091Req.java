package com.std.forum.dto.req;

/** 
 * 修改关键词
 * @author: zuixian 
 * @since: 2016年9月28日 下午1:47:14 
 * @history:
 */
public class XN610091Req {

    // 关键词编号 （必填）
    private String code;

    // 关键词 （必填）
    private String word;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
