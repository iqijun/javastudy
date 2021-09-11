package com.fullstacker.study.course.xml.xstream.po;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @description:
 * @time: 2020/10/21 18:00
 */
@Getter
@Setter
@XStreamAlias("MessageEntity")
public class RtsBackMessage implements Serializable {

    @XStreamAlias("MessageId")
    private String messageId;

    @XStreamAlias("Type")
    private String type;

    @XStreamAlias("WMSGUID")
    private String wmsGuID;

    @XStreamAlias("Text")
    private String text;
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

}
