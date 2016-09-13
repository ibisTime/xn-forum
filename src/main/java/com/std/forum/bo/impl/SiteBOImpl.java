/**
 * @Title SiteBOImpl.java 
 * @Package com.std.forum.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午1:26:58 
 * @version V1.0   
 */
package com.std.forum.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.ISiteBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.dao.ISiteDAO;
import com.std.forum.domain.Site;
import com.std.forum.enums.EPrefixCode;
import com.std.forum.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午1:26:58 
 * @history:
 */
@Component
public class SiteBOImpl extends PaginableBOImpl<Site> implements ISiteBO {
    @Autowired
    private ISiteDAO siteDAO;

    /** 
     * @see com.std.forum.bo.ISiteBO#isExistSite(java.lang.String)
     */
    @Override
    public void isExistSite(String name) {
        Site condition = new Site();
        condition.setName(name);
        long count = siteDAO.selectTotalCount(condition);
        if (count > 0) {
            throw new BizException("xn000000", "该站点名称已存在");
        }
    }

    /** 
     * @see com.std.forum.bo.ISiteBO#saveSite(com.std.forum.domain.Site)
     */
    @Override
    public String saveSite(Site data) {
        String code = null;
        if (data != null) {
            code = EPrefixCode.SITE.getCode();
            data.setCode(code);
            data.setUpdateDatetime(new Date());
            siteDAO.insert(data);
        }
        return code;
    }

    /** 
     * @see com.std.forum.bo.ISiteBO#refreshSite(com.std.forum.domain.Site)
     */
    @Override
    public int refreshSite(Site data) {
        int count = 0;
        if (data != null && data.getCode() != null) {
            data.setUpdateDatetime(new Date());
            count = siteDAO.update(data);
        }
        return count;
    }

    /** 
     * @see com.std.forum.bo.ISiteBO#getSite(java.lang.String)
     */
    @Override
    public Site getSite(String code) {
        Site result = null;
        if (StringUtils.isNotBlank(code)) {
            Site condition = new Site();
            condition.setCode(code);
            result = siteDAO.select(condition);
        }
        return result;
    }

    /** 
     * @see com.std.forum.bo.ISiteBO#querySiteList(com.std.forum.domain.Site)
     */
    @Override
    public List<Site> querySiteList(Site condition) {
        return siteDAO.selectList(condition);
    }
}
