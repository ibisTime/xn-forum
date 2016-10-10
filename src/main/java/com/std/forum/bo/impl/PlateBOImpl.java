/**
 * @Title PlateBOImpl.java 
 * @Package com.std.forum.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午1:28:00 
 * @version V1.0   
 */
package com.std.forum.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.IPlateBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
import com.std.forum.dao.IPlateDAO;
import com.std.forum.domain.Plate;
import com.std.forum.enums.EPrefixCode;
import com.std.forum.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午1:28:00 
 * @history:
 */
@Component
public class PlateBOImpl extends PaginableBOImpl<Plate> implements IPlateBO {

    @Autowired
    private IPlateDAO plateDAO;

    /** 
     * @see com.std.forum.bo.IPlateBO#isExistPlate(java.lang.String)
     */
    @Override
    public void isExistPlateName(String code, String name, String siteCode) {
        boolean resultFlag = false;
        Plate condition = new Plate();
        condition.setName(name);
        condition.setSiteCode(siteCode);
        List<Plate> plateList = plateDAO.selectList(condition);
        if (CollectionUtils.isNotEmpty(plateList)) {
            if (StringUtils.isBlank(code)) {
                resultFlag = true;
            } else {
                Plate plate = plateList.get(0);
                if (!code.equals(plate.getCode())) {
                    resultFlag = true;
                }
            }
        }
        if (resultFlag == true) {
            throw new BizException("xn000000", "板块名称已存在");
        }
    }

    /** 
     * @see com.std.forum.bo.IPlateBO#savePlate(com.std.forum.domain.Plate)
     */
    @Override
    public String savePlate(Plate data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generate(EPrefixCode.PLATE.getCode());
            data.setCode(code);
            data.setUpdateDatetime(new Date());
            plateDAO.insert(data);
        }
        return code;
    }

    /** 
     * @see com.std.forum.bo.IPlateBO#refreshPlate(com.std.forum.domain.Plate)
     */
    @Override
    public int refreshPlate(Plate data) {
        int count = 0;
        if (data != null && data.getCode() != null) {
            data.setUpdateDatetime(new Date());
            count = plateDAO.update(data);
        }
        return count;
    }

    /** 
     * @see com.std.forum.bo.IPlateBO#getPlate(java.lang.String)
     */
    @Override
    public Plate getPlate(String code) {
        Plate result = null;
        if (StringUtils.isNotBlank(code)) {
            Plate condition = new Plate();
            condition.setCode(code);
            result = plateDAO.select(condition);
            if (result == null) {
                throw new BizException("xn000000", "板块编号不存在");
            }
        }
        return result;
    }

    /** 
     * @see com.std.forum.bo.IPlateBO#queryPlateList(com.std.forum.domain.Plate)
     */
    @Override
    public List<Plate> queryPlateList(Plate condition) {
        return plateDAO.selectList(condition);
    }
}
