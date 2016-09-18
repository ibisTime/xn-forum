package com.std.forum.api.converter;

import com.std.forum.domain.Site;
import com.std.forum.dto.req.XN610000Req;
import com.std.forum.dto.req.XN610002Req;
import com.std.forum.dto.req.XN610010Req;
import com.std.forum.dto.req.XN610011Req;
import com.std.forum.dto.req.XN610012Req;

public class SiteConverter {
    // 新增站点
    public static Site converter(XN610000Req req) {
        Site result = new Site();
        result.setName(req.getName());
        result.setLongitude(req.getLongitude());
        result.setLatitude(req.getLatitude());
        result.setUserId(req.getUserId());
        result.setPriority(req.getPriority());
        result.setDomain(req.getDomain());
        result.setLogo(req.getLogo());
        result.setAddress(req.getAddress());
        result.setTelephone(req.getTelephone());
        result.setDescription(req.getDescription());
        result.setEmail(req.getEmail());
        result.setQrCode(req.getQrCode());
        result.setRemark(req.getRemark());
        return result;
    }

    // 修改站点信息
    public static Site converter(XN610002Req req) {
        Site result = new Site();
        result.setCode(req.getCode());
        result.setName(req.getName());
        result.setLongitude(req.getLongitude());
        result.setLatitude(req.getLatitude());
        result.setUserId(req.getUserId());
        result.setPriority(req.getPriority());
        result.setDomain(req.getDomain());
        result.setLogo(req.getLogo());
        result.setAddress(req.getAddress());
        result.setTelephone(req.getTelephone());
        result.setDescription(req.getDescription());
        result.setEmail(req.getEmail());
        result.setQrCode(req.getQrCode());
        result.setRemark(req.getRemark());
        return result;
    }

    // 分页查询站点信息
    public static Site converter(XN610010Req req) {
        Site result = new Site();
        result.setNameForQuery(req.getName());
        result.setUserId(req.getUserId());
        result.setPriority(req.getPriority());
        result.setIsDefault(req.getIsDefault());
        return result;
    }

    // 列表查询站点信息
    public static Site converter(XN610011Req req) {
        Site result = new Site();
        result.setCode(req.getCode());
        result.setNameForQuery(req.getName());
        result.setUserId(req.getUserId());
        result.setPriority(req.getPriority());
        result.setIsDefault(req.getIsDefault());
        return result;
    }

    // 经纬度查询站点
    public static Site converter(XN610012Req req) {
        Site result = new Site();
        result.setLongitude(req.getLongitude());
        result.setLatitude(req.getLatitude());
        return result;
    }
}
