package com.std.forum.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.IMenuAO;
import com.std.forum.bo.IMenuBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Menu;
import com.std.forum.dto.req.XN610080Req;
import com.std.forum.dto.req.XN610081Req;
import com.std.forum.enums.EBelong;
import com.std.forum.enums.EBoolean;
import com.std.forum.exception.BizException;

@Service
public class MenuAOImpl implements IMenuAO {

    @Autowired
    private IMenuBO menuBO;

    @Override
    public void editMenuByGlobal(XN610080Req req) {
        if (!EBelong.getBelongMap().containsKey(req.getBelong())) {
            throw new BizException("xn0000", "属于不允许自定义");
        }
        Menu menu = menuBO.getMenu(req.getCode());
        if (EBelong.GLOBAL.getCode().equals(menu.getBelong())
                || EBelong.LOCAL.getCode().equals(menu.getBelong())) {
            menuBO.refreshMenuByGlobal(req.getCode(), req.getName(),
                req.getPic(), req.getOrderNo(), req.getBelong(),
                req.getRemark());
        } else {
            throw new BizException("xn0000", "地方性菜单，不可修改");
        }
    }

    @Override
    public void editMenuByLocal(XN610081Req req) {
        Menu menu = menuBO.getMenu(req.getCode());
        if (EBelong.LOCAL.getCode().equals(menu.getBelong())) {
            menuBO.saveMenu(req.getName(), req.getPic(), req.getOrderNo(),
                req.getCode(), req.getCompanyCode(), req.getRemark());
        } else if (EBelong.GLOBAL.getCode().equals(menu.getBelong())) {
            throw new BizException("xn0000", "总部菜单，地方不可修改");
        } else {
            menuBO.refreshMenuByLocal(req.getCode(), req.getName(),
                req.getPic(), req.getOrderNo(), req.getRemark());
        }
    }

    @Override
    public Paginable<Menu> queryMenuPage(int start, int limit, Menu condition) {
        return menuBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Menu> queryMenuList(String companyCode) {
        List<Menu> resultList = new ArrayList<Menu>();
        // 本地的List
        List<Menu> localList = menuBO.queryMenuList(companyCode);
        List<Menu> menuList = menuBO.queryMenuList(EBoolean.NO.getCode());

        for (Menu menu : menuList) {
            if (CollectionUtils.isNotEmpty(localList)) {
                for (Menu local : localList) {
                    // 本地菜单的上级是全局的
                    if (local.getBelong().equals(menu.getCode())
                            && EBelong.GLOBAL.getCode().equalsIgnoreCase(
                                menu.getBelong())) {
                        resultList.add(menu);
                    }
                    // 本地菜单的上级是可配的
                    if (local.getBelong().equals(menu.getCode())
                            && EBelong.LOCAL.getCode().equalsIgnoreCase(
                                menu.getBelong())) {
                        resultList.add(local);
                    }
                }
            }
        }
        for (Menu result : resultList) {
            for (Menu menu : menuList) {
                if (result.getCode().equals(menu.getCode())) {
                    menuList.remove(menu);
                    break;
                }
            }
        }
        resultList.addAll(menuList);
        return resultList;
    }

    @Override
    public Menu getMenu(String code) {
        return menuBO.getMenu(code);
    }

}
