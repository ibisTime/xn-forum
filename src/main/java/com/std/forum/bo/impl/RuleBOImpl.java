package com.std.forum.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.std.forum.bo.IRuleBO;
import com.std.forum.domain.Rule;
import com.std.forum.dto.req.XN807726Req;
import com.std.forum.enums.ERuleKind;
import com.std.forum.enums.ERuleType;
import com.std.forum.http.BizConnecter;
import com.std.forum.http.JsonUtils;

@Component
public class RuleBOImpl implements IRuleBO {

    @Override
    public Long getAmountByRule(ERuleKind kind, ERuleType type, String level) {
        Long amount = 0L;
        XN807726Req req = new XN807726Req();
        req.setKind(kind.getCode());
        req.setType(type.getCode());
        req.setLevel(level);
        String jsonStr = BizConnecter.getBizData("807726",
            JsonUtils.object2Json(req));
        Gson gson = new Gson();
        List<Rule> ruleList = gson.fromJson(jsonStr,
            new TypeToken<List<Rule>>() {
            }.getType());
        if (!CollectionUtils.sizeIsEmpty(ruleList)) {
            Rule rule = ruleList.get(0);
            amount = Long.valueOf(rule.getValue());
        }
        return amount;
    }
}
