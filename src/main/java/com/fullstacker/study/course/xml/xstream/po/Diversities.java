package com.fullstacker.study.course.xml.xstream.po;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@XStreamAlias("Diversity")
public class Diversities implements Serializable {
    private static final long serialVersionUID = 4624813761151017248L;
    /**
     * 商品编号
     */
    @XStreamAlias("ID")
    private String id;

    /**
     * 商品等级
     */
    @XStreamAlias("GoodsGrade")
    private String goodsGrade;

    /**
     * 缺量的数量
     */
    @XStreamAlias("LackNum")
    private Integer lackNum;

    /**
     * 缺量原因-编码
     */
    @XStreamAlias("ReasonCode")
    private String reasonCode;

    /**
     * 缺量原因
     */
    @XStreamAlias("ReasonDesc")
    private String reasonDesc;
}
