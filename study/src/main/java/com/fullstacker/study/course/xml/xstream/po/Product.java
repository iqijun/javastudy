/*
package com.fullstacker.study.course.xml.xstream.po;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@XStreamAlias("Product")
public class Product implements Serializable {
    private static final long serialVersionUID = -740998796873611354L;
    */
/**
 * 序号
 * <p>
 * 商品编号
 * <p>
 * 商品等级
 * <p>
 * 更改前数量
 * <p>
 * 更改后数量
 * <p>
 * 发货的数量
 * <p>
 * 批次号
 * <p>
 * 备注
 * <p>
 * 序列号(JFS地址)
 * <p>
 * 序列号(serialJfsList解析后的数据)
 *//*

    private String orderLine;

    */
/**
 * 商品编号
 *//*

    @XStreamAlias("ID")
    private String id;

    */
/**
 * 商品等级
 *//*

    @XStreamAlias("GoodsGrade")
    private String goodsGrade;

    */
/**
 * 更改前数量
 *//*

    @XStreamAlias("NumBefore")
    private Integer numBefore;

    */
/**
 * 更改后数量
 *//*

    @XStreamAlias("NumAfter")
    private Integer numAfter;

    */
/**
 * 发货的数量
 *//*

    @XStreamAlias("Num")
    private Integer num;

    */
/**
 * 批次号
 *//*

    @XStreamAlias("BatchNo")
    private String batchNo;

    */
/**
 * 备注
 *//*

    @XStreamAlias("Remark")
    private String remark;

    */
/**
 * 序列号(JFS地址)
 *//*

    @XStreamAlias("SerialJfsList")
    private List<String> serialJfsList;

    */
/**
 * 序列号(serialJfsList解析后的数据)
 *//*

    private LinkedList<String> SerialNoList;

    @XStreamAlias("BatchAttr")
    private String batchAttr;
}
*/
