package com.std.forum.api.converter;

import com.std.forum.domain.Plate;
import com.std.forum.dto.req.XN610020Req;
import com.std.forum.dto.req.XN610021Req;
import com.std.forum.dto.req.XN610030Req;

public class PlateConverter {

    // 新增板块
    public static Plate converter(XN610020Req req) {
        Plate result = new Plate();
        result.setName(req.getName());
        result.setKind(req.getKind());
        result.setLocation(req.getLocation());
        result.setOrderNo(req.getOrderNo());
        result.setPic(req.getPic());
        result.setUserId(req.getUserId());
        result.setSiteCode(req.getSiteCode());
        result.setStatus(req.getStatus());
        result.setUpdater(req.getUpdater());
        result.setRemark(req.getRemark());
        return result;
    }

    // 修改板块
    public static Plate converter(XN610021Req req) {
        Plate result = new Plate();
        result.setCode(req.getCode());
        result.setName(req.getName());
        result.setKind(req.getKind());
        result.setLocation(req.getLocation());
        result.setOrderNo(req.getOrderNo());
        result.setPic(req.getPic());
        result.setUserId(req.getUserId());
        result.setStatus(req.getStatus());
        result.setUpdater(req.getUpdater());
        result.setRemark(req.getRemark());
        return result;
    }

    // 分页查询板块
    public static Plate converter(XN610030Req req) {
        Plate result = new Plate();
        result.setNameForQuery(req.getName());
        result.setKind(req.getKind());
        result.setLocation(req.getLocation());
        result.setStatus(req.getStatus());
        result.setSiteCode(req.getSiteCode());
        return result;
    }
}
