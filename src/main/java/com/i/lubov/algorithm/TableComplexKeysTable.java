/*
 * Copyright (c) 2020 ilubov
 * https://www.ilubov.cn
 * All rights reserved.
 */
package com.i.lubov.algorithm;

import cn.hutool.core.util.StrUtil;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysShardingValue;
import org.apache.shardingsphere.api.sharding.complex.ComplexKeysTableShardingAlgorithm;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 复合分片：处理=和IN
 * 分片类型：16库、16不同表名
 * 用于：订单子表
 *
 * @author ilubov
 * @date 2020/08/26
 */
public class TableComplexKeysTable implements ComplexKeysTableShardingAlgorithm<String> {

    private static final int MAX_SHARDING = 16;

    /**
     * 按单号后四位抹除16选择表
     *
     * @param datasource 数据库
     * @param availableTargetNames 表
     * @param shardingValue 分片键值
     * @return table
     */
    @Override
    public Collection<String> doSharding(String datasource, Collection<String> availableTargetNames, ComplexKeysShardingValue<String> shardingValue) {
        int datasourceIndex = Integer.parseInt(datasource.substring(2)) % MAX_SHARDING;
        Map<String, Collection<String>> shardingMap = shardingValue.getColumnNameAndShardingValuesMap();
        Set<String> sharding = new HashSet<>(MAX_SHARDING);
        shardingMap.forEach((k, v) -> v.forEach(no -> {
            if (StrUtil.isNotBlank(no) && no.length() > 4) {
                int thisDatasourceIndex = Integer.parseInt(no.substring(no.length() - 2)) % MAX_SHARDING;
                if (thisDatasourceIndex == datasourceIndex) {
                    int tableIndex = Integer.parseInt(no.substring(no.length() - 4)) % MAX_SHARDING;
                    sharding.add(availableTargetNames.toArray(new String[]{})[(tableIndex)]);
                }
            }
        }));
        return sharding;
    }
}
