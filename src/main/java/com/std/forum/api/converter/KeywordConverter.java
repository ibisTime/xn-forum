/**
 * @Title KeywordConverter.java 
 * @Package com.std.forum.api.converter 
 * @Description 
 * @author xieyj  
 * @date 2016年10月10日 下午11:33:27 
 * @version V1.0   
 */
package com.std.forum.api.converter;

import com.std.forum.core.StringValidater;
import com.std.forum.domain.Keyword;
import com.std.forum.dto.req.XN610000Req;
import com.std.forum.dto.req.XN610002Req;
import com.std.forum.dto.req.XN610010Req;

/** 
 * @author: xieyj 
 * @since: 2016年10月10日 下午11:33:27 
 * @history:
 */
public class KeywordConverter {

    // 新增关键字
    public static Keyword converter(XN610000Req req) {
        Keyword result = new Keyword();
        result.setWord(req.getWord());
        result.setWeight(StringValidater.toDouble(req.getWeight()));
        result.setLevel(req.getLevel());
        result.setReaction(req.getReaction());
        result.setUpdater(req.getUpdater());
        result.setRemark(req.getRemark());
        return result;
    }

    // 修改关键字信息
    public static Keyword converter(XN610002Req req) {
        Keyword result = new Keyword();
        result.setCode(req.getCode());
        result.setWord(req.getWord());
        result.setWeight(StringValidater.toDouble(req.getWeight()));
        result.setLevel(req.getLevel());
        result.setReaction(req.getReaction());
        result.setUpdater(req.getUpdater());
        result.setRemark(req.getRemark());
        return result;
    }

    // 分页查询关键字信息
    public static Keyword converter(XN610010Req req) {
        Keyword result = new Keyword();
        result.setWordForQuery(req.getWord());
        result.setLevel(req.getLevel());
        return result;
    }
}
