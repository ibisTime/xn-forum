package com.std.forum.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.SplateTemplate;

@Component
public interface ISplateTemplateAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addSplateTemplate(String name, String parentCode, String pic,
            String orderNo, String updater);

    public int dropSplateTemplate(String code);

    public int editSplateTemplate(String code, String name, String parentCode,
            String pic, String orderNo, String updater);

    public Paginable<SplateTemplate> querySplateTemplatePage(int start,
            int limit, SplateTemplate condition);

    public List<SplateTemplate> querySplateTemplateList(SplateTemplate condition);

    public SplateTemplate getSplateTemplate(String code);

}
