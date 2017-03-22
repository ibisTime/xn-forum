package com.std.forum.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.forum.ao.IBannerAO;
import com.std.forum.bo.IBannerBO;
import com.std.forum.bo.base.Paginable;
import com.std.forum.domain.Banner;
import com.std.forum.enums.EBelong;
import com.std.forum.enums.EBoolean;
import com.std.forum.exception.BizException;

@Service
public class BannerAOImpl implements IBannerAO {

    @Autowired
    private IBannerBO bannerBO;

    @Override
    public void editBannerGlobal(String code, String name, String url,
            String pic, String location, String orderNo, String belong,
            String remark) {
        if (!EBelong.getBelongMap().containsKey(belong)) {
            throw new BizException("xn0000", "属于不允许自定义");
        }
        Banner banner = bannerBO.getBanner(code);
        if (EBelong.GLOBAL.getCode().equals(banner.getBelong())
                || EBelong.LOCAL.getCode().equals(banner.getBelong())) {
            bannerBO.refreshBannerByGlobal(code, name, url, pic, location,
                orderNo, belong, remark);
        } else {
            throw new BizException("xn0000", "地方性banner，不可修改");
        }
    }

    @Override
    public void editBannerLocal(String code, String name, String url,
            String pic, String location, String orderNo, String belong,
            String companyCode, String remark) {
        Banner banner = bannerBO.getBanner(code);
        if (EBelong.LOCAL.getCode().equals(banner.getBelong())) {
            bannerBO.saveBanner(name, url, pic, location, orderNo, code,
                companyCode, remark);
        } else if (EBelong.GLOBAL.getCode().equals(banner.getBelong())) {
            throw new BizException("xn0000", "总部菜单，地方不可修改");
        } else {
            bannerBO.refreshBannerByLocal(code, name, url, pic, location,
                orderNo, belong, companyCode, remark);
        }
    }

    @Override
    public Paginable<Banner> queryBannerPage(int start, int limit,
            Banner condition) {
        return bannerBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Banner> queryBannerList(String companyCode) {
        List<Banner> bannerList = new ArrayList<Banner>();
        List<Banner> localList = bannerBO.queryBannerList(companyCode);
        List<Banner> globalList = bannerBO.queryBannerList(EBoolean.NO
            .getCode());
        for (Banner global : globalList) {
            if (CollectionUtils.isNotEmpty(localList)) {
                for (Banner local : localList) {
                    // 本地菜单的上级是全局的
                    if (local.getBelong().equals(global.getCode())
                            && EBelong.GLOBAL.getCode().equalsIgnoreCase(
                                global.getBelong())) {
                        bannerList.add(global);
                    }
                    // 本地菜单的上级是可配的
                    if (local.getBelong().equals(global.getCode())
                            && EBelong.LOCAL.getCode().equalsIgnoreCase(
                                global.getBelong())) {
                        bannerList.add(local);
                    }
                }
            }
        }
        for (Banner banner : bannerList) {
            for (Banner global : globalList) {
                if (banner.getCode().equals(global.getCode())) {
                    globalList.remove(global);
                    break;
                }
            }
        }
        bannerList.addAll(globalList);
        return bannerList;
    }

    @Override
    public Banner getBanner(String code) {
        return bannerBO.getBanner(code);
    }

}
