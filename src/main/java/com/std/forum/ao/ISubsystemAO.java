package com.std.forum.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Subsystem;
import com.std.forum.dto.req.XN610090Req;
import com.std.forum.dto.req.XN610091Req;

@Component
public interface ISubsystemAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public void editSubsystemByGlobal(XN610090Req req);

    public void editSubsystemByLocal(XN610091Req req);

    public Paginable<Subsystem> querySubsystemPage(int start, int limit,
            Subsystem condition);

    public List<Subsystem> querySubsystemList(String companyCode);

    public Subsystem getSubsystem(String code);

}
