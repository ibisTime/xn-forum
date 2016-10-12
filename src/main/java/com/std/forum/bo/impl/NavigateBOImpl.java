package com.std.forum.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.INavigateBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
import com.std.forum.dao.INavigateDAO;
import com.std.forum.domain.Navigate;
import com.std.forum.enums.EBoolean;
import com.std.forum.enums.EPrefixCode;
import com.std.forum.exception.BizException;

/** 
 * @author: zuixian 
 * @since: 2016年9月14日 上午10:57:31 
 * @history:
 */
@Component
public class NavigateBOImpl extends PaginableBOImpl<Navigate> implements
        INavigateBO {

    @Autowired
    private INavigateDAO navigateDAO;

    @Override
    public void isExistNavigate(String code, String name, String siteCode) {
        boolean resultFlag = false;
        Navigate condition = new Navigate();
        condition.setName(name);
        condition.setSiteCode(siteCode);
        List<Navigate> navigateList = navigateDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(navigateList)) {
            if (StringUtils.isBlank(code)) {
                resultFlag = true;
            } else {
                Navigate navigate = navigateList.get(0);
                if (!code.equals(navigate.getCode())) {
                    resultFlag = true;
                }
            }
        }
        if (resultFlag == true) {
            throw new BizException("xn000000", "该导航名称已存在");
        }
    }

    @Override
    public Navigate getNavigate(String code) {
        Navigate result = null;
        if (StringUtils.isNotBlank(code)) {
            Navigate condition = new Navigate();
            condition.setCode(code);
            result = navigateDAO.select(condition);
        }
        return result;
    }

    @Override
    public String saveNavigate(Navigate data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EPrefixCode.NAVIGATE.getCode());
            data.setCode(code);
            if (data.getIsGlobal().equals(EBoolean.YES.getCode())) {
                data.setSiteCode(EBoolean.NO.getCode());
            }
            navigateDAO.insert(data);
        }
        return code;
    }

    @Override
    public int refreshNavigate(Navigate data) {
        int count = 0;
        if (data != null && data.getCode() != null) {
            count = navigateDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Navigate> queryNavigateList(Navigate condition) {
        return navigateDAO.selectList(condition);
    }

    @Override
    public int deleteNavigate(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Navigate data = new Navigate();
            data.setCode(code);
            count = navigateDAO.delete(data);
        }
        return count;
    }

}
