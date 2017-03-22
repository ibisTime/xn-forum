package com.std.forum.dto.req;

/**
 * 前端列表查询banner
 * @author: asus 
 * @since: 2017年3月22日 上午10:31:10 
 * @history:
 */
public class XN610107Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 站点编号
    private String companyCode;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
