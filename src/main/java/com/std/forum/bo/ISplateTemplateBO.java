package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.SplateTemplate;

public interface ISplateTemplateBO extends IPaginableBO<SplateTemplate> {

    public boolean isSplateTemplateExist(String code);

    public String saveSplateTemplate(String name, String parentCode,
            String pic, String orderNo, String updater);

    public int removeSplateTemplate(String code);

    public int refreshSplateTemplate(String code, String name,
            String parentCode, String pic, String orderNo, String updater);

    public List<SplateTemplate> querySplateTemplateList(SplateTemplate condition);

    public SplateTemplate getSplateTemplate(String code);

}
