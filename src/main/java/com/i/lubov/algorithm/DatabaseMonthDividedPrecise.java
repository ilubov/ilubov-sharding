/*
 * Copyright (c) 2020 ilubov
 * https://www.ilubov.cn
 * All rights reserved.
 */
package com.i.lubov.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.joda.time.LocalDate;

import java.util.Collection;
import java.util.Date;

/**
 * 标准分片：处理=和IN
 * 分片类型：12库、同表名
 * 用于：订单主表
 *
 * @author ilubov
 * @date 2020/08/26
 */
public class DatabaseMonthDividedPrecise implements PreciseShardingAlgorithm<Date> {

    /**
     * 按input_time所属月份选择数据库
     *
     * @param availableTargetNames 数据库
     * @param shardingValue 分片键值
     * @return database
     */
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Date> shardingValue) {
        int month = LocalDate.fromDateFields(shardingValue.getValue()).getMonthOfYear();
        return availableTargetNames.toArray(new String[]{})[(month - 1)];
    }
}
