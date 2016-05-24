package com.std.user.ao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.std.user.ao.ISYSMenuRoleAO;
import com.std.user.bo.ISYSMenuBO;
import com.std.user.bo.ISYSMenuRoleBO;
import com.std.user.bo.ISYSRoleBO;
import com.std.user.domain.SYSMenu;
import com.std.user.domain.SYSMenuRole;
import com.std.user.exception.BizException;

@Service
public class SYSMenuRoleAOImpl implements ISYSMenuRoleAO {

    @Autowired
    ISYSMenuRoleBO sysMenuRoleBO;

    @Autowired
    ISYSMenuBO sysMenuBO;

    @Autowired
    ISYSRoleBO sysRoleBO;

    /** 
     * @see com.std.user.ao.ISYSMenuRoleAO#addSYSMenuRole(com.xnjr.std.security.domain.SYSMenuRole)
     */
    @Override
    @Transactional
    public int addSYSMenuRole(SYSMenuRole data) {
        int count = 0;
        if (!sysRoleBO.isSYSRoleExist(data.getRoleCode())) {
            throw new BizException("lh0000", "角色编号不存在！");
        }
        // 删除角色所关联的菜单
        sysMenuRoleBO.removeSYSMenuList(data.getRoleCode());
        // 重新分配角色菜单
        if (CollectionUtils.isNotEmpty(data.getMenuCodeList())) {
            for (String sysMenuCode : data.getMenuCodeList()) {
                if (!sysMenuBO.isSYSMenuExist(sysMenuCode)) {
                    throw new BizException("lh0000", "菜单编号不存在！");
                }
                SYSMenuRole sysMenuRole = new SYSMenuRole();
                sysMenuRole.setMenuCode(sysMenuCode);
                sysMenuRole.setRoleCode(data.getRoleCode());
                sysMenuRole.setUpdater(data.getUpdater());
                sysMenuRole.setUpdateDatetime(new Date());
                sysMenuRole.setRemark(data.getRemark());
                count += sysMenuRoleBO.saveSYSMenuRole(sysMenuRole);
            }
        }
        return count;
    }

    /**
     * @see com.std.user.ao.ISYSMenuRoleAO#dropSYSMenuList(java.lang.String)
     */
    @Override
    public int dropSYSMenuList(String roleCode) {
        if (!sysRoleBO.isSYSRoleExist(roleCode)) {
            throw new BizException("lh0000", "角色编号不存在！");
        }
        return sysMenuRoleBO.removeSYSMenuList(roleCode);
    }

    /**
     * @see com.std.user.ao.ISYSMenuRoleAO#querySYSMenuList(com.xnjr.std.security.domain.SYSMenuRole)
     */
    @Override
    public List<SYSMenu> querySYSMenuList(SYSMenuRole data) {
        return sysMenuRoleBO.querySYSMenuList(data);
    }

    /** 
     * @see com.std.user.ao.ISYSMenuRoleAO#querySYSMenuListByTopCode(java.lang.String, java.lang.String)
     */
    @Override
    public List<SYSMenu> querySYSMenuListByTopCode(String roleCode,
            String parentCode, String type) {
        List<SYSMenu> resultList = new ArrayList<SYSMenu>();
        SYSMenuRole condition = new SYSMenuRole();
        condition.setRoleCode(roleCode);
        condition.setParentCode(parentCode);
        condition.setType(type);
        List<SYSMenu> list = sysMenuRoleBO.querySYSMenuList(condition);
        for (SYSMenu sysMenu : list) {
            SYSMenuRole childMenuRole = new SYSMenuRole();
            childMenuRole.setRoleCode(roleCode);
            childMenuRole.setParentCode(sysMenu.getCode());
            childMenuRole.setType(type);
            resultList.addAll(sysMenuRoleBO.querySYSMenuList(childMenuRole));
        }
        return resultList;
    }
}
