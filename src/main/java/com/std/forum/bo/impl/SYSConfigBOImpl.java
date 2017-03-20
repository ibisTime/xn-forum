package com.std.forum.bo.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.ISYSConfigBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.dao.ISYSConfigDAO;
import com.std.forum.domain.SYSConfig;

/**
 * 
 * @author: Gejin 
 * @since: 2016年4月17日 下午7:56:03 
 * @history:
 */

@Component
public class SYSConfigBOImpl extends PaginableBOImpl<SYSConfig> implements
        ISYSConfigBO {
    @Autowired
    private ISYSConfigDAO sysConfigDAO;

    @Override
    public boolean isSYSConfigExist(Long Id) {
        SYSConfig sysConfig = new SYSConfig();
        sysConfig.setId(Id);
        if (sysConfigDAO.selectTotalCount(sysConfig) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public int saveSYSConfig(SYSConfig data) {
        int count = 0;
        if (data != null) {
            data.setId(data.getId());
            data.setUpdateDatetime(new Date());
            count = sysConfigDAO.insert(data);
        }
        return count;
    }

    @Override
    public int refreshSYSConfig(SYSConfig data) {
        int count = 0;
        if (data != null) {
            data.setUpdateDatetime(new Date());
            count = sysConfigDAO.updateValue(data);
        }
        return count;
    }

    @Override
    public SYSConfig getConfig(Long id) {
        SYSConfig sysConfig = null;
        if (id != null) {
            SYSConfig condition = new SYSConfig();
            condition.setId(id);
            sysConfig = sysConfigDAO.select(condition);
        }
        return sysConfig;
    }

    /** 
     * @see com.xnjr.base.bo.ISYSConfigBO#getConfigValue(java.lang.String)
     */
    @Override
    public SYSConfig getConfigValue(String ckey) {
        SYSConfig result = null;
        if (ckey != null) {
            SYSConfig condition = new SYSConfig();
            condition.setCkey(ckey);
            result = sysConfigDAO.select(condition);
        }
        return result;
    }
}
