package com.std.forum.bo;

import com.std.forum.dto.res.XN806010Res;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午8:09:47 
 * @history:
 */
public interface ISiteBO {

    /**
     * @param companyCode
     * @return 
     * @create: 2016年10月31日 下午8:02:20 xieyj
     * @history:
     */
    public XN806010Res getCompany(String companyCode);
}
