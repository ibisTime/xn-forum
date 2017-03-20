package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.BplateTemplate;

public interface IBplateTemplateBO extends IPaginableBO<BplateTemplate> {

    public boolean isBplateTemplateExist(String code);

    public String saveBplateTemplate(String name, String orderNo, String updater);

    public int removeBplateTemplate(String code);

    public int refreshBplateTemplate(String code, String name, String orderNo,
            String updater);

    public List<BplateTemplate> queryBplateTemplateList(BplateTemplate condition);

    public BplateTemplate getBplateTemplate(String code);

}
