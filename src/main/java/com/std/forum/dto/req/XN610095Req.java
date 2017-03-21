package com.std.forum.dto.req;

/**
 * 分页查询子系统配置
 * @author: asus 
 * @since: 2017年3月21日 下午7:40:59 
 * @history:
 */
public class XN610095Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 名称
    private String name;

    // 属于
    private String belong;

    // 公司编号
    private String companyCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
