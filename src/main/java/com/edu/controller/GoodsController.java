package com.edu.controller;

import com.edu.commons.JsonModel;
import com.edu.pojo.Goods;
import com.edu.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    private GoodsService gs;


    //通过gid查询
    @RequestMapping("goodsbygid.do")
    @ResponseBody
    public JsonModel queryById(Integer gid){
        JsonModel js = new JsonModel();
        Goods goods = gs.queryById(gid);

        if(null != goods){
           js.setCode(0);
           js.setData(goods);
        }else{

            js.setCode(1);
            js.setMsg("查询失败");
        }
        return js;

    }

    //通过商品列表
    @RequestMapping("goodsbytid.do")
    public String goodsbytid(Integer tid, Model model){
        List<Goods> list = gs.queryByTid(tid);
        model.addAttribute("glist",list);
        return "goodsList.jsp";
    }

    //查询商品详情
    @RequestMapping("goodsbyid.do")
    public String goodsbyid(Integer gid, Model model){
        Goods goods = gs.queryById(gid);
        model.addAttribute("goods",goods);
        return "goodsDetail.jsp";
    }
}
