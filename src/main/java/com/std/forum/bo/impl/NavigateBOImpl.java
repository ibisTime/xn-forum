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
import com.std.forum.dao.ISiteDAO;
import com.std.forum.domain.Navigate;
import com.std.forum.domain.Site;
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

    @Autowired
    private ISiteDAO siteDAO;

    @Override
    public void isExistNavigate(String code, String title, String siteCode) {
        boolean resultFlag = false;
        Navigate condition = new Navigate();
        condition.setTitle(title);
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
            throw new BizException("xn000000", "该导航标题已存在");
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
            if (data.getIsGlobal().equals("0")) {
                Site site = new Site();
                site.setUserId(data.getSiteCode());
                Site result = siteDAO.select(site);
                if (result != null) {
                    data.setSiteCode(result.getCode());
                } else {
                    throw new BizException("xn000000", "该用户无负责站点");
                }
            } else {
                data.setSiteCode("0");
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
        Navigate data = new Navigate();
        int count = 0;
        if (code != null && code != "") {
            data.setCode(code);
            count = navigateDAO.delete(data);
        }
        return count;
    }

}
