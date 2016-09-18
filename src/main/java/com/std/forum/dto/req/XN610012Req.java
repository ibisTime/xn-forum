package com.std.forum.dto.req;

/** 
 * 经纬度查询站点
 * @author: zuixian 
 * @since: 2016年9月13日 下午5:16:42 
 * @history:
 */
public class XN610012Req {
    // 经度
    private String longitude;

    // 纬度
    private String latitude;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
