package com.edu.web.interceptor;

import com.edu.commons.Constant.ConstantInterface;
import com.edu.pojo.User;
import com.edu.service.UserService;
import com.edu.util.AutoLogin;
import com.edu.util.MyMD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService us;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取cookie
        Cookie[] cookies = request.getCookies();
        //调用封装好的自动登录获取cookievalue
        String[] cookieValues = AutoLogin.checkCookie(cookies, "mallUser");
        System.out.println(cookieValues[1]);
        if(null != cookieValues){
            //根据cookievalue中的username查找user
            User user = us.selectByName(cookieValues[0]);
            System.out.println(user);
            //重新组装加密编码，比较明文信息
            if(null != user){

                String plainTextInMD5 = MyMD5Util.getEncryptedPwd(user.getUname() + user.getUpassword() + cookieValues[1] + ConstantInterface.WEBKEY);
                //如果相等证明cookie的用户信息没问题
                if(cookieValues.equals(plainTextInMD5)){
                    //设置session
                    request.getSession().setAttribute("user",user);
                    response.sendRedirect(request.getContextPath() +"/index.jsp");
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
