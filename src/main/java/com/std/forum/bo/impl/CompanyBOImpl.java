package com.std.forum.bo.impl;

import org.springframework.stereotype.Component;

import com.std.forum.bo.ICompanyBO;
import com.std.forum.domain.Company;
import com.std.forum.exception.BizException;
import com.std.forum.http.BizConnecter;
import com.std.forum.http.JsonUtils;

@Component
public class CompanyBOImpl implements ICompanyBO {

    @Override
    public Company getCompany(String companyCode) {
        Company res = BizConnecter.getBizData("806010",
            JsonUtils.string2Json("companyCode", companyCode), Company.class);
        if (res == null) {
            throw new BizException("XN000000", "公司不存在");
        }
        return res;
    }
}
