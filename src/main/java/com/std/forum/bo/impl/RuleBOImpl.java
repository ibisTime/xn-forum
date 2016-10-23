package com.std.forum.bo.impl;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.std.forum.bo.IRuleBO;
import com.std.forum.domain.Rule;
import com.std.forum.http.BizConnecter;
import com.std.forum.http.JsonUtils;

@Component
public class RuleBOImpl implements IRuleBO {

    @Override
    public Long getJBTimesByUserId(String userId) {
        Long times = 0L;
        String jsonStr = BizConnecter.getBizData("807728",
            JsonUtils.string2Json("userId", userId));
        Gson gson = new Gson();
        Rule rule = gson.fromJson(jsonStr, new TypeToken<Rule>() {
        }.getType());
        if (rule != null) {
            times = Long.valueOf(rule.getValue());
        }
        return times;
    }
}
