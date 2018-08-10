package com.zz.HttpClient.Util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class OrderNoUtil {
	
	 public static String getId(){  
         String id = UUID.randomUUID().toString().replace("-", "");
         return id;  
     }  

	/**
	 * 订单号
	 * 201508171108900(yyMMddHHMMSS) +
	 * uuid: db30cc85-3387-4845-87bc-dc390b55b7ea 前8位 
	 * 即：201508171108900db30cc85
	 * @param prefix 订单类别前缀
	 * @return
	 */
	public static String getOrderNoByDate(String prefix) {
		String orderNo = "";
		UUID uuid = UUID.randomUUID();
		String sdf = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		orderNo = uuid.toString().substring(0, 8);
		orderNo = prefix + sdf + orderNo;
		return orderNo;
	}
	
	/**
	 * 明细订单号
	 * @return
	 */
	public static String getDetailOrderNo() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0     
        // 4 代表长度为4     
        // d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
    }
	
	/**
	 * 生成六位验证码(发短信验证)
	 * @param charCount
	 * @return
	 */
	public static String getRandNum(int charCount) {
        String charValue = "";
        for (int i = 0; i < charCount; i++) {
            char c = (char) (randomInt(0, 10) + '0');
            charValue += String.valueOf(c);
        }
        return charValue;
    }

	public static int randomInt(int from, int to) {
        Random r = new Random();
        return from + r.nextInt(to - from);
	}
	
	public static void main(String[] args) {
		System.out.println(getRandNum(6));
	}
}
