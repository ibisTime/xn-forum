package com.std.forum.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.BplateTemplate;

@Component
public interface IBplateTemplateAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addBplateTemplate(String name, String orderNo, String updater);

    public int dropBplateTemplate(String code);

    public int editBplateTemplate(String code, String name, String orderNo,
            String updater);

    public Paginable<BplateTemplate> queryBplateTemplatePage(int start,
            int limit, BplateTemplate condition);

    public List<BplateTemplate> queryBplateTemplateList(BplateTemplate condition);

    public BplateTemplate getBplateTemplate(String code);

}
