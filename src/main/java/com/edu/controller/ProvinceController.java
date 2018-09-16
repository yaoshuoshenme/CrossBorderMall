package com.edu.controller;

import com.edu.pojo.City;
import com.edu.pojo.Country;
import com.edu.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProvinceController {

    @Autowired
    private ProvinceService ps;


    //根据省份获取城市
    @RequestMapping("querycity.do")
    @ResponseBody
    public List<City> querycity(Integer id){
        return ps.selectByPid(id);
    }

    //根据城市县/区
    @RequestMapping("querycountry.do")
    @ResponseBody
    public List<Country> querycountry(Integer id){
        return ps.selectByCityId(id);
    }
}
