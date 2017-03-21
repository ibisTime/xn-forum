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
    public String saveBanner(Banner data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateME(EPrefixCode.BANNER.getCode());
            data.setCode(code);
            bannerDAO.insert(data);
        }
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
    public int refreshBanner(Banner data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = bannerDAO.update(data);
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
}
