package com.std.forum.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.IMenuBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
import com.std.forum.dao.IMenuDAO;
import com.std.forum.domain.Menu;
import com.std.forum.enums.EPrefixCode;
import com.std.forum.exception.BizException;

@Component
public class MenuBOImpl extends PaginableBOImpl<Menu> implements IMenuBO {

    @Autowired
    private IMenuDAO menuDAO;

    @Override
    public boolean isMenuExist(String code) {
        Menu condition = new Menu();
        condition.setCode(code);
        if (menuDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveMenu(Menu data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateME(EPrefixCode.MENU.getCode());
            data.setCode(code);
            menuDAO.insert(data);
        }
        return code;
    }

    @Override
    public int removeMenu(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Menu data = new Menu();
            data.setCode(code);
            count = menuDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshMenu(Menu data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = menuDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Menu> queryMenuList(Menu condition) {
        return menuDAO.selectList(condition);
    }

    @Override
    public Menu getMenu(String code) {
        Menu data = null;
        if (StringUtils.isNotBlank(code)) {
            Menu condition = new Menu();
            condition.setCode(code);
            data = menuDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }
}
