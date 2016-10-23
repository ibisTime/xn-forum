package com.std.forum.api.converter;

import com.std.forum.core.StringValidater;
import com.std.forum.domain.Product;
import com.std.forum.dto.req.XN610300Req;
import com.std.forum.dto.req.XN610302Req;
import com.std.forum.dto.req.XN610310Req;

public class ProductConverter {

    // 新增产品
    public static Product converter(XN610300Req req) {
        Product result = new Product();
        result.setName(req.getName());
        result.setKind(req.getKind());
        result.setPic(req.getPic());
        result.setDescription(req.getDescription());
        result.setQuantity(StringValidater.toInteger(req.getQuantity()));
        result.setSiteCode(req.getSiteCode());
        return result;
    }

    // 修改产品
    public static Product converter(XN610302Req req) {
        Product result = new Product();
        result.setCode(req.getCode());
        result.setName(req.getName());
        result.setKind(req.getKind());
        result.setPic(req.getPic());
        result.setDescription(req.getDescription());
        result.setQuantity(StringValidater.toInteger(req.getQuantity()));
        result.setSiteCode(req.getSiteCode());
        return result;
    }

    // 分页查询产品
    public static Product converter(XN610310Req req) {
        Product result = new Product();
        result.setName(req.getName());
        result.setKind(req.getKind());
        result.setStatus(req.getStatus());
        result.setSiteCode(req.getSiteCode());
        return result;
    }
}
