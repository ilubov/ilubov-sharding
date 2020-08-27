/*
 * Copyright (c) 2020 ilubov
 * https://www.ilubov.cn
 * All rights reserved.
 */
package com.i.lubov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.i.lubov.entity.OrderInfo;
import com.i.lubov.mapper.OrderInfoMapper;
import com.i.lubov.service.OrderInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * OrderInfoServiceImpl
 *
 * @author ilubov
 * @date 2020/08/26
 */
@Slf4j
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

}
