/**
 * @Title SiteBOImpl.java 
 * @Package com.std.forum.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午1:26:58 
 * @version V1.0   
 */
package com.std.forum.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.ISiteBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
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
    public void isExistSite(String code, String name) {
        boolean resultFlag = false;
        Site condition = new Site();
        condition.setName(name);
        List<Site> siteList = siteDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(siteList)) {
            if (StringUtils.isBlank(code)) {
                resultFlag = true;
            } else {
                Site site = siteList.get(0);
                if (!code.equals(site.getCode())) {
                    resultFlag = true;
                }
            }
        }
        if (resultFlag == true) {
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
            code = OrderNoGenerater.generate(EPrefixCode.SITE.getCode());
            data.setIsDefault("0");
            data.setCode(code);
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

    @Override
    public int refreshSiteDef(String code) {
        Site data = new Site();
        int count = 0;
        if (code != null && code != "") {
            data.setCode(code);
            // 先找出默认的站点
            Site site1 = new Site();
            site1.setIsDefault("1");
            Site condition = siteDAO.select(site1);
            // 若原本就有默认站点
            if (condition != null) {
                // 如果默认站点与目的站点相同，则将取消其默认
                // 如果不相同，则取消默认站点的默认，将目的站点设置为默认
                if (condition.getCode().equals(data.getCode())) {
                    data.setIsDefault("0");
                    count = siteDAO.updateDef(data);
                } else {
                    condition.setIsDefault("0");
                    siteDAO.updateDef(condition);
                    data.setIsDefault("1");
                    count = siteDAO.updateDef(data);
                }
            } else {
                // 若原本无默认站点，则直接将目的站点设置为默认
                data.setIsDefault("1");
                count = siteDAO.updateDef(data);
            }
            // 效果：至多只有一个默认站点
        }
        return count;
    }

    @Override
    public int refreshSitePri(String code) {
        Site data = new Site();
        int count = 0;
        if (code != null && code != "") {
            data.setCode(code);
            data.setPriority("0");
            count = siteDAO.updatePri(data);
        }
        return count;
    }
}
