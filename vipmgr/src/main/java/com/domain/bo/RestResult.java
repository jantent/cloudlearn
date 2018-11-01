package com.domain.bo;

import com.constant.RestCode;
import org.springframework.ui.ModelMap;


public class RestResult {

    /**
     * 成功返回
     * @return
     */
    public static ModelMap ok() {
        ModelMap mp = new ModelMap();
        mp.put("code", RestCode.SUCCESS.code);
        mp.put("msg", RestCode.SUCCESS.msg);
        mp.put("data", "");
        return mp;
    }

    /**
     * 一般成功 统一返回
     */
    public static ModelMap ok(Object obj) {
        ModelMap mp = new ModelMap();
        mp.put("code", RestCode.SUCCESS.code);
        mp.put("msg", RestCode.SUCCESS.msg);
        mp.put("data", obj);
        return mp;
    }

    /**
     * 自定义成功消息
     */
    public static ModelMap ok(String msg, Object obj) {
        ModelMap map = new ModelMap();
        map.put("code", RestCode.SUCCESS.code);
        map.put("msg", msg);
        map.put("data", obj);
        return map;
    }

    /**
     * 自定义成功返回
     */
    public static ModelMap ok(int code, String msg, Object obj){
        ModelMap map = new ModelMap();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", obj);
        return map;
    }

    public static ModelMap fail(String msg){
        ModelMap map = new ModelMap();
        map.put("code", -1);
        map.put("msg", msg);
        return map;
    }

    /**
     * 一般错误 统一返回
     */
    public static ModelMap fail(RestCode restCode) {
        ModelMap map = new ModelMap();
        map.put("code", restCode.code);
        map.put("msg", restCode.msg);
        return map;
    }

    /**
     * 自定义错误信息
     */
    public static ModelMap fail(int code, String msg) {
        ModelMap mp = new ModelMap();
        mp.put("code", code);
        mp.put("msg", msg);
        return mp;
    }
}
