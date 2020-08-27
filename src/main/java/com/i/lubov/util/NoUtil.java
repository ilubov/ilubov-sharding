/*
 * Copyright (c) 2020 ilubov
 * https://www.ilubov.cn
 * All rights reserved.
 */
package com.i.lubov.util;

import cn.hutool.core.date.DateUtil;

import java.util.Date;
import java.util.Random;

/**
 * NoUtil
 *
 * @author ilubov
 * @date 2020/08/26
 */
public class NoUtil {

    public static String getOrderNo(String flag) {
        Random random = new Random();
        int ranNum = (int) (random.nextDouble() * (999999 - 100000 + 1)) + 100000;
        return flag + DateUtil.format(new Date(), "yyMMdd") + ranNum;
    }
}
