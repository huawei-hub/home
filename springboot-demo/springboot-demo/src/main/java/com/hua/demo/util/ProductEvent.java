package com.hua.demo.util;

import org.springframework.context.ApplicationEvent;

//创建事件
public class ProductEvent extends ApplicationEvent {

    private Integer nodeId;

    public ProductEvent(Object source, Integer nodeId) {
        super(source);
        this.nodeId = nodeId;
    }

    public Integer getNodeId() {
        return nodeId;
    }
}
