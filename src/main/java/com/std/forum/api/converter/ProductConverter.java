package com.std.forum.api.converter;

import com.std.forum.core.StringValidater;
import com.std.forum.domain.ProdOrder;
import com.std.forum.domain.Product;
import com.std.forum.dto.req.XN610300Req;
import com.std.forum.dto.req.XN610302Req;
import com.std.forum.dto.req.XN610310Req;
import com.std.forum.dto.req.XN610320Req;
import com.std.forum.dto.req.XN610321Req;

public class ProductConverter {

    // 新增产品
    public static Product converter(XN610300Req req) {
        Product result = new Product();
        result.setName(req.getName());
        result.setKind(req.getKind());
        result.setPic(req.getPic());
        result.setDescription(req.getDescription());
        result.setStatus(req.getStatus());
        result.setPrice(StringValidater.toInteger(req.getPrice()));
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
        result.setStatus(req.getStatus());
        result.setPrice(StringValidater.toInteger(req.getPrice()));
        result.setSiteCode(req.getSiteCode());
        return result;
    }

    // 分页查询产品
    public static Product converter(XN610310Req req) {
        Product result = new Product();
        result.setName(req.getName());
        result.setKind(req.getKind());
        result.setStatus(req.getStatus());
        return result;
    }

    // 兑换产品
    public static ProdOrder converter(XN610320Req req) {
        ProdOrder result = new ProdOrder();
        result.setPayer(req.getUserId());
        result.setProductCode(req.getProductCode());
        result.setQuantity(StringValidater.toInteger(req.getQuantity()));
        return result;
    }

    // 确认提货
    public static ProdOrder converter(XN610321Req req) {
        ProdOrder result = new ProdOrder();
        result.setCode(req.getOrderCode());
        result.setTaker(req.getTaker());
        result.setRemark(req.getTakeNote());
        return result;
    }
}
