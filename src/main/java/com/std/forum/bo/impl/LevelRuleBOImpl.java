package com.std.forum.bo.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.std.forum.bo.ILevelRuleBO;
import com.std.forum.domain.LevelRule;
import com.std.forum.dto.req.XN805114Req;
import com.std.forum.http.BizConnecter;
import com.std.forum.http.JsonUtils;

@Component
public class LevelRuleBOImpl implements ILevelRuleBO {

    @Override
    public LevelRule getLevelRule(String code) {
        LevelRule data = null;
        if (StringUtils.isNotBlank(code)) {
            XN805114Req req = new XN805114Req();
            req.setCode(code);
            String jsonStr = BizConnecter.getBizData("805114",
                JsonUtils.object2Json(req));
            Gson gson = new Gson();
            data = gson.fromJson(jsonStr, new TypeToken<LevelRule>() {
            }.getType());
        }
        return data;
    }
}
