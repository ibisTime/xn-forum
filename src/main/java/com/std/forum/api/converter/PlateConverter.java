package com.std.forum.api.converter;

import com.std.forum.domain.Plate;
import com.std.forum.dto.req.XN610040Req;
import com.std.forum.dto.req.XN610041Req;
import com.std.forum.dto.req.XN610045Req;
import com.std.forum.dto.req.XN610046Req;

public class PlateConverter {

    // 新增板块
    public static Plate converter(XN610040Req req) {
        Plate result = new Plate();
        result.setName(req.getName());
        result.setPic(req.getPic());
        result.setSiteCode(req.getSiteCode());
        result.setUpdater(req.getUpdater());
        result.setRemark(req.getRemark());
        return result;
    }

    // 修改板块
    public static Plate converter(XN610041Req req) {
        Plate result = new Plate();
        result.setCode(req.getCode());
        result.setName(req.getName());
        result.setPic(req.getPic());
        result.setSiteCode(req.getSiteCode());
        result.setUpdater(req.getUpdater());
        result.setRemark(req.getRemark());
        return result;
    }

    // 分页查询板块
    public static Plate converter(XN610045Req req) {
        Plate result = new Plate();
        result.setNameForQuery(req.getName());
        result.setSiteCode(req.getSiteCode());
        return result;
    }

    // 列表查询板块
    public static Plate converter(XN610046Req req) {
        Plate result = new Plate();
        result.setNameForQuery(req.getName());
        result.setSiteCode(req.getSiteCode());
        return result;
    }
}
