package com.std.forum.api.converter;

import com.std.forum.domain.Rule;
import com.std.forum.dto.req.XN610110Req;
import com.std.forum.dto.req.XN610120Req;

/**
 * 规则
 * @author: xieyj 
 * @since: 2016年10月11日 上午9:38:07 
 * @history:
 */
public class RuleConverter {

    // 修改规则
    public static Rule converter(XN610110Req req) {
        Rule result = new Rule();
        result.setCode(req.getCode());
        result.setKind(req.getKind());
        result.setType(req.getType());
        result.setLevel(req.getLevel());
        result.setValue(req.getValue());
        result.setUpdater(req.getUpdater());
        result.setRemark(req.getRemark());
        return result;
    }

    // 分页查询关键字信息
    public static Rule converter(XN610120Req req) {
        Rule result = new Rule();
        result.setKind(req.getKind());
        result.setType(req.getType());
        result.setLevel(req.getLevel());
        return result;
    }
}
