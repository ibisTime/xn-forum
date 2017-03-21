package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.Bplate;

public interface IBplateBO extends IPaginableBO<Bplate> {

    public boolean isBplateExist(String code);

    public String saveBplate(String name, String status, String orderNo,
            String companyCode, String updater);

    public int removeBplate(String code);

    public int refreshBplate(String code, String name, String status,
            String orderNo, String companyCode, String updater);

    public List<Bplate> queryBplateList(Bplate condition);

    public Bplate getBplate(String code);

}
