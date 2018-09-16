package com.edu.controller;

import com.edu.commons.JsonModel;
import com.edu.pojo.GoodType;
import com.edu.service.GoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GoodTypeController {
    @Autowired
    private GoodTypeService gs;

    /**
     * 查询主页的菜单
     * @param gtlevel
     * @return
     */
    @GetMapping("goodstypelist.do")
    @ResponseBody
    public JsonModel goodtypelist(Integer gtlevel){
        JsonModel js = new JsonModel();
        List<GoodType> list = gs.queryByLevel(gtlevel);
        if(null != list && list.size() > 0){
            js.setData(list);
            js.setCode(0);
        }else{
            js.setCode(1);
            js.setMsg("查询失败");
        }
        return js;
    }
}
