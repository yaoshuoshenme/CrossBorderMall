package com.edu.controller;


import com.edu.commons.JsonModel;
import com.edu.pojo.Cart;
import com.edu.pojo.Cartitem;
import com.edu.pojo.User;
import com.edu.service.CartService;
import com.edu.service.CartitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartitemService cis;
    @Autowired
    private CartService cs;

    //添加购物车
    @GetMapping("addCart.do")
    public String addCart(Integer gid, HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        if(null != cart){

            if(cis.saveOrUpdate(gid, cart.getCid())){
                return "cartSuccess.jsp";
            }else{
                //失败跳回商品详情页
                return "redirect:goodsbyid.do?gid=" + gid;
            }

        }else{
            return "login.html";
        }

    }
    //删除购物车商品
    @PostMapping("deleteCartitem.do")
    public String deleteCartitme(Integer ciid, HttpSession session){
        boolean b = cis.deleteByPrimaryKey(ciid);
        Cart cart = (Cart) session.getAttribute("cart");
        Integer cid = cart.getCid();
        return "redirect:querycartitem.do?cid=" + cid;
    }

    //清空购物车
    @GetMapping("clearcart.do")
    public String clearcart(HttpSession session){
        //获得购物车id
        Cart cart = (Cart) session.getAttribute("cart");
        Integer cid = cart.getCid();
        //删除购物车中全部商品信息
        cis.deleteByCid(cid);
        //重新查询跳转
        return "redirect:querycartitem.do?cid=" + cid;

    }
    //查询购物车
    @GetMapping("querycartitem.do")
    public String querycartitem( HttpSession session){
        //获取uid
        User user = (User) session.getAttribute("user");
        //获取cid
        Integer cid = cs.querytByUid(user.getUid()).getCid();
        //通过cid查询
        List<Cartitem> list = cis.queryByCid(cid);
        if(null != list && list.size() > 0){
            session.setAttribute("carts",list);
        }

        return  "cart.jsp";
    }
    //更改数量
    @GetMapping("updatecount.do")
    @ResponseBody
    public JsonModel updatecount(Integer ciid, Integer count){
        if(cis.updateByCiid(ciid, count)){
            return JsonModel.ok();
        }else{
            return JsonModel.error();
        }
    }
}
