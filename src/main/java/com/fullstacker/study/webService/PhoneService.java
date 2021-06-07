package com.fullstacker.study.webService;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.Date;

/**
 * @description:
 * @time: 2021/4/14 18:38
 */
@WebService
public class PhoneService {

    public Phone getPhoneInfo(Phone phoneParm) {
        Phone phone = new Phone();
        String name = phoneParm.getName();
        phone.setName(name);
        if (name.endsWith("android")) {
            phone.setProduce("Oracle");
            phone.setTime(new Date());
        } else if (name.endsWith("apple")) {
            phone.setProduce("Apple");
            phone.setTime(new Date());
        } else {
            phone.setProduce("未知");
            phone.setTime(new Date());
        }
        return phone;
    }

    public static void main(String[] args) {
        //WebService发布的地址，端口号和路径随意写，IP地址在实际应用时应该写发布WebService的服务器的地址
        String address = "http://127.0.0.1:7777/wwss/phoneService";
        Endpoint endpoint = Endpoint.publish(address, new PhoneService());
        //这里可以手动停止该服务，但是在实际开发中也不会随意停止
//        endpoint.stop();
        System.out.println(address + "?WSDL");
    }
}
