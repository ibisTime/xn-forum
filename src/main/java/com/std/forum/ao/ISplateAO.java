package com.std.forum.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Splate;
import com.std.forum.dto.req.XN610040Req;
import com.std.forum.dto.req.XN610042Req;

@Component
public interface ISplateAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addSplate(XN610040Req req);

    public int dropSplate(String code);

    public int editSplate(XN610042Req req);

    public Paginable<Splate> querySplatePage(int start, int limit,
            Splate condition);

    public List<Splate> querySplateList(Splate condition);

    public Splate getSplate(String code);

}
