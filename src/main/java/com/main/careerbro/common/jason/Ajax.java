package com.main.careerbro.common.jason;

import java.util.LinkedHashMap;

public class Ajax {

    public static AjaxJson success(LinkedHashMap<String,Object> map){
        AjaxJson j = new AjaxJson();
        j.setCode(AjaxEnum.SUCCESS.getCode());
        j.setMsg(AjaxEnum.SUCCESS.getMsg());
        if (null!=map && map.size()>0)
            j.setBody(map);
        return j;
    }

    public static AjaxJson success(){
        return success(null);
    }

    public static AjaxJson error(AjaxEnum ajaxEnum,LinkedHashMap<String,Object> map){
        AjaxJson j = new AjaxJson();
        j.setCode(ajaxEnum.getCode());
        j.setMsg(ajaxEnum.getMsg());
        if (null!=map && map.size()>0)
            j.setBody(map);
        return j;
    }

    public static AjaxJson error(AjaxEnum ajaxEnum){
        return error(ajaxEnum,null);
    }
}
