/*
package com.fullstacker.study.course.xml.xstream;

import com.fullstacker.study.course.JAVASE.date.DateUtil;
import com.fullstacker.study.course.xml.xstream.po.Product;
import com.fullstacker.study.course.xml.xstream.po.RtsBackMessage;
import com.fullstacker.study.course.xml.xstream.po.RtsSendGoodsReturn;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

*/
/**
 * @description:
 * @time: 2020/10/22 17:12
 *//*

public class XStreamTest {

    public static void main(String[] args) {
        RtsSendGoodsReturn rtsSendGoodsReturn = new RtsSendGoodsReturn();
        rtsSendGoodsReturn.setId("19203");
        rtsSendGoodsReturn.setResult("1");
        rtsSendGoodsReturn.setSource(4);
        rtsSendGoodsReturn.setRfDate(DateUtil.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss"));
        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Product product = new Product();
            product.setId("1903" + i);
            product.setBatchAttr("102902-30-904" + i);
            product.setNum(1 + i);
            product.setBatchNo("-1");
            products.add(product);
        }
        rtsSendGoodsReturn.setProductList(products);
        String text = XMLUtils.generateXMLTaskContent(rtsSendGoodsReturn);
        RtsBackMessage rtsBackMessage = new RtsBackMessage();
        rtsBackMessage.setText(text);
        rtsBackMessage.setMessageId(rtsSendGoodsReturn.getId());
        rtsBackMessage.setType("RTS_BACK_MSG_TYPE");
        rtsBackMessage.setWmsGuID(UUID.randomUUID().toString());
        String message = XMLUtils.generateXMLTaskContent(rtsBackMessage);
        System.out.println(message);
        System.out.println("=======================================================");
        message = message.replace("&lt;", "<").replace("&gt;", ">");
        System.out.println(message);
    }
}
*/
