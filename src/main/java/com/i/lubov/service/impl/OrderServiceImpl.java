/*
 * Copyright (c) 2020 ilubov
 * https://www.ilubov.cn
 * All rights reserved.
 */
package com.i.lubov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.i.lubov.entity.Order;
import com.i.lubov.mapper.OrderMapper;
import com.i.lubov.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
