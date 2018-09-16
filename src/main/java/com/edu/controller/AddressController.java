package com.edu.controller;

import com.edu.commons.JsonModel;
import com.edu.pojo.Address;
import com.edu.pojo.User;
import com.edu.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AddressController {
    @Autowired
    private AddressService as;

    //添加地址
    @RequestMapping("addaddress.do")
    public String addaddress(Address address){
        if(as.insert(address)){
            return "selectall.do" ;
        }else{
            return "self_info.jsp";
        }
    }

    //修改地址
    @RequestMapping("modifyaddress.do")
    @ResponseBody
    public JsonModel modifyaddress(Address address){
        if(as.updateByAid(address)){
            return JsonModel.ok();
        }else{
            return JsonModel.error();
        }
    }

    //删除地址
    @RequestMapping("deleteaddress.do")
    public String deleteaddress(Integer aid){
        as.deleteByAid(aid);
        return "selectall.do";

    }

    //查询所有地址
    @RequestMapping("selectall.do")
    public String selectall(HttpSession session, Model model ){
        User user = (User) session.getAttribute("user");
        Integer uid = user.getUid();
        List<Address> addList = as.selectAll(uid);
        session.setAttribute("addList",addList);
        return "redirect:self_info.jsp";
    }

    //指定默认地址
    @RequestMapping("defaultaddress.do")
    public String defaultaddress(Integer aid,HttpSession session){
        User user = (User) session.getAttribute("user");
        Integer uid = user.getUid();
        as.updateDefault(uid,aid);

        return "selectall.do";
    }

}
