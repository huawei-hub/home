package com.hua.demo.event;

import com.hua.demo.dto.Order;
import lombok.Data;

@Data
public class OrderEvent {
    private Order order;

    private String addOrUpdate;

    public OrderEvent(Order order, String addOrUpdate) {
        this.order = order;
        this.addOrUpdate = addOrUpdate;
    }
}
