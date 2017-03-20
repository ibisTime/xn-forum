package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.Splate;

public interface ISplateBO extends IPaginableBO<Splate> {

    public boolean isSplateExist(String code);

    public String saveSplate(String name, String parentCode, String pic,
            String orderNo, String userId, String companyCode, String status,
            String updater, String remark);

    public int removeSplate(String code);

    public int refreshSplate(String code, String name, String parentCode,
            String pic, String orderNo, String userId, String companyCode,
            String status, String updater, String remark);

    public List<Splate> querySplateList(Splate condition);

    public Splate getSplate(String code);

}
