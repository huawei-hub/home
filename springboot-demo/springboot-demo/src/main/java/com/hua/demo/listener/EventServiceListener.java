package com.hua.demo.listener;

import com.hua.demo.dto.Order;
import com.hua.demo.dto.Person;
import com.hua.demo.event.BaseEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventServiceListener {

    /*    @EventListener
        public void handleOrderEvent(OrderEvent orderEvent) {
            log.info("监听到的内容是："+orderEvent);
        }*/
    /*@EventListener
    public void handleBaseEvent(BaseEvent<?> event) {
        if (baseEvent.getT() instanceof Person) {
            log.info("监听到person, 内容是{}：",event);
        } else if (baseEvent.getT() instanceof Order) {
            log.info("监听到order, 内容是{}：",event);
        }
    }*/

    @EventListener
    public void handleOrderEvent(BaseEvent<Order> event) {
        log.info("监听到order, 内容是{}：",event);
    }

    @EventListener
    public void handlePersonEvent(BaseEvent<Person> event) {
        log.info("监听到person, 内容是{}：",event);
    }
}
