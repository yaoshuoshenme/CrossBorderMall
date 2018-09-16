package com.edu.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

//����������֤ ������ ʹ�õ������
public class RandomUtils {
	//��ǰʱ�� + �����
	public static String createActive(){
		
		return getTime()+Integer.toHexString(new Random().nextInt(900)+100);
	}
	public static String getTime(){
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
	}
	//���ɶ������
	public static String createOrderId(){
		return getTime();
	}
}
