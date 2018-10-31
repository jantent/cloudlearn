package com.domain.bo;

import java.util.HashMap;
import java.util.List;

/**
 * @author: tangJ
 * @Date: 2018/10/31 14:29
 * @description:
 */
public class LayRespBo extends HashMap<String,Object>{
    private int code = 0;

    private String msg;

    private int count;

    public static LayRespBo data(List<?> data){
        LayRespBo layRespBo = new LayRespBo();
        layRespBo.put("code",0);
        layRespBo.put("msg","");
        layRespBo.put("count",data.size());
        layRespBo.put("data",data);
        return layRespBo;
    }


}
