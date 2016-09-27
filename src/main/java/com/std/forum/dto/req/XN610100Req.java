package com.std.forum.dto.req;

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
