/*
 * Copyright (c) 2020 ilubov
 * https://www.ilubov.cn
 * All rights reserved.
 */
package com.i.lubov.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.i.lubov.entity.Order;

import java.util.Date;
import java.util.List;

/**
 * OrderService
 *
 * @author ilubov
 * @date 2020/08/26
 */
public interface OrderService extends IService<Order> {

    List<Order> getList(Date date);

    List<Order> getJoinList(Date date);

    List<Order> insertBatch(Date date);

    List<Order> insert(Date date);
}
