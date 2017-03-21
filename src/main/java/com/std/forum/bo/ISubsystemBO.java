package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.Subsystem;

public interface ISubsystemBO extends IPaginableBO<Subsystem> {

    public boolean isSubsystemExist(String code);

    public String saveSubsystem(String name, String url, String pic,
            String location, String orderNo, String companyCode, String remark);

    public int removeSubsystem(String code);

    public int refreshSubsystem(String code, String name, String url,
            String pic, String location, String orderNo, String companyCode,
            String remark);

    public List<Subsystem> querySubsystemList(Subsystem condition);

    public List<Subsystem> querySubsystemList(String companyCode);

    public Subsystem getSubsystem(String code);

}
