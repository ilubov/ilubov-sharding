/*
 * Copyright (c) 2020 ilubov
 * https://www.ilubov.cn
 * All rights reserved.
 */
package com.i.lubov.algorithm;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.i.lubov.exception.BusinessException;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 复合分片：用于处理=和IN
 * 分片类型：16库、16不同表名
 * 用于：订单子表
 *
 * @author ilubov
 * @date 2020/08/26
 */
public class DatabaseComplexKeys implements ComplexKeysShardingAlgorithm<String> {

    private static final int MAX_SHARDING = 16;

    /**
     * 按单号后两位抹除16选择数据库
     *
     * @param availableTargetNames 数据库
     * @param shardingValue 分片键值
     * @return database
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames,
                                         ComplexKeysShardingValue<String> shardingValue) {
        Map<String, Collection<String>> shardingMap = shardingValue.getColumnNameAndShardingValuesMap();
        Set<String> sharding = new HashSet<>(MAX_SHARDING);
        shardingMap.forEach((k, v) -> v.forEach(no -> {
            if (StrUtil.isNotBlank(no) && no.length() > 4) {
                int datasourceIndex = Integer.parseInt(no.substring(no.length() - 2));
                sharding.add(availableTargetNames.toArray(new String[]{})[(datasourceIndex % MAX_SHARDING)]);
            }
        }));
        if (CollUtil.isEmpty(sharding)) {
            throw new BusinessException("The number is less than 3");
        }
        return sharding;
    }
}
