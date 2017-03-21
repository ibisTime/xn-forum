package com.std.forum.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Bplate;

@Component
public interface IBplateAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBplate(String name, String status, String orderNo,
            String companyCode, String updater);

    public int dropBplate(String code);

    public int editBplate(String code, String name, String status,
            String orderNo, String companyCode, String updater);

    public Paginable<Bplate> queryBplatePage(int start, int limit,
            Bplate condition);

    public List<Bplate> queryBplateList(Bplate condition);

    public Bplate getBplate(String code);

}
