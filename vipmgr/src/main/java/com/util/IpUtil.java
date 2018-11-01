package com.util;

import com.util.http.PoolHttpClient;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
/**
 * @author: tangJ
 * @Date: 2018/10/31 11:32
 * @description:
 */
public class IpUtil {

    private static String unknown = "unknown";

    private  static String ipUrlStr = "http://ip.taobao.com/service/getIpInfo.php?ip=";

    private static PoolHttpClient httpClient = new PoolHttpClient();

    public static String getIpAddrByRequest(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static String getIpAddresses(String ip) {
        String url = ipUrlStr+ip;
        String result = httpClient.doGet(url);
        System.out.println(result);
        return result;
    }

//    public static void main(String args[]){
//        String ip = "/101.231.201.50";
//        getIpAddresses(ip);
//    }
}
