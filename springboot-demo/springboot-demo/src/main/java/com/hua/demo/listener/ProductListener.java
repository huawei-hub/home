package com.hua.demo.listener;

import com.hua.demo.util.ProductEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ProductListener implements ApplicationListener<ProductEvent> {
    @Override
    public void onApplicationEvent(ProductEvent event) {
        Integer nodeId = event.getNodeId();
        System.out.println("监听器监听节点Id：" + nodeId);
    }
}
