package com.std.forum.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.std.forum.bo.IBannerBO;
import com.std.forum.bo.base.PaginableBOImpl;
import com.std.forum.core.OrderNoGenerater;
import com.std.forum.dao.IBannerDAO;
import com.std.forum.domain.Banner;
import com.std.forum.enums.EPrefixCode;
import com.std.forum.exception.BizException;

@Component
public class BannerBOImpl extends PaginableBOImpl<Banner> implements IBannerBO {

    @Autowired
    private IBannerDAO bannerDAO;

    @Override
    public boolean isBannerExist(String code) {
        Banner condition = new Banner();
        condition.setCode(code);
        if (bannerDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    @Override
    public String saveBanner(String name, String url, String pic,
            String location, String orderNo, String belong, String companyCode,
            String remark) {
        Banner data = new Banner();
        String code = OrderNoGenerater.generateME(EPrefixCode.BANNER.getCode());
        data.setCode(code);
        data.setName(name);
        data.setUrl(url);
        data.setPic(pic);
        data.setLocation(location);
        data.setOrderNo(orderNo);
        data.setBelong(belong);
        data.setCompanyCode(companyCode);
        data.setRemark(remark);
        bannerDAO.insert(data);
        return code;
    }

    @Override
    public int removeBanner(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Banner data = new Banner();
            data.setCode(code);
            count = bannerDAO.delete(data);
        }
        return count;
    }

    @Override
    public List<Banner> queryBannerList(Banner condition) {
        return bannerDAO.selectList(condition);
    }

    @Override
    public Banner getBanner(String code) {
        Banner data = null;
        if (StringUtils.isNotBlank(code)) {
            Banner condition = new Banner();
            condition.setCode(code);
            data = bannerDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "�� ��Ų�����");
            }
        }
        return data;
    }

    @Override
    public void refreshBannerByGlobal(String code, String name, String url,
            String pic, String location, String orderNo, String belong,
            String remark) {
        Banner data = new Banner();
        data.setCode(code);
        data.setName(name);
        data.setUrl(url);
        data.setPic(pic);
        data.setLocation(location);
        data.setOrderNo(orderNo);
        data.setBelong(belong);
        data.setRemark(remark);
        bannerDAO.updateByGlobal(data);
    }

    @Override
    public void refreshBannerByLocal(String code, String name, String url,
            String pic, String location, String orderNo, String belong,
            String companyCode, String remark) {
        Banner data = new Banner();
        data.setCode(code);
        data.setName(name);
        data.setUrl(url);
        data.setPic(pic);
        data.setLocation(location);
        data.setOrderNo(orderNo);
        data.setBelong(belong);
        data.setCompanyCode(companyCode);
        data.setRemark(remark);
        bannerDAO.updateByLocal(data);
    }
}
