/*
 * Copyright (c) 2020 ilubov
 * https://www.ilubov.cn
 * All rights reserved.
 */
package com.i.lubov.rest;

import cn.hutool.core.date.DateUtil;
import com.i.lubov.entity.*;
import com.i.lubov.service.*;
import com.i.lubov.util.NoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * 测试
 *
 * @author ilubov
 * @date 2020/08/26
 */
@RestController
@RequestMapping("/")
public class DemoController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderInfoService orderInfoService;

    @Autowired
    private WaybillService waybillService;

    @Autowired
    private DictService dictService;

    @GetMapping("/order")
    public Order order(String date) {
        Order order = new Order();
        order.setOrderNo(NoUtil.getOrderNo("O"));
        order.setInputTime(DateUtil.parseDateTime(date));
        order.setWaybillNo(NoUtil.getOrderNo("W"));
        orderService.save(order);
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNo(order.getOrderNo());
        orderInfoService.save(orderInfo);
        return order;
    }

    @GetMapping("/order-batch")
    public List<Order> orderBatch(String date) {
        // return orderService.insertBatch(DateUtil.parseDateTime(date));
        return orderService.insert(DateUtil.parseDateTime(date));
    }

    @GetMapping("/get-order")
    public List<Order> getOrder(String date) {
        return orderService.query().between("input_time", DateUtil.parseDateTime(date), new Date()).list();
    }

    @GetMapping("/search-order")
    public List<Order> searchOrder(String orderNo) {
        return orderService.query().eq("order_no", orderNo).list();
    }

    @GetMapping("/func-test")
    public List<Order> funcTest(String date) {
        // return orderService.getList(DateUtil.parseDateTime(date));
        return orderService.getJoinList(DateUtil.parseDateTime(date));
    }

    @GetMapping("/order-info")
    public OrderInfo orderInfo() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNo(NoUtil.getOrderNo("O"));
        orderInfoService.save(orderInfo);
        return orderInfo;
    }

    @GetMapping("/get-order-info")
    public List<OrderInfo> getOrderInfo(String orderNo) {
        return orderInfoService.query().in("order_no", orderNo).list();
    }

    @GetMapping("/search-order-info")
    public List<OrderInfo> searchOrderInfo(Long orderId) {
        return orderInfoService.query().eq("id", orderId).list();
    }

    @GetMapping("/waybill")
    public Waybill waybill() {
        Waybill waybill = new Waybill();
        waybill.setOrderNo(NoUtil.getOrderNo("O"));
        waybill.setWaybillNo(NoUtil.getOrderNo("W"));
        waybill.setUserId(System.currentTimeMillis());
        waybillService.save(waybill);
        return waybill;
    }

    @GetMapping("/get-waybill")
    public List<Waybill> getWaybill(Long userId) {
        return waybillService.query().eq("user_id", userId).list();
    }

    @GetMapping("/search-waybill")
    public List<Waybill> searchWaybill(Long waybillId) {
        return waybillService.query().eq("id", waybillId).list();
    }

    @GetMapping("/dict")
    public Dict dict() {
        Dict dict = new Dict();
        dict.setLabel("label" + System.currentTimeMillis());
        dict.setValue("value" + System.currentTimeMillis());
        dictService.save(dict);
        return dict;
    }

    @GetMapping("/get-dict")
    public List<Dict> getDict() {
        return dictService.list();
    }
}
