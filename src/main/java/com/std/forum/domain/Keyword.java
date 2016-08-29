package com.std.forum.domain;

import com.std.forum.dao.base.ABaseDO;

/**
 * 关键词过滤
 * @author: xieyj 
 * @since: 2016年8月29日 下午1:11:17 
 * @history:
 */
public class Keyword extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 关键词
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
