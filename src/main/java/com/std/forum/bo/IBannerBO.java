package com.std.forum.bo;

import java.util.List;

import com.std.forum.bo.base.IPaginableBO;
import com.std.forum.domain.Banner;



//CHECK ��鲢��ע�� 
public interface IBannerBO extends IPaginableBO<Banner> {


	public boolean isBannerExist(String code);


	public String saveBanner(Banner data);


	public int removeBanner(String code);


	public int refreshBanner(Banner data);


	public List<Banner> queryBannerList(Banner condition);


	public Banner getBanner(String code);


}