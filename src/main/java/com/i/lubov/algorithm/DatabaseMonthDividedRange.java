/*
 * Copyright (c) 2020 ilubov
 * https://www.ilubov.cn
 * All rights reserved.
 */
package com.i.lubov.algorithm;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.*;


/**
 * 标准分片：处理BETWEEN AND, > , <, >=, <=
 * 分片类型：12库、同表名
 * 用于：订单主表
 *
 * @author ilubov
 * @date 2020/08/26
 */
public class DatabaseMonthDividedRange implements RangeShardingAlgorithm<Date> {

    private static final int MAX_SHARDING = 12;

    private static final String FORMAT_MONTH = "MM";

    /**
     * 按input_time所属月份选择数据库
     *
     * @param availableTargetNames 数据库
     * @param shardingValue 分片键区间
     * @return database
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Date> shardingValue) {
        Range<Date> dateRange = shardingValue.getValueRange();
        // 有界返回指定分片
        if (dateRange.hasLowerBound() && dateRange.hasUpperBound()) {
            Date startTime = new Date(dateRange.lowerEndpoint().getTime());
            Date endTime = new Date(dateRange.upperEndpoint().getTime());
            Calendar min = Calendar.getInstance();
            Calendar max = Calendar.getInstance();
            min.setTime(startTime);
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
            max.setTime(endTime);
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
            Set<String> sharding = new HashSet<>(MAX_SHARDING);
            String[] ds = availableTargetNames.toArray(new String[]{});
            while (min.before(max)) {
                sharding.add(ds[Integer.parseInt(DateUtil.format(min.getTime(), FORMAT_MONTH)) - 1]);
                min.add(Calendar.MONTH, 1);
            }
            return sharding;
        } else {
            // 无界返回所有分片
            return availableTargetNames;
        }
    }
}
