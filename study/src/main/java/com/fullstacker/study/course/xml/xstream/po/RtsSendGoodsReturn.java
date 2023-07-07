package com.fullstacker.study.course.xml.xstream.po;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@XStreamAlias("Provider_ReturnsOrder")
public class RtsSendGoodsReturn implements Serializable {
    
    private static final long serialVersionUID = 6076899936309552792L;
    
    /**
     * 标记为节点属性 ,命名空间
     */
    @XStreamAsAttribute
    protected String xmlnsxsi = "http://www.w3.org/2001/XMLSchema-instance";
    
    /**
     * 标记为节点属性 ,命名空间
     */
    @XStreamAsAttribute
    protected String xmlnsxsd = "http://www.w3.org/2001/XMLSchema";
    
    /**
     * 订单号
     */
    
    @XStreamAlias("ID")
    private String id;
    
    /**
     * 发货的状态
     */
    
    @XStreamAlias("Result")
    private String result;
    
    /**
     * 错误代码
     */
    
    @XStreamAlias("ErrCode")
    private String errorCode;
    
    /**
     * 错误信息
     */
    
    @XStreamAlias("ErrMsg")
    private String errMsg;
    
    /**
     * 已经发货的商品数量
     */
    
    //    @XStreamAlias("ProductList")
    //    private List<Product> productList;
    
    /**
     * 差异商品信息
     */
    
    @XStreamAlias("Diversities")
    private List<Diversities> diversitiesList;
    
    /**
     * RF操作时间
     */
    @XStreamAlias("Rfdate")
    private String rfDate;
    
    /**
     * 消息来源
     */
    private Integer source;
    
}
