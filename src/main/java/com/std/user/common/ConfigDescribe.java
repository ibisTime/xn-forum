package com.std.user.common;

import java.util.List;

/**
 * Created by wulp on 2015/4/7.
 */
public class ConfigDescribe {
    private List<String> ipList;

    private List<String> codeList;

    public void printAllInfo() {
        for (String ele : ipList) {
            System.out.println(ele);
        }
        for (String ele : codeList) {
            System.out.println(ele);
        }
    }

    public List<String> getIpList() {
        return ipList;
    }

    public void setIpList(List<String> ipList) {
        this.ipList = ipList;
    }

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

}
