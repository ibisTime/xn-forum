package com.std.forum.bo.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.ICategoryBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
import com.std.forum.dao.ICategoryDAO;
import com.std.forum.domain.Category;
import com.std.forum.enums.EBoolean;
import com.std.forum.enums.ECategoryType;
import com.std.forum.enums.EPrefixCode;
import com.std.forum.exception.BizException;

/**
 * @author: xieyj 
 * @since: 2016年11月17日 上午8:32:03 
 * @history:
 */
@Component
public class CategoryBOImpl extends PaginableBOImpl<Category> implements
        ICategoryBO {

    @Autowired
    private ICategoryDAO categoryDAO;

    @Override
    public boolean isCategoryExist(String code) {
        Category condition = new Category();
        condition.setCode(code);
        if (categoryDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveCategory(Category data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateME(EPrefixCode.CATEGORY.getCode());
            data.setCode(code);
            categoryDAO.insert(data);
        }
        return code;
    }

    @Override
    public Map<String, String> saveDefaultCategory(List<Category> list,
            String companyCode) {
        Map<String, String> resultMap = new HashMap<String, String>();
        for (Category category : list) {
            Category data = new Category();
            data.setParentCode(category.getParentCode());
            data.setType(category.getType());
            data.setName(category.getName());
            data.setPic(category.getPic());
            data.setOrderNo(category.getOrderNo());
            data.setBelong(null);
            data.setCompanyCode(companyCode);
            String newCode = saveCategory(data);
            resultMap.put(category.getCode(), newCode);
        }
        return resultMap;
    }

    @Override
    public int removeCategory(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Category data = new Category();
            data.setCode(code);
            count = categoryDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshCategory(Category data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = categoryDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Category> queryCategoryList(Category condition) {
        return categoryDAO.selectList(condition);
    }

    @Override
    public Category getCategory(String code) {
        Category data = null;
        if (StringUtils.isNotBlank(code)) {
            Category condition = new Category();
            condition.setCode(code);
            data = categoryDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "该分类编号不存在");
            }
        }
        return data;
    }

    @Override
    public List<Category> queryCategoryList() {
        Category condition = new Category();
        condition.setType(ECategoryType.PLATE.getCode());
        condition.setBelong(EBoolean.YES.getCode());
        condition.setCompanyCode(EBoolean.NO.getCode());
        return categoryDAO.selectList(condition);
    }
}
