package com.edu.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {

    public static void main(String[] args) throws ParseException {
//当前时间加30分钟
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();//获取当前时间
        System.out.println("当前时间：" + sdf.format(date));
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 30);//要增加什么，在这里写
        System.out.println("增加30分钟之后的时间：" + sdf.format(nowTime.getTime()));

//把自己定义的某个时间增加一段时间
        Calendar nowTime1 = Calendar.getInstance();
        Date date1 = sdf.parse("2012-07-25 21:00:00");//把字符串转换成时间类型
        nowTime1.setTime(date1);
        nowTime1.add(Calendar.MINUTE, 30);//要增加什么，在这里写
        System.out.println("自己定义的某个时间增加30分钟之后的时间：" + sdf.format(nowTime1.getTime()));
    }

}
