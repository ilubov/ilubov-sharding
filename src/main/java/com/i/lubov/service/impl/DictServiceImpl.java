/*
 * Copyright (c) 2020 ilubov
 * https://www.ilubov.cn
 * All rights reserved.
 */
package com.i.lubov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.i.lubov.entity.Dict;
import com.i.lubov.mapper.DictMapper;
import com.i.lubov.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * DictServiceImpl
 *
 * @author ilubov
 * @date 2020/08/26
 */
@Slf4j
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

}
