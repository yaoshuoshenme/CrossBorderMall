package com.edu.util;

import java.util.Base64;

//base64 ���� ���� �����ʼ���ʱ�� Ϊ �����ַ code��֤�� ���м���
//�� �ش������� ���������ַ �� code �Ľ���
public class Base64Utils {
	//����
	public static String encode(String msg){
		return Base64.getEncoder().encodeToString(msg.getBytes());
	}
	//����
	public static String decode(String msg){
		return new String(Base64.getDecoder().decode(msg));
	}
}
