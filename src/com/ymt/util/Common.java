package com.ymt.util;

/**
 * Created by xujian on 2015/11/5.
 */
public class Common {

    public static String buildCommand() {
        StringBuilder sb = new StringBuilder();
        sb.append("***********************************************\r\n");
        sb.append("* 1.Build Umeng Analysis data(umeng.txt)\n");
        sb.append("* 2.Exit\n");
        sb.append("***********************************************\n");

        return sb.toString();
    }
}
