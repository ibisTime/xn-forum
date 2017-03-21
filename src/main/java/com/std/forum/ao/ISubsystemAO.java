package com.std.forum.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Subsystem;

@Component
public interface ISubsystemAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addSubsystem(Subsystem data);

    public int dropSubsystem(String code);

    public int editSubsystem(Subsystem data);

    public Paginable<Subsystem> querySubsystemPage(int start, int limit,
            Subsystem condition);

    public List<Subsystem> querySubsystemList(Subsystem condition);

    public Subsystem getSubsystem(String code);

}
