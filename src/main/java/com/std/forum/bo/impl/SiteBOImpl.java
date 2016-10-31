package com.std.forum.bo.impl;

import org.springframework.stereotype.Component;

import com.std.forum.bo.ISiteBO;
import com.std.forum.dto.res.XN806010Res;
import com.std.forum.http.BizConnecter;
import com.std.forum.http.JsonUtils;

/**
 * @author: xieyj 
 * @since: 2016年5月30日 上午9:28:30 
 * @history:
 */
@Component
public class SiteBOImpl implements ISiteBO {

    /** 
     * @see com.xnjr.mall.bo.IUserBO#getRemoteUser(java.lang.String)
     */
    @Override
    public XN806010Res getCompany(String companyCode) {
        return BizConnecter.getBizData("806010",
            JsonUtils.string2Json("code", companyCode), XN806010Res.class);
    }
}
