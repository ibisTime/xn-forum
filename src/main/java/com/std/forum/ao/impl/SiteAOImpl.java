/**
 * @Title SiteAOImpl.java 
 * @Package com.std.forum.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午2:03:31 
 * @version V1.0   
 */
package com.std.forum.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.ISiteAO;
import com.std.forum.bo.ISiteBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Site;
import com.std.forum.enums.EBoolean;
import com.std.forum.util.PinYin;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午2:03:31 
 * @history:
 */
@Service
public class SiteAOImpl implements ISiteAO {
    @Autowired
    protected ISiteBO siteBO;

    /** 
     * @see com.std.forum.ao.ISiteAO#addSite(com.std.forum.domain.Site)
     */
    @Override
    public String addSite(Site data) {
        siteBO.isExistSite(null, data.getName());
        return siteBO.saveSite(data);
    }

    /** 
     * @see com.std.forum.ao.ISiteAO#editSite(com.std.forum.domain.Site)
     */
    @Override
    public int editSite(Site data) {
        siteBO.isExistSite(data.getCode(), data.getName());
        return siteBO.refreshSite(data);
    }

    /** 
     * @see com.std.forum.ao.ISiteAO#querySitePage(int, int, com.std.forum.domain.Site)
     */
    @Override
    public Paginable<Site> querySitePage(int start, int limit, Site condition) {
        return siteBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.std.forum.ao.ISiteAO#querySiteList(com.std.forum.domain.Site)
     */
    @Override
    public List<Site> querySiteList(Site condition) {
        List<Site> list = siteBO.querySiteList(condition);
        // 将结果按首字母排序
        return sortByFirstLetter(list);
    }

    // 将结果按首字母排序
    private List<Site> sortByFirstLetter(List<Site> list) {
        List<Site> result = new ArrayList<>();
        // 用来记录result的长度
        int i = 0;
        // 用来判断该元素是否已添加
        boolean isAdd = false;
        // 遍历待排序数组
        for (Site site : list) {
            isAdd = false;
            if (i == 0) {
                result.add(site);
                i++;
            } else {
                // 遍历已排序数组
                for (int j = 0; j < i; j++) {
                    // 若待排序元素的首字母小于其元素，则将待排序元素插入到其位置
                    if (PinYin.cn2py(site.getName()).charAt(0) < PinYin.cn2py(
                        result.get(j).getName()).charAt(0)) {
                        result.add(j, site);
                        isAdd = true;
                        i++;
                        break;
                    }
                }
                if (!isAdd) {
                    result.add(site);
                }
            }
        }
        return result;
    }

    @Override
    public int editSiteDef(String code) {
        return siteBO.refreshSiteDef(code);
    }

    @Override
    public int editSitePri(String code) {
        return siteBO.refreshSitePri(code);
    }

    @Override
    public Site getSiteByJW(Site condition) {
        Site condition1 = new Site();
        List<Site> list = siteBO.querySiteList(condition1);
        // 设置查询默认站点条件
        Site defaultCondition = new Site();
        defaultCondition.setIsDefault(EBoolean.YES.getCode());
        List<Site> defaultSitelist = siteBO.querySiteList(defaultCondition);
        // 获取默认站点
        Site defaultSite = defaultSitelist.get(0);
        // 若经纬度为空，则返回默认站点
        if (condition.getLongitude() == null
                || condition.getLongitude().equalsIgnoreCase("")
                || condition.getLatitude() == null
                || condition.getLatitude().equalsIgnoreCase("")) {
            return defaultSite;
        }
        double lo = Double.valueOf(condition.getLongitude());
        double la = Double.valueOf(condition.getLatitude());
        for (Site site : list) {
            String[] los = site.getLongitude().split("-");
            String[] las = site.getLatitude().split("-");
            if (los.length > 1 && las.length > 1) {
                double lo1 = Double.valueOf(los[0]);
                double lo2 = Double.valueOf(los[1]);
                double la1 = Double.valueOf(las[0]);
                double la2 = Double.valueOf(las[1]);
                if (lo >= lo1 && lo <= lo2 && la >= la1 && la <= la2) {
                    return site;
                }
            }
        }
        // 若查询不到符合站点，则返回默认站点
        return defaultSite;
    }

    @Override
    public Site getSite(String code) {
        return siteBO.getSite(code);
    }
}
