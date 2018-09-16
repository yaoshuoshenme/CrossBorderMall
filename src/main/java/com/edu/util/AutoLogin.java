package com.edu.util;

import com.edu.commons.Constant.ConstantInterface;

import javax.servlet.http.Cookie;
import java.util.Date;

/**
 * 整个流程：
 * ——|保存用户信息阶段
 * ————|1.得到用户名、经MD5加密后的用户密码、cookie有效时间(本文设置的是两星期，可根据自己需要修改)
 * ————|2.自定义的一个webKey，这个Key是我们为自己的网站定义的一个字符串常量，这个可根据自己需要随意设置
 * ————|3.将上两步得到的四个值得新连接成一个新的字符串，再进行MD5加密，这样就得到了一个MD5明文字符串
 * ————|4.将用户名、cookie有效时间、MD5明文字符串使用“：”间隔连接起来，再对这个连接后的新字符串进行Base64编码
 * ————|5.设置一个cookieName,将cookieName和上一步产生的Base64编码写入到客户端
 *
 * ——|读取用户信息阶段
 * ————|1.根据设置的cookieName，得到cookieValue，如果值为空，就不帮用户进行自动登陆；否则执行读取方法
 * ————|2.将cookieValue进行Base64解码，将取得的字符串以split(“:”)进行拆分，得到一个String数组cookieValues（此操作与保存阶段的第4步正好相反），这一步将得到三个值：
 *        cookieValues[0] ---- 用户名
 *        cookieValues[1] ---- cookie有效时间
 *        cookieValues[2] ---- MD5明文字符串
 * ————|3.判断cookieValues的长度是否为3，如果不为3则进行错误处理。
 * ————|4.如果长度等于3，取出第二个,即cookieValues[1]，此时将会得到有效时间（long型），将有效时间与服务器系统当前时间比较，如果小于当前时间，则说明cookie过期，进行错误处理
 * ————|5.如果cookie没有过期，就取cookieValues[0]，这样就可以得到用户名了，然后去数据库按用户名查找用户。
 * ————|6.如果上一步返回为空，进行错误处理。如果不为空，那么将会得到一个已经封装好用户信息的User实例对象user
 * ————|7.取出实例对象user的用户名、密码、cookie有效时间（即cookieValues[1]）、webKey，然后将四个值连接起来，然后进行MD5加密，这样做也会得到一个MD5明文字符串（此操作与保存阶段的第3步类似）
 * ————|8.将上一步得到MD5明文与cookieValues[2]进行equals比较，如果是false，进行错误处理；如果是true，则将user对象添加到session中，帮助用户完成自动登陆
 * 明文(Plain text)  密文(Cipher text)
 */

public class AutoLogin {


    /**
     * 保存阶段，生成cookie信息
     */
    public static String getCookieValue(String username, String pwdInMD, String timeOut){
        //加密，生成新的明文
        String plainText = username + pwdInMD + timeOut + ConstantInterface.WEBKEY;
        try {
            plainText = MyMD5Util.getEncryptedPwd(plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //重新组装字符串，并进行Base64编码。username:timeout:plainText
            //组装
        String newPlatinText = username + ":" + timeOut + ":" + plainText;
            //编码返回
        return  Base64Utils.encode(newPlatinText);

    }

    /**
     * 校验
     * @return  null cookie信息错误或者过期
     * @return  String[] cookie未过期，返回String数组包含username,timeout以及明文信息
     */
    public static String[] checkCookie(Cookie[] cookies, String cookieName){

        String cookieValue = null;
        cookieName = ConstantInterface.VALUENAME;

        if(null == cookies){
            return null;
        }
        //获取cookieValue
        for (Cookie cookie: cookies
             ) {
            if(cookieName.equals(cookie.getName())){
                cookieValue = cookie.getValue();
            }
        }
        if( null != cookieValue){
            //Base64解码
            String decode = Base64Utils.decode(cookieValue);
            //用split方法分割
            //0:用户名，1:cookie有效时间, 2:MD5明文字符串
            String[] cookieValuse = decode.split(":");

            //判断长度是否为3
            if(cookieValuse.length == 3){
                //获取有效时间(long),判断与当前时间的大小
                Long timeOut = Long.valueOf(cookieValuse[1]);
                Long currentTime = new Date().getTime();
                //小于当前时间说明cookie过期，报错
                if(timeOut > currentTime){
                    return cookieValuse;
                }
            }
        }
        return null;
    }

}
