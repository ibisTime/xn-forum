package com.std.forum.api.converter;

import com.std.forum.domain.Navigate;
import com.std.forum.dto.req.XN610020Req;
import com.std.forum.dto.req.XN610022Req;
import com.std.forum.dto.req.XN610030Req;
import com.std.forum.dto.req.XN610031Req;

public class NavigateConverter {
    // 新增导航
    public static Navigate converter(XN610020Req req) {
        Navigate result = new Navigate();
        result.setUrl(req.getUrl());
        result.setPic(req.getPic());
        result.setTitle(req.getTitle());
        result.setOrderNo(Integer.valueOf(req.getOrderNo()));
        result.setStatus(req.getStatus());
        result.setType(req.getType());
        result.setIsGlobal(req.getIsGlobal());
        result.setParentCode(req.getParentCode());
        result.setSiteCode(req.getUserId());
        result.setRemark(req.getRemark());
        return result;
    }

    // 修改导航信息
    public static Navigate converter(XN610022Req req) {
        Navigate result = new Navigate();
        result.setCode(req.getCode());
        result.setUrl(req.getUrl());
        result.setPic(req.getPic());
        result.setTitle(req.getTitle());
        result.setOrderNo(Integer.valueOf(req.getOrderNo()));
        result.setStatus(req.getStatus());
        result.setType(req.getType());
        result.setParentCode(req.getParentCode());
        result.setRemark(req.getRemark());
        return result;
    }

    // 分页查询导航信息
    public static Navigate converter(XN610030Req req) {
        Navigate result = new Navigate();
        result.setTitleForQuery(req.getTitle());
        result.setStatus(req.getStatus());
        result.setType(req.getType());
        result.setIsGlobal(req.getIsGlobal());
        result.setParentCode(req.getParentCode());
        result.setSiteCode(req.getSiteCode());
        result.setIsDqNavigate(req.getIsDqNavigate());
        return result;
    }

    // 列表查询导航信息
    public static Navigate converter(XN610031Req req) {
        Navigate result = new Navigate();
        result.setCode(req.getCode());
        result.setTitleForQuery(req.getTitle());
        result.setStatus(req.getStatus());
        result.setType(req.getType());
        result.setIsGlobal(req.getIsGlobal());
        result.setParentCode(req.getParentCode());
        result.setSiteCode(req.getSiteCode());
        result.setIsDqNavigate(req.getIsDqNavigate());
        return result;
    }
}
