package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.Banner;

public interface IBannerBO extends IPaginableBO<Banner> {

    public boolean isBannerExist(String code);

    public String saveBanner(String name, String url, String pic,
            String location, String orderNo, String belong, String companyCode,
            String remark);

    public void refreshBannerByGlobal(String code, String name, String url,
            String pic, String location, String orderNo, String belong,
            String remark);

    public void refreshBannerByLocal(String code, String name, String url,
            String pic, String location, String orderNo, String belong,
            String companyCode, String remark);

    public int removeBanner(String code);

    public List<Banner> queryBannerList(String companyCode);

    public Banner getBanner(String code);

}
