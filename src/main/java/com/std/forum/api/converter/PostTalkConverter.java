package com.std.forum.api.converter;

import com.std.forum.domain.PostTalk;
import com.std.forum.dto.req.XN610056Req;
import com.std.forum.dto.req.XN610059Req;

public class PostTalkConverter {

    // 进行【点赞/收藏】操作或取消【点赞/收藏】操作
    public static PostTalk converter(XN610056Req req) {
        PostTalk result = new PostTalk();
        result.setType(req.getType());
        result.setPostCode(req.getPostCode());
        result.setTalker(req.getTalker());
        return result;
    }

    // 打赏帖子
    public static PostTalk converter(XN610059Req req) {
        PostTalk result = new PostTalk();
        result.setPostCode(req.getPostCode());
        result.setAmount(Integer.valueOf(req.getAmount()));
        result.setTalker(req.getTalker());
        return result;
    }
}
