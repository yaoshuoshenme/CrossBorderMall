package com.edu.controller;


import com.edu.commons.JsonModel;
import com.edu.pojo.Address;
import com.edu.pojo.Cartitem;
import com.edu.pojo.OrderList;
import com.edu.pojo.User;
import com.edu.service.AddressService;
import com.edu.service.CartitemService;
import com.edu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private CartitemService cis;
    @Autowired
    private OrderService os;
    @Autowired
    private AddressService as;

    //生成订单

    @PostMapping("selectByCiids.do")
    @ResponseBody
    public JsonModel selectByCiids(String ciids, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Cartitem> cartitems = cis.selectByCiids(ciids);
        List<Address> addList = as.selectAll(user.getUid());
        if(null != cartitems){
            session.setAttribute("cartList",cartitems);
            session.setAttribute("addList",addList);
            session.setAttribute("ciids",ciids);
            return JsonModel.ok();
        }else{
            return JsonModel.error();
        }
    }

    //保存订单
    @GetMapping("ordersave.do")
    public String ordersave(Integer aid, HttpSession session){

        User user = (User) session.getAttribute("user");
        //获取session中的商品id
        String ciids = (String) session.getAttribute("ciids");
        //下单
        if(os.createOrder(user.getUid(), ciids, aid)){
            return "payWeixin.jsp";
        }else{
            return "cart.jsp";
        }
    }

    //查询所有订单

    @GetMapping("getOrderList.do")
    public String getOrderList(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        List<OrderList> orderLists = os.queryByUid(user.getUid());
        model.addAttribute("orderList",orderLists);
        return "orderList.jsp";
    }

    //查看订单详情

    @GetMapping("getOrderDetail.do")
    public String getOrderDetail(Integer oid, Model model){
        model.addAttribute("od",os.queryByOid(oid));
        return "orderDetail.jsp";
    }

}
