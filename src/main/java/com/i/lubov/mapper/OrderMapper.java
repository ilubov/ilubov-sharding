/*
 * Copyright (c) 2020 ilubov
 * https://www.ilubov.cn
 * All rights reserved.
 */
package com.i.lubov.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.i.lubov.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * OrderMapper
 *
 * @author ilubov
 * @date 2020/08/26
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    List<Order> getList(@Param("date") Date date);

    List<Order> getJoinList(@Param("date") Date date);
}
