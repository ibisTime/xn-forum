package com.std.forum.api.converter;

import com.std.forum.domain.Post;
import com.std.forum.dto.req.XN610050Req;
import com.std.forum.dto.req.XN610053Req;

public class PostConverter {

    // 发布帖子
    public static Post converter(XN610050Req req) {
        Post result = new Post();
        result.setTitle(req.getTitle());
        result.setContent(req.getContent());
        result.setPic(req.getPic());
        result.setPlateCode(req.getPlateCode());
        result.setPublisher(req.getPublisher());
        return result;
    }

    // 设置帖子
    public static Post converter(XN610053Req req) {
        Post result = new Post();
        result.setCode(req.getCode());
        result.setIsHeadline(req.getIsHeadline());
        result.setIsTop(req.getIsTop());
        result.setIsEssence(req.getIsEssence());
        return result;
    }
}
