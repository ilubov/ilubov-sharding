/*
 * Copyright (c) 2020 ilubov
 * https://www.ilubov.cn
 * All rights reserved.
 */
package com.i.lubov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.i.lubov.entity.Order;
import com.i.lubov.mapper.OrderMapper;
import com.i.lubov.service.OrderService;
import com.i.lubov.util.NoUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * OrderServiceImpl
 *
 * @author ilubov
 * @date 2020/08/26
 */
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Override
    public List<Order> getList(Date date) {
        return this.baseMapper.getList(date);
    }

    @Override
    public List<Order> getJoinList(Date date) {
        return this.baseMapper.getJoinList(date);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Order> insertBatch(Date date) {
        int size = 5;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        List<Order> orders = Lists.newArrayListWithCapacity(size);
        for (int i = 0; i < size; i++) {
            if (i > 1) {
                calendar.add(Calendar.MONTH, 1);
            }
            Order order = new Order();
            order.setOrderNo(NoUtil.getOrderNo("O"));
            order.setInputTime(calendar.getTime());
            order.setWaybillNo(NoUtil.getOrderNo("W"));
            orders.add(order);
        }
        this.saveBatch(orders);
        return orders;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public List<Order> insert(Date date) {
        int size = 5;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        List<Order> orders = Lists.newArrayListWithCapacity(size);
        for (int i = 0; i < size; i++) {
            if (i == 2) {
                int x = i / 0;
            }
            if (i > 1) {
                calendar.add(Calendar.MONTH, 1);
            }
            Order order = new Order();
            order.setOrderNo(NoUtil.getOrderNo("O"));
            order.setInputTime(calendar.getTime());
            order.setWaybillNo(NoUtil.getOrderNo("W"));
            this.save(order);
            orders.add(order);
        }
        return orders;
    }
}
