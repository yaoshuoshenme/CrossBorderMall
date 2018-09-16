package com.edu.controller;

import com.edu.commons.Constant.ConstantInterface;
import com.edu.commons.JsonModel;
import com.edu.pojo.User;
import com.edu.service.CartService;
import com.edu.service.UserService;
import com.edu.util.AutoLogin;
import com.edu.util.EmailUtils;
import com.edu.util.MyMD5Util;
import com.edu.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.json.Json;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Controller
public class UserController extends BaseController {

    @Autowired
    private UserService us;

    @Autowired
    private CartService cs;

    /**
     * 登录
     * @param uname 用户名或邮箱名
     * @param upassword 密码
     * @param auto  自动登录选项
     * @param request
     * @param response
     * @return 返回包含登录状态信息的json字符串
     */
    @RequestMapping(value="api/v1/login.do", method=RequestMethod.POST)
    public String login(String uname, String upassword, boolean auto, HttpServletRequest request, HttpServletResponse response,Model model){
        User user;
        //判断是用户名登录还是邮箱登录
        if(uname.contains("@")){
            user = us.selectByMail(uname);
        }else{
            user  = us.selectByName(uname);
        }

        try {
            //判断登录状态和flag
            if(null != user && MyMD5Util.validPassword(upassword,user.getUpassword())){
                if(2 != user.getUflag()){

                 model.addAttribute("登录成功");
                    //登录信息,购物车放到session
                    request.getSession().setAttribute("user",user);
                    request.getSession().setAttribute("cart",cs.querytByUid(user.getUid()));
                    //判断是否需要自动登录
                    if(auto){
                        //获取cookieValue
                        String cookieValue = AutoLogin.getCookieValue(user.getUname(),user.getUpassword(),new Date().toString());
                        Cookie cookie = new Cookie(ConstantInterface.VALUENAME, cookieValue);
                        cookie.setMaxAge(14*24*60*60);
                        response.addCookie(cookie);
                    }
                    return "redirect:/index.jsp";

                }else{
                    model.addAttribute("账户被冻结");
                    return "/login.html";
                }

            }else{
                model.addAttribute("登录失败，用户名或密码错误");
                return "/login.html";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "/login.html";
        }

    }


    /**
     * 注册，code=1002注册成功，code=1003注册失败
     * @param user 用户注册信息封装到user对象
     * @return 重定向
     */

    @GetMapping("api/v1/register.do")
    public String register( User user, HttpSession session){

        String pwdInMD = null;

        //设置激活码
        user.setUactivation(RandomUtils.createActive());

        //密码加密
        try {
            pwdInMD = MyMD5Util.getEncryptedPwd(user.getUpassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setUpassword(pwdInMD);

        //调用service保存
       us.register(user);
        Integer b = user.getUid();
        System.out.println(b);
        //组装json返回
        if(b > 0){
            EmailUtils.sendEmail(user);
            //分配一个购物车,并放到session
            session.setAttribute("cart",cs.insert(b));
            return "redirect:/registerSuccess.jsp";
        }else{
            return "redirect:/register.jsp";
        }

    }

    /**
     * 注销登录
     * @param request
     * @return
     */
    @GetMapping("api/v1/userloginout.do")
    public String userloginout(HttpServletRequest request){

        request.getSession().removeAttribute("user");
        return "redirect:/login.html";
    }


    /**
     * 验证用户名是否存在
     * @param uname
     * @return
     */
    @GetMapping("api/v1/checkname.do")
    @ResponseBody
    public JsonModel checkname(String uname){

        if(null == us.selectByName(uname)){
            return JsonModel.ok();
        }else{
            return JsonModel.error();
        }

    }

    /**
     * 验证邮箱是否合法
     * @param umail
     * @return
     */

    @GetMapping("api/v1/checkmail")
    @ResponseBody
    public JsonModel checkmail(String umail){
        if(null == us.selectByMail(umail)){
            return JsonModel.ok();
        }else{
            return JsonModel.error();
        }
    }

    /**
     * 激活账户
     * @param uname
     * @param uactivation
     * @return
     */
    @RequestMapping(value="api/v1/active", method = RequestMethod.PATCH)
    public String active(String uname, String uactivation){
        //先通过用户名和激活码判断
        User user = us.selectByName(uname);
        if(null != user && uactivation.equals(user.getUactivation())){
            user.setUflag(1);
            if(us.updateByPrimaryKey(user) > 0){
                return "redirect:/index.jsp";
            }else{
                return "redirect:/login.html";
            }
        }else{
            return "redirect:/login.html";
        }
    }

    //检测是否登录
    @GetMapping("api/v1/userlogincheck.do")
    @ResponseBody
    public JsonModel userlogincheck(HttpSession session){
        User user = (User) session.getAttribute("user");
        JsonModel js = new JsonModel();
        if(null != user){
            js.setCode(0);
            js.setData(user);
        }else{
            js.setCode(1);
        }
        return js;
    }

}
