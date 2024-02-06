package com.hua.demo.service.Impl;

import com.hua.demo.dto.AppConfigProperties;
import com.hua.demo.service.PublishService;
import com.hua.demo.util.ProductEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class PublishServiceImpl implements PublishService {

    @Resource
    private ApplicationEventPublisher eventPublisher;
    @Resource
    private AppConfigProperties properties;

    @Override
    public boolean sendMsg(int nodeId) {
        System.out.println("保存节点：" + nodeId);
        System.out.println("app.id:" + properties.getId());
        //事件发布 ProductEvent自定义的事件
        eventPublisher.publishEvent(new ProductEvent(this, nodeId));
        return true;
    }

}
